package controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.Docente;
import model.Email;
import model.Estudante;
import model.Modulos;
import model.Nomes;
import model.Notificacoes;
import model.Pautas;
import model.Usuario;

@WebServlet(urlPatterns = { "/docentes", "/perfil", "/notificacoes", "/pautas", "/modulos", "/login", "/entrar",
		"/menu", "/alterarSenha", "/paginaSenha", "/recuperarSenha", "/listaEstudantes", "/docenteModulos",
		"/docenteNotificacoes", "/docentePerfil", "/docentePauta", "/alterarNotas", "/docenteMenu", "/acessarPerfil",
		"/enviarNovaSenha" })
public class Controler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String emailUsuario;
	private static String senha;


	public static String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		Controler.emailUsuario = emailUsuario;
	}
	
	public static String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		Controler.senha = senha;
	}


	DAO dao = new DAO();

	Estudante estudante = new Estudante();

	Estudante user = new Estudante();

	Notificacoes notificacoes = new Notificacoes();

	Pautas pautas = new Pautas();

	Modulos modulos = new Modulos();

	Usuario usuario = new Usuario();

	Docente docente = new Docente();

	public Controler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		if (action.equals("/entrar")) {
			entrar(request, response);
		} else if (action.equals("/perfil")) {
			estudantePerfil(request, response);
		} else if (action.equals("/docentes")) {
			docentes(request, response);
		} else if (action.equals("/notificacoes")) {
			notificacoes(request, response);
		} else if (action.equals("/pautas")) {
			pautas(request, response);
		} else if (action.equals("/modulos")) {
			modulos(request, response);
		} else if (action.equals("/login")) {
			response.sendRedirect("login.jsp");
		} else if (action.equals("/menu")) {
			menu(request, response);
		} else if (action.equals("/alterarSenha")) {
			alterarSenha(request, response);
		} else if (action.equals("/paginaSenha")) {
			response.sendRedirect("alterarSenha.jsp");
		} else if (action.equals("/recuperarSenha")) {
			response.sendRedirect("recuperarSenha.jsp");
		} else if (action.equals("/listaEstudantes")) {
			listaEstudantes(request, response);
		} else if (action.equals("/docenteModulos")) {
			docenteModulos(request, response);
		} else if (action.equals("/docenteNotificacoes")) {
			docenteNotificacoes(request, response);
		} else if (action.equals("/docentePerfil")) {
			docentePerfil(request, response);
		} else if (action.equals("/docentePauta")) {
			listarNotas(request, response);
		} else if (action.equals("/alterarNotas")) {
			alterarNotas(request, response);
		} else if (action.equals("/docenteMenu")) {
			docenteMenu(request, response);
		} else if (action.equals("/acessarPerfil")) {
			acessarPerfil(request, response);
		} else if (action.equals("/enviarNovaSenha")) {
			response.sendRedirect("login.jsp");
			enviarNovaSenha(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	protected void enviarNovaSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String senha = dao.recuperarSenha(request.getParameter("id"));
		String email = dao.recuperarSenhaEmail(request.getParameter("id"));
		
		setSenha(senha);
		setEmailUsuario(email);
		System.out.print("PRONTO PARA MANDAR EMAIL '" + senha + "' PARA " + email);
		Email.main(null); 

	}

	protected void listarNotas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("nome", request.getParameter("nome"));
		request.setAttribute("teste1", request.getParameter("teste1"));
		request.setAttribute("teste2", request.getParameter("teste2"));

		RequestDispatcher rd = request.getRequestDispatcher("docentePauta.jsp");
		rd.forward(request, response);
	}

	protected void alterarSenha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String atual = request.getParameter("atual");
		String nova = request.getParameter("nova");

		int resultado = dao.alterarSenha(estudante.getCodigo(), nova, atual);

		request.setAttribute("resultadoSenha", resultado);

		String caminho = "alterarSenha.jsp";

		RequestDispatcher rd = request.getRequestDispatcher(caminho);
		rd.forward(request, response);
	}

	protected void entrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String resultado = dao.verificarUsuario(request.getParameter("id"), request.getParameter("senha"));
		usuario.setTipo(resultado);

		if (resultado.equals("estudante")) {

			ArrayList<Estudante> lista = dao.criarUsuario(request.getParameter("id"));

			estudante.setNome(lista.get(0).getNome());
			estudante.setCodigo(lista.get(0).getCodigo());
			estudante.setContacto(lista.get(0).getContacto());
			estudante.setCurso(lista.get(0).getCurso());
			estudante.setEmail(lista.get(0).getEmail());
			estudante.setEndereco(lista.get(0).getEndereco());
			estudante.setNascimento(lista.get(0).getNascimento());
			estudante.setRoll(lista.get(0).getRoll());
			estudante.setAno(lista.get(0).getAno());
			estudante.setSenha(lista.get(0).getSenha());

			request.setAttribute("user", estudante.getNome());
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);

		} else if (resultado.equals("docente")) {

			ArrayList<Docente> lista = dao.criarDocente(request.getParameter("id"));

			docente.setAno(lista.get(0).getAno());
			docente.setCurso(lista.get(0).getCurso());
			docente.setEmail(lista.get(0).getEmail());
			docente.setId(lista.get(0).getId());
			docente.setModulo(lista.get(0).getModulo());
			docente.setNome(lista.get(0).getNome());
			docente.setNumero(lista.get(0).getNumero());
			docente.setPosicao(lista.get(0).getPosicao());
			docente.setSenha(lista.get(0).getSenha());

			request.setAttribute("user", docente.getNome());
			RequestDispatcher rd = request.getRequestDispatcher("docenteMenu.jsp");
			rd.forward(request, response);

		} else if (resultado.equals("nulo")) {
			request.setAttribute("erro", "Usuário ou senha inválidos!");

			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

	protected void alterarNotas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		dao.alterarNotas(request.getParameter("id"), request.getParameter("teste1"), request.getParameter("teste2"),
				docente.getModulo());

		response.sendRedirect("listaEstudantes");
	}

	protected void acessarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (usuario.getTipo().equals("estudante")) {

			request.setAttribute("user", estudante.getNome());
			RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			rd.forward(request, response);

		} else if (usuario.getTipo().equals("docente")) {

			request.setAttribute("user", docente.getNome());
			RequestDispatcher rd = request.getRequestDispatcher("docenteMenu.jsp");
			rd.forward(request, response);

		}

	}

	protected void menu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("user", estudante.getNome());
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);
	}

	protected void docenteMenu(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("user", docente.getNome());
		RequestDispatcher rd = request.getRequestDispatcher("docenteMenu.jsp");
		rd.forward(request, response);
	}

	protected void docentes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean disponiveis = dao.contarDocentes(estudante.getCurso(), estudante.getAno());
		ArrayList<Nomes> lista = dao.docentes(estudante.getCurso(), estudante.getAno());

		request.setAttribute("conta", lista);
		request.setAttribute("user", estudante.getNome());
		request.setAttribute("disponivel", disponiveis);
		RequestDispatcher rd = request.getRequestDispatcher("listaDocentes.jsp");
		rd.forward(request, response);
	}

	protected void listaEstudantes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean disponiveis = dao.contarEstudantes(docente.getCurso(), docente.getAno());
		ArrayList<Estudante> lista = dao.listaEstudantes(docente.getCurso(), docente.getAno());

		for (int i = 0; i < lista.size(); i++) {
			String roll = lista.get(i).getRoll();
			String nota1 = dao.verNotas(roll, "theorymarks", docente.getModulo());
			String nota2 = dao.verNotas(roll, "practicalmarks", docente.getModulo());

			request.setAttribute("nota1(" + i + ")", nota1);
			request.setAttribute("nota2(" + i + ")", nota2);
		}

