<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
  <head>
    
    
    <title>  </title>
    
	<%@include file="/WEB-INF/systemplate/head_info.jsp" %>

	<style type="text/css">
		body {
			font-size: 14px;
			font-family: 黑体;
		}
		#dv1,#dv2{
			width: 220px;
			float: left;
			margin: 10px;
			border: 0px; 
			height: 300px;
			margin-bottom: 20px;
			overflow: auto;
			color: #ffffff;
			text-align: center;
		}
		#dv1{
			margin-left: 166px;
		}
		#dv1 div,#dv2 div{
			width: 90%;
			line-height: 20px;
			margin: 10px;
			background-color: #6188AE;
		}
		#dv1 div button{
			float: right;
		}
		#dv2 div button{
			float: left;
		}
	</style>
	
  </head>
  
  <body>
	
  	<div style="margin: 10px;">
  		学生姓名:${student.stname }
	  	&nbsp;&nbsp;
	  	所在班级:${student.classinfo.clname }
  	</div>
  	
  <hr>
  	
  	<div id="dv1" style="text-align: center;">
  		<span style="color: black;font-weight: bold;margin-bottom: 10px;">系统课程</span>
  		<hr>
  
  		<c:forEach items="${subjects_all }" var="subject">
  			<div>${subject.subname }
	  			<button type="button" style="background-color: transparent;border: 0px;">
		  			<img alt="" src="/school/imgs/go_2.png" style="width: 20px;height: 18px;">
		  			<input type="hidden" name="sub_infoes.subid" value="${subject.subid }"/>
		  		</button>
	  		</div>
  		</c:forEach> 
  	</div>
  	
  	<div style="border: 1px solid #6188AE;float: left;height: 320px;"></div>
  	
  	
  	<form id="fm_sub" action="/school/act/studentAction/updateSubjectOfStudent" method="post">
  		<input type="hidden" name="student.stid" value="${student.stid }">
  	<div id="dv2" style="text-align: center;">
  		<span style="color: black;font-weight: bold;margin-bottom: 10px;">已选课程</span>
  		<hr>
 
  		<c:forEach items="${subjects_now }" var="studentSubject">
  			<div>${studentSubject.id.subjectinfo.subname }
	  			<button type="button" style="background-color: transparent;border: 0px;">
		  			<img alt="" src="/school/imgs/go_1.png" style="width: 20px;height: 18px;">
			  		<input type="hidden" name="sub_infoes.subid" value="${studentSubject.id.subjectinfo.subid }">
		  		</button>
	  		</div>
  		</c:forEach>
  	</div>
  	<hr style="clear: both;">
  	</form>
    
    	<div style="text-align: center;margin-top: 30px;margin-left: 586px;">
    	
	    		<button id="bt_sub" style="border: 0px;float: left;background-color: #6188AE;border-radius: 6px;height: 20px;">
	    			<img alt="" src="/school/imgs/save.png" style="width: 12px;height: 15px;float: left;">
	    			保存选课状态
	    		</button>
	    		
    		<form action="/school/act/studentAction/toSubject" method="post" style="width: 68px;float: right;margin-right:30px;height: 20px;">
    			<button style="border: 0px;background-color: #6188AE;border-radius: 6px;"
    				name="student.stid" value="${student.stid }">
	    			<img alt="" src="/school/imgs/reset.png" style="width: 16px;height: 16px;float: left;">
	    			重置
	    		</button>
    		</form>
    		
    	</div>
    
  </body>
  
  <script type="text/javascript">
  	(function(){
  		$("").ready(function(){
  		
  			$("#dv1>div>button,#dv2>div>button").click(function(){
  				if($(this).parent().parent()[0].id=="dv1"){
  					$(this).children("img").css("float","left")
  					$(this).children("img").attr("src","/school/imgs/go_1.png");
  					$("#dv2").append($(this).parent());
  				}else{
  					$(this).children("img").css("float","right")
  					$(this).children("img").attr("src","/school/imgs/go_2.png");
  					$("#dv1").append($(this).parent());  					
  				}
  			});
  			
  			$("#bt_sub").click(function(){
  				$("#fm_sub")[0].submit();
  			});
  			
  		});
  	})();
  </script>
  
</html>
