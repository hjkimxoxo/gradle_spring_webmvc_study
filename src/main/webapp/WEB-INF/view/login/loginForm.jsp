<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

	<form:form modelAttribute="loginCommand">
		<form:errors />
		<p>
			<label><spring:message code="email" />:<br>
			<form:input path="email" />
				<form:errors path="email" /></label>
		</p>
		<p>
			<label><spring:message code="password" />:<br>
			<form:password path="password" />
				<form:errors path="password" /></label>
		</p>
		<p>
			<label><spring:message code="rememberEmail" />:<form:checkbox
					path="rememberEmail" /> </label>
		</p>
		<input type="submit" value="<spring:message code="login.btn" />">
	</form:form>


	<%-- <form:form modelAttribute="login" method="post" action="result">
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
	 --%>
</body>
</html>