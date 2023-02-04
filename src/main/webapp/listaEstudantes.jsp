<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Estudante"%>
<%@ page import="java.util.ArrayList"%>
<%

@ SuppressWarnings ("unchecked")
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
    <link rel="shortcut icon" href="assets/img/icon/icone.png" type="image/x-icon">
  </head>
  <body onload="listaVazia()">
    <div class="navigation">
       <ul>
        <li class="perfil">
          <a href="docentePerfil">
            <span class=""
              ><img src="assets/img/images/<%out.print(request.getAttribute("user"));%>.jpg" alt=""
            /></span>
            <span class="title nome"><%out.print(request.getAttribute("user"));%></span>
          </a>
        </li>
        <li class="list ">
          <a href="docenteMenu">
            <span class="icon"
              ><img src="assets/img/icon/263115.png" alt=""
            /></span>
            <span class="title">Principal</span>
          </a>
        </li>
        <li class="list active">
          <a href="listaEstudantes">
            <span class="icon"
              ><img src="assets/img/icon/263070.png" alt=""
            /></span>
            <span class="title">Estudantes</span>
          </a>
        </li>
        <li class="list">
          <a href="docenteModulos">
            <span class="icon"
              ><img src="assets/img/icon/263081.png" alt=""
            /></span>
            <span class="title">Disciplinas</span>
          </a>
        </li>
 
        <li class="list prs">
          <a href="docentePresencas">
            <span class="icon"
              ><img src="assets/img/icon/263089.png" alt=""
            /></span>
            <span class="title">Presenças</span>
          </a>
        </li>
        <li class="list">
          <a href="docentePerfil">
            <span class="icon"
              ><img src="assets/img/icon/263058.png" alt=""
            /></span>
            <span class="title">Perfil</span>
          </a>
        </li>
        <li class="list" id="notif">
          <a href="docenteNotificacoes">
            <span class="icon"
              ><img src="assets/img/icon/263119.png" alt=""
            /></span>
            <span class="title"
              >Notificações <span class="notificacao">12</span></span
            >
          </a>
        </li>
        <li class="list">
          <a href="login">
            <span class="icon"
              ><img src="assets/img/icon/263136.png" alt=""
            /></span>
            <span class="title">Sair</span>
          </a>
        </li>
      </ul>
    </div>
    <div class="principal">
      <div class="logotela">
        <img src="assets/img/images/logotipo.png" alt="" />
      </div>
      <div class="telaFinal rolar-direita">
      <img class="menuMobile" src="assets/img/icon/3917762.png" alt="">
        <div class="vetor-final">
          <h1>Lista de Estudantes</h1>
          <img src="assets/img/images/students.jpg" alt="">
        </div>
        <div class="disponiveis"><%out.print(request.getAttribute("disponivel"));%></div>
        <div class="vazio">
        <img class="erroImg" src="assets/img/images/not-found.jpg" alt="" />
        <h1>Opa! Nada encontrado!<h1/>
        </div>
        <table class="tabelaFinal scroll">
          <thead>
            <tr>
              <th>Nome</th>
              <th>Código</th>
              <th>Email</th>
              <th>Curso</th>
              <th>Ano</th>
              <th>Nota I</th>
              <th>Nota II</th>
              <th>Opções</th>
            </tr>
          </thead>

          <tbody>
            <%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCodigo()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getCurso()%></td>
				<td><%=lista.get(i).getAno()%></td>
				<td  class="divNota"><%out.print(request.getAttribute("nota1("+i+")"));%></td>
				<td  class="divNota"><%out.print(request.getAttribute("nota2("+i+")"));%></td>
				<td><a href="docentePauta?id=<%=lista.get(i).getRoll()%>&nome=<%=lista.get(i).getNome()%>&teste1=<%out.print(request.getAttribute("nota1("+i+")"));%>&teste2=<%out.print(request.getAttribute("nota2("+i+")"));%>" class=""> <img class="iconeOpcoes" src="assets/img/icon/3917376.png" alt="" /> </a></td>
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
