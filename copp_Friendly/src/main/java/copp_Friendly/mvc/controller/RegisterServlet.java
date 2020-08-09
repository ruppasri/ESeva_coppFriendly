package copp_Friendly.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import copp_Friendly.mvc.bean.RegisterBean;
import copp_Friendly.trafficCopp.RegisterDao;
import copp_Friendly.trafficCopp.sendSMS;
 
public class RegisterServlet extends HttpServlet {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
         String fullName = request.getParameter("fullname");
         String phone = (request.getParameter("phone"));
         String latitude = request.getParameter("latitude");
         String longitude= request.getParameter("longitude");
         String license = request.getParameter("license");
         String roffender = request.getParameter("roffender");
         String vehicle = request.getParameter("vehicle");
         String location = request.getParameter("location");
         String type = request.getParameter("type");
         String fine = request.getParameter("fine");
         RegisterBean registerBean = new RegisterBean();
    
         registerBean.setName(fullName);
         registerBean.setPhone(phone);
         registerBean.setLicense(license); 
         registerBean.setLatitude(latitude);
         registerBean.setRoffender(roffender);
         registerBean.setVehicle(vehicle); 
         registerBean.setLongitude(longitude);
         registerBean.setLocation(location);
         registerBean.setType(type);
         registerBean.setFine(fine);
         
         RegisterDao registerDao = new RegisterDao();
         sendSMS send=new sendSMS();
         String userRegistered = registerDao.registerUser(registerBean);
         String s=send.sendSms(registerBean);
         System.out.println(s);
         if(userRegistered.equals("SUCCESS"))   
         {
        	 request.setAttribute("errMessage","Registered Successfully");
            request.getRequestDispatcher("/Traffic.jsp").forward(request, response);
         }
         else   
         {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/Traffic.jsp").forward(request, response);
         }
     }
}