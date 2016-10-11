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
  		学生姓名:${student.stname }小明
	  	&nbsp;&nbsp;
	  	所在班级:${student.classinfo.clname }java大数据一班
  	</div>
  	
  <hr>
  	<div id="dv1" style="text-align: center;">
  	
  		<span style="color: black;">系统课程</span>
  		<hr>
  	
  		<div>java分布式1
  			<button style="background-color: transparent;border: 0px;">
	  			<img alt="" src="/school/imgs/go_2.png" style="width: 20px;height: 18px;">
	  		</button>
  		</div>
  		
  		<div>java分布式2
  			<button style="background-color: transparent;border: 0px;">
	  			<img alt="" src="/school/imgs/go_2.png" style="width: 20px;height: 18px;">
	  		</button>
  		</div>
  		<div>java分布式3
  			<button style="background-color: transparent;border: 0px;">
	  			<img alt="" src="/school/imgs/go_2.png" style="width: 20px;height: 18px;">
	  		</button>
  		</div>
  		
  		<!-- <c:forEach items="${subjects_now }" var="studentSubject">
  			<div>${studentSubject.id.subjectinfo.subname }</div>
  		</c:forEach> -->
  	</div>
  	<div style="border: 1px solid #6188AE;float: left;height: 320px;"></div>
  	<div id="dv2" style="text-align: center;">
  	
  		<span style="color: black;">已选课程</span>
  		<hr>
  	
  		<div>java分布式4
  			<button style="background-color: transparent;border: 0px;">
	  			<img alt="" src="/school/imgs/go_1.png" style="width: 20px;height: 18px;">
	  		</button>
  		</div>
  		<div>java分布式5
  			<button style="background-color: transparent;border: 0px;">
	  			<img alt="" src="/school/imgs/go_1.png" style="width: 20px;height: 18px;">
	  		</button>
  		</div>
  		<div>java分布式6
  			<button style="background-color: transparent;border: 0px;">
	  			<img alt="" src="/school/imgs/go_1.png" style="width: 20px;height: 18px;">
	  		</button>
  		</div>
  	
  		<!-- <c:forEach items="${subjects_all }" var="subject">
  			<div>${subject.subname }</div>
  		</c:forEach> -->
  	</div>
  	<hr style="clear: both;">
    
    	<div style="text-align: center;margin-top: 20px;">
    		<button style="margin-left: 226px;font-size: 14px;background: transparent;">
    			<img alt="" src="/school/imgs/save.png" style="width: 12px;height: 15px;float: left;">保存选课状态
    		</button>
    		<button style="margin-left: 10px;font-size: 14px;background: transparent;">
    			<img alt="" src="/school/imgs/reset.png" style="width: 16px;height: 16px;float: left;">重置
    		</button>
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
  		});
  	})();
  </script>
  
</html>
