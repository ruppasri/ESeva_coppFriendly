package copp_Friendly.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
//import copp_Friendly.mvc.bean.MedicalBean;
import copp_Friendly.mvc.util.DBConnection;
//import copp_Friendly.trafficCopp.MedicalDao;

public class CentralServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("11111");
        String  name= request.getParameter("name");
        String location = request.getParameter("location");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        Connection con = null; 
        Statement statement = null;
        ResultSet resultSet = null;
        Statement stat=null;
        ResultSet res=null;
        double longitude=0;
        double latitude=0;
        try
        {
            con = DBConnection.createConnection();
            statement = con.createStatement(); 
            resultSet = statement.executeQuery("select  latitude ,  longitude from sos where location=\""+location+"\";"); 
            resultSet.next();
            
            latitude= resultSet.getDouble("latitude"); 
           
            longitude = resultSet.getDouble("longitude");
            System.out.println(latitude+" "+longitude);
            statement.close();
            
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        } 
        try {
        	stat = con.createStatement();
            res=stat.executeQuery("select username from login where post=\"sergent\"order by abs(longitude-"+longitude+"),abs(latitude-"+latitude+") ;");
            System.out.println(latitude+" "+longitude);
            int i=0;
            res.next();
            while(res.next()&& i<=(Integer.parseInt(numem)+Integer.parseInt(numaffec))/3) {
            	String s=res.getString("username");
            	String str="Central Team : Emergency near "+location+" and your asked to asked to go there immediately .";
            	System.out.println(s);
            	stat.executeUpdate("insert into "+s+" (sln,message) values (null,\""+str+"\");"); //Insert user details into the table 'USERS'
                i=i+1;
                System.out.println(s);
                
        
            }
            System.out.println(latitude+" "+longitude);
            stat.close();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        request.getRequestDispatcher("/NotificationC.jsp").forward(request, response);
    }
}