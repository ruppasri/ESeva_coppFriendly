package copp_Friendly.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class MedicalServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("11111");
        String  numem = request.getParameter("numem");
        String numaffec = request.getParameter("numaffec");
        String location = request.getParameter("location");
//        String  numem = "1";
//        String numaffec = "2";
//        String location = "nagapattinam";
        System.out.println(numem+" "+numaffec+" "+location);
    	//String userValidate="SUCCESS";
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
            System.out.println(numem+" "+numaffec+" "+location);
            statement = con.createStatement(); 
            resultSet = statement.executeQuery("select  latitude ,  longitude from emergency where location=\""+location+"\";"); 
            resultSet.next();
            System.out.println(numem+" "+numaffec+" "+location);
            latitude= resultSet.getDouble("latitude"); 
            System.out.println(numem+" "+numaffec+" "+location);
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
            res=stat.executeQuery("select username from login order by abs(longitude-"+longitude+"),abs(latitude-"+latitude+") and post=\"sergent\" ;");
            System.out.println(latitude+" "+longitude);
            int i=0;
            res.next();
            while(res.next()&& i<=(Integer.parseInt(numem)+Integer.parseInt(numaffec))/3) {
            	String s=res.getString("username");
            	String str="Medical Team : Emergency near "+location+" and your asked to asked to go there immediately .";
            	System.out.println(s);
            	stat.executeUpdate("insert into "+s+" (sln,message) values (null,\""+str+"\");"); 
                i=i+1;
                System.out.println(s);
                
        
            }
            System.out.println(latitude+" "+longitude);
            stat.close();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
        request.getRequestDispatcher("/Medical.jsp").forward(request, response);
    }
}