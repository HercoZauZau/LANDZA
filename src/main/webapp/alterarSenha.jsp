<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0 , maximum-scale=1.0, user-scalable=no" />
<title>Landza</title>
<link rel="stylesheet" href="assets/css/senha.css" />
<link rel="shortcut icon" href="assets/img/icon/icone.png"
	type="image/x-icon">
</head>
<body>
	<div class="telaAlterarSenha">
		<a class="sair" href="acessarPerfil"><img alt="" src="assets/img/icon/close.gif"
			class="icon"></a>
		<h1 class="tituloSenha">Alterar Senha</h1>
		<img class="ilustra" src="assets/img/images/mobile-login.jpg"
			alt="">

		<form action="alterarSenha">
			<label for="">
				<p>Senha Actual</p> <input type="password" name="atual" required autofocus>
			</label> <label for="">
				<p>Nova senha</p> <input class="inputNovaSenha" type="password" name="nova" required autofocus>
			</label> <label for="">
				<p>Confirmar nova senha</p> <input class="inputConfirmaSenha" type="password" required autofocus>
			</label>
			<button class="gravar" type="submit">Gravar</button>
		</form>
	</div>

	<div class='resultado'>
		<%
		out.print(request.getAttribute("resultadoSenha"));
		%>
	</div>

	<script src="assets/js/senha.js"></script>
</body>
</html>
