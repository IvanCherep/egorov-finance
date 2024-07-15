package ru.sut.egorov.finance.db;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInitializer {

    private static final String CHANGELOG_FILE = "changelog.xml";

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
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Failed to close DB connection: " + e.getMessage());
            }
        }

        return true;
    }

}
