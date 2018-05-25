<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#content{
		height:auto;
		width:au to;
	}
</style>
</head>
<body>
<h1>${news.newsTitle }</h1>
<hr>
	<div id="content">${news.newsContent }</div>
<hr>
<a href="NewsServlet?pageNumber=${pageNumber }">返回</a>
</body>
</html>