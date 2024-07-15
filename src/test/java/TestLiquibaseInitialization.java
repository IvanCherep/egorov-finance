import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.db.DatabaseInitializer;

import java.sql.Connection;

public class TestLiquibaseInitialization {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDB(connection);
    }

}
