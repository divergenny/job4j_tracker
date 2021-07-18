package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    /**
     * Открываем поток profiles.stream()
     * Получаем адреса .map(x -> x.getAddress())
     * сортируем по полю getCity()
     * оставляем уникальные города .distinct()
     * записываем элементы потока в коллецию .collect(Collectors.toList());
     * @param profiles на вход список профилей
     * @return на выходе список адресов
     */
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(new SortByCity())
                .distinct()
                .collect(Collectors.toList());
    }
}
