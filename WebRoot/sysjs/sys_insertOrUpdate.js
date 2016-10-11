(function(){
	$("").ready(function(){
	
  		$("#fm1").submit(function(){
  		
  			var ok=true;
  			
  			$(this).find("[notnull=true]").each(function(){
  				if(isNull(this)){
  					ok=false;
  				}
  			});
  			return ok;
  		});
	
		function isNull(ipt){
			$(ipt).nextAll().remove();//问题出在这里
			if(ipt.value==""){
				$(ipt).after("<span class='validate_1'>*"+ipt.title+"不能为空</span>")
				return true;
			}
			return false;
		}
	});
})();