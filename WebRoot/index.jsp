
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include  page="commons/copyright.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Sign In</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="登录，管理员" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<!-- chart -->
<script src="js/Chart.js"></script>
<!-- //chart -->
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!----webfonts--->

<!---//webfonts---> 
 <!-- Meters graphs -->
<script src="js/jquery-1.10.2.min.js"></script>
<!-- Placed js at the end of the document so the pages load faster -->

</head> 
   
 <body class="sign-in-up">
    <section>
			<div id="page-wrapper" class="sign-in-wrapper">
				<div class="graphs">
					<div class="sign-in-form">
						<div class="sign-in-form-top">
							<p> <a href="">登录</a></p>
						</div>
						
						  
						  
						  
						  
						 
						<div class="signin">
							<div class="signin-rit">
							<%   boolean qur = true ;
						 	  if(session.getAttribute("suss") !=null)
						     qur=(Boolean)session.getAttribute("suss");; 
	                  	   String bu = "";	 
						  if (!qur) bu="用户名错误或密码错误";%>
						   <stronger><%=bu %></stronger>  
							
								<p><a href="#">忘记密码？</a> </p>
								
								<div class="clearfix"> </div>
							</div>
							<form action=<%=path + "/servlet/UserServlet?method=login" %> method="post">
							<div class="log-input">
								<div class="log-input-left">
								   <input type="text" name="id"class="user" value="用户名" onfocus="this.value = '';" />
								</div>
								
								<div class="clearfix"> </div>
							</div>
							<div class="log-input">
								<div class="log-input-left">
								   <input type="password" name="password" class="lock" value="password" onfocus="this.value = '';" />
								</div>
								
								<div class="clearfix"> </div>
							</div>
							<input type="submit" value="登录">
						</form>	 
						</div>
						
					</div>
				</div>
			</div>
		
	</section>
	
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>