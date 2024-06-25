package view;

import model.Record;

public class Demo {

    public static void main(String[] args) {
        Record recordA = new Record("pencil", "study", 100.99);
        System.out.println(recordA.toString());
    }

}
