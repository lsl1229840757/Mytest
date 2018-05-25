<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻列表</title>
<script type="text/javascript">
 	function quanxuan(qx){
		var di = document.getElementsByName("deleteid");
		document.getElementById("operate").value="pishan";
		for(var i=0;i<di.length;i++){
			di[i].checked=qx.checked;
		}
	}

 	function pisheng(){
 		document.getElementById("operate").value="pisheng";
 		document.forms[0].submit();
 	}
 	
</script>
</head>
<body>
	<form action="DeleteServlet2" method="post">
	<input type="hidden" id="operate" name="operate" value="pishan"> 
	<input type="submit" value="批量删除">
	<input type="button" onclick="pisheng()" value="批量审核"/>
	 <table width="1000px" cellpadding="0px" cellspacing="0px" border="1px" style="border:1px solid gray; border-collapse: collapse;">
		<tr>
			<th><input type="checkbox" name="qx" onclick="quanxuan(this);"/></th>
			<th>文章ID</th>
    		<th>文章标题</th>
    		<!-- <th>内容</th> -->
    		<th>是否审核</th>
    		<th>所属栏目</th>
    		<th>创建时间</th>
    		<th>操作</th>
    	</tr>
		<c:forEach items="${NewsList }" var="n">
			<tr>
				<td><input type="checkbox" name="deleteid" id="deleteid" value="${n.newsId }"/></td>
				<td>${n.newsId }</td>
				<td><a href="NewsReadServlet?id=${n.newsId}&pageNumber=${pageNumber}" target="_blanket">${n.newsTitle }</a></td>
				<!-- <td>${n.newsContent }</td> -->
				<td>${n.newsStatus }</td>
				<td>${n.newsType }</td>
				<td>${n.createtime }</td>	
				<td><a href="UpdateServlet?id=${n.newsId }">编辑</a> |<a href = "DeleteServlet?id=${n.newsId }"> 删除</a></td>		
			</tr>		
		</c:forEach>
		<tr>
			<td colspan="7"><a href="NewsServlet?pageNumber=1">首页</a>
			<a href="NewsServlet?pageNumber=${pageNumber-1>0?pageNumber-1:1 }">上一页</a>
			第${pageNumber }页
			<a href="NewsServlet?pageNumber=${pageNumber+1>pageCount?pageCount:pageNumber+1 }">下一页</a>
			<a href="NewsServlet?pageNumber=${pageCount }">尾页</a>
			<a href="NewsAdd.jsp" target="_blanket">发布新闻</a></td>
		</tr>
	</table>
	</form>
</body>
</html>