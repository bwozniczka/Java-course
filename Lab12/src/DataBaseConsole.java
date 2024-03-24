import java.sql.*;
import java.util.Scanner;

public class DataBaseConsole  {
    private static final String DATABASE_URL = "jdbc:sqlite:/Users/bartlomiejwozniczka/Desktop/PZ1_java/Lab12/db";
    public static void connect() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL)) {
            // Tworzenie tabeli, jeśli nie istnieje
            String createTableSql = "CREATE TABLE IF NOT EXISTS dane (\n"
                    + "	id INTEGER PRIMARY KEY,\n"
                    + "	tekst TEXT NOT NULL,\n"
                    + "	liczba REAL\n"
                    + ");";

            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSql);
            }

            try (Statement stmt = conn.createStatement()) {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String query = scanner.nextLine();

                    if (query.equalsIgnoreCase("exit")) {
                        break;
                    }
                    try {
                        if (query.trim().toLowerCase().startsWith("select")) {
                            try (ResultSet resultSet = stmt.executeQuery(query)) {
                                ResultSetMetaData rsmd = resultSet.getMetaData();
                                int columnCount = rsmd.getColumnCount();

                                while (resultSet.next()) {
                                    for (int i = 1; i <= columnCount; i++) {
                                        if (i > 1) System.out.print(" ");
                                        System.out.print(resultSet.getString(i));
                                    }
                                    System.out.println(" ");
                                }
                            }
                        } else {
                            int rowsAffected = stmt.executeUpdate(query);
                            System.out.println("Liczba zmienionych wierszy: " + rowsAffected);
                        }
                    } catch (SQLException e) {
                        System.out.println("Błąd: " + e.getMessage());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        connect();
    }
}
