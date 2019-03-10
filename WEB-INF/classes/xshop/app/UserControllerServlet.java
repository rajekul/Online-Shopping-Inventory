package xshop.app;

import xshop.entity.User;
import xshop.core.*;
import xshop.config.FormValidation;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;


public class UserControllerServlet extends HttpServlet{
	RequestDispatcher dispatcher;
	String baseurl;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String view = request.getServletPath().substring(1);
		if(view.equals("adminaccess")){
			HttpSession session=request.getSession();
			session.setAttribute("user",null);
			dispatcher = request.getRequestDispatcher("User/adminAccess.jsp");
			dispatcher.forward(request, response);
		}
		else if(view.equals("logout")){
			
			dispatcher = request.getRequestDispatcher("User/adminAccess.jsp");
			dispatcher.forward(request, response);
		}
		else if(view.equals("error")){
			
			dispatcher = request.getRequestDispatcher("User/error.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		ServletContext application=getServletContext();
		baseurl=application.getInitParameter("baseurl");
		
		FormValidation v=new FormValidation();
		
		String view = request.getServletPath().substring(1);

		if(view.equals("adminaccess")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			boolean userValid,passwordValid;
			userValid=v.requiredValidation(username,"Username Required");
			passwordValid=v.requiredValidation(password,"password Required");
			
			if(userValid && passwordValid ){
				
				Service<User> service=new DataService().Create("User");
				User user=service.getByName(username);
				if(user!=null){
					if(user.getPassword().equals(password)){
						HttpSession session=request.getSession();
						session.setAttribute("user",user);
						if(user.getStatus().equals("Active")){
							if(user.getType().equals("Admin")){
								response.sendRedirect(baseurl+"/admin");
								//request.setAttribute("message", user.getType());
							}
							else{
								response.sendRedirect(baseurl+"/error");
							}
						}
						else{
							v.setErrors("You don't have any access!!");
						}
					}
					else{
						v.setErrors("Invalid Username or Password2");
					}
				}
				else{
					v.setErrors("Invalid Username or Password1");
				}
			}
				
			dispatcher = request.getRequestDispatcher("User/adminAccess.jsp");
			request.setAttribute("message", v.getErrors());
			dispatcher.include(request, response);
				
		}

		
	}
}