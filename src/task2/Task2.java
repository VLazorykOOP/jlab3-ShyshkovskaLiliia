package task2;

import java.util.Scanner;

public class Task2 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Демонстрація класів task2.Money і task2.Complex ");

        Pair[] objects = createObjectsArray();

        demonstrateArrayOperations(objects);

        demonstrateAllMethods();

        scanner.close();
    }

    public static Pair[] createObjectsArray() {
        System.out.println("\nСтворення масиву об'єктів: ");
        System.out.print("Введіть кількість об'єктів у масиві: ");
        int count = scanner.nextInt();

        Pair[] objects = new Pair[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nОб'єкт " + (i + 1) + ":");
            System.out.println("1 - task2.Money (гроші)");
            System.out.println("2 - task2.Complex (комплексне число)");
            System.out.print("Виберіть тип об'єкта: ");
            int type = scanner.nextInt();

            if (type == 1) {
                objects[i] = createMoney();
            } else if (type == 2) {
                objects[i] = createComplex();
            } else {
                System.out.println("Невірний вибір, спробуйте ще раз.");
                i--;
            }
        }

        return objects;
    }

    public static Money createMoney() {
        System.out.print("Введіть кількість гривень: ");
        double hryvnia = scanner.nextDouble();

        System.out.print("Введіть кількість копійок: ");
        double kopeck = scanner.nextDouble();

        return new Money(hryvnia, kopeck);
    }

    public static Complex createComplex() {
        System.out.print("Введіть дійсну частину: ");
        double real = scanner.nextDouble();

        System.out.print("Введіть уявну частину: ");
        double imag = scanner.nextDouble();

        return new Complex(real, imag);
    }

    public static void demonstrateArrayOperations(Pair[] objects) {
        System.out.println("\n=== МАСИВ ОБ'ЄКТІВ ===");
        for (int i = 0; i < objects.length; i++) {
            System.out.println("objects[" + i + "] = " + objects[i]);
        }

        System.out.print("\nВведіть число для множення всіх об'єктів: ");
        int multiplyBy = scanner.nextInt();

        System.out.print("Введіть число для ділення всіх об'єктів: ");
        int divideBy = scanner.nextInt();

        System.out.println("\nРезультати операцій з масивом:");
        for (int i = 0; i < objects.length; i++) {
            System.out.println("\nОб'єкт " + i + ": " + objects[i]);
            System.out.println("  Множення на " + multiplyBy + ": " + objects[i].multiply(multiplyBy));
            System.out.println("  Ділення на " + divideBy + ": " + objects[i].divide(divideBy));
        }
    }

    public static void demonstrateAllMethods() {
        System.out.println("\n=== ДЕТАЛЬНА ДЕМОНСТРАЦІЯ МЕТОДІВ ===");

        // task2.Money демонстрація
        System.out.println("\n--- КЛАС MONEY ---");
        System.out.println("Створення першого об'єкта task2.Money:");
        Money money1 = createMoney();

        System.out.println("Створення другого об'єкта task2.Money:");
        Money money2 = createMoney();

        System.out.println("\nРезультати операцій з task2.Money:");
        System.out.println("money1 = " + money1);
        System.out.println("money2 = " + money2);
        System.out.println("Додавання: " + money1.add(money2));
        System.out.println("Віднімання: " + money1.subtract(money2));

        System.out.print("Введіть число для множення: ");
        int multiplyMoney = scanner.nextInt();
        System.out.println("Множення: " + money1.multiply(multiplyMoney));

        System.out.print("Введіть число для ділення: ");
        int divideMoney = scanner.nextInt();
        System.out.println("Ділення: " + money1.divide(divideMoney));

        System.out.println("Порівняння (equals): " + money1.equals(money2));

        // task2.Complex демонстрація
        System.out.println("\n--- КЛАС COMPLEX ---");
        System.out.println("Створення першого об'єкта task2.Complex:");
        Complex complex1 = createComplex();

        System.out.println("Створення другого об'єкта task2.Complex:");
        Complex complex2 = createComplex();

        System.out.println("\nРезультати операцій з task2.Complex:");
        System.out.println("complex1 = " + complex1);
        System.out.println("complex2 = " + complex2);
        System.out.println("Додавання: " + complex1.add(complex2));
        System.out.println("Віднімання: " + complex1.subtract(complex2));

        System.out.print("Введіть число для множення: ");
        int multiplyComplex = scanner.nextInt();
        System.out.println("Множення: " + complex1.multiply(multiplyComplex));

        System.out.print("Введіть число для ділення: ");
        int divideComplex = scanner.nextInt();
        System.out.println("Ділення: " + complex1.divide(divideComplex));

        System.out.println("Порівняння (equals): " + complex1.equals(complex2));

        testErrorHandling();
    }

    public static void testErrorHandling() {
        System.out.println("\n=== ТЕСТУВАННЯ ОБРОБКИ ПОМИЛОК ===");

        try {
            System.out.println("\nСтворення об'єкта task2.Money для тесту ділення на нуль:");
            Money testMoney = createMoney();
            System.out.println("Спроба ділення на нуль...");
            testMoney.divide(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            System.out.println("\nСтворення об'єкта task2.Complex для тесту ділення на нуль:");
            Complex testComplex = createComplex();
            System.out.println("Спроба ділення на нуль...");
            testComplex.divide(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            System.out.println("\nТестування несумісних типів:");
            Money money = createMoney();
            Complex complex = createComplex();
            System.out.println("Спроба додати task2.Money та task2.Complex...");
            money.add(complex);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}