<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Estudante"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Estudante> lista = (ArrayList<Estudante>) request.getAttribute("conta");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>Landza</title>
<link rel="stylesheet" href="assets/css/menu.css" />
<link rel="shortcut icon" href="assets/img/icon/icone.png"
	type="image/x-icon">
</head>
<body>
	<div class="navigation">
		<ul>
			<li class="perfil"><a href="perfil"> <span class=""><img
						src="assets/img/images/<%=lista.get(0).getNome()%>.jpg" alt="" /></span>
					<span class="title nome"><%=lista.get(0).getNome()%></span>
			</a></li>
			<li class="list "><a href="menu"> <span class="icon"><img
						src="assets/img/icon/263115.png" alt="" /></span> <span class="title">Principal</span>
			</a></li>
			<li class="list"><a href="docentes"> <span class="icon"><img
						src="assets/img/icon/263070.png" alt="" /></span> <span class="title">Docentes</span>
			</a></li>
			<li class="list"><a href="modulos"> <span class="icon"><img
						src="assets/img/icon/263081.png" alt="" /></span> <span class="title">Disciplinas</span>
			</a></li>
			<li class="list"><a href="pautas"> <span class="icon"><img
						src="assets/img/icon/263135.png" alt="" /></span> <span class="title">Pautas</span>
			</a></li>
			<li class="list prs"><a href="#"> <span class="icon"><img
						src="assets/img/icon/263089.png" alt="" /></span> <span class="title">Presenças</span>
			</a></li>
			<li class="list active"><a href="perfil"> <span class="icon"><img
						src="assets/img/icon/263058.png" alt="" /></span> <span class="title">Perfil</span>
			</a></li>
			<li class="list" id="notif"><a href="notificacoes"> <span
					class="icon"><img src="assets/img/icon/263119.png" alt="" /></span>
					<span class="title">Notificações <span class="notificacao">12</span></span>
			</a></li>
			<li class="list"><a href="login"> <span class="icon"><img
						src="assets/img/icon/263136.png" alt="" /></span> <span class="title">Sair</span>
			</a></li>
		</ul>
	</div>
	<div class="principal">
		<div class="logotela">
			<img src="assets/img/images/logotipo.png" alt="" />
		</div>

		<div class="tela-perfil telaFinal rolar-direita">
			<img class="menuMobile" src="assets/img/icon/3917762.png" alt="">
			<h1><%=lista.get(0).getNome()%></h1>
			<img alt="" class="fotoDePerfil"
				src="assets/img/images/<%=lista.get(0).getNome()%>.jpg">
				
				<div class="divTab">
				<h4>Dados Pessoais</h4>
				<table class="dadosPerfil">
				<tr>
					<th>
						<p>Nome</p>
					</th>
					<td>
						<p>
							<%=lista.get(0).getNome()%>
						</p>
					</td>
				</tr>
				<th>
					<p>Código</p>
				</th>
				<td>
					<p><%=lista.get(0).getCodigo()%></p>
				</td>
				</tr>
				<th>
					<p>Endereço</p>
				</th>
				<td>
					<p><%=lista.get(0).getEndereco()%></p>
				</td>
				</tr>
				<th>
					<p>Email</p>
				</th>
				<td>
					<p><%=lista.get(0).getEmail()%></p>
				</td>
				</tr>
				<th>
					<p>Data de nascimento</p>
				</th>
				<td>
					<p><%=lista.get(0).getNascimento()%></p>
				</td>
				</tr>
				<th>
					<p>Contacto</p>
				</th>
				<td>
					<p><%=lista.get(0).getContacto()%></p>
				</td>
				</tr>
				<th>
					<p>Curso</p>
				</th>
				<td>
					<p ><%=lista.get(0).getCurso()%></p>
				</td>
				</tr>
			</table>
				</div>
			
			<div class="botaoAlterarSenha">
				<a href="paginaSenha">Alterar Senha</a>
			</div>
		</div>
	</div>
	<script src="assets/js/menu.js"></script>
</body>
</html>
