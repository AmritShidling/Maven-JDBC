package com.sqlsamples;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {

        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Practice;user=I332936;password=root";

        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting localhost to SQL Server ... ");
            
            try(Connection connection =  DriverManager.getConnection(connectionUrl)){
            	System.out.println("Done.");
            	String query = "select * from TBLPERSON";
            	try(Statement statement = connection.createStatement();
            		ResultSet resultSet = statement.executeQuery(query);){
            		while(resultSet.next()) {
            			System.out.println(
            					resultSet.getInt(1) +
            					" " + resultSet.getString(2) + 
            					" " + resultSet.getString(3));
            			
            		}
            		 connection.close();
                     System.out.println("All done.");
            	}
            	catch(Exception e) {
            		
            	}

            }
       
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
