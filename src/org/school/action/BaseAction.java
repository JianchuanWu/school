package org.school.action;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.school.hb.entities.Student;
import org.school.mdservice.ModelService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

/**
 * �������������� ��Ӧ���Ʋ�action�ĸ��� ������Ҫ������Ƹı�ָ���������ռ�(namespace) �Լ�resultsע��
 * 
 * @author Administrator
 *
 */
@Controller
@Lazy(true)
@ParentPackage("struts-default")
public abstract class BaseAction {

	/**
	 * ��ҳ��ѯʱʹ�õ� ҳ��
	 */
	private int pageNum = 1;

	/**
	 * ��ҳ��ѯʱ��ָ��ÿҳ����
	 */
	private int rowCount = 10;

	/**
	 * ��ҳ��ѯ�ǣ�����ָ��������rowCount������ر����Ϣ��ȡָ�������Է�ҳ��ҳ��
	 */
	private Integer pageCount = null;

	/**
	 * ���ڹ���service��ָ����action��Ҫʹ�õĻ���DAO����
	 */
	private String key;

	/**
	 * ����springע���ȡModelService����
	 */
	@Resource(name = "modelService")
	private ModelService service;

	/**
	 * �ж���ز�������ӻ��Ǹ��µı�ʶ
	 */
	private String insertOrUpdate;

	// ===========================================================================

	public String getInsertOrUpdate() {
		return insertOrUpdate;
	}

	public void setInsertOrUpdate(String insertOrUpdate) {
		this.insertOrUpdate = insertOrUpdate;
	}

	/**
	 * ��ҳ��ѯ�ǣ�����ָ��������rowCount������ر����Ϣ��ȡָ�������Է�ҳ��ҳ��
	 * 
	 * @return ҳ��
	 */
	public Integer getPageCount() {
		if (pageCount == null) {
			pageCount = this.getService().getPageCount(getKey(),
					this.getRowCount());
		}
		return pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	/**
	 * ��Ӧsetter ��װ�ж� ָ��ҳ���ĺ�����
	 * 
	 * @param pageNum
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		if (this.pageNum < 1) {
			this.pageNum = 1;
		}
		if (this.pageNum > this.getPageCount()) {
			this.pageNum = this.getPageCount();
		}
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * ǿ��ʵ��getKey��ϸ����װ��Ҫ���ṩ�������෽��ʹ��
	 * 
	 * @return ���ڹ���service��ָ����action��Ҫʹ�õĻ���DAO����Ĺؼ���
	 */
	public abstract String getKey();

	public void setKey(String key) {
		this.key = key;
	}

	public ModelService getService() {
		return service;
	}

	public void setService(ModelService service) {
		this.service = service;
	}

	public abstract List getBatch_list();

	public abstract Serializable getEntity();

	// ===========================================================================

	/**
	 * �����ƶ�������ȡ��ҳ��Ϣ��ѯ
	 * 
	 * @return
	 */
	@Action(value = "getInfo")
	public String getInfo() {
		// ��ȡrequest��map
		Map map = (Map) ActionContext.getContext().get("request");
		// �ѻ�ȡ��ѧ����Ϣ�ŵ�request��
		map.put("infoes",
				this.getService().getInfoByPageNum(this.getKey(), getPageNum(),
						getRowCount()));
		return "infoes";
	}

	/**
	 * ���ݲ�������ָ��ɾ�� �� ����ɾ��
	 * 
	 * @return
	 */
	@Action(value = "delete")
	public String delete_info() {
		if (getBatch_list() != null && getBatch_list().size() > 0) {
			this.getService().delete_batch(getKey(), getBatch_list().toArray());
		} else if (getEntity() != null) {
			this.getService().delete_batch(getKey(), getEntity());
		}
		return getInfo();
	}

	/**
	 * ���ݱ�ʶ��insertOrUpdate����ֵ������Ϣ��ӻ���µķ���
	 * 
	 * @return
	 */
	@Action(value = "insertOrUpdate")
	public String insertOrUpdate() {

		if (this.getInsertOrUpdate().equals("insert")) {
			getService().insert_batch(getKey(), getEntity());
		} else if (this.getInsertOrUpdate().equals("update")) {
			getService().update_batch(getKey(), getEntity());
		}

		return getInfo();
	}

	// ===========================================================================

	public interface ServiceHelper {
		String TEACHER = "teacherDao";
		String STUDENT = "studentDao";
		String USERINF = "userInfoDao";
	}

}
