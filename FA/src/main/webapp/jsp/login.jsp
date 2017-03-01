<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>固定资产管理系统登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	

	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 




</script>

<script type="text/javascript">
function login(){
	 var userName=document.getElementById("userName").value; 
	 var password=document.getElementById("password").value; 
	 var matchResult=true; 
	 if(userName=="用户名"||password=="      "){ 
		 alert("请确认是否有空缺项！"); 
		 matchResult=false; 
		 }
	 if(userName==""||password==""){ 
		 alert("请确认是否有空缺项！"); 
		 matchResult=false; 
		 }
	 if(matchResult==true){ 
	 if(userName.charAt(0)>=0&&userName.charAt(0)<=9){ 
		 alert("用户名不能以数字字符开始！"); 
		 matchResult=false; 
		 } 
	 } 

	 return matchResult; 
}

</script>
<!-- Bootstrap Core CSS -->
<link href="<%=basePath%>/css/bootstrap.min.css" rel='stylesheet'
	type='text/css' />
<!-- Custom CSS -->
<link href="<%=basePath%>/css/style.css" rel='stylesheet'
	type='text/css' />
<link href="<%=basePath%>/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="<%=basePath%>/js/jquery.min.js"></script>
<!----webfonts--->
<!-- <link href='http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
 -->
<!---//webfonts--->
<!-- Bootstrap Core JavaScript -->
<script src="<%=basePath%>/js/bootstrap.min.js"></script>
</head>

<body id="login">
	<div class="login-logo">
		<a href="index.html"></a>
	</div>
	<h2 class="form-heading">固定资产管理系统登录</h2>
	<div class="app-cam">
		<form action="LoginAction" onsubmit="return login()" method="post">
			<input type="text" class="text" name="userName" id="userName"
				value="用户名" onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = '用户名';}"></input> <input
				type="password" name="password" id="password" value="      "
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = '      ';}"></input>
				<c:if test="${sessionScope.flag>0}">错误次数${sessionScope.flag}</c:if>
			<div class="submit">
				<input type="submit" value="Login">
			</div>
		</form>
	</div>
</body>
</html>