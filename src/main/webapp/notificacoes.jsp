<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Notificacoes"%>
<%@ page import="java.util.ArrayList"%>
<%

@ SuppressWarnings ("unchecked")
ArrayList<Notificacoes> lista = (ArrayList<Notificacoes>) request.getAttribute("conta");
%>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>Landza</title>
    <link rel="stylesheet" href="assets/css/menu.css" />
    <link rel="stylesheet" href="assets/css/perfil.css" />
    <link rel="shortcut icon" href="assets/img/icon/icone.png" type="image/x-icon">
  </head>
  <body onload="listaVazia()">
    <div class="navigation">
       <ul>
        <li class="perfil">
          <a href="perfil">
            <span class=""
              ><img src="assets/img/images/<%out.print(request.getAttribute("user"));%>.jpg" alt=""
            /></span>
            <span class="title nome"><%out.print(request.getAttribute("user"));%></span>
          </a>
        </li>
        <li class="list ">
          <a href="menu">
            <span class="icon"
              ><img src="assets/img/icon/263115.png" alt=""
            /></span>
            <span class="title">Principal</span>
          </a>
        </li>
        <li class="list">
          <a href="docentes">
            <span class="icon"
              ><img src="assets/img/icon/263070.png" alt=""
            /></span>
            <span class="title">Docentes</span>
          </a>
        </li>
        <li class="list">
          <a href="modulos">
            <span class="icon"
              ><img src="assets/img/icon/263081.png" alt=""
            /></span>
            <span class="title">Disciplinas</span>
          </a>
        </li>
        <li class="list">
          <a href="pautas">
            <span class="icon"
              ><img src="assets/img/icon/263135.png" alt=""
            /></span>
            <span class="title">Pautas</span>
          </a>
        </li>
        <li class="list prs" >
          <a href="#">
            <span class="icon"
              ><img src="assets/img/icon/263089.png" alt=""
            /></span>
            <span class="title">Presenças</span>
          </a>
        </li>
        <li class="list">
          <a href="perfil">
            <span class="icon"
              ><img src="assets/img/icon/263058.png" alt=""
            /></span>
            <span class="title">Perfil</span>
          </a>
        </li>
        <li class="list active" id="notif">
          <a href="notificacoes">
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
          <h1>Notificações</h1>
          <img src="assets/img/images/notific.jpg" alt="">
        </div>
       <div class="disponiveis"><%out.print(request.getAttribute("disponivel"));%></div>
        <div class="vazio">
        <img class="erroImg" src="assets/img/images/not-found.jpg" alt="" />
        <h1>Opa! Nada encontrado!<h1/>
        </div>
        
          <div class="tabela-notificacoes scroll">
            <%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<article>
			<p><%=lista.get(i).getTitulo()%></p>
				<p><%=lista.get(i).getMsg()%></p>
				<p><%=lista.get(i).getHora()%></p>
			</article>
			<%
			}
			%>
          </div>
      </div>
    </div>
    <script src="assets/js/menu.js"></script>
  </body>
</html>
