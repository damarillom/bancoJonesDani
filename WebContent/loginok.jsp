<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.Cliente" %>
<%
Cliente c = null;
String user = null;
String dni = null;
String sessionID = null;
if (session.getAttribute("clientSession") == null) {
	request.getRequestDispatcher("jones.jsp").include(request,response);
	return;
} else {
	c = (Cliente)session.getAttribute("clientSession");
	user = c.getNombre();
	dni = c.getDni();
}
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if (cookie.getName().equals("JSESSIONID") ) {
			sessionID = cookie.getValue();
		}
	}
} else {
	sessionID = "No hay cookies";
}
%>
<h3>hola <%=user %>, con dni <%=dni %> <%=sessionID %></h3>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<%-- <form method="POST" action=<%=response.encodeURL("LogoutServlet")%>>
		<input type="submit" value="cerrar sesion">
	</form> --%>
	<form method="POST" action="<%=response.encodeURL("ControllerServlet")%>">
		<input type="hidden" name="action" value="logout">
		<input type="submit" value="Cerrar sesión">
	</form>
	
	<form method="POST" action="<%=response.encodeURL("PerfilServlet")%>">
		<input type="submit" value="Perfil">
	</form>
	<!--<form method="POST" action="<%=response.encodeURL("ListAccountsServlet")%>">
		<input type="submit" value="Cuentas">
	</form>-->
	<form method="POST" action="<%=response.encodeURL("ControllerServlet")%>">
		<input type="hidden" name="action" value="listAccounts">
		<input type="submit" value="Cuentas">
	</form>
	
</body>
</html>