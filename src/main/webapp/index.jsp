<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>欢迎登陆商品管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="css/public.css" type=text/css rel=stylesheet>
<LINK href="css/login.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
	<DIV id=div1>


		<TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800
			align=center>
			<TBODY>
				<TR id=main>
					<TD>
						<form action="" onsubmit='return checkLogin()' method='post'>
							<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
								<TBODY>
									<TR>
										<TD colSpan=4>&nbsp;</TD>
									</TR>
									<TR height=30>
										<TD width=380>&nbsp;</TD>
										<TD>&nbsp;</TD>
										<TD>&nbsp;</TD>
										<TD>&nbsp;</TD>
									</TR>
									<TR height=40>
										<TD rowSpan=4></TD>
										<TD>用户名：</TD>
										<TD><INPUT class=textbox id="userName" name="userName">
										</TD>
										<TD width=120>&nbsp;</TD>
									</TR>
									<TR height=40>
										<TD>密 码：</TD>
										<TD><INPUT class=textbox id="password" type=password
											name="password"></TD>
										<TD width=120>&nbsp;</TD>
									</TR>
									<TR height=40>
										<TD>
											<!-- 验证码：-->
										</TD>
										<TD vAlign=center colSpan=2>
											<!-- <INPUT id=txtSN size=4 name=txtSN> &nbsp; <IMG src="images/default.gif" border=0> <A id=LinkButton1 href="#">不清楚，再来一张</A>-->
											<font color='red'>${errorMsgs }</font>
										</TD>
									</TR>
									<TR height=40>
										<TD></TD>
										<TD align=right><INPUT id=btnLogin type="button"
											value=" 登 录 " onclick="login();"></TD>
										<TD width=120>&nbsp;</TD>
									</TR>
									<TR height=110>
										<TD colSpan=4>&nbsp;</TD>
									</TR>
								</TBODY>
							</TABLE>
						</form>
					</TD>
				</TR>
				<TR id=root height=104>
					<TD>&nbsp;</TD>
				</TR>
			</TBODY>
		</TABLE>
	</DIV>
	<DIV id=div2 style="DISPLAY: none"></DIV>
	<script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath}/js/cp.js"></script>
	<script type="text/javascript">
		login = function(){
			var username = $("#userName").val();
			var password = $("#password").val();
			if(username!=""&&password!=""){
				post("${basePath}/login",{"username":username,"password":password});
			}else{
				alert("请输入用户名和密码！！");
			}
		};
		
		
	</script>
	
</BODY>
</HTML>
