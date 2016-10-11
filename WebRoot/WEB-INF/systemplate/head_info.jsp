<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
application.setAttribute("basepath", basePath);

%>
   
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">


<link rel="stylesheet" type="text/css" href="/school/syscss/info.css">

<script type="text/javascript" src="/school/sysjs/jquery-2.1.1.min.js"></script>
<!-- <script type="text/javascript" src="/school/sysjs/sys_info.js"></script> -->