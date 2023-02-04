// MENU LATERAL ================================================================
const list = document.querySelectorAll(".list");

function activeLink() {
	list.forEach((item) => item.classList.remove("active"));

	this.classList.add("active");

	if (this.id == "notif") {
		document.querySelector(".notificacao").style.display = "none";
		console.log("yes");
	}
}

list.forEach((item) => item.addEventListener("click", activeLink));

const barra = document.querySelector(".navigation");

// barra.style.width = "350px";

barra.addEventListener("mouseleave", () => {
	barra.style.width = "70px";
});

barra.addEventListener("mouseover", () => {
	barra.style.width = "350px";
});

// ELEMENTO VAZIO ==================================================================

function listaVazia() {

	let resultado = document.querySelector(".disponiveis");
	let telaVazio = document.querySelector(".vazio");
	let ilustracao = document.querySelector(".vetor-final img");
	let tabelaFinal = document.querySelector(".tabelaFinal");
	let tabelaNotificacoes = document.querySelector(".tabela-notificacoes");

	if (resultado.textContent == "false") {
		if (tabelaFinal != null) {
			tabelaFinal.style.display = "none";
			ilustracao.style.display = "none";
		}

		if (tabelaNotificacoes != null) {
			tabelaNotificacoes.style.display = "none";
		}

		telaVazio.style.display = "inherit";
	} else {
		telaVazio.style.display = "none";
	}
}



// EXIBICAO DAS NOTAS   ==================================================================

let divNota = document.querySelectorAll(".divNota");

for (let i = 0; i < divNota.length; i++) {
	if (divNota[i].textContent < 10) {
		divNota[i].style.color = "red";
	}
}


// MENU MOBILE ============================================================================

let botao_menu_mobile = document.querySelector('.menuMobile')
let botaoSenha = document.querySelector('.botaoAlterarSenha')
let conteudo = document.querySelector('.conteudo')

let estadoMenu = true

botao_menu_mobile.addEventListener('click', menuMobile)

function menuMobile() {
	if (estadoMenu) {
		if(botaoSenha != null) botaoSenha.style.display = 'none';
		barra.style.display = 'inherit'
		barra.style.width = '75%'
		barra.style.position = 'absolute'
		botao_menu_mobile.src = "assets/img/icon/close.gif"
		estadoMenu = false
	} else {
		barra.style.display = 'none'
		if(botaoSenha != null) botaoSenha.style.display = 'inherit'
		botao_menu_mobile.src = "assets/img/icon/3917762.png"
		estadoMenu = true
	}
}

// ==================================================================
// NOTIFICACAO

// LOGIN

//

// function checarLogin() {
//     if (document.querySelector('#erroLogin').value != 'll') {
//         document.querySelector('#erroLogin').value = 'ERRO DE ENTRADA'
//     }
// }
