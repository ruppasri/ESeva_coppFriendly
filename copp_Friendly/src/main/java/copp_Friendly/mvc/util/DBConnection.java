package copp_Friendly.mvc.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
 public static Connection createConnection()
 {
     Connection con = null;  
     try 
     {
    	 System.out.println("connection1");
         try 
         {
        	System.out.println("connection2");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("connection2");
         } 
         catch (ClassNotFoundException e)
         {
        	 System.out.println("ppppp");
            e.printStackTrace();
            System.out.println("ppppp");
            
         }
         System.out.println("connection3");
         con = DriverManager.getConnection("jdbc:mysql://localhost/coppFriendly?"+"user=root&password=Ruppasri@133"); //attempting to connect to MySQL database
         System.out.println("Printing connection object "+con);
     } 
     catch (Exception e) 
     {
        e.printStackTrace();
     }
     return con; 
 }
}
