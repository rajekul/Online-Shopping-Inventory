<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.Category"%>

							<div class="col-sm-10">
								<table class="table table-bordered table-striped">
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th >Action</th>
									</tr>
									
									<c:forEach var="category" items="${requestScope.categories}"> 
									   
									<tr>
										<td>${category.getId()}</td>
										<td>${category.getName()} </td>
										<td><a href="${initParam.baseurl}/categoryedit?id=${category.getId()}">Edit</a> |
										<a href="${initParam.baseurl}/categorydetails?id=${category.getId()}">Details</a> |
										<a class="text-danger" href="${initParam.baseurl}/categorydelete?id=${category.getId()}">Delete</a></td>
									</tr>
									</c:forEach>  
								</table>
							</div>