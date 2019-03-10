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
                        <h1 class="page-header">Edit Product</h1>
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
								<form method="post" enctype="multipart/form-data">
									<input type="hidden" name="id" value="${requestScope.Product.id}"/>
									<h4>Name</h4>
									<input type="text" name="name" value="${requestScope.Product.name}" class="form-control" placeholder="Product Name"/>
									
									<h4>Selling Price</h4>
									<input type="text" name="sellingPrice" value="${requestScope.Product.sellingPrice}" class="form-control" placeholder="selling Price"/>
									<h4>Category</h4>
									<select name="categoryId" class="form-control">
										<c:forEach var="category" items="${requestScope.categories}"> 
											<option value="${category.getId()}"  >${category.getName()}</option>	
										</c:forEach>
									</select>
									<h4>Supplier</h4>
									<select name="supplierId" class="form-control">
										<c:forEach var="supplier" items="${requestScope.suppliers}"> 
											<option value="${supplier.getId()}">${supplier.getName()}</option>	
										</c:forEach>
									</select>
									
									<h4>Photo</h4>
									<img style="width:120px; height:120px" src="${initParam.baseurl}/files/pictures/${requestScope.Product.picture}"><br/>
									
									<input type="file" name="pic" ><br/>
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