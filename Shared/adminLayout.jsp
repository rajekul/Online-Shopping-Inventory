

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
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${initParam.baseurl}/admin">Xshop</a>
            </div>
            

            <ul class="nav navbar-top-links navbar-right">
                
                <!-- /.dropdown -->
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        
                        <li><a href="#"><i class="fa fa-gear fa-lock"></i> Change Password</a>
                        </li>
                        <li class="divider"></li>
                        <li class="text-danger"><a href="${initParam.baseurl}/adminaccess" ><i class="fa fa-sign-out fa-fw "></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <h3>&nbsp&nbsp<span class="glyphicon glyphicon-list pull-right"></span>MENU</h3> 
                        </li>
                        <li>
                            <a href="${initParam.baseurl}/admin"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="${initParam.baseurl}/product"><i class="fa fa-sitemap fa-fw"></i> Products<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="${initParam.baseurl}/category">Categories <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="${initParam.baseurl}/categoryadd">Add New</a>
                                        </li>
                                        <li>
                                            <a href="${initParam.baseurl}/category">View Categories</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
								<li>
                                    <a href="${initParam.baseurl}/supplier">Suppliers <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="${initParam.baseurl}/supplieradd">Add New</a>
                                        </li>
                                        <li>
                                            <a href="${initParam.baseurl}/supplier">View Suppliers</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
								<li>
                                    <a href="${initParam.baseurl}/product">Products <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="${initParam.baseurl}/productadd">Add New</a>
                                        </li>
                                        <li>
                                            <a href="${initParam.baseurl}/product">View Products</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
						<li>
                            <a href="${initParam.baseurl}/purchases"><i class="fa fa-bar-chart-o fa-fw"></i> Purchase History</a>
                        </li>
                        <li>
                            <a href="${initParam.baseurl}/order"><i class="fa fa-shopping-cart fa-fw"></i> Orders</a>
                        </li>
						<li>
                            <a href="${initParam.baseurl}/Invoice"><i class="fa fa-check fa-fw"></i> Invoices</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
		<div id="page-wrapper">
            <div class="container-fluid">
			<br/>
				
		
      