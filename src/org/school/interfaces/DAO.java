package org.school.interfaces;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

/**
 * ���ڹ淶������Ƶ�DAO�ӿ�
 * 
 * @author Administrator
 *
 * @param <T>
 */
public interface DAO<T> {

	/**
	 * ��ȡ��ر��ȫ����Ϣ
	 * 
	 * @return ��װ�������Ϣ��ʵ��������List
	 */
	List<T> getAll();

	/**
	 * ����������ȡָ����Ϣ��װ����
	 * 
	 * @param id
	 *            ������Ϣ
	 * @return ��װ��������ݵ�ʵ�������
	 */
	T getByID(Serializable id);

	/**
	 * ����ҵ����Ҫ�����ж�������ѯ�ķ���
	 * 
	 * @param criterion
	 *            ��ѯ����
	 * @return ��װ�������Ϣ��ʵ��������List
	 */
	List<T> getInfoesByProperties(Criterion... criterions);

	/**
	 * ����ҵ����Ҫ�����ж�������ѯ��ʵ�ַ�ҳ
	 * 
	 * @param pageNum
	 *            Ҫ��ѯ��ҳ��
	 * @param rowCount
	 *            ָ��ÿҳ��ʾ������
	 * @param criterion
	 *            ��ѯ����
	 * @return ��װ�������Ϣ��ʵ��������List
	 */
	List<T> getInfoesByPage(Integer pageNum, Integer rowCount,
			Criterion... criterions);

	/**
	 * �����������������ӵķ���
	 * 
	 * @param ts
	 *            ��װ�����ݵ� n��ʵ�������
	 */
	void execute_insert(T... ts);

	/**
	 * ���������������ɾ���ķ���
	 * 
	 * @param ts
	 *            ��װ�����ݵ� n��ʵ�������
	 */
	void execute_delete(T... ts);

	/**
	 * ��������������ݸ��µķ���
	 * 
	 * @param ts
	 *            ��װ�����ݵ� n��ʵ�������
	 */
	void execute_update(T... ts);

	/**
	 * ����ÿҳ�������õ���ر����Էֳɼ�ҳ�ķ���
	 * 
	 * @param rowCount
	 *            ÿҳ����
	 * @return ҳ��
	 */
	int getPageCountByRowCount(int rowCount);
}
