import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DataBaseGUI {
    private static final String DATABASE_URL = "jdbc:sqlite:/Users/bartlomiejwozniczka/Desktop/PZ1_java/Lab12/db";
    private static JFrame frame;
    private static DefaultTableModel tableModel;

    public static void connect() {
        frame = new JFrame("Panel zapytań");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        JPanel panel = new JPanel(new BorderLayout());

        JTextArea inputQuery = new JTextArea();
        inputQuery.setRows(5);
        inputQuery.setLineWrap(true);
        JScrollPane inputScrollPane = new JScrollPane(inputQuery);

        JButton executeButton = new JButton("Wykonaj zapytanie");
        executeButton.setPreferredSize(new Dimension(150, 30));

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputScrollPane, BorderLayout.CENTER);
        inputPanel.add(executeButton, BorderLayout.SOUTH);

        panel.add(inputPanel, BorderLayout.NORTH);

        JTable table = new JTable();
        tableModel = new DefaultTableModel();
        table.setModel(tableModel);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = inputQuery.getText();
                if (!query.isEmpty()) {
                    executeQuery(query);
                }
            }
        });
    }

    public static void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL)) {
            try (Statement stmt = conn.createStatement()) {
                if (query.trim().toLowerCase().startsWith("select")) {
                    try (ResultSet resultSet = stmt.executeQuery(query)) {
                        ResultSetMetaData rsmd = resultSet.getMetaData();
                        int columnCount = rsmd.getColumnCount();

                        tableModel.setRowCount(0);
                        tableModel.setColumnCount(0);

                        for (int i = 1; i <= columnCount; i++) {
                            tableModel.addColumn(rsmd.getColumnName(i));
                        }

                        while (resultSet.next()) {
                            Object[] row = new Object[columnCount];
                            for (int i = 1; i <= columnCount; i++) {
                                row[i - 1] = resultSet.getString(i);
                            }
                            tableModel.addRow(row);
                        }
                    }
                } else {
                    int rowsAffected = stmt.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Zaktualizowano tabele");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Błąd: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                connect();
            }
        });
    }
}
