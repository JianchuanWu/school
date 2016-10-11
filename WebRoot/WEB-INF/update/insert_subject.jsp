<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>My JSP 'insert_subjectInfo.jsp' starting page</title>
    
	<%@include file="/WEB-INF/systemplate/head_insertOrUpdate.jsp" %>

	
  </head>
  <body>
  	<form id="fm1" action="/school/act/subjectInfoAction/insertOrUpdate" method="post" >
  		<table class="table_update" >
	  		<tr>
	  			<td>课程名称：</td>
	  			<td>
	  				<input type="text" name="subjectinfo.subname" notnull="true" title="课程名称" />
	  			</td>
  				<input type="hidden" name="insertOrUpdate" value="insert" />
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
