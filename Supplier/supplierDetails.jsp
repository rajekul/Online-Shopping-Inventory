<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.Supplier"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Supplier</title>
    
	<jsp:include page="../Shared/adminLayout.jsp" /> 
        <!-- Page Content -->
        
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Supplier Details</h1>
						<div id="message">
							<c:set var="message" scope="page" value="${requestScope.message}"/> 
							<c:if test="${message!=null}"> 
								<div class="alert alert-danger alert-dismissable fade in">
									<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
									<strong>Errors!</strong> ${ requestScope.message }
								</div> 
							</c:if>  
						</div>
						<div class="row">
							<div class="col-sm-6">
								<h4>ID : <c:out value="${requestScope.Supplier.id}"/></h4>
								<h4>Name :<c:out value="${requestScope.Supplier.name}"/> </h4>
								<h4>Contact :<c:out value="${requestScope.Supplier.contact}"/> </h4>
								
							</div>
						</div><br/>
						<a href="${initParam.baseurl}/supplieredit?id=${requestScope.Supplier.id}">Edit</a> | <a href="${initParam.baseurl}/supplier">Back To List</a>
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