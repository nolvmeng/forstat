<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include  page="/commons/copyright.jsp"/>
<%@ page import=" com.haisan.saleOA.web.Page" %>
<%@ page import=" com.haisan.saleOA.domain.Good" %>
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
				<a href="GoodServlet?method=AllGoods"><i class="lnr lnr-home"></i> </a>
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
								<li><a href="OrderServlet?method=newFresh&new=is&refresh=is">新订单</a> </li>
								<li><a href="OrderServlet?method=getOrder">查看订单</a> </li>
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
				 <div class="classbuton">
					<input class="btn btn-default " type="button" value="全部货品" onClick="allfood()"">
					<input class="btn btn-default " type="button" value="蔬菜类" onClick="getVegetables()">
					<input class="btn btn-default " type="button" value="肉类" onClick="getMeat()">
					<input class="btn btn-default " type="button" value="主食类" onClick="getAtaplefood()">
					<input class="btn btn-default " type="button" value="其他" onClick="getOther()"></div>
					
				<div class="search-box">
				
										<div id="sb-search" class="sb-search">
										
											<form name="form1" action="GoodServlet?method=AllGoods" method="post">
											
												<input class="sb-search-input" placeholder="这里可以搜索" type="search" id="box" name="search">
												<input class="sb-search-submit" type="submit" value="搜索" ">
											
												<span class="sb-icon-search"> </span>
											</form>
										</div>
									</div>
										<!-- search-scripts -->
										
										<script src="<%=path%>/js/nextpage.js"></script>
										<script src="<%=path%>/js/classie.js"></script>
										<script src="<%=path%>/js/uisearch.js"></script>
											<script>
												new UISearch( document.getElementById( 'sb-search' ) );
											</script>
										<!-- //search-scripts -->
				 <div class="bs-example4" data-example-id="contextual-table">
				   
				 
				 
						<table class="table">
						  <thead>
							<tr>
							  <th>货品编号</th>
							  <th>货品名称</th>
							  <th>单价</th>
							  <th>库存</th>
							  <th></th>
							</tr>
						  </thead>
						  <tbody>
						  
					 <% Page<Good> pageGood = (Page)request.getAttribute("pageGood");
					    List<Good> goods =pageGood.getList();//(List)request.getAttribute("pageGood");
					    String ca_ji = (String)request.getAttribute("att_cate");//种类名
					    String ca ="all";
					    if(ca_ji != null)
					       ca= ca_ji ;
					    String[] cla = {"success", "info"};
					    int i = 0;
					     for(Good g : goods ){  
			                    session.setAttribute(g.getGoodId(), g) ;            %>
							<tr class="<%=cla[i%2] %>">
							  <th scope="row" ><%=g.getGoodId() %></th>
							  <td><%=g.getGoodName() %></td>
							  <td><%=g.getGoodPrice()+"元/公斤" %></td>
							  <td><%=g.getReserve()+"公斤" %></td>
							  <td><a href="GoodServlet?method=changejsp&id=<%=g.getGoodId() %>" class="btn btn-default">修改</a><a href="GoodServlet?method=delGood&id=<%=g.getGoodId()  %>" class="btn btn-default" onClick="return confirm('是否删除？');">删除</a></td>
							</tr><% i++;} %>
							
						  </tbody>
						</table>
					   </div>
				 
				 
				 <div class="mail-toolbar clearfix">
				 
				 <div class="float-right">
									       	<div class="btn-group">
												 	<%String moth ="AllGoods";
									       	   String key = "";
									       	if(request.getAttribute("mo") != null && request.getAttribute("some") != null){
									       	moth=(String)request.getAttribute("mo");
									       	key=(String)request.getAttribute("some");
									       
									     
									       	}
									       	 %>
									       	 <input type="text" id="a" style="visibility:hidden" value="<%=key %>"/>
												<a href="GoodServlet?method=<%=moth+"&searcht="+key+"&fan=is" %>&pageNO=<%=pageGood.getPrevPage()%>&category=<%=ca %>" class="btn btn-default"><i class="fa fa-angle-left"></i></a>
												<a href="GoodServlet?method=<%=moth+"&searcht="+key+"&fan=is" %>&pageNO=<%=pageGood.getNextPage()%>&category=<%=ca %>" class="btn btn-default"><i class="fa fa-angle-right"></i></a>
											</div>
										  
											<span class="text-muted m-r-sm">当前第<%=pageGood.getPageNO()%>页 ，共<%=pageGood.getTotalPageNumber()%>页 </span>
											<div class="btn-group m-r-sm mail-hidden-options" style="display: inline-block;">
												<div class="btn-group">
													<a class="btn btn-default dropdown-toggle"  >
													<i class="fa fa-folder">首页</i></a>
													
												</div>
												<div class="btn-group">
													<a class="btn btn-default dropdown-toggle" >
													<i class="fa fa-tags">尾页</i> </a>
												</div>
											</div>
										
										<div class="clearfix"> </div>
									
								</div>
				 
								 <div class="float-left">
								 
			 
				   </div>
								 
									 
								 
									
								</div>
								
							   </div>
				 
				 
				 
				 
				 
				 
				 
				 
				 
				 
				
				 
			<!--body wrapper start-->
			</div>
   </section>
  
<script src="<%=path%>/js/jquery.nicescroll.js"></script>
<script src="<%=path%>/js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="<%=path%>/js/bootstrap.min.js"></script>
</body>
</html>
