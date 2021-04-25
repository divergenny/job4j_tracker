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
            if (!users.get(foundUser).contains(account)) {
                users.get(foundUser).add(account);
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
        User srcUser = findByPassport(srcPassport);
        User destUser = findByPassport(destPassport);
        if (srcUser != null && destUser != null) {
            int srcNumReq = users.get(srcUser).indexOf(new Account(srcRequisite, -1));
            int destNumReq = users.get(srcUser).indexOf(new Account(destRequisite, -1));
            if (srcNumReq != -1 && destNumReq != -1) {
                double srcMoney = users.get(srcUser).get(srcNumReq).getBalance();
                if (srcMoney - amount >= 0) {
                    users.get(srcUser).get(destNumReq).addBalance(amount);
                    srcMoney = srcMoney - amount;
                    users.get(srcUser).get(srcNumReq).setBalance(srcMoney);
                    rsl = true;
                }
            }
        }
        return rsl;
    }
}
