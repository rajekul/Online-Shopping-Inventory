package xshop.app;

import xshop.config.FormValidation;
import xshop.entity.*;
import xshop.core.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import com.oreilly.servlet.MultipartRequest;
import java.util.*;

public class ProductControllerServlet extends HttpServlet{
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
				Service<Product> service=new DataService().Create("Product");
				Service<Category> categoryService=new DataService().Create("Category");
				Service<Supplier> supplierService=new DataService().Create("Supplier");
				String view = request.getServletPath().substring(1);
				//.......................................................................................................................................................................................................................action view 
				if(view.equals("product")){
					List<Category> category= categoryService.getAll();
					request.setAttribute("categories",category );
					List<Supplier> supplier=supplierService.getAll();
					request.setAttribute("suppliers",supplier );
					List<Product> product=service.getAll();
					request.setAttribute("products",product );
					dispatcher = request.getRequestDispatcher("Product/product.jsp");
					dispatcher.forward(request, response);
				}
				//...........................................................................................................................................................................................................................action add
				else if(view.equals("productadd")){
					List<Category> category= categoryService.getAll();
					request.setAttribute("categories",category );
					List<Supplier> supplier=supplierService.getAll();
					request.setAttribute("suppliers",supplier );
					dispatcher = request.getRequestDispatcher("Product/productAdd.jsp");
					dispatcher.forward(request, response);
				}
				//.................................................................................................................................................................................................................................action edit
				else if(view.equals("productedit")){
					List<Category> category= categoryService.getAll();
					request.setAttribute("categories",category );
					List<Supplier> supplier=supplierService.getAll();
					request.setAttribute("suppliers",supplier );
					int id=Integer.parseInt(request.getParameter("id"));
					Product product=service.getById(id);
					request.setAttribute("Product", product);
					dispatcher = request.getRequestDispatcher("Product/productEdit.jsp");
					dispatcher.forward(request, response);
				}
				//.................................................................................................................................................................................................................................action additem
				else if(view.equals("productadditem")){
					int id=Integer.parseInt(request.getParameter("id"));
					Product product=service.getById(id);
					request.setAttribute("Product", product);
					dispatcher = request.getRequestDispatcher("Product/productAdditem.jsp");
					dispatcher.forward(request, response);
				}
				//......................................................................................................................................................................................................................................action delete
				else if(view.equals("productdelete")){
					int id=Integer.parseInt(request.getParameter("id"));
					Product product=service.getById(id);
					request.setAttribute("Product", product);
					dispatcher = request.getRequestDispatcher("Product/productDelete.jsp");
					dispatcher.forward(request, response);
				}
				//.........................................................................................................................................................................................................................................action details
				else if(view.equals("productdetails")){
					int id=Integer.parseInt(request.getParameter("id"));
					Product product=service.getById(id);
					request.setAttribute("Product", product);
					dispatcher = request.getRequestDispatcher("Product/productDetails.jsp");
					dispatcher.forward(request, response);
				}
				//.......................................................................................................................................................................................................................action search
				else if(view.equals("productsearch")){
					//PrintWriter out = response.getWriter();
					//out.println(request.getParameter("name"));
					List<Product> product=null;
					if(request.getParameter("name")!=null){
						String name=request.getParameter("name");
						product=service.search(name);
					}
					else if(request.getParameter("categoryId")!=null){
						int id=Integer.parseInt(request.getParameter("categoryId"));
						product=new DataService().product().getByCategory(id);
					}
					else if(request.getParameter("supplierId")!=null){
						int id=Integer.parseInt(request.getParameter("supplierId"));
						product=new DataService().product().getBySupplier(id);
					}
					request.setAttribute("products", product);
					dispatcher = request.getRequestDispatcher("Product/productSearch.jsp");
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
				Service<Product> service=new DataService().Create("Product");
				Service<Category> categoryService=new DataService().Create("Category");
				Service<Supplier> supplierService=new DataService().Create("Supplier");
				String view = request.getServletPath().substring(1);
				
				//.......................................................................................................................................................................................................................action view 
				if(view.equals("product")){
					//PrintWriter out = response.getWriter();
					//out.println(request.getParameter("name"));
					String name=request.getParameter("name");
					List<Product> product=service.search(name);
					request.setAttribute("products", product);
					dispatcher = request.getRequestDispatcher("Product/product.jsp");
					dispatcher.forward(request, response);
				}
				//....................................................................................................................................................................................................................................................action add
				else if(view.equals("productadd")){
					MultipartRequest m=new MultipartRequest(request,"D:/tomcat-portable/apache-tomcat-8.0.35/webapps/X-shop/files/pictures");  
					String name = m.getParameter("name");
					
					int categoryId=Integer.parseInt(m.getParameter("categoryId"));
					int supplierId=Integer.parseInt(m.getParameter("supplierId"));
					boolean nameValid=v.requiredValidation(name,"Product Name Required");
					
					if(nameValid ){
						if(m.getFilesystemName("pic") !=null){
							String pic=m.getFilesystemName("pic");
							Product product = new Product(name,0,0,0,pic,categoryService.getById(categoryId),supplierService.getById(supplierId));  
							if(service.add(product)){
								session.setAttribute("Success", "Successfully Added");
								response.sendRedirect(baseurl+"/product");
							}
							else{
								session.setAttribute("Failed", "Failed to add product");
								response.sendRedirect(baseurl+"/product");
							}
						}
						else{
							List<Category> category= categoryService.getAll();
							request.setAttribute("categories",category );
							List<Supplier> supplier=supplierService.getAll();
							request.setAttribute("suppliers",supplier );
							dispatcher = request.getRequestDispatcher("Product/productAdd.jsp");
							request.setAttribute("message", "Photo required");
							dispatcher.include(request, response);
						}
					}
					else{
						List<Category> category= categoryService.getAll();
						request.setAttribute("categories",category );
						List<Supplier> supplier=supplierService.getAll();
						request.setAttribute("suppliers",supplier );
						dispatcher = request.getRequestDispatcher("Product/productAdd.jsp");
						request.setAttribute("message", v.getErrors());
						dispatcher.include(request, response);
					}
					
				}
				//........................................................................................................................................................................................................................................................................action edit
				else if(view.equals("productedit")){
					MultipartRequest m=new MultipartRequest(request,"D:/tomcat-portable/apache-tomcat-8.0.35/webapps/X-shop/files/pictures");  
					int id=Integer.parseInt(m.getParameter("id"));
					Product product=service.getById(id);
					String name = m.getParameter("name");
					
					double sellingPrice = Double.parseDouble(m.getParameter("sellingPrice"));
					int categoryId=Integer.parseInt(m.getParameter("categoryId"));
					int supplierId=Integer.parseInt(m.getParameter("supplierId"));
					boolean nameValid=v.requiredValidation(name,"Product Name Required");
					
					boolean sellingPriceValid=v.requiredValidation(String.valueOf(sellingPrice),"Selling Price Required");
					if(nameValid  && sellingPriceValid){
						product.setName(name);
						product.setSellingPrice(sellingPrice);
						product.addCategory(categoryService.getById(categoryId));
						product.addSupplier(supplierService.getById(supplierId));
						if(m.getFilesystemName("pic")!=null ){
							product.setPicture(m.getFilesystemName("pic"));
						}
						if(service.edit(product)){
							
							session.setAttribute("Success", "Successfully Updated");
							response.sendRedirect(baseurl+"/product");
						}
						else{
							session.setAttribute("Failed", "Failed to Update product");
							response.sendRedirect(baseurl+"/product");
						}	
					}
					else{
						session.setAttribute("Failed", "Failed to Update product");
						response.sendRedirect(baseurl+"/product");
					}
				}
				//........................................................................................................................................................................................................................................................................action edit
				else if(view.equals("productadditem")){
					 
					int id=Integer.parseInt(request.getParameter("id"));
					Product product=service.getById(id);
					int item=Integer.parseInt(request.getParameter("item"));
					boolean itemValid=v.requiredValidation(String.valueOf(item),"Product Name Required");
					double buyingPrice = Double.parseDouble(request.getParameter("buyingPrice"));
					boolean buyingPriceValid=v.requiredValidation(String.valueOf(buyingPrice),"buying Price Required");
					if(itemValid  && buyingPriceValid){
						product.setStock(product.getStock()+item);
						product.setBuyingPrice(product.getBuyingPrice()+buyingPrice);
						
						if(service.edit(product)){
							Purchase purchase=new Purchase("2017/05/03",item,buyingPrice,product);
							new PurchaseService().add(purchase);
							session.setAttribute("Success", "Successfully Added New item");
							response.sendRedirect(baseurl+"/product");
						}
						else{
							session.setAttribute("Failed", "Failed to Update product");
							response.sendRedirect(baseurl+"/product");
						}	
					}
					else{
						session.setAttribute("Failed", "Failed to Update product");
						response.sendRedirect(baseurl+"/product");
					}
				}
				//.......................................................................................................................................................................................................................action delete
				else if(view.equals("productdelete")){
					int id=Integer.parseInt(request.getParameter("id"));
					service.remove(id);
					session.setAttribute("Success", "Successfully Deleted");
					response.sendRedirect(baseurl+"/product");
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