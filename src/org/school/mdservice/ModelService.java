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

	// ----------------以下是根据DAO 相关实现 进行的基础操作方法封装--------------------
	/**
	 * 获取指定表格所有信息
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @return 封装有相关信息实体类对象的List
	 */
	public List getAll(String key) {
		return this.daoMap.get(key).getAll();
	}

	/**
	 * 返回指定信息
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param id
	 *            主键编号
	 * @return 封装有相关数据的实体类对象
	 */
	public Object getInfoByID(String key, Serializable id) {
		return this.daoMap.get(key).getByID(id);
	}

	/**
	 * 根据提供的条件做相应的查询获取信息的方法，并可以指定分页操作
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param pagetNum
	 *            指定页面编号
	 * @param rowCount
	 *            单页显示信息行数
	 * @param criterions
	 *            查询条件
	 * @return 封装有相关信息实体类对象的List
	 */
	public List getInfoByProperties(String key, Integer pagetNum,
			Integer rowCount, Criterion... criterions) {
		return this.daoMap.get(key).getInfoesByPage(pagetNum, rowCount,
				criterions);
	}

	/**
	 * 根据提供的条件做相应的查询获取信息的方法
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param criterions
	 *            查询条件
	 * @return 封装有相关信息实体类对象的List
	 */
	public List getInfoByProperties(String key, Criterion... criterions) {
		return this.daoMap.get(key).getInfoesByProperties(criterions);
	}

	/**
	 * 对指定表格进行批量数据添加的方法
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param entities
	 *            根据hibernate规范和业务需要封装有相关数据的实体类对象
	 */
	public void insert_batch(String key, Object... entities) {
		this.daoMap.get(key).execute_insert(entities);
	}

	/**
	 * 对指定表格进行批量数据删除的方法
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param entities
	 *            根据hibernate规范和业务需要封装有相关数据的实体类对象
	 */
	public void delete_batch(String key, Object... entities) {
		this.daoMap.get(key).execute_delete(entities);
	}

	/**
	 * 对指定表格进行批量数据更新的方法
	 * 
	 * @param key
	 *            指定表格key（常量）
	 * @param entities
	 *            根据hibernate规范和业务需要封装有相关数据的实体类对象
	 */
	public void update_batch(String key, Object... entities) {
		this.daoMap.get(key).execute_update(entities);
	}

	/**
	 * 根据每页行数得到指定表格信息可以分成的页数
	 * 
	 * @param type
	 *            指定表格
	 * @param rowCount
	 *            指定每页行数
	 * @return 可以分页数的数量
	 */
	public int getPageCount(String type, int rowCount) {
		return this.daoMap.get(type).getPageCountByRowCount(rowCount);
	}

	// ----------------以下是根据DAO 相关实现 进行的业务需要方法--------------------

	/**
	 * 根据分页操作获取指定信息
	 * 
	 * @param type
	 *            指定表格
	 * @param pageNum
	 *            指定页码
	 * @param rowCount
	 *            指定每页显示行数
	 * @return 查询结果
	 */
	public List getInfoByPageNum(String type, int pageNum, int rowCount) {
		return this.getInfoByProperties(type, pageNum, rowCount);
	}

	/**
	 * 根据指定学生信息获取其当前选修的课程
	 * 
	 * @param student
	 *            指定的学生信息(要求封装有主键编号即可)
	 * @return 学员当前选修的课程
	 */
	public List<StudentSubject> getSubjectByStudent(Student student) {
		Criterion c1 = Restrictions.eq("id.student", student);
		List<StudentSubject> infoes = daoMap.get(STUDENTSUBJECT)
				.getInfoesByProperties(c1);
		return infoes;
	}

	/**
	 * 根据指定课程信息获取选了这门课程的学生
	 * 
	 * @param student
	 *            指定的课程信息(要求封装有主键编号即可)
	 * @return 选修当前课程的学员
	 */
	public List<StudentSubject> getStudentBySubject(Subjectinfo subjectinfo) {
		Criterion c1 = Restrictions.eq("id.subjectinfo", subjectinfo);
		List<StudentSubject> infoes = daoMap.get(STUDENTSUBJECT)
				.getInfoesByProperties(c1);
		return infoes;
	}

	/**
	 * 更新学员选课信息
	 * 
	 * @param student
	 *            指定学生
	 * @param subjectinfos
	 *            选课信息
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
	 * 根据需要清除指定学生所有信息
	 * 
	 * @param students
	 *            指定学生信息
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
	 * 根据需要清除指定课程所有信息
	 * 
	 * @param students
	 *            指定课程信息
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
	 * 系统登录
	 * @param user 封装有用户名和密码的用户对象
	 * @return 如果正确则返回封装有此用户全部信息属性的对象，否则返回空，标识查无此人
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
	 * 系统用户退出
	 * @param user 需要退出的用户，封装数据以填写日志表格
	 */
	public void exit(Userinfo user){
		
		Userloginfo userloginfo = new Userloginfo(user, new Date(), 0);
		
		daoMap.get(USERLOGINFO).execute_insert(userloginfo);
	}

}
