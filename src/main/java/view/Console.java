package view;

import model.Record;
import model.RecordService;
import model.RecordServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Console {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);

        List<Record> records = new ArrayList<>();
        boolean stopFlag = false;
        RecordService recordService = new RecordServiceImpl();

        while(!stopFlag) {
            printMenu();
            int choice = input.nextInt();
            switch(choice) {
                case 1:
                    // Добавить запись о расходе
                    Map<String, Object> recordValues = readRecord(input);
                    Record record = recordService.createRecord(recordValues);
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
        input.close();
    }

    private static Map<String, Object> readRecord(Scanner input) {
        Map<String, Object> recordValues = new HashMap<>();
        input.nextLine();
        System.out.print("Название: ");
        String name = input.nextLine();
        recordValues.put("name", name);
        System.out.print("Категория: ");
        String category = input.nextLine();
        recordValues.put("category", category);
        System.out.print("Сумма: ");
        Double moneyAmount = readMoneyAmount(input);
        recordValues.put("moneyAmount", moneyAmount);
        input.nextLine();
        System.out.print("Дата (дд.мм.гггг): ");
        Long transactionDate = readDate(input);
        recordValues.put("transactionDate", transactionDate);

        return recordValues;
    }

    private static double readMoneyAmount(Scanner input) {
        while (!input.hasNextDouble()) {
            input.nextLine();
            System.out.println("Ошибка! Неверный формат.");
            System.out.print("Сумма: ");
        }
        return input.nextDouble();
    }

    private static long readDate(Scanner input) {
        String strTransactionDate = input.nextLine();
        Date date = new Date();
        if (strTransactionDate.isEmpty()) {
            return date.getTime();
        }
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
        try {
            date = formater.parse(strTransactionDate);
        } catch (ParseException e) {
            System.out.println("Ошибка! Неверный формат.");
            System.out.print("Дата (дд.мм.гггг): ");
            readDate(input);
        }
        return date.getTime();
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
