import java.util.Random;
import java.util.Scanner;

public class Lab3 {
    private static int getIntFromInput(Scanner scanner) {
        final String INPUT_REQUEST = "Введите размерность матрицы (целое число от 0 до 20):";
        int finalNumber = 0;
        boolean isValid = false;

        do {
            System.out.println(INPUT_REQUEST);
            final String line = scanner.nextLine().trim();
            final boolean isSeveralArgs = line.contains(" ");
            if (!isSeveralArgs) {
                try {
                    final int number = Integer.parseInt(line);
                    if (number >= 0 && number <= 20) {
                        finalNumber = number;
                        isValid = true;
                    } else {
                        System.out.println("Ошибка! Вне допустимого диапазона значения");
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                    System.out.println("Ошибка! Некорректный ввод");
                }
            } else {
                System.out.println("Ошибка! Слишком много аргументов");
            }
        } while (!isValid);
        return finalNumber;
    }

    private static double[][] generateRandomMatrix(int rows, int columns) {
        final Random random = new Random();
        double[][] matrix = new double[rows][columns];

        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < rows; row++) {
                final int integerPart = -100 + random.nextInt(200);
                final double fractionalPart = random.nextInt(100) / 100.0;
                matrix[row][column] = Math.floor((integerPart + fractionalPart) * 100) / 100;
            }
        }
        return matrix;
    }

    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(String.format("%7s", element));
            }
            System.out.println();
        }
    }

    private static double getOddElementsSumUnderSideDiagonal(double[][] matrix) {
        double sum = 0;
        final int length = matrix.length;
        for(int i = 0; i < length; i++) {
            final double element = matrix[length - (i + 1)][i];
            if ((int)element % 2 == 0) {
                sum += element;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Лабораторная №3. Вариант  №41");
        System.out.println("Таранов Иван Андрревич, 19-ИЭ-2.2\n");

        System.out.println("Задание: Сумма нечетных элементов под побочной диагональю");
        final Scanner scanner = new Scanner(System.in);

        final int N = getIntFromInput(scanner);

        double[][] matrix = generateRandomMatrix(N, N);
        printMatrix(matrix);

        final double sum = getOddElementsSumUnderSideDiagonal(matrix);
        System.out.println("Результат: " + sum);
    }
}
