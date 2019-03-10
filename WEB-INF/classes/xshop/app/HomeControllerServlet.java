package xshop.app;

import xshop.entity.*;
import xshop.core.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

public class HomeControllerServlet extends HttpServlet{
	HttpSession session;
	RequestDispatcher dispatcher;
	String baseurl;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletContext application=getServletContext();
		baseurl=application.getInitParameter("baseurl");
		session=request.getSession();
		List<Cart> cartlist=(List<Cart>)session.getAttribute("cartlist");
		request.setAttribute("cart", cartlist);
		String view = request.getServletPath().substring(1);
		if(view.equals("home")){
			Service<Category> service=new DataService().Create("Category");
			List<Category> category=service.getAll();
			request.setAttribute("categories", category);
			dispatcher = request.getRequestDispatcher("Home/home.jsp");
			dispatcher.forward(request, response);
		}
		else if(view.equals("productview")){
			iProductService service=new DataService().product();
			List<Product> product=service.getByCategory(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("products", product);
			dispatcher = request.getRequestDispatcher("Home/viewproduct.jsp");
			dispatcher.forward(request, response);
		}
		else if(view.equals("productbuy")){
			Service<Product> service=new DataService().Create("Product");
			Product product=service.getById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("product", product);
			dispatcher = request.getRequestDispatcher("Home/productbuy.jsp");
			dispatcher.forward(request, response);
		}
		else if(view.equals("viewcart")){
			
			dispatcher = request.getRequestDispatcher("Home/viewcart.jsp");
			dispatcher.forward(request, response);
		}
		else if(view.equals("confirmorder")){
			
			dispatcher = request.getRequestDispatcher("Home/confirmorder.jsp");
			dispatcher.forward(request, response);
		}
		else if(view.equals("cancelorder")){
			session.setAttribute("cart", null);
			response.sendRedirect(baseurl+"/home");
		}
		else{
			Service<Category> service=new DataService().Create("Category");
			List<Category> category=service.getAll();
			request.setAttribute("categories", category);
			dispatcher = request.getRequestDispatcher("Home/home.jsp");
			dispatcher.forward(request, response);
			
		}	
			
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletContext application=getServletContext();
		baseurl=application.getInitParameter("baseurl");
		session=request.getSession();
		List<Cart> cartlist=(List<Cart>)session.getAttribute("cart");
		if(cartlist==null){
			cartlist=new ArrayList<Cart>();	
		}
		String view = request.getServletPath().substring(1);
				
				//.......................................................................................................................................................................................................................action view 
		if(view.equals("productbuy")){
			Service<Product> service=new DataService().Create("Product");
			Product product=service.getById(Integer.parseInt(request.getParameter("id")));
			Cart cart=new Cart(Integer.parseInt(request.getParameter("quantity")),product);
			
			cartlist.add(cart);
			session.setAttribute("cart", cartlist);
			response.sendRedirect(baseurl+"/home");
		}
		else if(view.equals("confirmorder")){
			
			dispatcher = request.getRequestDispatcher("Home/confirmorder.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}