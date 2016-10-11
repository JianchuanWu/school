/**
 * 用于信息显示页面的初始化以及相关操作 如：批处理删除、全选等
 * 
 */
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