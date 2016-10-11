package org.school.action;

import java.io.Serializable;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.school.hb.entities.Subjectinfo;

@Namespace(value = "/act/subjectInfoAction")
@Results(value = {
		@Result(name = "infoes", location = "/WEB-INF/infoes/info_subject.jsp"),
		@Result(name = "toInsert", location = "/WEB-INF/update/insert_subject.jsp") })
public class SubjectInfoAction extends BaseAction {
	
	private Subjectinfo subjectinfo;

	private List<Subjectinfo> batch_list;

	public Subjectinfo getSubjectinfo() {
		return subjectinfo;
	}

	public void setSubjectinfo(Subjectinfo subjectinfo) {
		this.subjectinfo = subjectinfo;
		System.out.println(this.subjectinfo);
	}

	public List<Subjectinfo> getBatch_list() {
		return batch_list;
	}

	public void setBatch_list(List<Subjectinfo> batch_list) {
		this.batch_list = batch_list;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return this.getService().SUBJECTINFO;
	}

	@Override
	public Serializable getEntity() {
		// TODO Auto-generated method stub
		return this.subjectinfo;
	}

	// =============================================================

	@Action(value = "toInsert")
	public String toInsertOrUpdate() {
		return "toInsert";
	}

	@Action(value = "delete")
	public String delete_info() {
		if (getBatch_list() != null && getBatch_list().size() > 0) {
			Subjectinfo[] subs = new Subjectinfo[getBatch_list().size()];
			subs = getBatch_list().toArray(subs);
			this.getService().delete_subject_clear(subs);
		} else if (getEntity() != null) {
			this.getService().delete_subject_clear(subjectinfo);
		}
		return getInfo();
	}
}
