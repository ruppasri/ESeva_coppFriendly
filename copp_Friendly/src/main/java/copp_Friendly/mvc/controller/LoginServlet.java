package copp_Friendly.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import copp_Friendly.mvc.bean.LoginBean;
import copp_Friendly.trafficCopp.LoginDao;

public class LoginServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//System.out.println("hello");
 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        LoginBean loginBean = new LoginBean(); 
        loginBean.setUserName(username); 
        loginBean.setPassword(password);
 
        LoginDao loginDao = new LoginDao();
        String userValidate = loginDao.authenticateUser(loginBean);
    	//String userValidate="SUCCESS";
        if(userValidate.equals("SUCCESS1")) 
         {
             request.setAttribute("username", username); 
             request.getRequestDispatcher("Traffic.jsp").forward(request, response);
         }
        else if(userValidate.equals("SUCCESS2")) 
        {
            request.setAttribute("username", username); 
            request.getRequestDispatcher("Medical.jsp").forward(request, response);
        }
        else if(userValidate.equals("SUCCESS3")) 
        {
            request.setAttribute("username", username); 
            request.getRequestDispatcher("Central.jsp").forward(request, response);
        }
         else
         {
             request.setAttribute("errMessage", userValidate); 
             request.getRequestDispatcher("Login.jsp").forward(request, response);
         }
    }
}