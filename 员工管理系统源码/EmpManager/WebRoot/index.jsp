<%@ page language="java" import="java.util.*"  contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"  %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登陆</title>
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/3d.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/script.js"></script>
<link rel="stylesheet" href="${ pageContext.request.contextPath}/style/index.css">
<script type="text/javascript" src="${ pageContext.request.contextPath}/js/index.js"></script>

</head>

<body>
<header id="header-top" class="header-top">
            <div class="contain-1">
                <div class="contain-1-1">
                        <div class="contain-1-1-1">
                            <img src="${ pageContext.request.contextPath}/img/guanli.png">
                        </div>
                        <div class="contain-1-1-1">
                            <h3>员工管理系统</h3>
                            <h4>yuan gong guan li xi tong</h4>
                        </div>
                </div>
                <div class="contain-1-1">
                    <div class="contain-1-2">
                        <ul>
                            <li>设为首页<span>|</span></li>
                            <li>联系我们<span>|</span></li>
                            <li>加入收藏<span>|</span></li>
                            <li>帮助中心</li>
                        </ul>
                    </div> 
                </div> 
            </div>
        </header>

<form action="employee_login" method="post" namespace="/">
 <div id="contain-2" class="contain-2">
            <div class="contain-2-1">
                <div class="contain-2-1-1">
                    <div class="contian-2-1-1-1">
                        <h3>Hi,</h3>
                        <h4>欢迎进入系统!</h4>
                        <div class="contian-2-1-1-1-1">
                            <div class="animate-1" align="center">
                                <img src="img/shujia.png" rel="书架">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="contain-2-1">
                <div class="contain-2-1-2">
                    <img src="img/guagou.png" class="img1">
                    <div class="contain-2-1-2-1">
                        <h3>登录</h3>
                        <div class="contain-2-1-2-middle">
                            <div class="contain-2-1-2-middle-1">
                                <img src="${ pageContext.request.contextPath}/img/guanliyuan.png" class="img2">  
                                <input class="input1" type="text" name="username" placeholder="管理登录"> 
                            </div>
                            <div class="contain-2-1-2-middle-1">
                                <img class="img2" src="${ pageContext.request.contextPath}/img/mima.png">
                                <input class="input1" type="password" name="password" placeholder="请输入密码">
                            </div>
                            <div class="contain-2-1-2-middle-1">
                                <input class="login_btn" type="submit"  value="登录">
                            </div>
	                            <div class="contain-2-1-2-middle-1-show">
	                             <h4><s:actionerror/></h4> 
	                             </div>
                            	<div class="contain-2-1-2-middle-2">
                                <h4>使用合作方软件进行登录</h4>
                                <div class="center">
                                    <img class="img3" src="${ pageContext.request.contextPath}/img/qq.png">
                                    <img class="img3" src="${ pageContext.request.contextPath}/img/wexin.png">
                                    <img class="img3" src="${ pageContext.request.contextPath}/img/xinlang.png">
                                </div>
                            </div>
                        </div>      
                    </div>
                </div>
            </div>
        </div>
</form>

<footer id="footer-bottom" class="footer-bottom">
            <div class="contain-3">
                <h3>Welcome to this system!</h3>
            </div>
        </footer>
</body>
</html>
 