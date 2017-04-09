<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include  page="/commons/copyright.jsp"/>
<%@ page import=" com.haisan.saleOA.web.Page" %>
<%@ page import=" com.haisan.saleOA.domain.OrderItem" %>
<%@ page import=" com.haisan.saleOA.domain.Good" %>
<%@ page import=" com.haisan.saleOA.domain.Shipment" %>
<%@ page import=" com.haisan.saleOA.domain.Order" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Order</title>
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
				  	
				<div class="search-box">
				
										<div id="sb-search" class="sb-search">
										
											<form name="form1" action="<%=path + "/servlet/GoodServlet?method=getAGood" %>">
											
												<input class="sb-search-input" placeholder="这里可以搜索" type="search" id="search" name="search">
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
							  <th>货品单价</th>
							  <th>数量</th>
							  <th>金额</th>
							  
						
							</tr>
						  </thead>
						  <tbody>
						  
					  <%//Page<OrderItem> pageOrder = (Page)request.getAttribute("pageOrder");
					  //  Map<String, Double> total =(Map)request.getAttribute("total");
					  //List<OrderItem> orderItems = pageOrder.getList();
					    
					   // List<Order> orders = o.getOrder()%>
					      <% 
					    String[] cla = {"success", "info"};
					    int i = 0;
					         String id = (String)request.getAttribute("id");
					         OrderItem o = (OrderItem)session.getAttribute(id);
					         List<Good> goodList = new ArrayList<Good>();
					         List<Shipment> ship = new ArrayList<Shipment>();
					         if(o != null) {
					             goodList = o.getGoodList(); 
					          ship = o.getShipmentList();
					          }
					          %>
						
							  
							  <% 
							  for(Shipment s : ship){
					           %>
							<tr class="<%=cla[i%2] %>">
							  <th scope="row"  ><%=goodList.get(i).getGoodId()%></th>
							  <td><%=goodList.get(i).getGoodName() %></td>
							  <td><%=s.getPrive()+"元/公斤" %></td>
							 
							   
							  <td><%=s.getAmount() %></td>
							  
							 <td> <%=s.getTotalPriceS()+"元"%></td>
							   
							</tr><% i++;} %>  
							 
							
						  </tbody>
						</table>
						   <label class="label btn_6 label-danger">订单总金额：<%=o.getTatalPriceS()+"元"%>
					   </div>
					   
					   
				  <div class="bs-example4" data-example-id="contextual-table">
				      <label>订单号：<%=o.getOrder().getOrderId() %></label>
				      <label class="label btn_7 label-info">	`	</label>
				      <label>客户编号：<%=o.getCustomer().getCustomerId() %></label>
				      <label class="label btn_7 label-info">	`	</label>
				      <label>客户名称：<%=o.getCustomer().getCustomerName() %></label>
				      <br>
				      <label>客户地址：<%=o.getCustomer().getAddress() %></label>
				      <label class="label btn_7 label-info">	`	</label>
				      <label>客户地址：<%=o.getCustomer().getPhoneNum() %></label>
				      <label class="label btn_7 label-info">	`	</label>
				      
				      <br><br>
				      <p> <lable class="label btn_6 label-primary">
				      			操作员编号:<%=o.getUserId() %>
				      </lable></p>
				      
				      
				      </div>
				 
				 <div class="mail-toolbar clearfix">
								 <div class="float-left">
									<div class="btn btn_1 btn-default mrg5R">
									   <i class="fa fa-refresh"> </i>
									</div>
									<div class="dropdown">
										<a href="#" title="" class="btn btn-default" data-toggle="dropdown" aria-expanded="false">
											<i class="fa fa-cog icon_8"></i>
											<i class="fa fa-chevron-down icon_8"></i>
										<div class="ripple-wrapper"></div></a>
										<ul class="dropdown-menu float-right">
											<li>
												<a href="#" title="">
													<i class="fa fa-pencil-square-o icon_9"></i>
													Edit
												</a>
											</li>
											<li>
												<a href="#" title="">
													<i class="fa fa-calendar icon_9"></i>
													Schedule
												</a>
											</li>
											<li>
												<a href="#" title="">
													<i class="fa fa-download icon_9"></i>
													Download
												</a>
											</li>
											<li class="divider"></li>
											<li>
												<a href="#" class="font-red" title="">
													<i class="fa fa-times" icon_9=""></i>
													Delete
												</a>
											</li>
										</ul>
									</div>
									<div class="clearfix"> </div>
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
