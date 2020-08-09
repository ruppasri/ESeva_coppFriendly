package copp_Friendly.trafficCopp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import copp_Friendly.mvc.bean.RegisterBean;
import copp_Friendly.mvc.util.DBConnection;
 
public class RegisterDao { 
     public String registerUser(RegisterBean registerBean)
     {
         String fullName = registerBean.getName();
         String phone = registerBean.getPhone();
         String location = registerBean.getLocation();
         double latitude = Double.parseDouble(registerBean.getLatitude());
         double longitude = Double.parseDouble(registerBean.getLongitude());
         String license = registerBean.getLicense();
         String roffender = registerBean.getRoffender();
         String vehicle = registerBean.getVehicle();
         String type = registerBean.getType();
         String date = registerBean.getDate();
         int fine =Integer.parseInt(registerBean.getFine());
         
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into violation(sln,fullName,phone,location,license,vehicle,roffender,violation_type,date,latitude,longitude,fine) values (null,?,?,?,?,?,?,?,?,?,?,?)"; 
             preparedStatement = con.prepareStatement(query); 
             preparedStatement.setString(1, fullName);
             preparedStatement.setString(2, phone);
             preparedStatement.setString(3, location);
             preparedStatement.setString(4, license);
             preparedStatement.setString(5, vehicle);
             preparedStatement.setString(6, roffender);
             preparedStatement.setString(7, type);
             preparedStatement.setString(8, date);
             preparedStatement.setDouble(9, latitude);
             preparedStatement.setDouble(10, longitude);
             preparedStatement.setInt(11, fine);
             
             int i= preparedStatement.executeUpdate();
             
             if (i!=0) 
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!"; 
     }
}
