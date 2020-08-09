package copp_Friendly.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import copp_Friendly.mvc.bean.RegisterEBean;
import copp_Friendly.trafficCopp.RegisterEDao;

public class RegisterEServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         //System.out.println("RegisterEServlet");
	         String fullName = request.getParameter("numaffec");
	         String phone = (request.getParameter("numem"));
	         String longitude = request.getParameter("longitude");
	         String latitude = request.getParameter("latitude");
	         String location = request.getParameter("location");
	         //System.out.println(fullName+" "+phone+" "+longitude+" "+latitude+" "+location);
	         RegisterEBean registerEBean = new RegisterEBean();
	         //System.out.println(fullName+" "+phone+" "+longitude+" "+latitude+" "+location);
	         registerEBean.setNoaffected(fullName);
	         registerEBean.setNoem(phone);
	         registerEBean.setLongitude(longitude);
	         registerEBean.setLatitude(latitude);
	         registerEBean.setLocation(location);
	         //System.out.println("registereservlet");
	         RegisterEDao registerDao = new RegisterEDao();
	         //System.out.println("registereservlet");
	         String userRegistered = registerDao.registerUser(registerEBean);
	         //System.out.println("registereservlet");
	         if(userRegistered.equals("SUCCESS"))   
	         {
	        	 request.setAttribute("errMessage", "Registered Successfully");
	            request.getRequestDispatcher("/Traffic.jsp").forward(request, response);
	         }
	         else   
	         {
	            request.setAttribute("errMessage", userRegistered);
	            request.getRequestDispatcher("/Traffic.jsp").forward(request, response);
	            
	         }
	     }
	 

}