<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Banco Jones - Insertar cuenta</title>
<style type="text/css">
	input {
		margin-top:5px;
	}
</style>
</head>
<body>
	<%@ include file="menu.html"%>
	<div>
		<form action="InsertAccountServlet" method="POST">
			IBAN: <input type="text" name="ibanIns"><br>
			Saldo: <input type="text" name="balanceIns"><br>
			<input type="submit" value="Insertar nueva cuenta">
		</form>
	</div>
</body>
</html>