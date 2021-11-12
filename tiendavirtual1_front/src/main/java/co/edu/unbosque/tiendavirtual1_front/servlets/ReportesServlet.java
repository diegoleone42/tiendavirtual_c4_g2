package co.edu.unbosque.tiendavirtual1_front.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Bean;

import co.edu.unbosque.tiendavirtual1_front.model.Clientes;
import co.edu.unbosque.tiendavirtual1_front.model.Reporte;
import co.edu.unbosque.tiendavirtual1_front.model.Usuarios;

@WebServlet("/ReportesServlet")
public class ReportesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Bean
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
		String listarusuarios = request.getParameter("ListarUsuarios");
		String listarclientes = request.getParameter("ListarClientes");
		String ventasCliente = request.getParameter("VentasCliente");
		
		String usuario = request.getParameter("usuarioreg");
		
		if(usuario != null) {
			String usuariotxt = (String) request.getParameter("usuarioreg");
			request.setAttribute("usuarioreg", usuariotxt);
		}
		
		if (listarusuarios != null) {
			try {
				listarusuarios(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(listarclientes != null) {
			try {
				listarclientes(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(ventasCliente != null) {
			try {
				VentasCliente(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	public void listarusuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		request.setAttribute("status_form", "reportes");
		request.setAttribute("estado", "true");
		ArrayList<Usuarios> listausuarios = new ArrayList<Usuarios>();
		listausuarios = UsuarioTestJSON.getJSON();
		request.setAttribute("listausuarios", listausuarios);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	public void listarclientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		request.setAttribute("status_form", "reportes");
		request.setAttribute("estado", "true");
		ArrayList<Clientes> listaclientes = new ArrayList<Clientes>();
		listaclientes = TestJSONclientes.getJSON();
		request.setAttribute("listaclientes", listaclientes);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	public void VentasCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		request.setAttribute("status_form", "reportes");
		request.setAttribute("estado", "true");
		ArrayList<Reporte> reporte = new ArrayList<Reporte>();
		reporte = TestJSONclientes.getJSON3();
		request.setAttribute("reporte", reporte);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
}

