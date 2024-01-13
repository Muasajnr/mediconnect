package src.main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
   static final String DB_URL = "jdbc:mysql://localhost:3306/java_ass_project";
   static final String USER = "brian";
   static final String PASS = "bm123456";

   public static void main(String[] args) {
      // Open a connection
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();) {
         // String sql = "CREATE DATABASE java_project";
         // stmt.executeUpdate(sql);
         //System.out.println("Database created successfully...");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}