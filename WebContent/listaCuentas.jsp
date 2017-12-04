<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.Cliente"%>
<%@ page import="beans.Account"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ?  language : 'es' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources/lang"/> 
<%
	Cliente c = null;
	String sessionID = null;
	List<Account> accounts = null;
	//String address = null;
	if (session.getAttribute("clientSession") == null) {
		response.sendRedirect("jones.jsp");
	} else {
		c = (Cliente) session.getAttribute("clientSession");
		accounts = c.getAccounts();
	}
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("JSESSIONID")) {
				sessionID = cookie.getValue();
			}
		}
	} else {
		sessionID = "No hay cookies";
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table {
		border: 1px solid black;
		border-collapse: inherit;
	}
	td {
		border:1px solid black;
		border-collapse: inherit;
	}
	tr {
		border:1px solid black;
		border-collapse: inherit;
	}
	#language {
		margin-left:90%;
	}
</style>
</head>
<body>
		<%@ include file="menu.html"%>
		<form>
			<select id="language" name="language" onchange="submit()">
				<option value="ca" ${language == 'ca' ? 'selected': '' } >Català</option>
				<option value="es" ${language == 'es' ? 'selected': '' } >Español</option>
			</select>
		</form>
		<h2> Cuentas del usuario <%=c.getNombre() %></h2>
	
	<div class="container" id="accounts">		
	<table class='table'><thead><tr><th>IBAN</th><th>Saldo</th></tr></thead>
	<%
		for (Account account : accounts) {
			String button = "<form action='DeleteAccountServlet' method='POST'><input type='submit' value='Eliminar cuenta'><input type='hidden' name='ibanIns' value='"+account.getIban()+"'><input type='hidden' name='balanceIns' value='"+account.getSaldo()+"'></form>";
			String iban = account.getIban();
			double balance = account.getSaldo();
			%> 
				<tbody><tr><td> <%=iban %> </td><td> <%=balance %></td><td><%=button %></td><td><input type="button" value="Transaccion" onclick="location.href='ListTransactionsServlet?iban=<%=iban %>'"></td></tr></tbody> 
			<%
		}
	%>
	</table>
	</div>
	<br>
	<br>
	<form method="POST" action=<%=response.encodeURL("insertAccount.jsp")%>>
		<input type="submit" value="Añadir nueva cuenta">
		
	</form>
</body>
</html>