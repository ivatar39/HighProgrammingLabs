import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lab4 {

    private static String getDoubledPunctuation(String line) {
        String newLine = line;
        int matches = 0;
        for (int i = 0; i < line.length(); i++) {
            if (Pattern.matches("\\p{Punct}" , String.valueOf(line.charAt(i)))) {
                newLine = new StringBuilder(newLine).insert((i+ matches), line.charAt(i)).toString();
                matches++;
            }
        }
        return newLine;
    }

    public static void main(String[] args) {
        System.out.println("Лабораторная №4. Вариант  №41");
        System.out.println("Таранов Иван Андрревич, 19-ИЭ-2.2\n");

        System.out.println("Задание: Продублировать все знаки препинания (рядом с найденными).");
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку для обработки: ");
        final String line = scanner.nextLine();
        System.out.println("Результат: " + getDoubledPunctuation(line));
    }
}
