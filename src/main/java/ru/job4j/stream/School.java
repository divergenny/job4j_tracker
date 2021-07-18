package ru.job4j.stream;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    /**
     * Cоздаём поток students.stream() и фильтруем .filter(predict)
     * Сохраняя результат в коллекции .collect(Collectors.toList());
     * @param students на вход список студентов
     * @param predict на вход данное сравнение
     * @return На выходе аккумулированный результат фильтрации
     * */
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    Map<String, Student> convertToMap(List<Student> students) {
        return students.stream()
                .collect(
                        Collectors.toMap(
                                e -> e.getSurname(),
                                e -> e,
                                (first, second) -> first
                        )
                );
    }
}
