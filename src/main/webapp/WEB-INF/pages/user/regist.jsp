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
<link rel="stylesheet" href="${ctx}/css/reset.css">
<link rel="stylesheet" href="${ctx}/css/supersized.css">
<link rel="stylesheet" href="${ctx}/css/userlogin.css">
<script src="${ctx}/js/jquery-1.8.2.min.js"></script>
<script src="${ctx}/js/supersized.3.2.7.min.js"></script>
<script src="${ctx}/js/supersized-init.js"></script>
<script src="${ctx}/js/scripts.js"></script>
<script type="text/javascript">
	function regist(){
		var Pwd = $("#Pwd").val();
		var userPwd =$("#userPwd").val();
		if(Pwd ==""){
			alert("登录密码不能为空");
			return;
		}
		if(userPwd ==""){
			alert("确认密码不能为空");
			return;
		}
		if(Pwd!=userPwd){
			alert("两次密码不一致，请重新输入！");
			return;
		}
		document.myform.attributes["action"].value = "${ctx}/user/registUser";
		$("form").submit();
	}
	
	function checkUserId(){
		var userId = $("#userId").val();
		var tipInfo = $("#tipInfo").val();
		if(userId == ""){
			$("#tipInfo").html("请输入账号");
			$("#userId").focus();
			return;
		}
	 	$.ajax({
	        type: "post",
	        url: "${pageContext.request.contextPath}/user/checkUserId",
	        data: {userId:userId},
	        dataType: "json",
	        success: function(data){
	        	$("#tipInfo").html(data.errorInfo);
	        }
	    });
        //alert("测试");
	}
	
	function checkPwd(){
		var Pwd = $("#Pwd").val();
		var userPwd =$("#userPwd").val();
		if(Pwd ==""){
			alert("登录密码不能为空");
			return;
		}
		if(userPwd ==""){
			alert("确认密码不能为空");
			return;
		}
		if(Pwd!=userPwd){
			alert("两次密码不一致，请重新输入！");
			return;
		}
	}

    function searchGrade() {
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/user/getGrade",
            dataType: "json",
            success: function(data){
                var grades;
                for (var i = 0; i < data.length; i++){
                    //alert(data[i].gradename);
                    grades = '<input type="radio" value="grade" name="grade" class="radio" checked="checked"/><span>'+data[i].gradename+'</span>&nbsp;';
                    $('label').append(grades);
                }
            }
        });
    }

</script>
</head>
<body onload="searchGrade()">
    <div class="page-container">
        <h1>用户注册</h1>
        <form action="${ctx}/user/regist" method="post" name="myform" id="myform">
            <input type="text" name="userid" id="userId" class="username" placeholder="用户账号" onblur="checkUserId()"><br><span style="color: red" id="tipInfo">${message }</span><br>
            <input type="text" name="username" id="userName" placeholder="用户昵称">
            <input type="password" name="userpwd" id="Pwd" class="password" placeholder="登录密码">
            <input type="password" name="userpwd_confirm" id="userPwd" class="password" placeholder="确认密码" onblur="checkPwd()"><br/>
				<%--<input id="gradeList" type="radio" checked="checked" name="grade"
					class="radio" /> &nbsp;--%>
            <input type="text" name="email" id="email" class="username" placeholder="邮箱">
            <input type="text" name="telphone" id="telphone" placeholder="联系电话">
            <input type="text" name="address" id="address" placeholder="联系地址"><br>
            <label></label>
            <button type="button" onclick="regist()">注册</button>
            <div class="error"><span>${message }</span></div>
        </form>
        <div class="connect"></div>
    </div>
    <div align="center">我已经有一个账号，我要 <a href="${ctx}/user/login" target="_self">登录</a></div>
</body>

</html>
