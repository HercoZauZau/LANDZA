package model;

public class Notificacoes {

	private String titulo;
	private String msg;
	private String hora;

	public Notificacoes() {
		super();

	}

	public Notificacoes(String titulo, String msg, String hora) {
		super();
		this.titulo = titulo;
		this.msg = msg;
		this.hora = hora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
