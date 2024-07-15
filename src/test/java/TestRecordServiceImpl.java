import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.db.DatabaseInitializer;
import ru.sut.egorov.finance.model.dao.RecordDao;
import ru.sut.egorov.finance.model.dao.impl.postgre.RecordDaoImpl;

import java.sql.Connection;

public class TestRecordServiceImpl {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDB(connection);
//        RecordDao recordDao = new RecordDaoImpl();

//        System.out.println(recordDao.getRecordsByCheckingAccount(3L));
    }

}
