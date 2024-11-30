package code.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
    private static final String URL = "jdbc:sqlite:system.db";

    private static Connection connection;

    private ConnectDB() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL);
                System.out.println("Database Connection: OK");
            } catch (SQLException e) {
                System.out.println("Error Connecting to Database");
                e.printStackTrace();
            }
        }
        return connection;
    }



    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection Closed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createTables() {
        Connection conn = getConnection(); // Get the connection without closing it
        try (Statement statement = conn.createStatement()) {
            String createStudentsTable = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT NOT NULL," +
                    "email TEXT," +
                    "phone TEXT)";
            statement.execute(createStudentsTable);

            String createGradesTable = "CREATE TABLE IF NOT EXISTS grades (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "student_id INTEGER NOT NULL," +
                    "subject TEXT NOT NULL," +
                    "score REAL NOT NULL)";
            statement.execute(createGradesTable);

            String createAttendancesTable = "CREATE TABLE IF NOT EXISTS attendances (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "student_id INTEGER NOT NULL," +
                    "date TEXT NOT NULL," +
                    "present BOOLEAN NOT NULL)";
            statement.execute(createAttendancesTable);
            System.out.println("Database Tables: OK");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
