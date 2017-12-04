<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banco Jones</title>
<style>
	#language {
		margin-left:90%;
	}
</style>
</head>
<body>
	<%@ include file="menu.html" %>
	<form>
		<select id="language" name="language" onchange="submit()">
			<option value="ca" ${language == 'ca' ? 'selected': '' } >Català</option>
			<option value="es" ${language == 'es' ? 'selected': '' } >Español</option>
		</select>
	</form>
	<h1><fmt:message key="welcome"/></h1>
</body>
</html>