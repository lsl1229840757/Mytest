<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新闻</title>
    <script type="text/javascript" charset="UTF-8" src="kindeditor-4.1.10/kindeditor.js" ></script>
    <script type="text/javascript" charset="UTF-8">
        KindEditor.ready(function(K) {
                K.create('#newscontent', {
	                uploadJson : 'kindeditor-4.1.10/jsp/upload_json.jsp',
	                fileManagerJson : 'kindeditor-4.1.10/jsp/file_manager_json.jsp',
	                allowFileManager : true
        		});
        });
    </script>
</head>
<body>
	<form action="DoUpdateNewsServlet" method="post">
		<input type="hidden" name="newsId" value="${news.newsId }"/>
		<input type="text" name="newstitle" value="${news.newsTitle }"/><br>
		新闻栏目
		<select name="newstype">
		<option <c:if test="${news.newsType==\"html\" }">selected</c:if> value='html'>html</option>
		<option <c:if test="${news.newsType==\"Java\" }">selected</c:if> value='Java'>Java</option>
		<option <c:if test="${news.newsType==\"Php\" }">selected</c:if> value='Php'>Php</option>
		</select><br>
	<textarea rows="30" cols="70" id="newscontent" name="newscontent" >${news.newsContent }</textarea><br>
	<input type="submit" value="确认修改">
	</form>
	<h1>${msg }</h1>
</body>
</html>