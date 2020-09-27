import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        System.out.println("Лабораторная №1. Вариант  №41");
        System.out.println("Таранов Иван Андрревич, 19-ИЭ-2.2\n");

        System.out.println("Задание: max(a, b) / min(b, c)");

        final Scanner scanner = new Scanner(System.in);
        final String INPUT_NUMBER = "Введите вещественное число %s (от -1000.0 до 1000.0)";

        System.out.println(String.format(INPUT_NUMBER, "a"));
        final float a = scanner.nextFloat();
        System.out.println(String.format(INPUT_NUMBER, "b"));
        final float b = scanner.nextFloat();
        System.out.println(String.format(INPUT_NUMBER, "c"));
        final float c = scanner.nextFloat();

        final float maxAB = Math.max(a, b);
        final float minBC = Math.min(b, c);

        final float result = maxAB / minBC;

        System.out.println("Результат: " + result);
    }
}
