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

public class SupplierControllerServlet extends HttpServlet{
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
				Service<Supplier> service=new DataService().Create("Supplier");
				String view = request.getServletPath().substring(1);
				//.......................................................................................................................................................................................................................action view 
				if(view.equals("supplier")){
					
					List<Supplier> supplier=service.getAll();
					request.setAttribute("suppliers", supplier);
					dispatcher = request.getRequestDispatcher("Supplier/supplier.jsp");
					dispatcher.forward(request, response);
				}
				//...........................................................................................................................................................................................................................action add
				else if(view.equals("supplieradd")){
					dispatcher = request.getRequestDispatcher("Supplier/supplierAdd.jsp");
					dispatcher.forward(request, response);
				}
				//.................................................................................................................................................................................................................................action edit
				else if(view.equals("supplieredit")){
					int id=Integer.parseInt(request.getParameter("id"));
					Supplier supplier=service.getById(id);
					request.setAttribute("Supplier", supplier);
					dispatcher = request.getRequestDispatcher("Supplier/supplierEdit.jsp");
					dispatcher.forward(request, response);
				}
				//......................................................................................................................................................................................................................................action delete
				else if(view.equals("supplierdelete")){
					int id=Integer.parseInt(request.getParameter("id"));
					Supplier supplier=service.getById(id);
					request.setAttribute("Supplier", supplier);
					dispatcher = request.getRequestDispatcher("Supplier/supplierDelete.jsp");
					dispatcher.forward(request, response);
				}
				//.........................................................................................................................................................................................................................................action details
				else if(view.equals("supplierdetails")){
					int id=Integer.parseInt(request.getParameter("id"));
					Supplier supplier=service.getById(id);
					request.setAttribute("Supplier", supplier);
					dispatcher = request.getRequestDispatcher("Supplier/supplierDetails.jsp");
					dispatcher.forward(request, response);
				}
				//.......................................................................................................................................................................................................................action search
				else if(view.equals("suppliersearch")){
					//PrintWriter out = response.getWriter();
					//out.println(request.getParameter("name"));
					String name=request.getParameter("name");
					List<Supplier> supplier=service.search(name);
					request.setAttribute("suppliers", supplier);
					dispatcher = request.getRequestDispatcher("Supplier/supplierSearch.jsp");
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
				Service<Supplier> service=new DataService().Create("Supplier");
				String view = request.getServletPath().substring(1);
				
				//.......................................................................................................................................................................................................................action view 
				if(view.equals("supplier")){
					//PrintWriter out = response.getWriter();
					//out.println(request.getParameter("name"));
					String name=request.getParameter("name");
					List<Supplier> supplier=service.search(name);
					request.setAttribute("suppliers", supplier);
					dispatcher = request.getRequestDispatcher("Supplier/supplier.jsp");
					dispatcher.forward(request, response);
				}
				//....................................................................................................................................................................................................................................................action add
				else if(view.equals("supplieradd")){
					String name = request.getParameter("name");
					String contact = request.getParameter("contact");
					boolean nameValid=v.requiredValidation(name,"Supplier Name Required");
					boolean contactValid=v.phoneValidation(contact);
					if(nameValid && contactValid){
						Supplier supplier = new Supplier(name,contact);  
						if(service.add(supplier)){
							
							session.setAttribute("Success", "Successfully Added");
							response.sendRedirect(baseurl+"/supplier");
						}
						else{
							session.setAttribute("Failed", "Failed to add Supplier");
							response.sendRedirect(baseurl+"/supplier");
						}
						
					}
					else{
						dispatcher = request.getRequestDispatcher("Supplier/supplierAdd.jsp");
						request.setAttribute("message", v.getErrors());
						dispatcher.include(request, response);
					}
					
				}
				//........................................................................................................................................................................................................................................................................action edit
				else if(view.equals("supplieredit")){
					
					int id=Integer.parseInt(request.getParameter("id"));
					Supplier supplier=service.getById(id);
					String name = request.getParameter("name");
					String contact = request.getParameter("contact");
					boolean nameValid=v.requiredValidation(name,"Supplier Name Required");
					boolean contactValid=v.phoneValidation(contact);
					if(nameValid && contactValid){
						supplier.setName(name);
						supplier.setContact(contact);
						
						if(service.edit(supplier)){
							
							session.setAttribute("Success", "Successfully Updated");
							response.sendRedirect(baseurl+"/supplier");
						}
						else{
							session.setAttribute("Failed", "Failed to Update Supplier");
							response.sendRedirect(baseurl+"/supplier");
						}	
					}
					else{
						dispatcher = request.getRequestDispatcher("Supplier/supplierEdit.jsp");
						request.setAttribute("message", v.getErrors());
						dispatcher.include(request, response);
					}
				}
				//.......................................................................................................................................................................................................................action delete
				else if(view.equals("supplierdelete")){
					int id=Integer.parseInt(request.getParameter("id"));
					service.remove(id);
					session.setAttribute("Success", "Successfully Deleted");
					response.sendRedirect(baseurl+"/supplier");
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