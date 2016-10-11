<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    
    <title>学校信息管理</title>
    
    <%@include file="/WEB-INF/systemplate/head_info.jsp" %>
    
  </head>
  
  <body>
 
  	<div class="bt_insert" >
  		<form action="${basepath }act/studentAction/toInsertOrUpdate" method="post">
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
    			<td>课程</td>
		  <form action="/school/act/studentAction/delete" method="post" id="fm_batch">
    			<td>
    			
    				<button style="border:0px;
		    				width:30px;	
		    				background-color: transparent;">
 						<img width="12px" height="12px" src="${basepath }imgs/delete.png">
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
	    				<form action="/school/act/studentAction/toSubject" method="post" >
	    					<td>
								<button name="student.stid" value="${student.stid }" style="background-color: transparent;border: 1px solid #6188AE;">选修</button>
							</td>
	    				</form>
	    				
    				<form action="/school/act/studentAction/delete" method="post" onsubmit="return confirm('是否确认操作？')">
    					<td>
    						<button class="bt_delete" name="student.stid" value="${student.stid }" >删除
	    					</button>
	    					<input type="hidden" name="pageNum" value="${requestScope.pageNum }" />
    				</form>
    				
	    						<input type="checkbox" btchname="batch_list" name="batch_list.stid" value="${student.stid }" />
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
			/*$(".bt_delete").click(function(){
					return window.confirm("是否确认操作？");
			});*/
			
			
			/*
				点击全选或者取消全部选中的操作
			*/
			$("#chooseBt1").click(function(){
				$("[btchname='batch_list']").prop("checked",this.checked);
			});
			/*
				批量删除选中信息
			*/
			$("#fm_batch").submit(function(){
				$("[btchname='batch_list']").appendTo($(this));
				return window.confirm("是否删除选中的信息");
			});
			
		});
	})();
  </script>
  
</html>
