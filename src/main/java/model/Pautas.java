package model;

public class Pautas {

	private String sem;
	private String cod;
	private String nome;
	private String teo;
	private String pra;

	public Pautas() {
		super();

	}

	public Pautas(String sem, String cod, String nome, String teo, String pra) {
		super();
		this.sem = sem;
		this.cod = cod;
		this.nome = nome;
		this.teo = teo;
		this.pra = pra;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTeo() {
		return teo;
	}

	public void setTeo(String teo) {
		this.teo = teo;
	}

	public String getPra() {
		return pra;
	}

	public void setPra(String pra) {
		this.pra = pra;
	}

}
