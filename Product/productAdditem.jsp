<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Product </title>
    
	<jsp:include page="../Shared/adminLayout.jsp" /> 
        <!-- Page Content -->
        
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Add New Item</h1>
						<div id="message">
							<c:set var="message" scope="page" value="${requestScope.message}"/> 
							<c:if test="${message!=null}"> 
								<div class="alert alert-danger alert-dismissable fade in">
									<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
									<strong>Errors!</strong> ${ requestScope.message }
								</div> 
							</c:if>  
						</div>
						<div class="row" >
							<div class="col-sm-6">
								<form method="post" >
									<input type="hidden" name="id" value="${requestScope.Product.id}"/>
									<h4>Name : ${requestScope.Product.name}</h4>
									<h4>Stock : ${requestScope.Product.stock}</h4>
									<h4>Items</h4>
									<input type="text" name="item" value="0" class="form-control" placeholder="item"/>
									<h4>Buying Price(total)</h4>
									<input type="text" name="buyingPrice" value="0" class="form-control" placeholder="price"/>
									<br/>
									<input type="submit" value="Save" class="btn btn-primary"/>
								</form>
							</div>
						</div><br/>
						<a href="${initParam.baseurl}/product">Back To List</a>
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