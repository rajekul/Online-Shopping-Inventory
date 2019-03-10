<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.*"%>

							<div class="col-sm-10">
								<table class="table table-bordered table-striped">
									<tr>
										<th>Date</th>
										<th>Product</th>
										<th >Quantity</th>
										<th >Buying Price</th>
										
									</tr>
									
									<c:forEach var="purchase" items="${requestScope.purchases}"> 
									   
									<tr>
										<td>${purchase.getDate()}</td>
										<td>${purchase.product.getName()} </td>
										<td>${purchase.quantity} </td>
										<td>${purchase.buyingPrice} </td>
										
									</tr>
									</c:forEach>  
								</table>
							</div>
						