import java.util.Scanner;

public class Lab2 {

    static float getFloatFromInput(Scanner scanner, char numberSymbol) {
        final String INPUT_NUMBER = "Введите вещественное число %s (от -1000.0 до 1000.0)";
        float finalNumber = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(String.format(INPUT_NUMBER, numberSymbol));
            if (scanner.hasNextFloat()) {
                String line = scanner.nextLine();
                if (line.trim().contains(" ")) {
                    System.out.println("Ошибка! Слишком много аргументов");
                    continue;
                } else {
                    try {
                        float number = Float.parseFloat(line);
                        if (number > -1000 && number < 1000) {
                            finalNumber = number;
                            isValid = true;
                            break;
                        } else {
                            System.out.println("Ошибка! Вне допустимого диапазона значения");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("Ошибка! Некорректный ввод");
                        continue;
                    }
                }
            } else {
                System.out.println("Ошибка! Некорректный ввод");
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    continue;
                }
            }
            scanner.next();
        }
        return finalNumber;
    }

    public static void main(String[] args) {
        System.out.println("Лабораторная №1. Вариант  №41");
        System.out.println("Таранов Иван Андрревич, 19-ИЭ-2.2\n");

        System.out.println("Задание: max(a, b) / min(b, c)");

        final Scanner scanner = new Scanner(System.in);

        final float a = getFloatFromInput(scanner, 'a');
        final float b = getFloatFromInput(scanner, 'b');
        final float c = getFloatFromInput(scanner, 'c');


        final float maxAB = Math.max(a, b);
        final float minBC = Math.min(b, c);
        if (minBC == 0) {
            System.out.println("На ноль делить нельзя!");
        } else {
            final float result = maxAB / minBC;
            System.out.println("Результат: " + result);
        }
    }
}
