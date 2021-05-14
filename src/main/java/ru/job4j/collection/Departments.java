package ru.job4j.collection;

import java.util.*;

public class Departments {

    /**
     * Метод описывает разделение списка департамента на одиночные символы
     * Создается Set для временного хранения и избавления от повторяющихся элементов.
     * Пробегаемся по списку и каждый его элемент разделяем по знаку "/"
     * если элемент цикла равен "", то добавляем его в Set
     * иначе добавляем start + "/" + el
     * @param deps на входе список департаментов
     * @return на выходе массив bp единичных элементов
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.equals("")) {
                    start = el;
                } else {
                    start = start + "/" + el;
                }
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * метод описывает сортировку по возрастанию
     * @param orgs принимает на вход список(лист) orgs
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /**
     * метод описывает сортировку по убыванию
     * @param orgs принимает на вход список(лист) orgs
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
