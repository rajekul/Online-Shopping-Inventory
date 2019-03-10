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
							
							<c:forEach var="category" items="${requestScope.categories}"> 
								<div class="row">
									<div class="col-sm-10 col-sm-offset-1" >
										<img style="width:100%; height:320px" src="${initParam.baseurl}/files/pictures/${category.picture}">
										<a href="${initParam.baseurl}/productview?id=${category.id}" class="btn btn-primary btn-large" role="button"><i class="fa fa-hand-o-right fa-fw"></i>Shop ${category.name}</a>
							
									</div>
									<div class="col-sm-1" >

							
									</div>
								</div><br/>
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