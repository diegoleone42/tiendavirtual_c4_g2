package co.edu.unbosque.tiendavirtual1_front.servlets;

import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import co.edu.unbosque.tiendavirtual1_front.CSVHelper;
import co.edu.unbosque.tiendavirtual1_front.model.Productos;
import co.edu.unbosque.tiendavirtual1_front.model.Proveedores;
import co.edu.unbosque.tiendavirtual1_front.model.Usuarios;

@MultipartConfig
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Bean
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
		String enviardatos = request.getParameter("Enviardatos");
		String usuario = request.getParameter("usuarioreg");
		
		if(usuario != null) {
			String usuariotxt = (String) request.getParameter("usuarioreg");
			request.setAttribute("usuarioreg", usuariotxt);
		}
		
		if (enviardatos != null) {
			enviardatos(request,response);
			
		}	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	public void enviardatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("estado", "true");
		request.setAttribute("status_form", "producto");
		
		try {
			Part csv = request.getPart("archivoProductos");
			DataInputStream input = new DataInputStream(csv.getInputStream());
			ArrayList<String[]> lista = CSVHelper.csvToTutorials(input);
			if (lista.size()!=0) {
				try {
					for (int i=1;i<lista.size();i++) {
						String linea = Arrays.toString(lista.get(i));
						linea = linea.replaceAll("\\]","");
						linea = linea.replaceAll("\\[","");
						List<String> elem = Arrays.asList(linea.split(";"));
						Productos producto = new Productos();
							producto.setCodigo_producto(Long.parseLong(elem.get(0)));
							producto.setNombre_producto(elem.get(1));
							Long nit = Long.parseLong(elem.get(2));
							Proveedores prove = new Proveedores();
							prove.setNit_proveedor(nit);
							producto.setProveedor(prove);
							producto.setPrecio_compra(Long.parseLong(elem.get(3)));
							producto.setIva_compra(Long.parseLong(elem.get(4)));
							producto.setPrecio_venta(Long.parseLong(elem.get(5)));
							int respuesta = TestJSONproductos.postJSON(producto);
							if (respuesta==200) {
								request.setAttribute("status_load", "true");
							}else {
								request.setAttribute("status_load", "error");
							}
						}
				}catch(Exception e) {
						request.setAttribute("status_load", "error");
					}
			}else {
				request.setAttribute("status_load", "empty");
			}
		}
		catch(Exception e){
			e.printStackTrace();
			request.setAttribute("status_load", "false");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
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
