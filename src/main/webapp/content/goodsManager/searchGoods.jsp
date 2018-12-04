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
<LINK href="<%=path %>/css/biz.css" type=text/css rel=stylesheet>
</HEAD>
<BODY>
<SCRIPT type=text/javascript>
function Goto(){}
function deleteCurrentRow(obj){
var tr=obj.parentNode.parentNode;
var tbody=tr.parentNode;
tbody.removeChild(tr);
}


</SCRIPT>
<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR  class="bg_header"  height=47>
        <TD width=10><SPAN class="main_hl"></SPAN></TD>
        <TD>
        <SPAN class="main_hl2"></SPAN>
        <SPAN class="main_hb">商品查询 </SPAN>
        <SPAN class="main_hr"></SPAN>
      	</TD>
        <TD  class="main_rc " width=10></TD>
      </TR>
      <TR>
        <TD class="main_ls">&nbsp;</TD>
        <TD class="main_nu" vAlign=top align=middle>
          <DIV>
            <TABLE class=gridView style="WIDTH: 80%; BORDER-COLLAPSE: collapse"  cellSpacing=0 rules=all  border=0>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader  >商品查询</TH>
                </TR>
                <TR><form action="" method="post">
                  <TD> &nbsp;&nbsp;&nbsp;商品Id &nbsp;&nbsp;&nbsp;  <input class=gridViewItem type="text" id="productIDs" name="productID">
						 &nbsp;&nbsp;&nbsp;商品名称 &nbsp;&nbsp;&nbsp;  <input class=gridViewItem type="text" id="productNames" name="productName">
						 &nbsp;&nbsp;&nbsp;<input class="button" type="button" onclick="doIt();" value="查询" />
				  </TD></form>
                </TR>
                <TR>
					  <td>
						<div id="pagination">
							<table class=gridView id="teb"  style="WIDTH: 100%; BORDER-COLLAPSE: collapse" width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
								 <TR>
								  <TH class=gridViewHeader >商品Id</TH>
								  <TH class=gridViewHeader >商品名称</TH>
								  <TH class=gridViewHeader >商品价格</TH>
								  <TH class=gridViewHeader >商品数量</TH>
								  <TH class=gridviewHeader >商品描述</TH>
								  <TH class=gridviewHeader >商品类别</TH>
								  <TH class=gridviewHeader >更新</TH>
								  <TH class=gridviewHeader >删除</TH>
								</TR>
								<c:forEach items="${goodsList }" var="goods">
									 <TR>
									  <TD class=gridViewItem>${goods.goodsID }</TD>
									  <TD class=gridViewItem>${goods.goodsName }</TD>
									  <TD class=gridViewItem>${goods.goodsPrice }元</TD>
									  <TD class=gridViewItem>${goods.goodsCount }</TD>
									  <TD class=gridViewItem>${goods.goodsDep }</TD>
									  <TD class=gridViewItem>${goods.type }</TD>
									  
									  <TD class=gridViewItem><A class=cmdField   href="${basePath }/content/goodsManager/update?goodsid=${goods.goodsID }">编辑</A></TD>
									  <TD class=gridViewItem><a class=cmdField  href="${basePath }/content/goodsManager/delete?goodsid=${goods.goodsID }&op=del">删除 </a></TD>
									</TR>
								</c:forEach>
                                   
							</table>
						</div>
				  </td>
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
</DIV>
	<script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath}/js/cp.js"></script>
    <script type="text/javascript">
		function doIt(){
			var productID = $("#productIDs").val();
			var productName = $("#productNames").val();
			$.ajax({
				type:"post",
				url:"${basePath}/content/goodsManager/searchGoods/fond",
				data:{"productID":productID,"productName":productName},
				success:function(data){
					val=eval(data);
					var dHtml = '<TR><TH class=gridViewHeader >商品Id</TH><TH class=gridViewHeader >商品名称</TH>'+
								  '<TH class=gridViewHeader >商品价格</TH><TH class=gridViewHeader >商品数量</TH>'+
								  '<TH class=gridviewHeader >商品描述</TH><TH class=gridviewHeader >商品类别</TH>'+
								  '<TH class=gridviewHeader >更新</TH><TH class=gridviewHeader >删除</TH></TR>';
					for(i in val){
						dHtml +=  '<TR>'+
									 ' <TD class=gridViewItem>'+val[i].goodsID+'</TD>'+
									  '<TD class=gridViewItem>'+val[i].goodsName+'</TD>'+
									  '<TD class=gridViewItem>'+val[i].goodsPrice+'元</TD>'+
									 ' <TD class=gridViewItem>'+val[i].goodsCount+'</TD>'+
									  '<TD class=gridViewItem>'+val[i].goodsDep+'</TD>'+
									 ' <TD class=gridViewItem>'+val[i].type+'</TD>'+
									 ' <TD class=gridViewItem><A class=cmdField   href="${basePath }/content/goodsManager/update?goodsid='+val[i].goodsID+'">编辑</A></TD>'+
									' <TD class=gridViewItem><a class=cmdField  href="${basePath }/content/goodsManager/delete?goodsid='+val[i].goodsID+'">删除 </a></TD>'+
									'</TR>';
					}
					$("#teb *").remove();
					$("#teb").html(dHtml);
				}
			});
		}
     </script>
</BODY>
</HTML>
