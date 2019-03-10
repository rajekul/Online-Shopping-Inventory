<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.Supplier"%>

							<div class="col-sm-10">
								<table class="table table-bordered table-striped">
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th>Contact</th>
										<th >Action</th>
									</tr>
									
									<c:forEach var="supplier" items="${requestScope.suppliers}"> 
									   
									<tr>
										<td>${supplier.getId()}</td>
										<td>${supplier.getName()} </td>
										<td>${supplier.getContact()} </td>
										<td><a href="${initParam.baseurl}/supplieredit?id=${supplier.getId()}">Edit</a> |
										<a href="${initParam.baseurl}/supplierdetails?id=${supplier.getId()}">Details</a> |
										<a class="text-danger" href="${initParam.baseurl}/supplierdelete?id=${supplier.getId()}">Delete</a></td>
									</tr>
									</c:forEach>  
								</table>
							</div>