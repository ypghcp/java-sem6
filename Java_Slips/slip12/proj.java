package Java_Slips.slip12;
import java.sql.*;
class proj
{
   public static void main(String args[]) throws SQLException
      {
        try
        {
          Connection con= DriverManager.getConnection("jdbc:postgresql://192.168.1.254:5432/","","");
	  Statement st1=con.createStatement();
	  ResultSet rs1=st1.executeQuery("select * from project");
	  System.out.print("Project table\n\n      project id | project name |  project description    | project-status ");
	  while(rs1.next())
	  	  System.out.printf("\n%16s |%-14s|%-25s|%-14s",rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4));
          System.out.println();
          con.close();
        }
        catch(Exception e)
        {  
             System.out.println("Connecton Failed...");
         }
       }
}
