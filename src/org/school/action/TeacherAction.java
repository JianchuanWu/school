package org.school.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.school.hb.entities.Teacher;

@Namespace(value = "/act/teacherAction")
@Results(value = {
		@Result(name = "infoes", location = "/WEB-INF/infoes/info_teacher.jsp"),
		@Result(name = "insert_or_update", location = "/WEB-INF/update/insertOrUpdate_teacher.jsp") })
public class TeacherAction extends BaseAction {

	private Teacher teacher;

	private List<Teacher> batch_list;

	// =========================================================================

	@Action(value = "toInsertOrUpdate")
	public String toInsertOrUpdate() {
		if (this.teacher != null && this.teacher.getTid() != null) {
			this.teacher = (Teacher) this.getService().getInfoByID(getKey(),
					teacher.getTid());
		}

		return "insert_or_update";
	}

	// =========================================================================

	public void setBatch_list(List<Teacher> batch_list) {
		this.batch_list = batch_list;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.getService().TEACHER;
	}

	@Override
	public List getBatch_list() {
		// TODO Auto-generated method stub
		return this.batch_list;
	}

	@Override
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return this.teacher;
	}

}
