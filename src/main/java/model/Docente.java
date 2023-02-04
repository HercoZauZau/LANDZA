package model;

public class Docente {
	
	private String id;
	private String nome;
	private String email;
	private String numero;
	private String curso;
	private String ano;
	private String modulo;
	private String posicao;
	private String serie;
	private String senha;
	
	
	public Docente() {
		super();
	}


	public Docente(String id, String nome, String email, String numero, String curso, String ano, String modulo,
			String posicao, String serie, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.numero = numero;
		this.curso = curso;
		this.ano = ano;
		this.modulo = modulo;
		this.posicao = posicao;
		this.serie = serie;
		this.senha = senha;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}


	public String getModulo() {
		return modulo;
	}


	public void setModulo(String modulo) {
		this.modulo = modulo;
	}


	public String getPosicao() {
		return posicao;
	}


	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
