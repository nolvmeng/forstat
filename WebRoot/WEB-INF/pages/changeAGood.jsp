<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include  page="/commons/copyright.jsp"/>
<%@ page import=" com.haisan.saleOA.web.Page" %>
<%@ page import=" com.haisan.saleOA.domain.Customer" %>
<%@ page import=" com.haisan.saleOA.domain.Good" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>addGood</title>
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
				<a href="GoodServlet?method=back"><i class="lnr lnr-home"></i> </a>
			</div>

			<!--logo and iconic logo end-->
			<div class="left-side-inner">

				<!--sidebar nav start-->
					<ul class="nav nav-pills nav-stacked custom-nav">
					<li><span>&nbsp;&nbsp;</span></li>
						<li class="active"><a href="GoodServlet?method=back"><i class="lnr lnr-power-switch"></i><span>返回</span></a></li>
						<li>
							<a href="GoodServlet?method=AllGoods"><i class="fa fa-tasks"></i>
								<span>货品管理</span></a>
							  <ul class="sub-menu-list">
									<li><a href="GoodServlet?method=findjsp">添加</a> </li>
									<li><a href="">修改</a></li>
									<li><a href="">删除</a></li>
								</ul>
						</li>
					  <li><a href="OrderServlet?method=getOrder"><i class="lnr lnr-spell-check"></i> <span>&nbsp;&nbsp;订单管理</span></a>
					  <ul class="sub-menu-list">
								<li><a href="GoodServlet?method=AllGoods&new=is">新订单</a> </li>
								<li><a href="">查看订单</a> </li>
							</ul>
							</li>
					  <li><a href="CustomerServlet?method=getCus"><i class="lnr lnr-user"></i> <span>&nbsp;&nbsp;客户管理</span></a> 
					  <ul class="sub-menu-list">
								<li><a href="CustomerServlet?method=findjsp">新增客户</a> </li>
								<li><a href=""></a> </li>
							</ul>           
							</li>  
						<li><a href="#"><i class="lnr lnr-users"></i> <span>&nbsp;&nbsp;用户管理</span></a>
						  <ul class="sub-menu-list">
								<li><a href="">管理操作员</a> </li>
								<li><a href="">修改用户信息</a> </li>
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
											<p> ${sessionScope.userw.username}
                                                <span> ${sessionScope.userw.position}</span></p>
										 </div>
										 <i class="lnr lnr-chevron-down"></i>
										 <i class="lnr lnr-chevron-up"></i>
										<div class="clearfix"></div>	
									</div>	
								</a>
								<ul class="dropdown-menu drp-mnu">
									<li> <a href="#"><i class="fa fa-cog"></i> 设置</a> </li> 
									<li> <a href="#"><i class="fa fa-user"></i>个人信息</a> </li> 
									<li> <a href="<%=path + "/servlet/UserServlet?method=destoryUser" %>"><i class="fa fa-sign-out"></i>登出</a> </li>
								</ul>
							</li>
							
							<div class="clearfix"> </div>
						</ul>
				
			 <!--body wrapper end-->
		</div>
				</div>
			<!--notification menu end -->
		<!-- //header-ends -->
				</div>
				</div>
					<div id="page-wrapper">
				  	
				
									<div class="graphs">
									<h3 class="blank1">修改货品</h3>
									<div class="tab-content">
									<form class="form-horizontal" action="GoodServlet?method=setGood" method="post">
								<%String id=(String)request.getAttribute("id");
				  	              Good g=(Good)session.getAttribute(id);
				  	              session.setAttribute("id", id); %>
				  	              
									<div class="form-group">
									<label for="idinput" class="col-sm-2 control-label">货品编号：</label>
									<div class="col-sm-8">
										<input type="text" class="form-control1" id="idinput" value="<%=g.getGoodId() %>" name="goodId">
									</div>
									</div>
									<div class="form-group">
									<label for="nameinput" class="col-sm-2 control-label">货品名称：</label>
									<div class="col-sm-8">
										<input  type="text" class="form-control1" id="nameinput" value="<%=g.getGoodName() %>" name="goodName">
									</div>
								</div>
								<div class="form-group">
									<label for="addressinput" class="col-sm-2 control-label">货品单价：</label>
									<div class="col-sm-8">
										<input  type="text" class="form-control1" id="addressinput" value="<%=g.getGoodPrice() %>" name="goodPrice">
									</div>
								</div>
								<div class="form-group">
									<label for="phoneinput" class="col-sm-2 control-label">货品数量：</label>
									<div class="col-sm-8">
										<input  type="text" class="form-control1" id="phoneinput" value="<%=g.getReserve() %>" name="goodNum">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label">归属分类：</label>
									<div class="col-sm-8">
										<select  class="form-control1" name="slCategory" >
										    <option selected><%=g.getCategory()%></option>
											<option value="vegetable">vegetable</option>
											<option value="meat">meat</option>
											<option value="main">main</option>
											<option value="other">other</option>
										</select>
									</div>
								</div>
								<div class="panel-footer">
							<div class="row">
								<div class="col-sm-8 col-sm-offset-2">
									<button class="btn-success btn" type="submit">提交</button>
									</div>
									</div>
									</div>
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
				
				 
				 
				
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				
				 
			<!--body wrapper start-->
			</div>
   </section>
  
<script src="<%=path%>/js/jquery.nicescroll.js"></script>
<script src="<%=path%>/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="<%=path%>/js/bootstrap.min.js"></script>
</body>
</html>
