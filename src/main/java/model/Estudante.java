package model;

public class Estudante {


private String nome;
private String codigo;
private String endereco;
private String email;
private String nascimento;
private String contacto;
private String curso;
private String roll;
private String ano;
private String senha;






public Estudante() {
	super();	
}





public Estudante(String nome, String codigo, String endereco, String email, String nascimento, String contacto,
		String curso, String roll, String ano, String senha) {
	super();
	this.nome = nome;
	this.codigo = codigo;
	this.endereco = endereco;
	this.email = email;
	this.nascimento = nascimento;
	this.contacto = contacto;
	this.curso = curso;
	this.roll = roll;
	this.ano = ano;
	this.senha = senha;
}





public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNascimento() {
	return nascimento;
}
public void setNascimento(String nascimento) {
	this.nascimento = nascimento;
}
public String getContacto() {
	return contacto;
}
public void setContacto(String contacto) {
	this.contacto = contacto;
}
public String getCurso() {
	return curso;
}
public void setCurso(String curso) {
	this.curso = curso;
}
public String getRoll() {
	return roll;
}
public void setRoll(String roll) {
	this.roll = roll;
}

public String getAno() {
	return ano;
}
public void setAno(String ano) {
	this.ano = ano;
}

public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}



}