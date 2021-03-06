<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include  page="copyright.jsp"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="left" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
 <link rel="stylesheet"  type="text/css"  href="<%=path%>/css/style.css"/> 
<link href="<%=path%>/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="<%=path%>/css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="<%=path%>/css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="<%=path%>/css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<link rel="stylesheet" href="<%=path%>/css/main.css" type='text/css' />
<!-- chart -->
<script src="<%=path%>/js/Chart.js"></script>
<!-- //chart -->
<!--animate-->
<link href="<%=path%>/css/animate.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="<%=path%>/css/weather.css" type='text/css' />
<script src="<%=path%>/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!----webfonts--->

<!---//webfonts---> 
 <!-- Meters graphs -->
<script src="<%=path%>/js/jquery-1.10.2.min.js"></script>
<!-- Placed js at the end of the document so the pages load faster -->

</head> 
   
 <body class="sticky-header left-side-collapsed">
    <section>
    <!-- left side start-->
		<div class="left-side sticky-left-side">

			<!--logo and iconic logo start-->
			<div class="logo">
				<h1><a href="index.jsp">您好！ <span>欢迎使用</span></a></h1>
			</div>
			<div class="logo-icon text-center">
				<a href="index.jsp"><i class="lnr lnr-home"></i> </a>
			</div>

			<!--logo and iconic logo end-->
			<div class="left-side-inner">

				<!--sidebar nav start-->
					<ul class="nav nav-pills nav-stacked custom-nav">
					<li><span>&nbsp;&nbsp;</span></li>
						<li class="active"><a href="index.jsp"><i class="lnr lnr-power-switch"></i><span>返回</span></a></li>
						<li class="menu-list">
							<a href="#"><i class="fa fa-tasks"></i>
								<span>货品管理</span></a>
							  <ul class="sub-menu-list">
									<li><a href="">添加</a> </li>
									<li><a href="">修改</a></li>
									<li><a href="">删除</a></li>
								</ul>
						</li>
					  <li><a href=""><i class="lnr lnr-spell-check"></i> <span>&nbsp;&nbsp;出货管理</span></a>
					  <ul class="sub-menu-list">
								<li><a href=""></a> </li>
								<li><a href=""></a> </li>
							</ul>
							</li>
					  <li><a href=""><i class="lnr lnr-user"></i> <span>&nbsp;&nbsp;客户管理</span></a> 
					  <ul class="sub-menu-list">
								<li><a href=""></a> </li>
								<li><a href=""></a> </li>
							</ul>           
							</li>  
						<li class="menu-list"><a href="#"><i class="lnr lnr-users"></i> <span>&nbsp;&nbsp;操作员管理</span></a>
						  <ul class="sub-menu-list">
								<li><a href=""></a> </li>
								<li><a href=""></a> </li>
							</ul>
						</li>      
						
					</ul>
				<!--sidebar nav end-->
			</div>
		</div>
		<!-- left side end-->
    
		<!-- main content start-->
		<div class="main-content">
			<!-- header-starts -->
			<div class="header-section">
			 
			<!--toggle button start-->
			<a class="toggle-btn  menu-collapsed"><i class="fa fa-bars"></i></a>
			<!--toggle button end-->

			<!--notification menu start -->
			<div class="menu-right">
				<div class="user-panel-top">  	
					<div class="profile_details_left">
						<ul class="nofitications-dropdown">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-envelope"></i><span class="badge">3</span></a>
								
										<ul class="dropdown-menu">
											<li>
												<div class="notification_header">
													<h3>You have 3 new messages</h3>
												</div>
											</li>
											<li><a href="#">
											   <div class="user_img"><img src="images/1.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor sit amet</p>
												<p><span>1 hour ago</span></p>
												</div>
											   <div class="clearfix"></div>	
											 </a></li>
											 <li class="odd"><a href="#">
												<div class="user_img"><img src="images/1.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor sit amet </p>
												<p><span>1 hour ago</span></p>
												</div>
											  <div class="clearfix"></div>	
											 </a></li>
											<li><a href="#">
											   <div class="user_img"><img src="images/1.png" alt=""></div>
											   <div class="notification_desc">
												<p>Lorem ipsum dolor sit amet </p>
												<p><span>1 hour ago</span></p>
												</div>
											   <div class="clearfix"></div>	
											</a></li>
											<li>
												<div class="notification_bottom">
													<a href="#">See all messages</a>
												</div> 
											</li>
										</ul>
							</li>	
							<li class="login_box" id="loginContainer">
								  <div class="search-box">
										<div id="sb-search" class="sb-search">
											<form>
												<input class="sb-search-input" placeholder="这里可以搜索" type="search" id="search">
												<input class="sb-search-submit" type="submit" value="">
												<span class="sb-icon-search"> </span>
											</form>
										</div>
									</div>
										<!-- search-scripts -->
										<script src="<%=path%>/js/classie.js"></script>
										<script src="<%=path%>/js/uisearch.js"></script>
											<script>
												new UISearch( document.getElementById( 'sb-search' ) );
											</script>
										<!-- //search-scripts -->
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-bell"></i><span class="badge blue">3</span></a>
								  <ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 3 new notification</h3>
											</div>
										</li>
										<li><a href="#">
											<div class="user_img"><img src="images/1.png" alt=""></div>
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet</p>
											<p><span>1 hour ago</span></p>
											</div>
										  <div class="clearfix"></div>	
										 </a></li>
										 <li class="odd"><a href="#">
											<div class="user_img"><img src="images/1.png" alt=""></div>
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet </p>
											<p><span>1 hour ago</span></p>
											</div>
										   <div class="clearfix"></div>	
										 </a></li>
										 <li><a href="#">
											<div class="user_img"><img src="images/1.png" alt=""></div>
										   <div class="notification_desc">
											<p>Lorem ipsum dolor sit amet </p>
											<p><span>1 hour ago</span></p>
											</div>
										   <div class="clearfix"></div>	
										 </a></li>
										 <li>
											<div class="notification_bottom">
												<a href="#">See all notification</a>
											</div> 
										</li>
									</ul>
							</li>	
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-tasks"></i><span class="badge blue1">22</span></a>
								  <ul class="dropdown-menu">
										<li>
											<div class="notification_header">
												<h3>You have 8 pending task</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="task-info">
												<span class="task-desc">Database update</span><span class="percentage">40%</span>
												<div class="clearfix"></div>	
											   </div>
												<div class="progress progress-striped active">
												 <div class="bar yellow" style="width:40%;"></div>
											</div>
										</a></li>
										<li><a href="#">
											<div class="task-info">
												<span class="task-desc">Dashboard done</span><span class="percentage">90%</span>
											   <div class="clearfix"></div>	
											</div>
										   
											<div class="progress progress-striped active">
												 <div class="bar green" style="width:90%;"></div>
											</div>
										</a></li>
										<li><a href="#">
											<div class="task-info">
												<span class="task-desc">Mobile App</span><span class="percentage">33%</span>
												<div class="clearfix"></div>	
											</div>
										   <div class="progress progress-striped active">
												 <div class="bar red" style="width: 33%;"></div>
											</div>
										</a></li>
										<li><a href="#">
											<div class="task-info">
												<span class="task-desc">Issues fixed</span><span class="percentage">80%</span>
											   <div class="clearfix"></div>	
											</div>
											<div class="progress progress-striped active">
												 <div class="bar  blue" style="width: 80%;"></div>
											</div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all pending task</a>
											</div> 
										</li>
									</ul>
							</li>		 
							
						   							   		
							<div class="clearfix"></div>	
						</ul>
					</div>
					<div class="profile_details">		
						<ul>
							<li class="dropdown profile_details_drop">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<div class="profile_img">	
										 
										 <div class="user-name">
											<p>Michael<span>Administrator</span></p>
										 </div>
										 <i class="lnr lnr-chevron-down"></i>
										 <i class="lnr lnr-chevron-up"></i>
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									<li> <a href="#"><i class="fa fa-cog"></i> 设置</a> </li> 
									<li> <a href="#"><i class="fa fa-user"></i>个人信息</a> </li> 
									<li> <a href="file:///E|/b项目实训/cpts_547_va/sign-up.html"><i class="fa fa-sign-out"></i>登出</a> </li>
								</ul>
							</li>
							
							<div class="clearfix"> </div>
						</ul>
				
			 <!--body wrapper end-->
		</div>
				<tianqi>
				<div id="weather">
				<a href="http://www.baidu.com/s?ie=utf-8&amp;wd=%E7%A9%BA%E6%B0%94%E8%B4%A8%E9%87%8F" target="_blank" class="red1" title=""></a>
				<a data-click="{&quot;act&quot;:&quot;cal_local&quot;}" href="http://map.baidu.com/?newmap=1&amp;ie=utf-8&amp;from=ibaidu&amp;s=s%26wd%3D东莞" target="_blank" class="blue">东莞</a>
				</div>
				</tianqi>		
					</div>
			<!--notification menu end -->
		<!-- //header-ends -->
				</div>
				</div>
					<div id="page">
				<stronger>12312412513</stronger>
			<!--body wrapper start-->
			</div>
   </section>
  
<script src="<%=path%>/js/jquery.nicescroll.js"></script>
<script src="<%=path%>/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="<%=path%>/js/bootstrap.min.js"></script>
</body>
</html>
