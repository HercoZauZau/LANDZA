<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>Landza</title>
<link rel="stylesheet" href="assets/css/menu.css" />
<link rel="shortcut icon" href="assets/img/icon/icone.png" type="image/x-icon">
</head>
<body>
	<div class="navigation">
		<ul>
			<li class="perfil"><a href="perfil"> <span class=""><img
						src="assets/img/images/<%out.print(request.getAttribute("user"));%>.jpg"
						alt="" /></span> <span class="title nome">
						<%
						out.print(request.getAttribute("user"));
						%>
				</span>
			</a></li>
			<li class="list active"><a href="menu"> <span class="icon"><img
						src="assets/img/icon/263115.png" alt="" /></span> <span
					class="title">Principal</span>
			</a></li>
			<li class="list"><a href="docentes"> <span class="icon"><img
						src="assets/img/icon/263070.png" alt="" /></span> <span
					class="title">Docentes</span>
			</a></li>
			<li class="list"><a href="modulos"> <span class="icon"><img
						src="assets/img/icon/263081.png" alt="" /></span> <span
					class="title">Disciplinas</span>
			</a></li>
			<li class="list"><a href="pautas"> <span class="icon"><img
						src="assets/img/icon/263135.png" alt="" /></span> <span
					class="title">Pautas</span>
			</a></li>
			<li class="list prs"><a href="#"> <span class="icon"><img
						src="assets/img/icon/263089.png" alt="" /></span> <span
					class="title">Presenças</span>
			</a></li>
			<li class="list"><a href="perfil"> <span class="icon"><img
						src="assets/img/icon/263058.png" alt="" /></span> <span
					class="title">Perfil</span>
			</a></li>
			<li class="list" id="notif"><a href="notificacoes"> <span
					class="icon"><img
						src="assets/img/icon/263119.png" alt="" /></span> <span
					class="title">Notificações <span
						class="notificacao">12</span></span>
			</a></li>
			<li class="list"><a href="login"> <span class="icon"><img
						src="assets/img/icon/263136.png" alt="" /></span> <span
					class="title">Sair</span>
			</a></li>
		</ul>
	</div>
	<div class="principal">
	<img class="menuMobile" src="assets/img/icon/3917762.png" alt="">
		<div class="logotela logo-branco">
			<img src="assets/img/images/logotipo (2).png" alt="" />
		</div>
		<div class="principal2 rolar-direita">
			<div class="texto">
				<h1 class="tituloPrincipal">Dinamismo na sua Instituição.</h1>
				<p>Organize as suas tarefas academicas de forma simples e
					dinâmica onde estiver, via Desktop, Mobile ou pela Web.</p>
				<button class="btPrincipal">Iniciar</button>
				<button class="btPrincipal">Saber mais</button>
			</div>
			<img src="assets/img/images/react.png" alt="" />
		</div>
	</div>
	<script src="assets/js/menu.js"></script>
</body>
</html>
