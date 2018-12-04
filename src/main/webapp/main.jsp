<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商品销售管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<frameset id=index border=0 frameSpacing=0 rows=120,* frameBorder=no>
	<frame id=topFrame name=topFrame src="Top.html" noResize scrolling=no>
	<frameset border=0 frameSpacing=0 frameBorder=no cols=20%,*>
		<frame id=leftFrame name=leftFrame src="Left.html" noResize
			scrolling=no>
		<frame id=mainFrame name=mainFrame
			src="${basePath}/content/userManager/userManager" noResize scrolling=no>
	</frameset>
</frameset>
</html>
