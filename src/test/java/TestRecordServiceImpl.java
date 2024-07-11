import db.DatabaseConnection;
import db.DatabaseInitializer;
import model.services.RecordService;
import model.services.impl.RecordServiceImpl;

import java.sql.Connection;

public class TestRecordServiceImpl {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDB(connection);
        RecordService recordService = new RecordServiceImpl();

        System.out.println(recordService.getRecordsByCheckingAccount(3L));
    }

}
