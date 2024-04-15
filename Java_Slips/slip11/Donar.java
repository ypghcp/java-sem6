import java.sql.*;

public class Donar {

    public static void main(String[] args) {

        try  
        {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://192.168.1.254:5432/","","");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM DONAR");
            ResultSet resultSet = statement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            System.out.println("Column Information for DONAR table:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Data Type: " + metaData.getColumnTypeName(i));
                System.out.println("Nullable: " + (metaData.isNullable(i) == ResultSetMetaData.columnNullable ? "Yes" : "No"));
                System.out.println("----------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
