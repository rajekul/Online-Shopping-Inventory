<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <link href="${initParam.baseurl}/template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="${initParam.baseurl}/template/vendor/jquery/jquery.min.js"></script>
    <script src="${initParam.baseurl}/template/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script>
        
    </script>
    <style>
        body {
            font-family: Arial;
            margin-top: 50px;
            background-color:#f2f2f2;
        }

    </style>
    <title>Admin access</title>
</head>
<body>
    <div class="container">
        
        <div class="row">
            <div class="col-sm-4 col-sm-offset-4">
                <c:out value="JSTL WORKS"/> 
                <div class="panel panel-info">
                    <div class="panel-heading"><strong>Admin Access</strong></div>
                    <div class="panel-body">
                        <form class="form"  method="post" id="form">
                            <div class="form-group has-feedback">
                                <input type="text" id="username" name="username" placeholder="Username" class="form-control" value="${param.username}" />
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <input type="password" name="password" placeholder="Password" class="form-control" />
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                           <button id="btnSubmit"class="btn btn-primary pull-right" ><span class="glyphicon glyphicon-log-in"></span> Login</button>
                        </form>
                    </div>
                </div>

                <div id="message">
					<c:set var="message" scope="page" value="${requestScope.message}"/> 
                    <c:if test="${message!=null}"> 
						<div class="alert alert-danger alert-dismissable fade in">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							<strong>Opps!</strong> ${ requestScope.message }
						</div> 
					</c:if>  
                </div>
            </div>
        </div>
    </div>
</body>
</html>
