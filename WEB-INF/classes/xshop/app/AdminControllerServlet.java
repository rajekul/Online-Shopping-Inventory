package xshop.app;

import xshop.entity.*;
import xshop.core.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class AdminControllerServlet extends HttpServlet{
	HttpSession session;
	RequestDispatcher dispatcher;
	String baseurl;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletContext application=getServletContext();
		baseurl=application.getInitParameter("baseurl");
		session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null ){
			if(user.getType().equals("Admin")){
				String view = request.getServletPath().substring(1);
				if(view.equals("admin")){
					dispatcher = request.getRequestDispatcher("Admin/dashboard.jsp");
					dispatcher.forward(request, response);
				}
				else if(view.equals("purchases")){
					PurchaseService purchaseService=new PurchaseService();
					List<Purchase> purchase=purchaseService.getAll();
					request.setAttribute("purchases", purchase);
					dispatcher = request.getRequestDispatcher("Admin/purchase.jsp");
					dispatcher.forward(request, response);
				}
				else if(view.equals("purchasesearch")){
					PurchaseService purchaseService=new PurchaseService();
					List<Purchase> purchase=purchaseService.search(request.getParameter("date"));
					request.setAttribute("purchases", purchase);
					dispatcher = request.getRequestDispatcher("Admin/purchaseSearch.jsp");
					dispatcher.forward(request, response);
				}
			}
			else{
				response.sendRedirect(baseurl+"/error");
			}
		}
		else{
			
			response.sendRedirect(baseurl+"/error");
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
	}
}