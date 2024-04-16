import java.sql.*;

public class metaData {

    public static void main(String[] args) 
    {
        try 
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","","");
            DatabaseMetaData metaData = connection.getMetaData();

            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());

            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            System.out.println("\nTables in the database:");
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
