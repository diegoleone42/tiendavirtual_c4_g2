package co.edu.unbosque.tiendavirtual1_front.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.unbosque.tiendavirtual1_front.model.Usuarios;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Bean
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
		String ingresar = request.getParameter("Ingresar");
		String crear = request.getParameter("Crear");
		String consultar = request.getParameter("Consultar");
		String actualizar = request.getParameter("Actualizar");
		String borrar = request.getParameter("Borrar");
		String usuario = request.getParameter("usuarioreg");
		
		if(usuario != null) {
			String usuariotxt = (String) request.getParameter("usuarioreg");
			request.setAttribute("usuarioreg", usuariotxt);
		}
		
		if(ingresar != null) {
			login(request, response);
		}
		if(crear != null) {
			crear(request,response);
		}
		if(consultar != null) {
			consultar(request,response);
		}
		if(actualizar != null) {
			actualizar(request,response);
		}
		if(borrar != null) {
			borrar(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuarios usuarios = new Usuarios();
		usuarios.setUsuario(request.getParameter("usuario"));
		usuarios.setPassword(request.getParameter("password"));
		if(usuarios.getUsuario().equals("admininicial") && usuarios.getPassword().equals("admin123456")) {
			String estado = "true";
			request.setAttribute("estado", estado);			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			try {
				String respuesta = UsuarioTestJSON.postJSON1(usuarios);
				request.setAttribute("estado", respuesta);
				Usuarios usuarioreg = (Usuarios) UsuarioTestJSON.postJSON2(usuarios);
				request.setAttribute("usuarioreg",usuarioreg.toString());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "usuarios");
		if (request.getParameter("cedula") == "" || 
			request.getParameter("nombre") == "" ||
			request.getParameter("email") == "" ||
			request.getParameter("usuario") == "" ||
			request.getParameter("password") == "") {
			request.setAttribute("status_crear", "empty");
			request.setAttribute("estado", "true");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			Usuarios usuarios = new Usuarios();
			usuarios.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
			usuarios.setNombre_usuario(request.getParameter("nombre"));
			usuarios.setEmail_usuario(request.getParameter("email"));
			usuarios.setUsuario(request.getParameter("usuario"));
			usuarios.setPassword(request.getParameter("password"));
			try {
				int respuesta = UsuarioTestJSON.postJSON(usuarios);
				if (respuesta==200) {
						request.setAttribute("estado", "true");
						request.setAttribute("status_crear", "true");
						request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
						request.setAttribute("estado", "true");
						request.setAttribute("status_crear", "false");
						request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "usuarios");
		long cedula = 0;
		try {
			cedula =  Long.parseLong(request.getParameter("cedula"));
			Usuarios respuesta = new Usuarios();	
			try {
				respuesta = (Usuarios) UsuarioTestJSON.getJSON1(cedula);
				long id = respuesta.getCedula_usuario();
				if (id != 0) {
						request.setAttribute("estado", "true");
						request.setAttribute("status_consultar", "true");
						request.setAttribute("cedula", id);
						request.setAttribute("nombre", respuesta.getNombre_usuario());
						request.setAttribute("email", respuesta.getEmail_usuario());
						request.setAttribute("usuario", respuesta.getUsuario());
						request.setAttribute("password", respuesta.getPassword());
						request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			catch (Exception e) {
				request.setAttribute("estado", "true");
				request.setAttribute("status_consultar", "empty");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}catch(Exception e) {
			cedula = 0;
			request.setAttribute("estado", "true");
			request.setAttribute("status_consultar", "empty_id");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	public void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "usuarios");
		if (request.getParameter("cedula") == "" || 
			request.getParameter("nombre") == "" ||
			request.getParameter("email") == "" ||
			request.getParameter("usuario") == "" ||
			request.getParameter("password") == "") {
			request.setAttribute("status_actualizar", "empty");
			request.setAttribute("estado", "true");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			Usuarios usuarios = new Usuarios();
			usuarios.setCedula_usuario(Long.parseLong(request.getParameter("cedula")));
			usuarios.setNombre_usuario(request.getParameter("nombre"));
			usuarios.setEmail_usuario(request.getParameter("email"));
			usuarios.setUsuario(request.getParameter("usuario"));
			usuarios.setPassword(request.getParameter("password"));
			try {
				int respuesta = UsuarioTestJSON.postJSON(usuarios);
				if (respuesta==200) {
						request.setAttribute("estado", "true");
						request.setAttribute("status_actualizar", "true");
						request.getRequestDispatcher("index.jsp").forward(request, response);
				}else {
						request.setAttribute("estado", "true");
						request.setAttribute("status_actualizar", "false");
						request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void borrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "usuarios");
		long cedula = 0;
		try {
			cedula =  Long.parseLong(request.getParameter("cedula"));
			int respuesta = UsuarioTestJSON.getJSON2(cedula);
			if (respuesta == 200) {
				request.setAttribute("estado", "true");
				request.setAttribute("status_borrar", "true");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else {
				request.setAttribute("estado", "true");
				request.setAttribute("status_borrar", "false");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}catch(Exception e) {
			cedula = 0;
			request.setAttribute("estado", "true");
			request.setAttribute("status_consultar", "empty");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}
