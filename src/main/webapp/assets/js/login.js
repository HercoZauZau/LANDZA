// ERRO DE LOGIN ==================================================================

let msgDiv = document.querySelector(".resultadoLogin");

let msg = msgDiv.textContent.trim();

console.log(msg);

if (msg != "null") {
  msgDiv.style.display = "inherit";
}
