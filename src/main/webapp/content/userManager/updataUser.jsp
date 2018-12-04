<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="../../css/biz.css" type=text/css rel=stylesheet>
<link rel="stylesheet" href="${basePath }/css/semantic.css" />
</HEAD>
<BODY>
<SCRIPT type=text/javascript>
</SCRIPT>
<DIV>
<form action='' name=myForm method='post'>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR  class="bg_header"  height=47>
        <TD width=10><SPAN class="main_hl"></SPAN></TD>
        <TD>
        <SPAN class="main_hl2"></SPAN>
        <SPAN class="main_hb">编辑用户 </SPAN>
        <SPAN class="main_hr"></SPAN>
      	</TD>
        <TD  class="main_rc " width=10></TD>
      </TR>
      <TR>
        <TD class="main_ls">&nbsp;</TD>
        <TD class="main_nu" vAlign=top align=middle>
          <DIV>
            <TABLE class=gridView style="WIDTH: 80%; BORDER-COLLAPSE: collapse"  cellSpacing=0 rules=all  border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader  colspan="5" >用户信息</TH>
                </TR>
                <TR>
                  <TD class=gridViewItem>用户名 </TD>
                  <TD class=gridViewItem><input  type="text" value="${user.userName }" name="userName" readonly="readonly"></TD>
                  <TD class=gridViewItem>有效标识</TD>
                  <TD class=gridViewItem >
                  <c:if test="${user.validateFlag == 0}">
                  	<input type='radio' name='validateFlag' value='0' checked="true">注销
				  	<input type='radio' name='validateFlag'    value='1'  >有效
                  </c:if>
                  <c:if test="${user.validateFlag == 1}">
                  	<input type='radio' name='validateFlag' value='0' >注销
				  	<input type='radio' name='validateFlag'    value='1'  checked="true">有效
                  </c:if>
                </TD>
                </TR>
                <TR>
                  <TD class=gridViewItem>密码 </TD>
                  <TD  class=gridViewItem><input type='password' name='password' value='${user.pwd }'></TD>
                  <TD class=gridViewItem>请再次输入密码 </TD>
                  <TD  class=gridViewItem><input type='password' name='password1' value='${user.pwd }'></TD>
              	 </tr>
              	 <TR>
                  <TD class=gridViewItem >用户类型 </TD>
                  <TD class=gridViewItem>
                		<select name="roleType" style="WIDTH:45% ;color:#566984" >
                			<c:forEach items="${rolseList }" var="rolse">
							    <option value="${rolse.id }">${rolse.roleName }</option>
                			</c:forEach>
						</select>  
				  </TD>
              	 </tr>
                <TR>
                  <TD class=gridViewItem  colspan="4" >
                <input class=cmdField type="button" onclick="doIt();" value="提交">&nbsp;&nbsp;&nbsp;
                  </Td>
                </TR>
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
  </form>
</DIV>
	<script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath}/js/cp.js"></script>
	<script type="text/javascript">
		function doIt(){
			var validateFlag;
			robj=document.myForm.validateFlag;
			for(i=0;i<robj.length;i++){
				if(robj[i].checked){
					validateFlag = robj[i].value;
				}
			}
		
			var username = $("input[name='userName']").val();
			var password = $("input[name='password']").val();
			var password1 = $("input[name='password1']").val();
			var roleType = $("select[name='roleType']").val();
			if(password != password1){
				alert("两次密码不符合！");
			};
			
			$.ajax({
				type:"post",
				url:"${basePath }/content/userManager/updataUserDo",
				data:{"username":username,
					  "password":password,
					  "validateFlag":validateFlag,
					  "roleType":roleType				
					  },
				success:function(data){
					if(data == "sccess"){
						alert("修改成功！");
						window.location.href="${basePath}/content/userManager/userManager"
					}else{
						alert("修改失败！");
					}
				}
			});
	    }
	</script>

</BODY>
</HTML>
