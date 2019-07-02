<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>

<html>
<head>
 <meta charset="UTF-8">
  <script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="js/jquery.ztree.core.js"></script>
 <link rel="stylesheet" href="${ pageContext.request.contextPath}/style/zTreeStyle.css">
 <link rel="stylesheet" href="${ pageContext.request.contextPath}/style/addDepartment.css">
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
                <h3>员工管理系统<span>></span>部门管理<span>></span>部门添加</h3>
            </div>
            <div class="contain-2-2">
                <div class="contain-2-2-1">
                    <div class="contain-2-2-1-1">
                    	<s:form id="saveform" action="department_save" method="post" namespace="/" theme="simple">
                        <table>
                        <tr>
                            <td><h3>部门名称:</h3></td>
                            <td class="addTd">
                            <h3> <%--<input type="text" name="department.dname" id="dddd"> --%>  <s:textfield name="dname"/>
                            </h3>
                            </td>
                        </tr>
                        <tr>
                            <td><h3>部门介绍:</h3></td>
                            <td class="addTd">
                            <h3><s:textarea rows="5" cols="50" name="ddesc" /></h3></td> 
                        </tr>
                        </table>
                        </s:form>
                    </div>
                    <div class="contain-2-2-2-1">
                    <div align="center">
	                    <h3 class="button">
		                  <a class="change" href="#">保存</a>
		                  </h3>
		                   <h3 class="button1">
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
