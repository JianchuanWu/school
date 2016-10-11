package org.school.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.school.hb.entities.Userinfo;

import com.opensymphony.xwork2.ActionContext;

@Namespace(value = "/act/logAction")
@Results(value = {
		@Result(name = "main", location = "/WEB-INF/main.html"), 
		@Result(name = "login", location = "/login.jsp", params={"msg","${msg }"}) 
		
})
public class LogAction extends BaseAction {

	private Userinfo userinfo;
	
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	@Action(value="login")
	public String login(){
		userinfo = getService().login(userinfo);
		if(userinfo!=null){
			ActionContext.getContext().getSession().put("user", userinfo);
			return "main";
		}
		msg = "no";
		return "login";
	}
	
	@Action(value="exit")
	public String exit(){
		userinfo = (Userinfo) ActionContext.getContext().getSession().get("user");
		
		ActionContext.getContext().getSession().clear();
		
		getService().exit(userinfo);
		
		msg="exit";
		
		return "login";
	}
	
	
	
	
	
	
	
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getBatch_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
