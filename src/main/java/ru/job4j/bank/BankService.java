package ru.job4j.bank;

import java.util.*;

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
        Optional<User> foundUser = findByPassport(passport);
        if (foundUser.isPresent()) {
            List<Account> userAccounts = users.get(foundUser.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Происходит поиск пользвателя по номеру паспорта
     * через использование стримов.
     * @param passport Строковое представление номера паспорта.
     * @return обьект user.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport()
                        .equals(passport))
                .findFirst();
    }

    /**
     * 1) Ищем пользователя по пасспорту
     * 2) Получаем список счетов данного пользователя
     * 3) Находим нужный счёт
     * @param passport Строковое представление номера паспорта.
     * @param requisite счёт который нужно найти.
     * @return найденный счёт
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> foundUser = findByPassport(passport);
        return foundUser.flatMap(user -> users.get(user)
                .stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
                && destAccount.isPresent()
                && amount <= srcAccount.get().getBalance()) {
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                rsl = true;
        }
        return rsl;
    }
}
