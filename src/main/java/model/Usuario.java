package model;

public class Usuario {

	private String nome;
	private String tipo;
	private String id;
	
	
	
	public Usuario() {
		super();
	}


	public Usuario(String nome, String tipo, String id) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
