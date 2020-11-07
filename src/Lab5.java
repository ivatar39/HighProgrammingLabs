import java.util.Scanner;

public class Lab5 {
    private static final int RUN_LAB2 = 1;
    private static final int RUN_LAB3 = 2;
    private static final int RUN_LAB4 = 3;
    private static final int ABOUT_AUTHOR = 4;
    private static final int EXIT = 5;


    private static boolean isInt(String line) {
        try {
            Integer.parseInt(line);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean runLab(Scanner scanner) {
        final String menuDivider = "\n------------------------------------------------------\n";
        final String line = scanner.nextLine();

        if (!line.trim().contains(" ") && isInt(line)) {

            int option = Integer.parseInt(line);
            final boolean rightRange = RUN_LAB2 <= option && option <= EXIT;
            if (rightRange) {
                switch (option) {
                    case RUN_LAB2:
                        System.out.println(menuDivider);
                        Lab2.main(new String[]{});
                        System.out.println(menuDivider);
                        break;
                    case RUN_LAB3:
                        System.out.println(menuDivider);
                        Lab3.main(new String[]{});
                        System.out.println(menuDivider);
                        break;
                    case RUN_LAB4:
                        System.out.println(menuDivider);
                        Lab4.main(new String[]{});
                        System.out.println(menuDivider);
                        break;
                    case ABOUT_AUTHOR:
                        System.out.println(menuDivider);
                        System.out.println(AboutAuthor.info);
                        System.out.println(menuDivider);
                        break;
                    case EXIT:
                        System.out.println("Нажмите любую клавишу для завершения...");
                        scanner.nextLine();
                        System.exit(0);
                        break;
                }
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println(menuDivider);
            return false;
        }

    }

    private static void printMenu(String errorMessage) {
        final String menuChoose = "Выберите пункт меню: ";
        final String menuRunLab2 = RUN_LAB2 + ". Лабораторная работа №2";
        final String menuRunLab3 = RUN_LAB3 + ". Лабораторная работа №3";
        final String menuRunLab4 = RUN_LAB4 + ". Лабораторная работа №4";
        final String menuAboutAuthor = ABOUT_AUTHOR + ". Об авторе";
        final String menuExit = EXIT + ". Выход";

        System.out.println(menuChoose);
        System.out.println(menuRunLab2);
        System.out.println(menuRunLab3);
        System.out.println(menuRunLab4);
        System.out.println(menuAboutAuthor);
        System.out.println(menuExit);
        System.out.println();
        if (errorMessage != null)
            System.out.println(errorMessage);
    }

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        String errorMessage = null;

        while (true) {
            printMenu(errorMessage);

            final boolean isRunSuccessful = runLab(scanner);
            if (!isRunSuccessful) {
                errorMessage = "Ошибка! Некорректный ввод";
            } else {
                errorMessage = null;
            }
        }
    }
}
