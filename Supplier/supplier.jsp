<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.Supplier"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Supplier</title>
    <script>
	function Search(value) {
			//alert(value);
			var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("supplier").innerHTML = xmlhttp.responseText;
				}
			};
			xmlhttp.open("GET","${initParam.baseurl}/suppliersearch?name="+value, true); //true=Asynchronous Request
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
                        <h1 class="page-header">Suppliers</h1>
						<div class="row">
							<div class="col-sm-4">
								<a href="${initParam.baseurl}/supplieradd" class="btn btn-primary" role="button">Add Supplier</a>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-4 col-sm-offset-6">
								<form method="post">
									<input type="text" onkeyup="Search(this.value) " name="name" placeholder="Search......." class="form-control"/>
									<noscript><input type="submit" value="Search" class="btn btn-default"/></noscript>
								</form>
							</div>
						</div><br/>
						<div class="row" id="supplier">
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