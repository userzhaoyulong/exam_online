<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en" class="no-js">
    <head>

        <meta charset="utf-8">
        <title>在线考试系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="${ctx}/css/reset.css">
        <link rel="stylesheet" href="${ctx}/css/supersized.css">
        <link rel="stylesheet" href="${ctx}/css/userlogin.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>
        <div class="page-container">
            <h1>用户登录</h1>
            <form action="${ctx}/user/login" method="post" name="myform" id="myform">
                <input type="text" name="userid" id="userid" class="username" placeholder="用户账号">
                <input type="password" name="userpwd" id="userpwd" class="password" placeholder="登录密码">
               <%--  <span>${message }</span> --%>
                <button type="button" onclick="login()">登录</button>
                <div class="error"><span>${message }</span></div>
            </form>
            <div class="connect">

            </div>
        </div>
        <div align="center">没有账号？ <a href="${ctx}/user/toRegist" target="_self">注册</a></div>

        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/supersized.3.2.7.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/supersized-init.js"></script>
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        <script type="text/javascript">
        	function login(){
        		var userId = $("#userid").val();
        		var userPwd = $("#userpwd").val();
        		$.post("${pageContext.request.contextPath}/user/checkPwd", { userid:userId, userpwd:userPwd },function(data){
                    //alert("test");
        		    if(data.errorNo == "0"){
    					alert(data.errorInfo);
    				}
    				if (data.errorNo == "1") {
    					document.myform.attributes["action"].value = "${pageContext.request.contextPath}/user/toIndex_u";
    					$("form").submit();
    				}
    				if (data.errorNo == "2") {
                        document.myform.attributes["action"].value = "${pageContext.request.contextPath}/user/toIndex_a";
                        $("form").submit();
                    }
        		},"json");
        	}
        </script>

    </body>

</html>
