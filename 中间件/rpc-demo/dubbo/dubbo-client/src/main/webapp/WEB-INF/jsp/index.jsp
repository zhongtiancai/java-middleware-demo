<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="/static/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function save() {
		$.ajax({
			url : '/saveJson',
			type : 'post',
			dataType : 'json',
			contentType : 'application/json',
			data : {
				"id" : $('#form1 input[name=id]').val(),
				"name" : $('#form1 input[name=name]').val()
			},
			success : function() {

			}
		})
	}
	function saveJson() {
		$.ajax({
			url : '/save',
			type : 'post',
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify({
				"id" : $('#form2 input[name=id]').val(),
				"name" : $('#form2 input[name=name]').val()
			}),
			success : function() {

			}
		})
	}
</script>
</head>
<body>
	<form id="form1" method="post" action="/saveJson">
		<input name="id" /> <input name="name" /> <input type="button"
			value="保存" onclick="saveJson();">
	</form>
	<form id="form2" method="post" action="/save">
		<input name="id" /> <input name="name" /> <input type="button"
			value="保存" onclick="save();">
	</form>
</body>
</html>