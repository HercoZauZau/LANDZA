<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0 , maximum-scale=1.0, user-scalable=no" />
<title>Landza</title>
<link rel="stylesheet" href="assets/css/senha.css" />
<link rel="shortcut icon" href="assets/img/icon/icone.png"
	type="image/x-icon">
</head>
<body>
	<div class="recuperarSenha">
		<a class="sair" href="login"><img alt=""
			src="assets/img/icon/close.gif" class="icon"></a>
		<h1 class="tituloSenha">Recuperar Senha</h1>
		<img class="ilustra" src="assets/img/images/forgot-password.jpg"
			alt="">
		<form action="enviarNovaSenha">
			<label for="">
				<p>ID de Usuário</p> <input autofocus required type="text" name="id">
			</label>
			<button class="gravar" type="submit">Submeter</button>
		</form>
	</div>


	<script src="assets/js/menu.js"></script>
</body>
</html>
