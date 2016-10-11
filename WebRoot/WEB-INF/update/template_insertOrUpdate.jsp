<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    <title>My JSP 'insert_student.jsp' starting page</title>
    
	<%@include file="/WEB-INF/systemplate/head_insertOrUpdate.jsp" %>
	
  </head>
  <body>
  	<form id="fm1" action="/school/act/<!-- ???????? -->Action/insertOrUpdate" method="post" >
  		<table class="table_update" >
	  		<tr>
	  			<td>item1</td>
	  			<td>
	  				<c:if test="${false }">
	  					<span>
		  				<input type="text" name="" title="" value="" />
	  					</span>
		  				<input type="hidden" name="insertOrUpdate" value="insert" />
	  				</c:if>
	  				<c:if test="${false }">
		  				
		  				<input type="hidden" name="" value="" />
		  				<input type="hidden" name="insertOrUpdate" value="update" />
	  				</c:if>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>item2</td>
	  			<td>
	  				<input type="text" name="" title="" value="" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>item3</td>
	  			<td>
	  				<input type="text" name="" title="" value="" />
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>item4</td>
	  			<td>
	  				<input type="text" name="" title="" value="" />
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
