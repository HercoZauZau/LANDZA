// ALTERACAO DE SENHA   ==================================================================


let resultado = document.querySelector(".resultado");

if (resultado.textContent.includes('null')) {
	console.log('null');
} else if (resultado.textContent.includes('1')) {
	window.alert('Senha alterada com sucesso!')
	window.location.href = 'perfil'
} else if (resultado.textContent.includes('0')) {
	window.alert('Falha! Introduza a senha correcta!')
	window.location.href = 'alterarSenha.jsp'
}


let botao = document.querySelector(".gravar");
let senha = document.querySelector(".inputNovaSenha");
let senha2 = document.querySelector(".inputConfirmaSenha");

botao.style.display = "none";

function validaSenha(e) {
	if ((senha.value != senha2.value) && (senha.value != "" && senha2.value != "")) {
		e.style.borderColor = "red";
		botao.style.display = "none";
	} else if ((senha.value == senha2.value) && (senha.value != "" && senha2.value != "")) {
		botao.style += 'display: inherit;';
		senha.style.borderColor = "black";
		senha2.style.borderColor = "black";
	}
}

senha.addEventListener("keyup", () => { validaSenha(senha2) });
senha2.addEventListener("keyup", () => { validaSenha(senha) });
