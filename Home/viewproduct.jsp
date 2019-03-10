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
							
							<c:forEach var="product" items="${requestScope.products}"> 
								
									<div class="col-sm-6" style="padding:40px">
										<img style="width:100%; height:320px" src="${initParam.baseurl}/files/pictures/${product.picture}">
										<a href="${initParam.baseurl}/productbuy?id=${product.id}" class="btn btn-primary " role="button"><i class="fa fa-hand-o-right fa-fw"></i>Shop ${product.name} | price: ${product.sellingPrice} </a>
										
										
										<c:if test="${product.status==true}">
											<h4 class="text-success"><c:out value="Available"/></h4>
										</c:if> 
										<c:if test="${product.status==false}">
											<h4 class="text-success"><c:out value="Out Of Stock"/></h4>
										</c:if> 
										
									</div>
									
								
							</c:forEach>  
								
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