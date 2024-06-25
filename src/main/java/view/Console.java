package view;

import model.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Console {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        List<Record> records = new ArrayList<>();
        boolean stopFlag = false;
        while(!stopFlag) {
            printMenu();
            int choice = input.nextInt();
            switch(choice) {
                case 1:
                    // Добавить запись о расходе
                    Record record = readRecord(input);
                    records.add(record);
                    System.out.println("Запись " + record.toString() + " успешно добавлена");
                    break;
                case 2:
                    // Добавить запись о доходе
                    break;
                case 3:
                    // Посмотреть расходы
                    break;
                case 4:
                    // Посмотреть доходы
                    break;
                case 5:
                    System.out.println(records);
                    break;
                case 6:
                    // Редактировать запись о расходе/доходе
                    break;
                case 7:
                    // Удалить запись о расходе/доходе
                    break;
                case 8:
                    // Загрузить записи о расходах/доходах из файла
                    break;
                case 9:
                    // Сохранить записи о расходах/доходах в файл
                    break;
                case 0:
                    // Выйти
                    stopFlag = true;
                    break;
            }
        }

    }

    private static Record readRecord(Scanner input) {
        input.nextLine();
        System.out.print("Название: ");
        String name = input.nextLine();
        System.out.print("Категория: ");
        String category = input.nextLine();
        System.out.print("Сумма: ");
        double moneyAmount = readMoneyAmount(input);

        return new Record(name, category, moneyAmount);
    }

    private static double readMoneyAmount(Scanner input) {
        while (!input.hasNextDouble()) {
            input.nextLine();
            System.out.println("Ошибка! Неверный формат.");
            System.out.print("Сумма: ");
        }
        double moneyAmount = input.nextDouble();
        return moneyAmount;
    }

    private static void printMenu() {
        System.out.println("==============================");
        System.out.println("=      EgorovFinance         =");
        System.out.println("==============================");
        System.out.println("[1] - Добавить запись о расходе");
        System.out.println("[2] - Добавить запись о доходе");
        System.out.println("[3] - Посмотреть расходы");
        System.out.println("[4] - Посмотреть доходы");
        System.out.println("[5] - Посмотреть записи о расходах/доходах");
        System.out.println("[6] - Редактировать запись о расходе/доходе");
        System.out.println("[7] - Удалить запись о расходе/доходе");
        System.out.println("[8] - Загрузить записи о расходах/доходах из файла");
        System.out.println("[9] - Сохранить записи о расходах/доходах в файл");
        System.out.println("[0] - Выйти");
        System.out.println("==============================");
        System.out.print("Выберите опцию: ");
    }

}
