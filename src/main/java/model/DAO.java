package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.print.Doc;

import com.mysql.cj.xdevapi.PreparableStatement;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://";

	private String user = "";

	private String password = "";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			return con;
		} catch (Exception e) {
			System.out.print(e);

			return null;
		}
	}

	public int alterarSenha(String id, String novaSenha, String senhaAtual) {
		String query = "update estudantes set password='" + novaSenha + "' where userid='" + id + "' and password ='"
				+ senhaAtual + "'";
		try {

			Connection con = conectar();
			PreparedStatement pr = con.prepareStatement(query);
			return pr.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Estudante> criarUsuario(String id) {
		ArrayList<Estudante> dados = new ArrayList<>();
		String read = "select primeiroNome,ultimoNome,userid,cidade,provincia,emailid,dataNascimento,numeroTelefone,Courcecode,numeroEstudante,semouano,password from estudantes where userid='"
				+ id + "'";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String nome = rs.getString(1) + " " + rs.getString(2);
				String codigo = rs.getString(3);
				String endereco = rs.getString(4) + "," + rs.getString(5);
				String email = rs.getString(6);
				String nascimento = rs.getString(7);
				String contacto = rs.getString(8);
				String curso = rs.getString(9);
				String roll = rs.getString(10);
				String ano = rs.getString(11);
				String senha = rs.getString(12);

				dados.add(new Estudante(nome, codigo, endereco, email, nascimento, contacto, curso, roll, ano, senha));
			}
			con.close();
			return dados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<Docente> criarDocente(String id) {
		ArrayList<Docente> dados = new ArrayList<>();
		String read = "select facultyid,facultyname,emailid,contactnumber,courcecode,semoryear,subject,position,sr_no,password from docentes where facultyid='"
				+ id + "'";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String codID = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String numero = rs.getString(4);
				String curso = rs.getString(5);
				String ano = rs.getString(6);
				String modulo = rs.getString(7);
				String posicao = rs.getString(8);
				String serie = rs.getString(9);
				String senha = rs.getString(10);

				dados.add(new Docente(codID, nome, email, numero, curso, ano, modulo, posicao, serie, senha));
			}
			con.close();
			return dados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}




	public ArrayList<Nomes> docentes(String curso, String ano) {
		ArrayList<Nomes> contactos = new ArrayList<>();
		String read = "select facultyname,emailid,contactnumber,subject,position from docentes where courcecode ='"
				+ curso + "' and semoryear=" + ano + " order by facultyname";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String nome = rs.getString(1);
				String email = rs.getString(2);
				String contacto = rs.getString(3);
				String cadeira = rs.getString(4);
				String posicao = rs.getString(5);

				contactos.add(new Nomes(nome, email, contacto, cadeira, posicao));
			}
			con.close();
			return contactos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean contarDocentes(String curso, String ano) {
		boolean result = false;
		String read2 = "select count(*) from docentes where courcecode='" + curso + "' and semoryear=" + ano;

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			ResultSet rs = pst.executeQuery();
			rs.next();

			if (rs.getInt(1) > 0) {

				result = true;
			} else {

				result = false;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;

	}

	public ArrayList<Estudante> listaEstudantes(String curso, String ano) {
		ArrayList<Estudante> estudante = new ArrayList<>();
		String read = "select primeiroNome,ultimoNome,userid,emailid,Courcecode,semouano,numeroEstudante from estudantes where Courcecode ='"
				+ curso + "' and semouano=" + ano + " order by primeiroNome";
		
		System.out.print(curso + " " + ano);

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String nome = rs.getString(1) + " " + rs.getString(2);
				String codigo = rs.getString(3);
				String email = rs.getString(4);
				String cursoId = rs.getString(5);
				String anoId = rs.getString(6);
				String roll = rs.getString(7);

				estudante.add(new Estudante(nome, codigo, "", email, "", "", cursoId, roll, anoId, ""));
			}
			con.close();
			return estudante;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean contarEstudantes(String curso, String ano) {
		boolean result = false;
		String read2 = "select count(*) from estudantes where Courcecode='" + curso + "' and semouano=" + ano;

		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			ResultSet rs = pst.executeQuery();
			rs.next();

			if (rs.getInt(1) > 0) {

				result = true;
			} else {

				result = false;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;

	}

	public ArrayList<Notificacoes> notificacoes(String id) {
		ArrayList<Notificacoes> dados = new ArrayList<>();
		String read = "select title,message,time from notificacao where userid = '" + id + "' order by `sr_no` DESC ";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String titulo = rs.getString(1);
				String msg = rs.getString(2);
				String hora = rs.getString(3);

				dados.add(new Notificacoes(titulo, msg, hora));
			}
			con.close();
			return dados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean contarNotificacoes(String id) {
		boolean result = false;
		String read2 = "select count(*) from notificacao where userid = '" + id + "'";
		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {

				result = true;
			} else {

				result = false;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;

	}

	public ArrayList<Pautas> pautas(String roll) {
		ArrayList<Pautas> dados = new ArrayList<>();
		String read = "select semoryear,subjectcode,subjectname,theorymarks,practicalmarks from notas where rollnumber ="
				+ roll;

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String sem = rs.getString(1);
				String cod = rs.getString(2);
				String nome = rs.getString(3);
				String teo = rs.getString(4);
				String pra = rs.getString(5);

				dados.add(new Pautas(sem, cod, nome, teo, pra));
			}
			con.close();
			return dados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean contarPautas(String roll) {
		boolean result = false;
		String read2 = "select count(*) from notas where rollnumber =" + roll;
		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {

				result = true;
			} else {

				result = false;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;

	}

	public ArrayList<Modulos> modulos(String ano, String cursoId) {
		ArrayList<Modulos> dados = new ArrayList<>();
		String read = "select semoryear,subjectcode,subjectname,courcecode,subjecttype from disciplina where semoryear = "
				+ ano + " and courcecode ='" + cursoId+"'";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String semestre = rs.getString(1);
				String codigo = rs.getString(2);
				String nome = rs.getString(3);
				String curso = rs.getString(4);
				String tipo = rs.getString(5);

				dados.add(new Modulos(semestre, codigo, nome, curso, tipo));
			}
			con.close();
			
			
			return dados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public boolean contarModulos(String ano, String cursoId) {
		boolean result = false;
		String read2 = "select count(*) from disciplina where semoryear = " + ano + " and courcecode ='" + cursoId+"'";
		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {

				result = true;
			} else {

				result = false;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;

	}

	public ArrayList<Estudante> estudantePerfil(String id) {
		ArrayList<Estudante> dados = new ArrayList<>();
		String read = "select primeiroNome,ultimoNome,userid,cidade,provincia,emailid,dataNascimento,numeroTelefone,Courcecode,numeroEstudante,semouano,password from estudantes where userid= '"
				+ id + "'";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String nome = rs.getString(1) + " " + rs.getString(2);
				String codigo = rs.getString(3);
				String endereco = rs.getString(4) + "," + rs.getString(5);
				String email = rs.getString(6);
				String nascimento = rs.getString(7);
				String contacto = rs.getString(8);
				String curso = rs.getString(9);
				String roll = rs.getString(10);
				String ano = rs.getString(11);
				String senha = rs.getString(12);

				dados.add(new Estudante(nome, codigo, endereco, email, nascimento, contacto, curso, roll, ano, senha));
			}
			con.close();
			return dados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<Docente> docentePerfil(String id) {
		ArrayList<Docente> dados = new ArrayList<>();
		String read = "select facultyid,facultyname,emailid,contactnumber,courcecode,semoryear,subject,position,sr_no from docentes where facultyid='"
				+ id + "'";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String codID = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String numero = rs.getString(4);
				String curso = rs.getString(5);
				String ano = rs.getString(6);
				String modulo = rs.getString(7);
				String posicao = rs.getString(8);
				String serie = rs.getString(9);

				dados.add(new Docente(codID, nome, email, numero, curso, ano, modulo, posicao, serie, ""));
			}
			con.close();
			return dados;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}



	public String verificarUsuario(String id, String senha) {
		String resultado = "nulo";

//		========================================================================================================================
		String estudante = "select count(*) from estudantes where userid='" + id + "' and password='" + senha + "'";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(estudante);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {

				resultado = "estudante";
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

//		========================================================================================================================
		String docente = "select count(*) from docentes where facultyid='" + id + "' and password='" + senha + "'";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(docente);
			ResultSet rs = pst.executeQuery();
			rs.next();
			if (rs.getInt(1) > 0) {

				resultado = "docente";
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
//		========================================================================================================================
		return resultado;

	}

	public void alterarNotas(String id, String teste1, String teste2, String modulo) {
		String create = "update notas set theorymarks=" + teste1 + ", practicalmarks=" + teste2 + " where rollnumber="
				+ id +" and subjectname='"+modulo+"'";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String verNotas(String id, String teste, String modulo) {
		String read = "select " + teste + " from notas where rollnumber="+id+" and subjectname='"+ modulo+"'";

		String nota = "";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				nota = rs.getString(1);
			}

//			System.out.print(read);

			con.close();
			return nota;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	

	public String recuperarSenha(String id) {
		String read = "select password from estudantes where userid='"+id+"'";

		

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

		String senha = "";
			
		while (rs.next()) {
			senha = rs.getString(1);
		}

			con.close();
			return senha;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	public String recuperarSenhaEmail(String id) {
		String read = "select emailid from estudantes where userid='"+id+"'";

		

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

		String email = "";
			
		while (rs.next()) {
			email = rs.getString(1);
		}

			con.close();
			return email;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	

}
