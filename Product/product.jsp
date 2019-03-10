<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Product</title>
    <script>
	function Search(value) {
			//alert(value);
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("product").innerHTML = xmlhttp.responseText;
				}
			};
			xmlhttp.open("GET","${initParam.baseurl}/productsearch?name="+value, true); //true=Asynchronous Request
			xmlhttp.send(); 
	}
	function SearchByCategory(value) {
			//alert(value);
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("product").innerHTML = xmlhttp.responseText;
				}
			};
			xmlhttp.open("GET","${initParam.baseurl}/productsearch?categoryId="+value, true); //true=Asynchronous Request
			xmlhttp.send(); 
	}
	function SearchBySupplier(value) {
			//alert(value);
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("product").innerHTML = xmlhttp.responseText;
				}
			};
			xmlhttp.open("GET","${initParam.baseurl}/productsearch?supplierId="+value, true); //true=Asynchronous Request
			xmlhttp.send(); 
	}
	</script>
	<jsp:include page="../Shared/adminLayout.jsp" /> 
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
                        <h1 class="page-header">Products</h1>
						<div class="row">
							<div class="col-sm-4">
								<a href="${initParam.baseurl}/productadd" class="btn btn-primary" role="button">Add Product</a>
							</div>
						</div><br/>
						<div class="row">
							<div class="col-sm-3">
								<select onchange="SearchByCategory(this.value)" class="form-control">
									<c:forEach var="category" items="${requestScope.categories}"> 
										<option value="${category.getId()}">${category.getName()}</option>	
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-3">
								<select onchange="SearchBySupplier(this.value)" class="form-control">
									<c:forEach var="supplier" items="${requestScope.suppliers}"> 
										<option value="${supplier.getId()}">${supplier.getName()}</option>	
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-4">
								<form method="post">
									<input type="text" onkeyup="Search(this.value) " name="name" placeholder="Search......." class="form-control"/>
									<noscript><input type="submit" value="Search" class="btn btn-default"/></noscript>
								</form>
							</div>
						</div><br/>
						<div class="row" id="product">
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
										<td><a href="${initParam.baseurl}/productadditem?id=${product.getId()}">Add New Item</a> |
										<a href="${initParam.baseurl}/productedit?id=${product.getId()}">Edit</a> |
										<a href="${initParam.baseurl}/productdetails?id=${product.getId()}">Details</a> |
										<a class="text-danger" href="${initParam.baseurl}/productdelete?id=${product.getId()}">Delete</a></td>
									</tr>
									</c:forEach>  
								</table>
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