package model;

public class Modulos {

	
	private String semestre;
	private String codigo;
	private String nome;
	private String curso;
	private String tipo;
	
	public Modulos() {
		super();
	}

	public Modulos(String semestre, String codigo, String nome, String curso, String tipo) {
		super();
		this.semestre = semestre;
		this.codigo = codigo;
		this.nome = nome;
		this.curso = curso;
		this.tipo = tipo;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
}
