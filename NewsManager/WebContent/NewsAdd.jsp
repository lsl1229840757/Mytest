<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="AddNewsServlet" method="post">
		<input type="text" name="newstitle" placeholder="请输入标题"/><br>
		新闻栏目
		<select name="newstype">
			<option value='html'>html</option>
		<option value='Java'>Java</option>
		<option value='Php'>Php</option>
		</select><br>
	<textarea rows="30" cols="70" id="newscontent" name="newscontent"></textarea><br>
	<input type="submit" value="发布文章">
	</form>
	<h1>${msg }</h1>
</body>
</html>