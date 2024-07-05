package model;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;

public class DatabaseInitializer {

    public static final String CHANGELOG_FILE = "changelog.xml";

    public static boolean initializeDB(Connection connection) {
        try {
            Liquibase liquibase = new Liquibase(
                    CHANGELOG_FILE,
                    new ClassLoaderResourceAccessor(),
                    DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection))
            );
            liquibase.update("");
        } catch (DatabaseException e) {
            System.err.println("Liquibase initialization error: " + e.getMessage());
            return false;
        } catch (LiquibaseException e) {
            System.err.println("Liquibase can't update exception: " + e.getMessage());
            return false;
        }

        return true;
    }

}
