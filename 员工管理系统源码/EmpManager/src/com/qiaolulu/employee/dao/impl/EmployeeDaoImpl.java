package com.qiaolulu.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.qiaolulu.employee.dao.EmployeeDao;
import com.qiaolulu.employee.domain.Employee;
/**
 * 员工管理的DAO的实现类
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao{

	@Override
	/**
	 * DAO中根据用户名和密码查询用户的方法
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username=? and password=?";
		//利用事务模板对象进行数据库的操作
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		//对list集合进行判断
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	//获取员工总记录
	public int fintCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	//获取员工集合信息
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	//添加员工
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}

	@Override
	//根据员工编号查询员工信息
	public Employee finById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class,eid);
	}

	@Override
	//更新员工信息
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
	}

	@Override
	//根据员工id删除员工
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
	}
}
