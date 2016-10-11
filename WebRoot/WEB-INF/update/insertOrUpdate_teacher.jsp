<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    <title>My JSP 'insert_student.jsp' starting page</title>
    
	<%@include file="/WEB-INF/systemplate/head_insertOrUpdate.jsp" %>
	
  </head>
  <body>
  	<form id="fm1" action="/school/act/teacherAction/insertOrUpdate" method="post" >
  		<table class="table_update" >
	  		<c:if test="${teacher.tid!=null }">
		  		<tr>
		  			<td>编号:</td>
		  			<td>
			  				${teacher.tid }
			  				<input type="hidden" name="teacher.tid" value="${teacher.tid }" />
			  				<input type="hidden" name="insertOrUpdate" value="update" />
		  			</td>
		  		</tr>
	  		</c:if>
	  		<tr>
	  			<td>姓名:</td>
	  			<td>
	  				<input type="text" name="teacher.tname" title="姓名" value="${teacher.tname }" notnull="true" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>年龄:</td>
	  			<td>
	  				<input type="text" name="teacher.tage" title="年龄" value="${teacher.tage }" notnull="true" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td colspan="2" style="text-align: center;text-align: left;">
	  			<hr style="width: 86%;margin-top: 10px;margin-bottom: 20px;margin-left: -6px;"/>
	  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  				<input type="submit" />&nbsp;
	  				<input type="reset" />
	  			</td>
	  		</tr>
	  	</table>
  	</form>
  </body>

</html>
