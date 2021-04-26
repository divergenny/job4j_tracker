package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> userAccounts = users.get(foundUser);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User foundUser = null;
        for (User userKey : users.keySet()) {
            if (passport.equals(userKey.getPassport())) {
                foundUser = userKey;
                break;
            }
        }
        return foundUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        User foundUser = findByPassport(passport);
        Account foundAccWithRequisite = null;
        if (foundUser != null) {
            for (Account accsRequisites : users.get(foundUser)) {
                if (requisite.equals(accsRequisites.getRequisite())) {
                    foundAccWithRequisite = accsRequisites;
                    break;
                }
            }
        }
        return foundAccWithRequisite;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            double srcMoney = srcAccount.getBalance();
            if (srcMoney - amount >= 0) {
                destAccount.addBalance(amount);
                srcMoney = srcMoney - amount;
                srcAccount.setBalance(srcMoney);
                rsl = true;
            }
        }
        return rsl;
    }
}
