<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    
    
    <title>  </title>
    
	<%@include file="/WEB-INF/systemplate/head_info.jsp" %>

  </head>
  
  <body>
 
  	<div class="bt_insert" >
  		<form action="${basepath }act/teacherAction/toInsertOrUpdate" method="post">
  			<button>添加</button>
  		</form>
  		
  	</div>
    <table class="container_info">
    
    	<thead>
    		<tr>
    			<td></td>
    			<td>姓名</td>
    			<td>年龄</td>
		  <form action="${basepath }act/teacherAction/delete" method="post" id="fm_batch">
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
    		<c:forEach  items="${infoes }" var="teacher" varStatus="vst">
    		
	    			<tr>
	    				<td>${vst.count }</td>
	    			<form action="${basepath }act/teacherAction/toInsertOrUpdate" method="post">
	    				<td>
    						<button class="bt_info" name="teacher.tid" value="${teacher.tid }">
	    						${teacher.tname }
	    					<div></div>
	    					</button>
	    				</td>
	    				<td>${teacher.tage }</td>
	    			</form>
    				<form action="${basepath }act/teacherAction/delete" method="post" onsubmit="return confirm('是否确认操作？')">
    					<td>
    						<button class="bt_delete" name="teacher.tid" value="${teacher.tid }" >删除
	    					</button>
	    					<input type="hidden" name="pageNum" value="${requestScope.pageNum }" />
    				</form>
    				
	    						<input type="checkbox" btchname="batch_list" name="batch_list.tid" value="${teacher.tid }" />
	    					</td>
	    			</tr>
    		</c:forEach>
    			</tbody>
    </table>
    </form>
    <form action="/school/act/teacherAction/getInfo" method="post">
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
