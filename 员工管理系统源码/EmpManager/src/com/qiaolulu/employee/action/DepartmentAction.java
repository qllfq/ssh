package com.qiaolulu.employee.action;

import com.qiaolulu.employee.domain.Department;
import com.qiaolulu.employee.domain.PageBean;
import com.qiaolulu.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 部门管理的Action的类
 * 该类中需要进行分页
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	//模型驱动
	private Department department = new Department();
	@Override
	public Department getModel() {
		return department;
	}
	//注入业务层
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	private Integer currPage = 1;//当前页，默认为1即为首页
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;//提供一个set方法进行注入
	}

	/**
	 * 提供一个查询的方法-->进行分页
	 */
	public String findAll(){
		System.out.println("findAll");
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 跳转到添加部门的页面的方法
	 */
	public String saveUI(){
		System.out.println("saveUI");
		return "saveUI";
	}
	/**
	 * 保存添加部门的数据方法
	 */
	public String save(){
		System.out.println("save");
		departmentService.save(department);
		return "saveSuccess";
	}
	/**
	 * 编辑部门的执行方法
	 */
	public String edit(){
		System.out.println("edit");
		//根据部门id查询部门信息
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	/**
	 * 修改部门的执行方法
	 */
	public String update(){
		System.out.println("update");
		departmentService.update(department);
		return "updateSuccess";
	}
	/**
	 * 删除部门的执行方法
	 */
	public String delete(){
		System.out.println("delete");
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);//此种操作可以实现级联删除
		return "deleteSuccess";
	}
	
}
