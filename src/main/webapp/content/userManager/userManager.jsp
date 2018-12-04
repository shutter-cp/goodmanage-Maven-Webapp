<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>查看用户列表</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>

	<script type="text/javascript">
		function Goto() {
		}
		function validateUser(flag, userName) {

			document.frm.op.value = flag;
			document.frm.userName.value = userName;
			document.frm.submit();

		}
	</script>
	<DIV>
		<form action='<%=path%>/servlet/FlagUserServlet' method='post'
			name='frm'>
			<input name='op' value='1' type='hidden'> <input
				name='userName' value='' type='hidden'>
		</form>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR class="bg_header" height=47>
					<TD width=10><SPAN class="main_hl"></SPAN></TD>
					<TD><SPAN class="main_hl2"></SPAN> <SPAN class="main_hb">用户管理
					</SPAN> <SPAN class="main_hr"></SPAN></TD>
					<TD class="main_rc" width=10></TD>
				</TR>
				<TR>
					<TD class="main_ls">&nbsp;</TD>
					<TD class="main_nu" vAlign=top align=middle>
						<DIV>
							<TABLE class=gridView
								style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0
								rules=all border=1>
								<TBODY>
									<TR>
										<TH class=gridViewHeader style="WIDTH: 50px" scope=col>&nbsp;</TH>
										<TH class=gridViewHeader scope=col>用户名</TH>
										<TH class=gridViewHeader scope=col>是否注销</TH>
										<TH class=gridviewHeader scope=col>用户详情</TH>
										<TH class=gridviewHeader scope=col>更新</TH>
										<TH class=gridviewHeader scope=col>注销</TH>
									</TR>
									
									<!--  在Java代码中嵌入网页代码，需使用%>  < %来将网页代码放入其中   -->
									<c:forEach items="${userList }" var="user">
										<tr>
											<td  class=gridViewItem style="WIDTH: 50px">
												<img src="../../images/bg_users.gif" alt="" />
											</td>
											<td class=gridViewItem>${user.userName }</td>
											<c:if test="${user.validateFlag==1}">
												<td class=gridViewItem>否</td>
											</c:if>
											<c:if test="${user.validateFlag==0}">
												<td class=gridViewItem>是</td>
											</c:if>
											<td class=gridViewItem>
												<a class=cmdField
													href="${basePath }/content/userManager/detailUser?userName=${user.userName }">查看详情</a></td>
											<td class=gridViewItem>
												<a class=cmdField
													href="${basePath }/content/userManager/updataUser?userName=${user.userName }">编辑</a></td>
											<td class=gridViewItem>
												<c:if test="${user.validateFlag==0}">
													<a class=cmdField href=""
														onclick="doIt('启用','${user.validateFlag}','${user.userName }')">
														启用
													</a>
												</c:if>
												<c:if test="${user.validateFlag==1}">
													<a class=cmdField href=""
														onclick="doIt('注销','${user.validateFlag}','${user.userName }');">
														注销
													</a>
												</c:if>
												
											</td>
										</tr>
									</c:forEach>
												

						</TBODY>
							</TABLE>
						</DIV>
					</TD>
					<TD class="main_rs"></TD>
				</TR>
				<TR class="main_fs" height=10>
					<TD class="main_lf"></TD>
					<TD class="main_fs"></TD>
					<TD class="main_rf"></TD>
				</TR>
			</TBODY>
		</TABLE>
	</DIV>
	
	<script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath}/js/cp.js"></script>
	<script type="text/javascript">
		function doIt(msg,temp,userName){
			var returnVal = confirm("是否"+msg);
			if(returnVal == true) {
			    $.ajax({
					type:"post",
					url:"${basePath }/content/userManager/upDo",
					data:{"temp":temp,
						  "username":userName},
					success:function(data){
						if(data == "sccess"){
							alert("修改成功！");
							location.reload();
						}else{
							alert("修改失败！");
						}
					}
				});
			}
	    }
	</script>
</BODY>
</HTML>