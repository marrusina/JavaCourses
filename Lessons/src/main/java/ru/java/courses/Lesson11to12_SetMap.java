package ru.java.courses;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.swing.tree.TreeCellEditor;

public class Lesson11to12_SetMap {

    public static class User implements Comparable<User>{

        private String name;
        private Integer age;
        private String phone;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public User(String phone) {
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name) &&
                    Objects.equals(phone, user.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, phone);
        }

        @Override
         public int compareTo(User o) {
           // int com = o1.name.compareTo(o2.name);
            if (name.compareTo(o.name) == 0) {
                return age.compareTo(o.age);
            }
            return name.compareTo(o.name);
        }
    }

    /**
     * В этом методе необходимо реализовать:
     * 1. На вход получаем коллекцию пользователей
     * 2. Удаляем все дубли (одинаковое имя и возраст)
     * 3. Сортируем по имени и возрасту
     * 4. Возвращаем последнего пользователя
     */
    public static User task1(Collection<User> source) {


         TreeSet<User> test = new TreeSet<>(source);
       //Stream<User> test2 = source.stream().filter(Objects::nonNull).distinct().skip(source.size() - 1);

       //TreeSet<User> test3 = new TreeSet<User>((Collection<? extends User>) test);
       //return test.collect(Collectors.toSet());
        return test.last();
    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем коллекцию пользователей
     * 2. Преобразовываем его в справочник [номер телефона -> пользователь]
     * 3. Один номер телефона на одного пользователя
     * 4. Вернуть количество записей в справочнике
     */
    public static int task2(Collection<User> source) {

        return source.stream().collect(Collectors.toSet()).size();

    }

    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем список названий книг
     * 2. Распределяем книги по полкам так, чтобы на каждой полке было примерно одинаковое количество книг
     * 3. Все книги должны быть отсортированы по алфавиту с первой до последней полки
     * 4. Количество полок константное - 5 штук
     * 5. Вернуть книги распределенные по полкам
     *
     * Нумерация полок начинается с нуля!
     */
    public static Map task3(Collection<String> source) {

        HashMap<Integer, List<String>> test = new HashMap<>();
        List<String> strings = new ArrayList<>(source);
        int i = 0;
        IntStream.range(0,5).forEach((k) -> {test.put(i, strings.subList(i, strings.size() /5));});

       // source.stream().collect(HashMap::new, (h,o) -> h.put(h.size(), o), (h,o) -> {}).forEach(i,o) -> {strings.add(i,source);};

      // Stream.of(source).filter( n -> n.size() <= 1).collect( Collectors.toList());
//        //int i = 0;
        //strings.stream().range(0,source.size()).filter(i -> i%5 == 0).mapToObj(i -> source).collect(Collectors.toList());
//        return test;
        return test;
    }



    /**
     * В этом методе необходимо реализовать следующий алгоритм:
     * 1. На вход получаем книги, распределенные по полкам
     * 5. Вернуть справочник [название книги -> номер полки]
     */
    public static Map task4(Map<Integer, String> source) {

        Map<String, Integer> test = new HashMap<>();
                source.entrySet().forEach(i -> {test.put(i.getValue(),i.getKey());});
                return test;
    }
}