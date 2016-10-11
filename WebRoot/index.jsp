<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <c:if test="${param.er=='-1' }">
  	<script type="text/javascript">
  		alert("您的操作有误，请按系统要求执行，谢谢")
  	</script>
  </c:if>
  <body>
    <form action="/school/act/teacherAction_getInfo" method="post">
    	tid:<input type="text" name="teacher.tid">
    	tname:<input type="text" name="teacher.tname">
    	tage:<input type="text" name="teacher.tage">
    	<button>ok</button>
    </form>
  </body>
</html>
