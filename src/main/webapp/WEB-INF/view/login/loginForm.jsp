<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="login" method="post" action="result">
	<p>
		<label for="loginType">로그인 타입</label>
		<form:select path="loginType">
			<form:options items="${loginType}"></form:options>
		</form:select>
		
	</p>
	<p>
	<label for="jobCodes">직군</label>
		<form:select path="jobCode">
			<!-- <option value="" selected>-- 선택하세요---</option> -->
			<form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
	</form:select>
	</p>
	<p>
		<label for="tools">tools</label>
		<form:radiobuttons items="${tools}" path="tools" />
	</p>
	<p>
		<label for="favoriteOs">선호 OS</label>
		<form:checkboxes items="${favoriteOs}" path="favoriteOs" />
	</p>
	<p>
	<label for="favoriteOs2">선호OS2</label>
		<form:checkboxes items="${favoriteOs2}" path="favoriteOs2" itemLabel="label" itemValue="code"/>
	</p>

	
	<input type="submit" value="결과보기">
</form:form>
	
</body>
</html>