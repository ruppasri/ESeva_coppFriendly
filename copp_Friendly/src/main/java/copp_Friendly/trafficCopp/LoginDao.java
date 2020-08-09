package copp_Friendly.trafficCopp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import copp_Friendly.mvc.bean.LoginBean;
import copp_Friendly.mvc.util.DBConnection;
 
public class LoginDao {
     public String authenticateUser(LoginBean loginBean)
     {
         String userName = loginBean.getUserName(); //Assign user entered values to temporary variables.
         String password = loginBean.getPassword();
 
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
         
         String userNameDB = "";
         String passwordDB = "";
         String postDB="";
         try
         {
             con = DBConnection.createConnection(); 
             statement = con.createStatement(); 
             resultSet = statement.executeQuery("select username,password,post from login;"); 
             System.out.println("Dao");
             while(resultSet.next())
             {
              userNameDB = resultSet.getString("username"); 
              passwordDB = resultSet.getString("password");
              postDB = resultSet.getString("post");
               if(userName.equals(userNameDB) && password.equals(passwordDB))
               {
            	   System.out.println(postDB);
            	   
            	   System.out.println("Hello");
            	   if(postDB.equalsIgnoreCase("sergent") || postDB.equalsIgnoreCase("inspector")) {
            		   try {
                    	   statement.executeUpdate("create table if not exists "+userName+" (sln int not null auto_increment primary key, message varchar(200) not null);");
                    	   }catch(SQLException e) {
                    		   e.printStackTrace();
                    	   }
            		   return "SUCCESS1";}
            	   else if(postDB.equalsIgnoreCase("medical team")) return "SUCCESS2";
            	   else if(postDB.equalsIgnoreCase("central team")) return "SUCCESS3";
               }
             }}
             catch(SQLException e)
             {
            	 e.printStackTrace();
             }
             return "Invalid user credentials"; 
         }
     }
