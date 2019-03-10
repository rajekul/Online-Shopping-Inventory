<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="xshop.entity.Category"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Category </title>
    
	<jsp:include page="../Shared/adminLayout.jsp" /> 
        <!-- Page Content -->
        
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Add Category</h1>
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
								<form method="post" enctype="multipart/form-data">
									<h4>Name</h4>
									<input type="text" name="name" value="${param.name}" class="form-control" placeholder="Category Name"/>
									<h4>Photo</h4>
									<input type="file" name="pic" class="form-control"><br/>
									<input type="submit" value="Save" class="btn btn-primary"/>
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

