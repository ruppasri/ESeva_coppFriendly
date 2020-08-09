package copp_Friendly.trafficCopp;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import copp_Friendly.mvc.bean.RegisterEBean;
import copp_Friendly.mvc.util.DBConnection;

public class RegisterEDao {

	public String registerUser(RegisterEBean registerBean)
    {
		System.out.println("1");
        int fullName = Integer.parseInt(registerBean.getNoaffected());
        System.out.println("1");
        int phone = Integer.parseInt(registerBean.getNoem());
        System.out.println("1");
        double longitude = Double.parseDouble(registerBean.getLongitude());
        System.out.println("1");
        double latitude= Double.parseDouble("79.804688");
        System.out.println("1");
        String location= registerBean.getLocation();
        System.out.println("1");
        Connection con = null;
        System.out.println("1");
        PreparedStatement preparedStatement = null;         
        try
        {
        	System.out.println("2");
            con = DBConnection.createConnection();
            System.out.println("3");
            String query = "insert into emergency values (null,?,?,?,?,?)"; //Insert user details into the table 'USERS'
            System.out.println("4");
            preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setInt(1, fullName);
            preparedStatement.setInt(2, phone);
            preparedStatement.setString(3, location);
            preparedStatement.setDouble(4, latitude);
            preparedStatement.setDouble(5, longitude);
            System.out.println("5");
            
            int i= preparedStatement.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
	
}