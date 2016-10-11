<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'info_teacher.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="syscss/info.css">
	<script type="text/javascript" src="/school/sysjs/jquery-2.1.1.min.js"></script>

  </head>
  
  <body>
 
  	<div class="bt_insert" >
  		<form action="act/studentAction/toInsertOrUpdate" method="post">
  			<button>添加</button>
  		</form>
  		
  	</div>
    <table class="container_info">
    
    	<thead>
    		<tr>
    			<td></td>
    			<td>学号</td>
    			<td>姓名</td>
    			<td>性别</td>
    			<td>生日</td>
    			<td>所在班级</td>
		  <form action="/school/act/studentAction/delete" method="post" id="fm_batch">
    			<td>
    			
    				<button style="border:0px;
		    				width:30px;	
		    				background-color: transparent;">
 						<img width="12px" height="12px" src="imgs/delete.png">
    				</button>
    				<input type="checkbox" id="chooseBt1" style="margin-left: 10px;" />
					
   				</td>
   			</form>
    		</tr>
    	</thead>
    	
    			<tbody>
    		<c:forEach items="${infoes }" var="student" varStatus="vst">
    		
	    			<tr>
	    				<td>${vst.count }</td>
	    				<td>${student.stid }</td>
	    			<form action="/school/act/studentAction/toInsertOrUpdate" method="post">
	    				<td>
    						<button class="bt_info" name="student.stid" value="${student.stid }">
	    						${student.stname }<div></div>
	    					</button>
	    				</td>
	    			</form>
	    				<td>${student.stsex==1?"男":"女" }</td>
	    				<td><fmt:formatDate value="${student.stbirthday }"/></td>
	    				<td>${student.classinfo.clname }</td>
	    				
    				<form action="/school/act/studentAction/delete" method="post">
    					<td>
    						<button class="bt_delete" name="student.stid" value="${student.stid }" >删除
	    					</button>
	    					<input type="hidden" name="pageNum" value="${requestScope.pageNum }" />
    				</form>
    				
	    						<input type="checkbox" name="batch_list.stid" value="${student.stid }" />
	    					</td>
	    			</tr>
    		</c:forEach>
    			</tbody>
    </table>
    </form>
    <form action="/school/act/studentAction/getInfo" method="post">
    	<div class="toolbar_1">
	    	<button name="pageNum" value="1">首页</button>
	    	<button name="pageNum" value="${requestScope.pageNum-1 }">上一页</button>
	    	<button name="pageNum" value="${requestScope.pageNum+1 }">下一页</button>
	    	<button name="pageNum" value="${requestScope.pageCount }">尾页</button>
	    </div>
  
    
  </body>
  
  <script type="text/javascript">
  	(function(){
  		$("").ready(function(){
  			$(".bt_delete").click(function(){
  					return window.confirm("是否确认操作？");
  			});
  			
  			$("#chooseBt1").click(function(){
  				$("[name='batch_list.stid']").prop("checked",this.checked);
  			});
  			
  			$("#fm_batch").submit(function(){
  				$("[name='batch_list.stid']").appendTo($(this));
  				return window.confirm("是否删除选中的信息");
  			});
  			
  		});
  	})();
  </script>
  
</html>
