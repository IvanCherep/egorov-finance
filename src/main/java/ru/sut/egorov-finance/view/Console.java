package view;

import controller.Controller;
import model.Record;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
                    // Добавить расход
                    addRecord(input, false);
                    break;
                case 2:
                    // Добавить доход
                    addRecord(input, true);
                    break;
                case 3:
                    // Посмотреть расходы
                    // С фильтрами
                    printRecords();
                    break;
                case 4:
                    // Посмотреть доходы
                    printRecords();
                    break;
                case 5:
                    // Посмотреть все записи
                    printRecords();
                    System.out.println(records);
                    break;
                case 6:
                    // Редактировать запись о расходе/доходе
                    modifyRecord();
                    break;
                case 7:
                    // Удалить запись о расходе/доходе
                    removeRecord();
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

    /**
     * Метод прендназначенный для удаления записи
     */
    private static void removeRecord() {
    }

    /**
     * Метод предназначенный для редактирования записи
     */
    private static void modifyRecord() {
    }

    /**
     * Метод преднозначен для вывода транзакций клиенту по указанным фильтрам
     */
    private static void printRecords() {
        // [1] - Вывести за последний месяц
        // [2] - Вывести по дате

    }

    private static void addRecord(Scanner input, boolean isIncome) {
        Map<String, Object> recordValues = readRecord(input);
        Controller controller = new Controller();
        boolean isRecordCreated = controller.createRecord(recordValues);
        while (!isRecordCreated) {
            System.out.println("Ошибка! Запись не создана!");
            isRecordCreated = controller.createRecord(readRecord(input));
        }
        System.out.println("Запись успешно добавлена");
    }

    /**
     * Метод считывает значение записи и кладет их в Map<String, Object>
     */
    private static Map<String, Object> readRecord(Scanner input) {
        Map<String, Object> recordValues = new HashMap<>();
        input.nextLine();
        String name = readRecordName(input);
        recordValues.put("name", name);
        String category = readRecordCategory(input);
        recordValues.put("category", category);
        Double moneyAmount = readMoneyAmount(input);
        recordValues.put("moneyAmount", moneyAmount);
        input.nextLine();
        Long transactionDate = readDate(input);
        recordValues.put("transactionDate", transactionDate);

        return recordValues;
    }

    /**
     * Метод счситывает имя записи
     */
    private static String readRecordName(Scanner input) {
        System.out.print("Название: ");
        return input.nextLine();
    }

    /**
     * Метод считвыает категорию записи
     */
    private static String readRecordCategory(Scanner input) {
        System.out.print("Категория: ");
        return input.nextLine();
    }

    /**
     * Метод считывает из консоли денежную сумму
     */
    private static double readMoneyAmount(Scanner input) {
        System.out.print("Сумма: ");
        // controller.validateRecord(Map, "moneyAmount")
        while (!input.hasNextDouble()) {
            input.nextLine();
            System.out.println("Ошибка! Неверный формат.");
            System.out.print("Сумма: ");
        }

        return input.nextDouble();
    }

    /**
     * Метод считывает дату от человека в удобном формате и возвращает
     * ее представление в миллисекундах
     */
    private static long readDate(Scanner input) {
        System.out.print("Дата (дд.мм.гггг): ");
        String strTransactionDate = input.nextLine();
        Date date = new Date();
        if (strTransactionDate.isEmpty()) {
            return date.getTime();
        }

        //TODO формат даты должен быть одинаковым во всем приложении
        //TODO переводим SipmleDateFormat в сингалтон
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

    /**
     * Метод выводит в консоль главмное меню программы
     */
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
