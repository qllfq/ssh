<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>

<html>
<head>
<meta charset="UTF-8">
  <script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="js/jquery.ztree.core.js"></script>
  <script type="text/javascript" src="${ pageContext.request.contextPath}/js/lyz.calendar.min.js"></script>
   <link rel="stylesheet" href="${ pageContext.request.contextPath}/style/lyz.calendar.css">
 <link rel="stylesheet" href="${ pageContext.request.contextPath}/style/zTreeStyle.css">
 <link rel="stylesheet" href="${ pageContext.request.contextPath}/style/addEmployee.css">
 <script type="text/javascript" src="${ pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>

 <header id="header-top" class="header-top">
            <div class="contain-1">
                <div class="nav">
                    <div id="mini">
                        <img src="img/mini.png" >
                    </div>
                    <ul id="treeDemo" class="ztree">

                    </ul>
                </div>
                <div class="contain-1-1">
                        <div class="contain-1-1-1">
                            <img src="img/guanli.png">
                        </div>
                        <div class="contain-1-1-1">
                            <h3>员工管理系统</h3>
                            <h4>yuan gong guan li xi tong</h4>
                        </div>
                </div>
                <div class="contain-1-1">
                    <div class="contain-1-2">
                        <img src="img/huanying.png">
                        <h3>欢迎进入该系统:</h3>
                    </div> 
                </div>
            </div>
        </header>
        <div class="contain-2">
            <div class="contain-2-1">
                <h3>员工管理系统<span>></span>员工管理<span>></span>员工添加</h3>
            </div>
            <div class="contain-2-2">
                <div class="contain-2-2-1">
                    <div class="contain-2-2-1-1">
                    	<s:form action="employee_save.action" id="saveform" method="post" namespace="/" theme="simple">
						<table border='0' cellpadding="0"  cellspacing="10">
							<tr>
								<td>姓名：</td>
								<td><h3  class="clear"><s:textfield name="ename"/></h3></td>
								<td>性别：</td>
								<td>
								<s:radio name="sex" list="{'男','女'}"></s:radio>
								</td>
							</tr>
							<tr>
								<td>用户名：</td>
								<td><h3 class="clear">
								<s:textfield name="username"/></h3>
								</td>
								<td>
								密码：</td>
								<td><h3  class="clear"><s:password name="password"/></h3></td>
							</tr>
							<tr>
								<td>出生日期：</td>
								<td>
								<h3 class="clear">
								<%-- <input id="saveform_birthday" type="text" value="<s:property value="#request.birthday"/>"> --%>
								 <s:textfield name="birthday"/>
								 </h3>
								 </td>
								<td>入职时间：</td>
								<td>
								<h3 class="clear">
								<s:textfield name="joinDate"/>
								</h3>
								</td>
							</tr>
							 <tr>
								<td>所属部门：</td>
								<td><h3 class="clear">
								<s:select list="list" name="department.did" listKey="did" listValue="dname" headerKey="" headerValue="-----请--选--择----"></s:select></h3></td>
								<td>编号：</td>
								<td><h3 class="clear"><s:textfield name="eno"/></h3></td>
							</tr>
						</table>
						</s:form> 
                    </div>
                     <div class="contain-2-2-2-1">
                    <div align="center">
	                    <h3 class="button-add">
		                 <a class="change-add">保存</a>
		                  </h3>
		                   <h3 class="button-add1">
						  <a href="javascript:history.go(-1)">退回 </a> 
							</h3>
					</div>
                    </div>
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
