package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу простейшего банковского сервиса
 * @author VLADISLAV
 * @version 1.0
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в HashMap,
     * в качестве второго параметра, используется пустой Лист.
     * @param user пользователь котрого добавляем.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Происходит добавление аккаунта пользователя.
     * 1) Находим пользователя по паспропту и проверям, есть ли такой пользователь.
     * 2) Если пользователь есть, получаем ссылку на Лист списка счетов данного пользователя.
     * 3) добавляем новый счет к ним.
     * @param passport Строковое значение пасспорта
     * @param account Аккаунт пользователя.
     */
    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> userAccounts = users.get(foundUser);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Происходит поиск пользвателя по номеру паспорта
     * через перебор всех элементов цикла foreach и метода Map.keySet.
     * @param passport Строковое представление номера паспорта.
     * @return обьект user.
     */
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

    /**
     * 1) Ищем пользователя по пасспорту
     * 2) Получаем список счетов данного пользователя
     * 3) Находим нужный счёт
     * @param passport Строковое представление номера паспорта.
     * @param requisite счёт который нужно найти.
     * @return найденный счёт
     */
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

    /**
     * 1) Получаем счёт через метод findByRequisite
     * 2) Проверяем, есть ли на балансе достаточно денег для перевода.
     * 3) Если достаточно, с аккаунта с которым перводим, отнимаем сумму
     * с аккаунта к которому переводим, добавляем деньги.
     * @param srcPassport Пасспорт с которого переводим деньги.
     * @param srcRequisite Счёт с которого переводим деньги.
     * @param destPassport Пасспорт на который переводим деньги.
     * @param destRequisite Счёт на который переводим деньги.
     * @param amount количество денег которые переводятся.
     * @return true - если операция проведена успешно, false - если возникли ошибки.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && amount <= srcAccount.getBalance()) {
                srcAccount.setBalance(srcAccount .getBalance() - amount);
                destAccount.setBalance(destAccount .getBalance() + amount);
                rsl = true;
        }
        return rsl;
    }
}
