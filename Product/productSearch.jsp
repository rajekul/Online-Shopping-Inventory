<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.Category"%>

							<div class="col-sm-10">
								<table class="table table-bordered table-striped">
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th>Status</th>
										<th >Action</th>
									</tr>
									
									<c:forEach var="product" items="${requestScope.products}"> 
									   
									<tr>
										<td>${product.getId()}</td>
										<td>${product.getName()} </td>
										<td>
											<c:if test="${product.getStatus()==true}">
												<c:out value="Available"/>
											</c:if> 
											<c:if test="${product.getStatus()==false}">
												<c:out value="Out of Stock"/>
											</c:if> 
										</td>
										<td><a href="${initParam.baseurl}/productedit?id=${product.getId()}">Edit</a> |
										<a href="${initParam.baseurl}/productdetails?id=${product.getId()}">Details</a> |
										<a class="text-danger" href="${initParam.baseurl}/productdelete?id=${product.getId()}">Delete</a></td>
									</tr>
									</c:forEach>  
								</table>
							</div>