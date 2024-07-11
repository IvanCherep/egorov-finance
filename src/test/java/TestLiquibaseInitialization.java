import db.DatabaseConnection;
import db.DatabaseInitializer;

import java.sql.Connection;

public class TestLiquibaseInitialization {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDB(connection);
    }

}
