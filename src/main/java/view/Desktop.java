package view;

import controller.Controller;
import model.Category;
import model.RecordResponseStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Desktop {
    // Счетчик используется для задания айди категории, при вводе
    private static int categoryCounter = 0;

    private static Controller controller = new Controller();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton createRecord = new JButton("Создать запись");
        JButton exitProgram = new JButton("Выйти из программы");
        JTextField nameField = new JTextField(10);
        JTextField categoryField = new JTextField(10);
        JTextField moneyAmountField = new JTextField(10);

        createRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, Object> recordValues = new HashMap<>();
                String name = JOptionPane.showInputDialog("Введите название");
                recordValues.put("name", name);
                String categoryString = JOptionPane.showInputDialog("Введите категорию");
                Category category = new Category(categoryCounter++, categoryString);
                recordValues.put("category", category);
                Double moneyAmount = readMoneyAmount(false);
                recordValues.put("moneyAmount", moneyAmount);
                RecordResponseStatus recordResponseStatus = controller.createRecord(recordValues);
                if (recordResponseStatus.getResponseStatus() == 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            recordResponseStatus.getRecord().toString()
                    );
                } else if (recordResponseStatus.getResponseStatus() == 1) {
                    name = JOptionPane.showInputDialog("Ошибка! Введите название");
                    recordValues.put("name", name);
                }
            }
        });

        exitProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(createRecord);
        panel.add(exitProgram);
        panel.add(nameField);
        panel.add(categoryField);
        panel.add(moneyAmountField);

        frame.setTitle("egorov-finance");
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private static double readMoneyAmount(boolean isThereTypeError) {
        String moneyAmountString;
        if (!isThereTypeError) {
            moneyAmountString = JOptionPane.showInputDialog("Введите сумму");
        } else {
            moneyAmountString = JOptionPane.showInputDialog("Ошибка! Введите сумму");
        }
        Double moneyAmount = (double) 0;
        try {
            moneyAmount = Double.valueOf(moneyAmountString);
        } catch (NumberFormatException ex) {
            moneyAmount = readMoneyAmount(true);
        }
        return moneyAmount;
    }

}
