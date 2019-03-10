package xshop.app;

import xshop.config.FormValidation;
import xshop.entity.*;
import xshop.core.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import com.oreilly.servlet.MultipartRequest;  

public class CategoryControllerServlet extends HttpServlet{
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
				Service<Category> service=new DataService().Create("Category");
				String view = request.getServletPath().substring(1);
				//.......................................................................................................................................................................................................................action view 
				if(view.equals("category")){
					
					List<Category> category=service.getAll();
					request.setAttribute("categories", category);
					dispatcher = request.getRequestDispatcher("Category/category.jsp");
					dispatcher.forward(request, response);
				}
				//...........................................................................................................................................................................................................................action add
				else if(view.equals("categoryadd")){
					dispatcher = request.getRequestDispatcher("Category/categoryAdd.jsp");
					dispatcher.forward(request, response);
				}
				//.................................................................................................................................................................................................................................action edit
				else if(view.equals("categoryedit")){
					int id=Integer.parseInt(request.getParameter("id"));
					Category category=service.getById(id);
					request.setAttribute("Category", category);
					dispatcher = request.getRequestDispatcher("Category/categoryEdit.jsp");
					dispatcher.forward(request, response);
				}
				//......................................................................................................................................................................................................................................action delete
				else if(view.equals("categorydelete")){
					int id=Integer.parseInt(request.getParameter("id"));
					Category category=service.getById(id);
					request.setAttribute("Category", category);
					dispatcher = request.getRequestDispatcher("Category/categoryDelete.jsp");
					dispatcher.forward(request, response);
				}
				//.........................................................................................................................................................................................................................................action details
				else if(view.equals("categorydetails")){
					int id=Integer.parseInt(request.getParameter("id"));
					Category category=service.getById(id);
					request.setAttribute("Category", category);
					dispatcher = request.getRequestDispatcher("Category/categoryDetails.jsp");
					dispatcher.forward(request, response);
				}
				//.......................................................................................................................................................................................................................action search
				else if(view.equals("categorysearch")){
					//PrintWriter out = response.getWriter();
					//out.println(request.getParameter("name"));
					String name=request.getParameter("name");
					List<Category> category=service.search(name);
					request.setAttribute("categories", category);
					dispatcher = request.getRequestDispatcher("Category/categorySearch.jsp");
					dispatcher.include(request, response);
					
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
		ServletContext application=getServletContext();
		baseurl=application.getInitParameter("baseurl");
		session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null ){
			if(user.getType().equals("Admin")){
				response.setContentType("text/html"); 
				FormValidation v=new FormValidation();
				HttpSession session=request.getSession();
				Service<Category> service=new DataService().Create("Category");
				String view = request.getServletPath().substring(1);
				
				//.......................................................................................................................................................................................................................action view 
				if(view.equals("category")){
					//PrintWriter out = response.getWriter();
					//out.println(request.getParameter("name"));
					String name=request.getParameter("name");
					List<Category> category=service.search(name);
					request.setAttribute("categories", category);
					dispatcher = request.getRequestDispatcher("Category/category.jsp");
					dispatcher.forward(request, response);
				}
				//....................................................................................................................................................................................................................................................action add
				else if(view.equals("categoryadd")){
					MultipartRequest m=new MultipartRequest(request,"D:/tomcat-portable/apache-tomcat-8.0.35/webapps/X-shop/files/pictures");  
					String name = m.getParameter("name");
					boolean nameValid=v.requiredValidation(name,"Category Name Required");
					if(nameValid){
						if(m.getFilesystemName("pic") !=null){
							String pic=m.getFilesystemName("pic");
							Category category = new Category(name,pic);  
							if(service.add(category)){
								
								session.setAttribute("Success", "Successfully Added");
								response.sendRedirect(baseurl+"/category");
							}
							else{
								session.setAttribute("Failed", "Failed to add Category");
								response.sendRedirect(baseurl+"/category");
							}
						}
						else{
							dispatcher = request.getRequestDispatcher("Category/categoryAdd.jsp");
							request.setAttribute("message", "Photo required");
							dispatcher.include(request, response);
						}
					}
					else{
						dispatcher = request.getRequestDispatcher("Category/categoryAdd.jsp");
						request.setAttribute("message", v.getErrors());
						dispatcher.include(request, response);
					}
					
				}
				//........................................................................................................................................................................................................................................................................action edit
				else if(view.equals("categoryedit")){
					MultipartRequest m=new MultipartRequest(request,"D:/tomcat-portable/apache-tomcat-8.0.35/webapps/X-shop/files/pictures");  
					int id=Integer.parseInt(m.getParameter("id"));
					String name = m.getParameter("name");
					Category category=service.getById(id);
					
					
					boolean nameValid=v.requiredValidation(name,"Category Name Required");
					if(nameValid){
						category.setName(name);
						if(m.getFilesystemName("pic")!=null ){
							category.setPicture(m.getFilesystemName("pic"));
						}
						if(service.edit(category)){
							
							session.setAttribute("Success", "Successfully Updated");
							response.sendRedirect(baseurl+"/category");
						}
						else{
							session.setAttribute("Failed", "Failed to Update Category");
							response.sendRedirect(baseurl+"/category");
						}	
					}
					else{
						dispatcher = request.getRequestDispatcher("Category/categoryEdit.jsp");
						request.setAttribute("message", v.getErrors());
						dispatcher.include(request, response);
					}
				}
				//.......................................................................................................................................................................................................................action delete
				else if(view.equals("categorydelete")){
					int id=Integer.parseInt(request.getParameter("id"));
					service.remove(id);
					session.setAttribute("Success", "Successfully Deleted");
					response.sendRedirect(baseurl+"/category");
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
}