/*
Пусть дан список сотрудников:
        Иван Иванов
        Светлана Петрова
        Кристина Белова
        Анна Мусина
        Анна Крутова
        Иван Юрин
        Петр Лыков
        Павел Чернов
        Петр Чернышов
        Мария Федорова
        Марина Светлова
        Мария Савина
        Мария Рыкова
        Марина Лугова
        Анна Владимирова
        Иван Мечников
        Петр Петин
        Иван Ежов
        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
        Отсортировать по убыванию популярности.
*/

import java.util.*;

public class ListOfEmployees {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>();
        employees.add("Иван Иванов");
        employees.add("Светлана Петрова");
        employees.add("Анна Мусина");
        employees.add("Анна Крутова");
        employees.add("Иван Юрин");
        employees.add("Петр Лыков");
        employees.add("Павел Чернов");
        employees.add("Петр Чернышов");
        employees.add("Мария Федорова");
        employees.add("Марина Лугова");
        employees.add("Анна Владимирова");
        employees.add("Иван Мечников");
        employees.add("Иван Ежов");
        System.out.println("Список сотрудников: " + employees);
        System.out.println();

        Map<String, Integer> unsortedNames = new HashMap<>();

        for (String employee : employees) {
            var temp = employee.split(" ");
            if (unsortedNames.putIfAbsent(temp[0], 1) == unsortedNames.get(temp[0])) {
                unsortedNames.put(temp[0], unsortedNames.get(temp[0]) + 1);
            }
        }

        List<Map.Entry<String, Integer>> toSort = new ArrayList<>(unsortedNames.entrySet());
        toSort.sort(Comparator.comparing(e -> -e.getValue()));

        Map<String, Integer> sortedNames = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : toSort) {
            if (entry.getValue() > 1) {
                sortedNames.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Повторяющиеся имена: " + sortedNames);
    }
}
