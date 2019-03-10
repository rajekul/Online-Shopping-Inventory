<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>xshop</title>
    
	<jsp:include page="../Shared/HomeLayout.jsp" /> 
        <!-- Page Content -->
				<div class="row">
					<div class="col-sm-10">
						<c:if test="${sessionScope.Success!=null}"> 
							<div class="alert alert-success alert-dismissable fade in">
								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								<strong>Success!</strong> ${ sessionScope.Success }
							</div> 
						</c:if> 
						<c:set var="Success" scope="session" value="${null}"/>
						<c:if test="${sessionScope.Failed!=null}"> 
							<div class="alert alert-danger alert-dismissable fade in">
								<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
								<strong>Failed!</strong> ${ sessionScope.Failed }
							</div> 
						</c:if> 
						<c:set var="Failed" scope="session" value="${null}"/>
					</div>
				</div>
                <div class="row">
                    <div class="col-lg-12">
                        
						
						<div class="row">
							<div class="col-sm-4 col-sm-offset-2">
							<h1>Delivery Information</h1>
								<form method="post" >
									<h4>Name</h4>
									<input type="text" name="name" value="${param.name}" class="form-control" placeholder=" Name"/>
									<h4>Phone</h4>
									<input type="text" name="phone" value="${param.phone}" class="form-control" placeholder=" phone"/>
									<h4>Address</h4>
									<input type="text" name="address" value="${param.address}" class="form-control" placeholder=" address"/>
									<br/>
									<a href="${initParam.baseurl}/cancelorder" class="btn btn-default" role="button">Cancel Order</a>
									<input type="submit" value="Confirm" class="btn btn-primary"/>
								</form>
							</div>
							<div class="col-sm-4">
							
							<h1>Order Details</h1>
							<table class="table table-bordered table-striped">
									<tr>
										<th>Product</th>
										<th>Id</th>
										<th>Name</th>
										<th>quantity</th>
										<th >Price</th>
									</tr>
									<c:set var="Nettotal" scope="session" value="${0}"/>  
									<c:forEach var="carts" items="${sessionScope.cart}"> 
									   
									<tr>
										<td><img style="width:30px; height:30px" src="${initParam.baseurl}/files/pictures/${carts.product.getPicture()}"></td>
										<td>${carts.product.getId()}</td>
										<td>${carts.product.getName()} </td>
										<td>
											${carts.quantity}
										</td>
										<td>
											${carts.quantity * carts.product.sellingPrice}
										</td>
									</tr>
									<c:set var="Nettotal" scope="session" value="${Nettotal+(carts.quantity * carts.product.sellingPrice)}"/> 
									</c:forEach>
									<tr>
										<td colspan="4" align="right">
											Total
										</td>
										<td >
											${Nettotal}
										</td>
									</tr>
								</table><br/>
								
								
								</div>
						</div>
						
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>


</body>

</html>