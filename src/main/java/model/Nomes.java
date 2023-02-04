package model;

public class Nomes {


private String nome;
private String email;
private String contacto;
private String cadeira;
private String posicao;

public Nomes() {
	super();
	
}


public Nomes(String nome,String email,String contacto,String cadeira,String posicao) {
	super();
	this.nome = nome;
	this.email = email;
	this.contacto = contacto;
	this.cadeira = cadeira;
	this.posicao = posicao;
}




public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public void setEmail(String email) {
	this.email = email;
}



public String getEmail() {
	return email;
}



public void setContacto(String contacto) {
	this.contacto = contacto;
}



public String getContacto() {
	return contacto;
}



public void setCadeira(String cadeira) {
	this.cadeira = cadeira;
}



public String getCadeira() {
	return cadeira;
}





public void setPosicao(String posicao) {
	this.posicao = posicao;
}



public String getPosicao() {
	return posicao;
}

}
