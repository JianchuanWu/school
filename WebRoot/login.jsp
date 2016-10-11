<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
  
    <title>系统登录</title>
	
	<%@include file="/WEB-INF/systemplate/head_insertOrUpdate.jsp" %>
	
	<style type="text/css">
		#tb1{
			margin: auto;
			margin-top: 100px;
			width: 500px;
			font-size: 16px;
			font-family: 黑体;
			line-height: 50px;
			border: 1px solid #6188AE;
		}
		#tb1 tr:FIRST-CHILD{
			background: #6188AE;
			color: #ffffff;
		}
		#tb1 tr td button img{
			width: 17px;
			height: 17px;
			float: left;
			margin-right: 3px;
		}
		#tb1 tr td button{
			font-size: 16px;
			font-family: 黑体;
			border: 1px solid #6188AE;
			background: transparent;
		}
		#tb1 tr td button:HOVER{
			box-shadow: 0px 0px 1px black;
		}
	</style>

  </head>
  
  <script type="text/javascript">
  	<c:if test="${requestScope.msg=='no' }">
	  	alert("您的用户名或密码有误");
	  </c:if>
  	<c:if test="${requestScope.msg=='exit' }">
	  	alert("用户已经安全退出，如需操作请登录");
	  </c:if>
  </script>
  
  <body>
    
	<form action="/school/act/logAction/login" method="post" id="fm1">
	
		<table id="tb1">
			<tr>
				<td >
					<img alt="" src="/school/imgs/sys_login.png" style="width: 38px;height: 36px;float: left;padding-top: 6px;padding-right: 16px;padding-left: 6px;">
					系统登录
				</td>
			</tr>
			
			<tr>
				<td>
					<ul>
						<li>
							用户名：<input type="text" placeholder="请填写用户名" name="userinfo.logname" style="height: 26px;" notnull="true">
						</li>
						<li>
							密&nbsp;&nbsp;码：<input type="password" placeholder="请填写用户密码" name="userinfo.keyword" style="height: 26px;" notnull="true">
						</li>
					</ul>
				</td>
			</tr> 
			
			<tr>
				<td>
					<button style="margin-left: 300px;">
						<img alt="" src="/school/imgs/login.png" >
						登录
					</button>
					&nbsp;&nbsp;
					<button type="reset">
						<img alt="" src="/school/imgs/reset.png">
						重置
					</button>
				</td>
			</tr>
		</table>
	</form>

  </body>
  
  
</html>
