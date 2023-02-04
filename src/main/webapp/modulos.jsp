<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Modulos"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<Modulos> lista = (ArrayList<Modulos>) request.getAttribute("modulos");
%>

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
<body onload="listaVazia()">
	<div class="navigation">
		<ul>
			<li class="perfil"><a href="perfil"> <span class=""><img
						src="assets/img/images/<%out.print(request.getAttribute("user"));%>.jpg" alt="" /></span> <span
					class="title nome"><%out.print(request.getAttribute("user"));%></span>
			</a></li>
			<li class="list "><a href="menu"> <span class="icon"><img
						src="assets/img/icon/263115.png" alt="" /></span> <span class="title">Principal</span>
			</a></li>
			<li class="list"><a href="docentes"> <span class="icon"><img
						src="assets/img/icon/263070.png" alt="" /></span> <span class="title">Docentes</span>
			</a></li>
			<li class="list active"><a href="modulos"> <span class="icon"><img
						src="assets/img/icon/263081.png" alt="" /></span> <span class="title">Disciplinas</span>
			</a></li>
			<li class="list "><a href="pautas"> <span class="icon"><img
						src="assets/img/icon/263135.png" alt="" /></span> <span class="title">Pautas</span>
			</a></li>
			<li class="list prs"><a href="#"> <span class="icon"><img
						src="assets/img/icon/263089.png" alt="" /></span> <span class="title">Presenças</span>
			</a></li>
			<li class="list"><a href="perfil"> <span class="icon"><img
						src="assets/img/icon/263058.png" alt="" /></span> <span class="title">Perfil</span>
			</a></li>
			<li class="list " id="notif"><a href="notificacoes"> <span
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
		<div class="telaFinal rolar-direita">
		<img class="menuMobile" src="assets/img/icon/3917762.png" alt="">
		  <div class="vetor-final">
          <h1>Lista de Módulos</h1>
          <img src="assets/img/images/modules.png" alt="">
        </div>
		 <div class="disponiveis"><%out.print(request.getAttribute("disponivel"));%></div>
        <div class="vazio">
        <img class="erroImg" src="assets/img/images/not-found.jpg" alt="" />
        <h1>Opa! Nada encontrado!<h1/>
        </div>
			<table class="tabelaFinal scroll">
				<thead>
					<tr>
						<th>Curso</th>
						<th>Semestre</th>
						<th>Módulo</th>
						<th>Tipo</th>
					</tr>
				</thead>

				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getCurso()%></td>
						<td><%=lista.get(i).getSemestre()%></td>
						<td><%=lista.get(i).getNome()%></td>
						<td><%=lista.get(i).getTipo()%></td>
					</tr>

					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<script src="assets/js/menu.js"></script>
</body>
</html>
