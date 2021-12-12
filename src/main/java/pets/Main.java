package pets;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Тузик", 11, 2, "черная");
        Cat cat = new Cat("Мурка", 5, 2, "белая");
        Duck duck = new Duck("Кряква", 3, 2, "желтая");

        List<Animals> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        animals.add(duck);
        Scanner scan = new Scanner(System.in);

        boolean menu = true;
        while (menu) {
            System.out.println("Меню");
            System.out.println("Введите add для добавления");
            System.out.println("Введите list для печати списка");
            System.out.println("Введите exit для выхода");

            String input = scan.next().toUpperCase(Locale.ROOT).trim();

            Command command = Command.of(input);
            switch (command) {
                case ADD -> {
                    System.out.println("Выберите животное: cat/dog/duck");
                    input = scan.next();

                    String name;
                    int age;
                    int weight;
                    String color;

                    System.out.println("Введите имя животного");
                    name = scan.next();
                    System.out.println("Введите возраст животного");
                    age = Integer.parseInt(scan.next());
                    System.out.println("Введите вес животного");
                    weight = Integer.parseInt(scan.next());
                    System.out.println("Введите цвет животного");
                    color = scan.next();

                    Animals animal;
                    switch (input) {
                        case "cat" -> animal = new Cat(name, age, weight, color);
                        case "dog" -> animal = new Dog(name, age, weight, color);
                        case "duck" -> animal = new Duck(name, age, weight, color);
                        default -> {
                            System.out.println("Неверный выбор");
                            animal = null;
                        }
                    }
                    if (animal != null) {
                        animals.add(animal);
                        animal.say();
                        System.out.println("Животное добавлено");
                    }
                }
                case LIST -> animals.forEach(System.out::println);
                case EXIT -> {
                    System.out.println("Выход из программы");
                    menu = false;
                }
                default -> System.out.println("Неверное значение");
            }
        }
        System.out.println("Выход произведен...");
    }
}
