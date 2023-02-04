<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 , maximum-scale=1.0, user-scalable=no">
<title>Lanza</title>
<link rel="stylesheet" href="assets/css/login.css">
<link rel="shortcut icon" href="assets/img/icon/icone.png"
	type="image/x-icon">
</head>
<body>
	<div class="intro">
		<img class="vetor" src="assets/img/images/vetor-book.png" alt="">
		<p>Dinamismo na sua Instituição</p>
		<p>Organize as suas tarefas academicas de forma simples e dinâmica
			onde estiver, via Desktop, Mobile ou pela Web.</p>
	</div>
	<header>
		<img src="assets/img/images/logotipo.png" alt="">
		<p class="msg">Bem-Vindo(a) ao Landza</p>

		<form action="entrar">
			<p class="resultadoLogin">
				<%
				out.print(request.getAttribute("erro"));
				%>
			</p>
			 <label for="">
				<p>Usuário</p> <input required autofocus type="text"
				autofocus="autofocus" name="id" id="">
			</label> <label for="">
				<p>Senha</p> <input required autofocus type="password"
				autofocus="autofocus" name="senha" id="">
			</label> <a href="recuperarSenha">esqueci minha senha</a>
			<button type="submit">Entrar</button>
		</form>
	</header>
	<script src="assets/js/login.js"></script>
</body>
</html>