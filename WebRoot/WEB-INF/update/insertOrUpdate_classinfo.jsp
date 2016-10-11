<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    <title>My JSP 'insert_student.jsp' starting page</title>
    
	<%@include file="/WEB-INF/systemplate/head_insertOrUpdate.jsp" %>
	
  </head>
  <body>
  	<form id="fm1" action="/school/act/classinfoAction/insertOrUpdate" method="post" >
  		<table class="table_update" >
	  		<tr>
	  			<td>编号:</td>
	  			<td>
	  				<c:if test="${classinfo==null }">
	  					<span>
		  				<input type="text" name="classinfo.clid" title="编号" value="${classinfo.clid }" notnull="true" />
	  					</span>
		  				<input type="hidden" name="insertOrUpdate" value="insert" />
	  				</c:if>
	  				<c:if test="${classinfo!=null }">
		  				${classinfo.clid }
		  				<input type="hidden" name="classinfo.clid" value="${classinfo.clid }" />
		  				<input type="hidden" name="insertOrUpdate" value="update" />
	  				</c:if>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>班名:</td>
	  			<td>
	  				<input type="text" name="classinfo.clname" title="班名" value="${classinfo.clname }" notnull="true" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>开班日期:</td>
	  			<td>
	  				<input type="date" name="classinfo.clbegindate" title="开班日期" value="${classinfo.clbegindate }" notnull="true" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>结课日期:</td>
	  			<td>
	  				<input type="date" name="classinfo.clenddate" title="结课日期" value="${classinfo.clenddate }" notnull="true" />
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
