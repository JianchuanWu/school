<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>My JSP 'insert_student.jsp' starting page</title>
    
	<%@include file="/WEB-INF/systemplate/head_insertOrUpdate.jsp" %>

	
  </head>
  <body>
  	<form id="fm1" action="/school/act/studentAction/insertOrUpdate" method="post" >
  		<table class="table_update" >
	  		<tr>
	  			<td>编号：</td>
	  			<td>
	  				<c:if test="${requestScope.student!=null }">
		  				${student.stid }
		  				<input type="hidden" name="student.stid" value="${student.stid }" />
		  				<input type="hidden" name="insertOrUpdate" value="update" />
	  				</c:if>
	  				<c:if test="${requestScope.student==null }">
	  					<span>
		  				<input type="text" name="student.stid" notnull="true" title="编号" />
	  					</span>
		  				<input type="hidden" name="insertOrUpdate" value="insert" />
	  				</c:if>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>姓名：</td>
	  			<td>
	  				<input type="text" name="student.stname" notnull="true" title="姓名" value="${student.stname }" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>性别：</td>
	  			<td>
	  				<input type="radio" value="1" checked="checked" name="student.stsex" />男
	  				<input type="radio" value="2" ${student.stsex==2?"checked='checked'":"" } 
	  						name="student.stsex" />女
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>生日：</td>
	  			<td>
	  				<input type="date" name="student.stbirthday" notnull="true" title="生日" value='<fmt:formateDate value="${student.stbirthday }" />' />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>班级：</td>
	  			<td>
	  				<select name="student.classinfo.clid" title="班级">
	  					<c:forEach items="${requestScope.infoes }" var="classinfo">
	  						<option value="${classinfo.clid }"
	  							${student.classinfo.clid==classinfo.clid?"selected='selected'":"" }
	  						>${classinfo.clname }</option>
	  					</c:forEach>
	  				</select>
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
