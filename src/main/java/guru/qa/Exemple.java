package guru.qa;

import java.util.Random;

public class Exemple {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(100); // случайное число от 0 до 99
        int b = random.nextInt(100);

        System.out.println("Сгенерированные числа: a = " + a + ", b = " + b);

        // Арифметические операции с двумя int
        System.out.println("Сложение: " + (a + b));
        System.out.println("Вычитание: " + (a - b));
        System.out.println("Умножение: " + (a * b));
        System.out.println("Деление: " + (b != 0 ? (a / b) : "деление на ноль"));
        System.out.println("Остаток от деления: " + (b != 0 ? (a % b) : "деление на ноль"));

        // Арифметические операции с int и double
        double c = random.nextDouble() * 10; // случайное число от 0 до 10
        System.out.println("int + double: " + (a + c));
        System.out.println("int - double: " + (a - c));
        System.out.println("int * double: " + (a * c));
        System.out.println("int / double: " + (a / c));

        // Логические операции
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));

        // Диапазоны чисел с плавающей точкой
        System.out.println("Максимальное значение float: " + Float.MAX_VALUE);
        System.out.println("Минимальное значение float: " + Float.MIN_VALUE);
        System.out.println("Максимальное значение double: " + Double.MAX_VALUE);
        System.out.println("Минимальное значение double: " + Double.MIN_VALUE);

        // Переполнение
        int maxInt = Integer.MAX_VALUE;
        System.out.println("Максимальный int: " + maxInt);
        System.out.println("Переполнение int: " + (maxInt + 1)); // Уйдет в отрицательные значения

        float largeFloat = Float.MAX_VALUE;
        System.out.println("Переполнение float: " + (largeFloat * 2)); // Получим бесконечность

        double largeDouble = Double.MAX_VALUE;
        System.out.println("Переполнение double: " + (largeDouble * 2)); // Получим бесконечность

        System.out.println("Проверка бесконечности float: " + Float.isInfinite(largeFloat * 2));
        System.out.println("Проверка бесконечности double: " + Double.isInfinite(largeDouble * 2));
    }
}
