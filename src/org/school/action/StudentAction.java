package org.school.action;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.school.hb.entities.Classinfo;
import org.school.hb.entities.Student;
import org.school.hb.entities.StudentSubject;
import org.school.hb.entities.Subjectinfo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Namespace(value = "/act/studentAction")
@Results(value = {
		@Result(name = "infoes", location = "/WEB-INF/infoes/info_student.jsp"),
		@Result(name = "insert_or_update", location = "/WEB-INF/update/insert_student.jsp"),
		@Result(name = "student_subject", location = "/WEB-INF/subject/student_subject.jsp") })
public class StudentAction extends BaseAction {

	private Student student;

	private List<Subjectinfo> sub_infoes;

	private List<Student> batch_list;

	public void setBatch_list(List<Student> batch_list) {
		this.batch_list = batch_list;
	}

	public List<Subjectinfo> getSub_infoes() {
		return sub_infoes;
	}

	public void setSub_infoes(List<Subjectinfo> sub_infoes) {
		this.sub_infoes = sub_infoes;
	}

	@Override
	public List<Student> getBatch_list() {
		return batch_list;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String getKey() {
		// 返回studentDAO（spring容器已将其实例化）
		return this.getService().STUDENT;
	}

	@Override
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return this.student;
	}

	@Action(value = "toInsertOrUpdate")
	public String toInsertOrUpdate() {
		if (student != null && student.getStid() != null) {
			this.student = (Student) getService().getInfoByID(getKey(),
					student.getStid());

		}

		// 获取所有班级信息，（getService().CLASSINFO得到的是classinfoDAO，spring容器已将其实例化）
		List<Classinfo> infoes = this.getService().getAll(
				getService().CLASSINFO);
		Map map = (Map) ActionContext.getContext().get("request");
		map.put("infoes", infoes);
		return "insert_or_update";
	}

	@Action(value = "toSubject")
	public String toSubject() {
		student = (Student) getService().getInfoByID(getKey(),
				student.getStid());

		List<Subjectinfo> subjects_all = getService().getAll(
				getService().SUBJECTINFO);
		List<StudentSubject> subjects_now = getService().getSubjectByStudent(
				student);

		for (int j = 0; j < subjects_now.size(); j++) {
			StudentSubject snow = subjects_now.get(j);
			for (int i = 0; i < subjects_all.size(); i++) {
				Subjectinfo subjectinfo = subjects_all.get(i);
				if (subjectinfo.getSubid().intValue() == snow.getId()
						.getSubjectinfo().getSubid().intValue()) {
					subjects_all.remove(subjectinfo);
				}
			}
		}

		Map<String, Object> map = (Map) ActionContext.getContext().get(
				"request");
		map.put("subjects_all", subjects_all);
		map.put("subjects_now", subjects_now);

		return "student_subject";
	}

	@Action(value = "updateSubjectOfStudent")
	public String updateSubjectOfStudent() {
		Subjectinfo[] ob = null;
		if (sub_infoes != null && sub_infoes.size() > 0) {
			ob = new Subjectinfo[sub_infoes.size()];
			ob = sub_infoes.toArray(ob);
		}
		this.getService().subjectToUpdate(student, ob);
		return getInfo();
	}

	@Action(value = "delete")
	public String delete_info() {
		if (getBatch_list() != null && getBatch_list().size() > 0) {
			Student[] sts = new Student[getBatch_list().size()];
			sts = getBatch_list().toArray(sts);
			this.getService().delete_student_clear(sts);
		} else if (getEntity() != null) {
			this.getService().delete_student_clear(this.student);
		}
		return getInfo();
	}

}
