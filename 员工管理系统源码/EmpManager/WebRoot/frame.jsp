<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
 <head>
 <meta charset="UTF-8">
  <script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
  <script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery.ztree.core.js"></script>
 <link rel="stylesheet" href="${ pageContext.request.contextPath}/style/zTreeStyle.css">
 <link rel="stylesheet" href="${ pageContext.request.contextPath}/style/frame.css">
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
                        <h3>欢迎进入该系统
                        	<span><s:property value="#session.existEmployee.ename"/></span>
                        </h3>
                    </div> 
                </div>
            </div>
        </header>
        <div class="contain-2">
            <div align="center">
            <img src="img/bj.png">
            </div>
        </div>
        <footer id="footer-bottom" class="footer-bottom">
                <div class="contain-3">
                    <h3>Welcome to this system!</h3>
                </div>
        </footer>
    </body>
</html>