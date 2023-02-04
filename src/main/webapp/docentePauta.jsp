<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>Landza</title>
<link rel="stylesheet" href="assets/css/senha.css" />
<link rel="shortcut icon" href="assets/img/icon/icone.png"
	type="image/x-icon">
</head> 
<body>
	<div class="alterarNotas">
		<a class="sair" href="listaEstudantes"><img alt=""
			src="assets/img/icon/close.gif" class="icon"></a>
		<h1 class="tituloSenha">Alterar Notas</h1>
		<img class="ilustra" src="assets/img/images/pie-chart.jpg"
			alt="">

		<form action="alterarNotas">
			<div class="notaNome" for="">
				<p ><%out.print(request.getAttribute("nome"));%></p> 
				<p>ID: <%out.print(request.getAttribute("id"));%></p>
			</div>
			<input class="resultado" type="Text" name="id"
				value="<%out.print(request.getAttribute("id"));%>">
			 <label for="">
				<p>Primeiro teste</p> 
				<input class="teste" type="number" name="teste1"
				required="required" min="0" max="20" 
				value="<%out.print(request.getAttribute("teste1"));%>">
			</label> 
			<label for="">
				<p>Segundo teste</p> <input class="teste" type="number"
				name="teste2" required="required"  min="0" max="20" 
				value="<%out.print(request.getAttribute("teste2"));%>">
			</label>
			<button class="gravar" type="submit">Atualizar Notas</button>
		</form>
	</div>


	
</body>
</html>
