<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    
    
    <title>  </title>
    
	<%@include file="/WEB-INF/systemplate/head_info.jsp" %>

  </head>
  
  <body>
 
  	<div class="bt_insert" >
  		<form action="" method="post">
  			<button>添加</button>
  		</form>
  		
  	</div>
    <table class="container_info">
    
    	<thead>
    		<tr>
    			<td>rowid</td>
    			<td>columName1</td>
    			<td>columName2</td>
    			<td>columName...</td>
    			
    			<td>Single_Or_Batch_Delete</td>
		  <form action="" method="post" id="fm_batch">
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
    		<c:forEach begin="1" end="10" varStatus="vst">
    		
	    			<tr>
	    				<td>${vst.count }</td>
	    				<td></td>
	    			<form action="" method="post">
	    				<td>
    						<button class="bt_info" name="" value="">
	    						msgName_to_Update
	    					<div></div>
	    					</button>
	    				</td>
	    			</form>
	    				<td></td>
    				<form action="" method="post" onsubmit="return confirm('是否确认操作？')">
    					<td>
    						<button class="bt_delete" name="" value="" >删除
	    					</button>
	    					<input type="hidden" name="pageNum" value="${requestScope.pageNum }" />
    				</form>
    				
	    						<input type="checkbox" btchname="batch_list" name="batch_list.???????" value="" />
	    					</td>
	    			</tr>
    		</c:forEach>
    			</tbody>
    </table>
    </form>
    <form action="" method="post">
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
