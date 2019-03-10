<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.Category"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Category</title>
    
	<jsp:include page="../Shared/adminLayout.jsp" /> 
        <!-- Page Content -->
        
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Delete Category</h1>
						<div id="message">
							<c:set var="message" scope="page" value="${requestScope.message}"/> 
							<c:if test="${message!=null}"> 
								<div class="alert alert-danger alert-dismissable fade in">
									<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
									<strong>Errors!</strong> ${ requestScope.message }
								</div> 
							</c:if>  
						</div>
						<div class="row" id="category">
							<div class="col-sm-6">
							<h4 class="text-danger">Are Sure Want to Delete!!!</h4>
								<form method="post" >
									<input type="hidden" name="id" value="${requestScope.Category.id}"/>
									<h4>Name :
									<c:out value="${requestScope.Category.name}"/> </h4>
									<h4>Photo</h4>
									<img style="width:120px; height:120px" src="${initParam.baseurl}/files/pictures/${requestScope.Category.picture}"><br/>
									<br/>
									<input type="submit" value="Confirm" class="btn btn-danger"/>
								</form>
							</div>
						</div><br/>
						<a href="${initParam.baseurl}/category">Back To List</a>
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