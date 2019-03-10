

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

   
    <link href="${initParam.baseurl}/template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <link href="${initParam.baseurl}/template/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <link href="${initParam.baseurl}/template/dist/css/sb-admin-2.css" rel="stylesheet">

    <link href="${initParam.baseurl}/template/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<script src="${initParam.baseurl}/template/vendor/jquery/jquery.min.js"></script>

    <script src="${initParam.baseurl}/template/vendor/bootstrap/js/bootstrap.min.js"></script>

    <script src="${initParam.baseurl}/template/vendor/metisMenu/metisMenu.min.js"></script>

    <script src="${initParam.baseurl}/template/dist/js/sb-admin-2.js"></script>

    

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; background-color:black;color:red;">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${initParam.baseurl}/home">Xshop</a>
            </div>
            

            <ul class="nav navbar-top-links navbar-right">
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-cog fa-fw"></i>Options <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-globe fa-fw"></i> Track Order</a>
                        </li>
						<li><a href="${initParam.baseurl}/adminaccess"><i class="fa fa-globe fa-fw"></i> Admin Site</a>
                        </li>
                        
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-shopping-cart  fa-fw"></i> <strong> ${sessionScope.cart.size()}</strong>
						<i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
						
							<li>
								<a href="#">
									
									<div>
										<i class="fa fa-check fa-fw"></i>${sessionScope.cart[0].product.name} | q:${sessionScope.cart[0].quantity}
										<span class="pull-right text-muted small">${sessionScope.cart[0].product.sellingPrice * sessionScope.cart[0].quantity}</span>
									</div>
								</a>
							</li> 
						
                        
                        
                        
                        <li>
                            <a class="text-center" class="btn btn-primary " href="${initParam.baseurl}/viewcart">
                                <strong>View cart</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
		</nav>
        
            <div class="container-fluid">
			<br/>

      