<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>

<html>
<head>
  <meta charset="UTF-8">
        <script type="text/javascript" src="${ pageContext.request.contextPath }/./js/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="${ pageContext.request.contextPath }/./js/jquery.ztree.core.js"></script>
        <link rel="stylesheet" href="${ pageContext.request.contextPath }/./style/listEmployee.css">
        <link rel="stylesheet" href="${ pageContext.request.contextPath }/./style/zTreeStyle.css">
        <link rel="stylesheet" href="${ pageContext.request.contextPath }/./style/demo.css">
        <script type="text/javascript" src="${ pageContext.request.contextPath }/js/index.js"></script>
</head>
<body>


<header id="header-top" class="header-top">
            <div class="contain-1">
                <div class="nav">
                    <div id="mini">
                        <img src="${ pageContext.request.contextPath }/./img/mini.png" >
                    </div>
                    <ul id="treeDemo" class="ztree">

                    </ul>
                </div>
                <div class="contain-1-1">
                        <div class="contain-1-1-1">
                            <img src="${ pageContext.request.contextPath }/./img/guanli.png">
                        </div>
                        <div class="contain-1-1-1">
                            <h3>员工管理系统</h3>
                            <h4>yuan gong guan li xi tong</h4>
                        </div>
                </div>
                <div class="contain-1-1">
                    <div class="contain-1-2">
                        <img src="${ pageContext.request.contextPath }/./img/huanying.png">
                        <h3>欢迎进入该系统:
                        <s:property value="#session.existEmployee.ename"/>
                        </h3>
                    </div> 
                </div>
            </div>
        </header>
        <div class="contain-2">
            <div class="contain-2-1">
                <h3>员工管理系统<span>></span>员工管理</h3>
                <a href="${pageContext.request.contextPath }/employee_saveUI.action">
                <img src="${ pageContext.request.contextPath }/./img/jia.png">
                </a>
                <div class="contain-2-1-1">
                	<table>
					<tr>
					<td>
					  <span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页
					   总的记录数：<s:property value="totalCount"/>
					  每页显示：<s:property value="pageSize"/>
					   </span>
					   <span>
					   <s:if test="currPage != 1">
					       <a href='employee_findAll.action?currPage=1'>[首页]</a>
					       <a href="employee_findAll.action?currPage=<s:property value='currPage - 1'/>">[上一页]</a>
					   </s:if>
					   <s:if test="currPage != totalPage">
					       <a href="employee_findAll.action?currPage=<s:property value='currPage + 1'/>">[下一页]</a>
					       <a href="employee_findAll.action?currPage=<s:property value='totalPage'/>">[尾页]</a>
					   </s:if>
					   </span>
					</td>
					</tr>
					</table>
                </div>
            </div>
            <div class="contain-2-2">
            	<div class="contain-2-2-1">
                <table>
                    <thead>
                       <tr>
                            <td><h3>编号</h3></td>
							<td><h3>员工姓名</h3></td>
							<td><h3>性别</h3></td>
							<td><h3>出生日期</h3></td>
							<td><h3>入职时间</h3></td>
							<td><h3>所属部门</h3></td>
							<td><h3>编辑</h3></td>
							<td><h3>删除</h3></td>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- 进行部门信息分页，迭代输出 -->
						<s:iterator value="list" var="e">
						<tr>
						<td align="center"><s:property value="#e.eno"/></td>
						<td align="center"><s:property value="#e.ename"/></td>
						<td align="center"><s:property value="#e.sex"/></td>
						<td align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
						<td align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"/></td>
						<td align="center"><s:property value="#e.department.dname"/></td>
						<td align="center"><a href="employee_edit.action?eid=<s:property value='#e.eid'/>">
						<img src="${pageContext.request.contextPath }/images/编辑.png"/></a></a></td>
						<td align="center"><a href="employee_delete.action?eid=<s:property value='#e.eid'/>">
						<img class="revise" src="${pageContext.request.contextPath }/images/icon/j.png"/></a></a></td>
						</tr>
					</s:iterator>
                    </tbody>
                </table>
                </div>
            </div>
        </div>
        <footer id="footer-bottom" class="footer-bottom">
                <div class="contain-3">
                    <h3>Welcome to this system!</h3>
                </div>
        </footer>
</body>
</html>