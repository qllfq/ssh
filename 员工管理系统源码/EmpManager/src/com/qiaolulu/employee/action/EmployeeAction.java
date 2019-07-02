package com.qiaolulu.employee.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.qiaolulu.employee.domain.Department;
import com.qiaolulu.employee.domain.Employee;
import com.qiaolulu.employee.domain.PageBean;
import com.qiaolulu.employee.service.DepartmentService;
import com.qiaolulu.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 员工管理的Action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	//模型驱动需要使用的对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	//注入业务层类：
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	/**
	 * 登录执行的方法：
	 * @return
	 */
	public String login(){
		System.out.println("login执行了。。。。");

		//调用业务层的类
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	
	/**
	 * 分页查询员工的执行方法
	 */
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public String findAll(){
		System.out.println("findAll");
		PageBean<Employee> pageBean = employeeService.findAll(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 跳转到添加员工页面执行的方法
	 */
	public String saveUI(){
		System.out.println("saveUI");
		List<Department> list = departmentService.findAll();//查询所有部门信息
		//将查询得到的部门信息集合存入值栈中，对象使用push方法，集合使用set方法
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/**
	 * 添加员工的执行方法
	 */
	public String save(){
		System.out.println("save");
		employeeService.save(employee);
		return "saveSuccess";
	}
	/**
	 * 编辑员工的执行的方法
	 */
	public String edit(){
		System.out.println("edit");
		//根据员工ID查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有的部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	/**
	 * 更新员工信息的执行方法
	 */
	public String update(){
		System.out.println("update");
		employeeService.update(employee);
		return "updateSuccess";
	}
	/**
	 * 根据员工id删除员工
	 */
	public String delete(){
		System.out.println("delete");
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
	
}
