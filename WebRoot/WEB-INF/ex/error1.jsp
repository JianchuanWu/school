<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isErrorPage="true"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		#err{
			font-size: 16px;
			font-family: 黑体;
		}
		#second{
			color: red;
			font-size: 16px;
			font-family: fantasy;
		}
	</style>
	
	<script type="text/javascript" src="/school/sysjs/jquery-2.1.1.min.js"></script>
	
  </head>
  
  <body>
    <div id="err">
    	<%=exception!=null?exception.getMessage():"请求页面不存在" %>
    	<hr>
    	系统将于<span id="second"></span>秒之后转会<a href="/school/index.jsp">主页面</a>
    </div>
  </body>
  <script type="text/javascript">
  	(function(){
  		var second = 6;
  		$("").ready(function(){
  			window.setInterval(function(){
  				if(second==0){
  					window.location.href="/school/index.jsp";
  				}
  				$("#second").html(second--);
  			}, 1000);
  		});
  	})();
  </script>
</html>
