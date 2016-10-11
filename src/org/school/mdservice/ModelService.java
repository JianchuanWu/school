package org.school.mdservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.school.dao.StudentCardDAO;
import org.school.hb.entities.Student;
import org.school.hb.entities.StudentSubject;
import org.school.hb.entities.StudentSubjectId;
import org.school.hb.entities.Studentcard;
import org.school.hb.entities.Subjectinfo;
import org.school.hb.entities.Userinfo;
import org.school.hb.entities.Userloginfo;
import org.school.interfaces.DAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModelService {

	public static final String TEACHER = "teacherDAO";
	public static final String CLASSINFO = "classinfoDAO";
	public static final String STUDENT = "studentDAO";
	public static final String SUBJECTINFO = "subjectinfoDAO";
	public static final String STUDENTCARD = "studentCardDAO";
	public static final String STUDENTSUBJECT = "studentSubjectDAO";
	public static final String USERINFO = "userinfoDAO";
	public static final String USERLOGINFO = "userLogInfoDAO";

	@Resource(name = "daoMap")
	private Map<String, DAO> daoMap;

	public Map<String, DAO> getDaoMap() {
		return daoMap;
	}

	public void setDaoMap(Map<String, DAO> daoMap) {
		this.daoMap = daoMap;
	}

	// ----------------�����Ǹ���DAO ���ʵ�� ���еĻ�������������װ--------------------
	/**
	 * ��ȡָ�����������Ϣ
	 * 
	 * @param key
	 *            ָ�����key��������
	 * @return ��װ�������Ϣʵ��������List
	 */
	public List getAll(String key) {
		return this.daoMap.get(key).getAll();
	}

	/**
	 * ����ָ����Ϣ
	 * 
	 * @param key
	 *            ָ�����key��������
	 * @param id
	 *            �������
	 * @return ��װ��������ݵ�ʵ�������
	 */
	public Object getInfoByID(String key, Serializable id) {
		return this.daoMap.get(key).getByID(id);
	}

	/**
	 * �����ṩ����������Ӧ�Ĳ�ѯ��ȡ��Ϣ�ķ�����������ָ����ҳ����
	 * 
	 * @param key
	 *            ָ�����key��������
	 * @param pagetNum
	 *            ָ��ҳ����
	 * @param rowCount
	 *            ��ҳ��ʾ��Ϣ����
	 * @param criterions
	 *            ��ѯ����
	 * @return ��װ�������Ϣʵ��������List
	 */
	public List getInfoByProperties(String key, Integer pagetNum,
			Integer rowCount, Criterion... criterions) {
		return this.daoMap.get(key).getInfoesByPage(pagetNum, rowCount,
				criterions);
	}

	/**
	 * �����ṩ����������Ӧ�Ĳ�ѯ��ȡ��Ϣ�ķ���
	 * 
	 * @param key
	 *            ָ�����key��������
	 * @param criterions
	 *            ��ѯ����
	 * @return ��װ�������Ϣʵ��������List
	 */
	public List getInfoByProperties(String key, Criterion... criterions) {
		return this.daoMap.get(key).getInfoesByProperties(criterions);
	}

	/**
	 * ��ָ������������������ӵķ���
	 * 
	 * @param key
	 *            ָ�����key��������
	 * @param entities
	 *            ����hibernate�淶��ҵ����Ҫ��װ��������ݵ�ʵ�������
	 */
	public void insert_batch(String key, Object... entities) {
		this.daoMap.get(key).execute_insert(entities);
	}

	/**
	 * ��ָ����������������ɾ���ķ���
	 * 
	 * @param key
	 *            ָ�����key��������
	 * @param entities
	 *            ����hibernate�淶��ҵ����Ҫ��װ��������ݵ�ʵ�������
	 */
	public void delete_batch(String key, Object... entities) {
		this.daoMap.get(key).execute_delete(entities);
	}

	/**
	 * ��ָ���������������ݸ��µķ���
	 * 
	 * @param key
	 *            ָ�����key��������
	 * @param entities
	 *            ����hibernate�淶��ҵ����Ҫ��װ��������ݵ�ʵ�������
	 */
	public void update_batch(String key, Object... entities) {
		this.daoMap.get(key).execute_update(entities);
	}

	/**
	 * ����ÿҳ�����õ�ָ�������Ϣ���Էֳɵ�ҳ��
	 * 
	 * @param type
	 *            ָ�����
	 * @param rowCount
	 *            ָ��ÿҳ����
	 * @return ���Է�ҳ��������
	 */
	public int getPageCount(String type, int rowCount) {
		return this.daoMap.get(type).getPageCountByRowCount(rowCount);
	}

	// ----------------�����Ǹ���DAO ���ʵ�� ���е�ҵ����Ҫ����--------------------

	/**
	 * ���ݷ�ҳ������ȡָ����Ϣ
	 * 
	 * @param type
	 *            ָ�����
	 * @param pageNum
	 *            ָ��ҳ��
	 * @param rowCount
	 *            ָ��ÿҳ��ʾ����
	 * @return ��ѯ���
	 */
	public List getInfoByPageNum(String type, int pageNum, int rowCount) {
		return this.getInfoByProperties(type, pageNum, rowCount);
	}

	/**
	 * ����ָ��ѧ����Ϣ��ȡ�䵱ǰѡ�޵Ŀγ�
	 * 
	 * @param student
	 *            ָ����ѧ����Ϣ(Ҫ���װ��������ż���)
	 * @return ѧԱ��ǰѡ�޵Ŀγ�
	 */
	public List<StudentSubject> getSubjectByStudent(Student student) {
		Criterion c1 = Restrictions.eq("id.student", student);
		List<StudentSubject> infoes = daoMap.get(STUDENTSUBJECT)
				.getInfoesByProperties(c1);
		return infoes;
	}

	/**
	 * ����ָ���γ���Ϣ��ȡѡ�����ſγ̵�ѧ��
	 * 
	 * @param student
	 *            ָ���Ŀγ���Ϣ(Ҫ���װ��������ż���)
	 * @return ѡ�޵�ǰ�γ̵�ѧԱ
	 */
	public List<StudentSubject> getStudentBySubject(Subjectinfo subjectinfo) {
		Criterion c1 = Restrictions.eq("id.subjectinfo", subjectinfo);
		List<StudentSubject> infoes = daoMap.get(STUDENTSUBJECT)
				.getInfoesByProperties(c1);
		return infoes;
	}

	/**
	 * ����ѧԱѡ����Ϣ
	 * 
	 * @param student
	 *            ָ��ѧ��
	 * @param subjectinfos
	 *            ѡ����Ϣ
	 * @return
	 */
	public boolean subjectToUpdate(Student student, Subjectinfo... subjectinfos) {
		List<StudentSubject> al = this.getSubjectByStudent(student);
		if (al.size() > 0) {
			daoMap.get(STUDENTSUBJECT).execute_delete(al.toArray());
		}
		al.clear();
		if (subjectinfos != null) {
			for (int i = 0; i < subjectinfos.length; i++) {
				StudentSubject bean = new StudentSubject();
				bean.setId(new StudentSubjectId(student, subjectinfos[i]));
				al.add(bean);
			}
			daoMap.get(STUDENTSUBJECT).execute_insert(al.toArray());
		}
		return true;
	}

	/**
	 * ������Ҫ���ָ��ѧ��������Ϣ
	 * 
	 * @param students
	 *            ָ��ѧ����Ϣ
	 * @return
	 */
	public boolean delete_student_clear(Student... students) {
		DAO dao_card = daoMap.get(STUDENTCARD);
		for (int i = 0; i < students.length; i++) {
			Student student = (Student) getInfoByID(STUDENT, students[i].getStid());
			students[i] = student;
		}
		List<StudentSubject> list_ss = new ArrayList<StudentSubject>();
		List<Studentcard> list_card = new ArrayList<Studentcard>();

		for (Student student : students) {
			list_card.add((Studentcard) dao_card.getByID(student.getStid()));
			list_ss.addAll(getSubjectByStudent(student));
		}

		delete_batch(STUDENTSUBJECT, list_ss.toArray());
		delete_batch(STUDENTCARD, list_card.toArray());
		delete_batch(STUDENT, students);

		return true;
	}

	/**
	 * ������Ҫ���ָ���γ�������Ϣ
	 * 
	 * @param students
	 *            ָ���γ���Ϣ
	 * @return
	 */
	public boolean delete_subject_clear(Subjectinfo... subjectinfos) {
		for(int i=0;i<subjectinfos.length;i++){
			Subjectinfo subjectinfo = (Subjectinfo) getInfoByID(SUBJECTINFO, subjectinfos[i].getSubid());
			subjectinfos[i] = subjectinfo;
		}
		List<StudentSubject> list_ss = new ArrayList<StudentSubject>();

		for (Subjectinfo subjectinfo : subjectinfos) {
			list_ss.addAll(getStudentBySubject(subjectinfo));
		}

		delete_batch(STUDENTSUBJECT, list_ss.toArray());
		delete_batch(SUBJECTINFO, subjectinfos);

		return true;
	}
	
	/**
	 * ϵͳ��¼
	 * @param user ��װ���û�����������û�����
	 * @return �����ȷ�򷵻ط�װ�д��û�ȫ����Ϣ���ԵĶ��󣬷��򷵻ؿգ���ʶ���޴���
	 */
	public Userinfo login(Userinfo user){
		Criterion c1 =  Restrictions.and(Restrictions.eq("logname", user.getLogname()), Restrictions.eq("keyword", user.getKeyword()));
		List<Userinfo> infoes = daoMap.get(USERINFO).getInfoesByProperties(c1);
		
		if(infoes!=null&&infoes.size()==1){
			
			Userinfo userinfo = infoes.get(0);
			
			Userloginfo userloginfo = new Userloginfo(userinfo, new Date(), 1);
			
			daoMap.get(USERLOGINFO).execute_insert(userloginfo);
			
			return userinfo;
			
		}
		return null;
	}
	
	/**
	 * ϵͳ�û��˳�
	 * @param user ��Ҫ�˳����û�����װ��������д��־���
	 */
	public void exit(Userinfo user){
		
		Userloginfo userloginfo = new Userloginfo(user, new Date(), 0);
		
		daoMap.get(USERLOGINFO).execute_insert(userloginfo);
	}

}
