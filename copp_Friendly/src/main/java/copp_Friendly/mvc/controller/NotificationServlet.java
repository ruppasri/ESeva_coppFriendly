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

import copp_Friendly.mvc.util.DBConnection;

public class NotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String) request.getParameter("username");
		String num=(String ) request.getParameter("num");
		double latitude=79;
		double longitude=10;
		System.out.println(username+" NotificationServlet");
		if (num.equals("0")) {
		request.setAttribute("username", username); 
        request.getRequestDispatcher("Notification.jsp").forward(request, response);
		}else if(num.equals("1")){
			request.setAttribute("username", username); 
	        request.getRequestDispatcher("Traffic.jsp").forward(request, response);
		}else {
			String date=(String) request.getParameter("date");
			String location="nagapattinam";
			Connection con = null;
	         PreparedStatement preparedStatement = null;  
	         Statement stat=null;
	         //ResultSet res=null;
	         try
	         {
	        	 System.out.println("hello");
	             con = DBConnection.createConnection();
	             stat = con.createStatement();
	             String query = "insert into sos values (null,\""+username+"\",\""+location+"\","+latitude+","+longitude+",\""+date+"\")"; 
	             stat.executeUpdate(query);
	             System.out.println("hello");
	             
	             //int i= preparedStatement.executeUpdate();
	         }
	         catch(SQLException e)
	         {
	            e.printStackTrace();
	         }   
	         request.getRequestDispatcher("/Traffic.jsp").forward(request, response);
		}
	}

}
