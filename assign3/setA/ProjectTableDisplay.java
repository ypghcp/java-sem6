import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ProjectTableDisplay extends JFrame {
    private JTable table;

    public ProjectTableDisplay() {
        setTitle("Project Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/your_database", "username", "password");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PROJECT");

            DefaultTableModel model = new DefaultTableModel();
            table.setModel(model);

            model.addColumn("Project ID");
            model.addColumn("Project Name");
            model.addColumn("Project Description");
            model.addColumn("Project Status");

            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("project_id"),
                        resultSet.getString("project_name"),
                        resultSet.getString("project_description"),
                        resultSet.getString("project_status")
                };
                model.addRow(row);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to fetch data from the database.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProjectTableDisplay projectTableDisplay = new ProjectTableDisplay();
            projectTableDisplay.setVisible(true);
        });
    }
}