//		System.out.print(lista.get(0).getRoll());

		request.setAttribute("conta", lista);

		request.setAttribute("user", docente.getNome());
		request.setAttribute("disponivel", disponiveis);

		RequestDispatcher rd = request.getRequestDispatcher("listaEstudantes.jsp");
		rd.forward(request, response);
	}

	protected void notificacoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Notificacoes> lista = dao.notificacoes(estudante.getCodigo());
		boolean disponiveis = dao.contarNotificacoes(estudante.getCodigo());

		request.setAttribute("conta", lista);
		request.setAttribute("user", estudante.getNome());
		request.setAttribute("disponivel", disponiveis);
		RequestDispatcher rd = request.getRequestDispatcher("notificacoes.jsp");
		rd.forward(request, response);
	}

	protected void docenteNotificacoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Notificacoes> lista = dao.notificacoes(docente.getId());
		boolean disponiveis = dao.contarNotificacoes(docente.getId());

		request.setAttribute("conta", lista);
		request.setAttribute("user", docente.getNome());
		request.setAttribute("disponivel", disponiveis);
		RequestDispatcher rd = request.getRequestDispatcher("docenteNotificacoes.jsp");
		rd.forward(request, response);
	}

	protected void pautas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean disponiveis = dao.contarPautas(estudante.getRoll());
		ArrayList<Pautas> lista = dao.pautas(estudante.getRoll());

		request.setAttribute("conta", lista);
		request.setAttribute("user", estudante.getNome());
		request.setAttribute("disponivel", disponiveis);
		RequestDispatcher rd = request.getRequestDispatcher("pautas.jsp");
		rd.forward(request, response);
	}

	protected void modulos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Modulos> lista = dao.modulos(estudante.getAno(), estudante.getCurso());
		boolean disponiveis = dao.contarModulos(estudante.getAno(), estudante.getCurso());

		request.setAttribute("modulos", lista);
		request.setAttribute("user", estudante.getNome());
		request.setAttribute("disponivel", disponiveis);
		RequestDispatcher rd = request.getRequestDispatcher("modulos.jsp");
		rd.forward(request, response);
	}

	protected void docenteModulos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Modulos> lista = dao.modulos(docente.getAno(), docente.getCurso());
		boolean disponiveis = dao.contarModulos(docente.getAno(), docente.getCurso());

		request.setAttribute("modulos", lista);
		request.setAttribute("user", docente.getNome());
		request.setAttribute("meuModulo", docente.getModulo());
		request.setAttribute("disponivel", disponiveis);
		RequestDispatcher rd = request.getRequestDispatcher("docenteModulos.jsp");
		rd.forward(request, response);
	}

	protected void estudantePerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Estudante> lista = dao.estudantePerfil(estudante.getCodigo());

		request.setAttribute("conta", lista);
		request.setAttribute("user", estudante.getNome());
		RequestDispatcher rd = request.getRequestDispatcher("estudantePerfil.jsp");
		rd.forward(request, response);
	}

	protected void docentePerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Docente> lista = dao.docentePerfil(docente.getId());

		request.setAttribute("conta", lista);
		request.setAttribute("user", docente.getNome());
		RequestDispatcher rd = request.getRequestDispatcher("docentePerfil.jsp");
		rd.forward(request, response);
	}

}
