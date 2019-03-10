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
							
							
								<div class="row">
									
									<div class="col-sm-6 col-sm-offset-3" style="padding:30px">
										<img style="width:100%; height:320px" src="${initParam.baseurl}/files/pictures/${product.picture}">
										<h4>Product ID : ${requestScope.product.id}</h4>
										<h4>Name :<c:out value="${requestScope.product.name}"/> </h4>
										<h4>Category :<c:out value="${requestScope.product.category.getName()}"/> </h4>
										<h4>Supplier :<c:out value="${requestScope.product.supplier.getName()}"/> </h4>
										<h4>Stock :<c:out value="${requestScope.product.stock}"/> </h4>
										<h4>Price :<c:out value="${requestScope.product.sellingPrice}"/> </h4>
										
											<c:if test="${requestScope.product.status==true}">
												<h4 class="text-success"><c:out value="Available"/></h4>
												<form method="post">
													<input type="hidden" name="id" value="${requestScope.product.id}"/>
													<h4>Quantity</h4>
													<input type="number" name="quantity" value="1" class="form-control"/>
													<br/>
													<input type="submit" value="Add to Cart" class="btn btn-primary"/>
												</form>
											</c:if> 
											<c:if test="${requestScope.product.status==false}">
												<h4 class="text-danger"><c:out value="Out of Stock"/></h4>
											</c:if> 
										
									</div>
									
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