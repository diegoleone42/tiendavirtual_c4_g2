package co.edu.unbosque.tiendavirtual1_front.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;

import co.edu.unbosque.tiendavirtual1_front.model.Proveedores;


@WebServlet("/ProveedorServlet")
public class ProveedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ProveedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Bean
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String crear = request.getParameter("Crear");
		String consultar = request.getParameter("Consultar");
		String actualizar = request.getParameter("Actualizar");
		String borrar = request.getParameter("Borrar");
		String usuario = request.getParameter("usuarioreg");
		
		if(usuario != null) {
			String usuariotxt = (String) request.getParameter("usuarioreg");
			request.setAttribute("usuarioreg", usuariotxt);
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

	public void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setAttribute("status_form", "proveedores");
	if(request.getParameter("NIT") == "" ||
	   request.getParameter("nombre_proveedor") == "" ||
	   request.getParameter("direccion") == "" ||
	   request.getParameter("ciudad") == "" ||
	   request.getParameter("telefono") == "") {
	   request.setAttribute("status_crear", "empty");
	   request.setAttribute("estado", "true");
	   request.getRequestDispatcher("index.jsp").forward(request, response);	
		}else {
			Proveedores proveedores = new Proveedores();
			proveedores.setNit_proveedor(Long.parseLong(request.getParameter(("NIT"))));
			proveedores.setNombre_proveedor(request.getParameter("nombre_proveedor"));
			proveedores.setDireccion_proveedor(request.getParameter("direccion"));
			proveedores.setCiudad(request.getParameter("ciudad"));
			proveedores.setTelefono_proveedor(Long.parseLong(request.getParameter("telefono")));
			try {
				int respuesta = TestJSONproveedores.postJSON(proveedores);
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
		request.setAttribute("status_form", "proveedores");
		long NIT = 0;
		try {
			NIT = Long.parseLong(request.getParameter("NIT"));
			Proveedores respuesta = new Proveedores();
			try {
				respuesta = (Proveedores) TestJSONproveedores.getJSON1(NIT);
				long id = respuesta.getNit_proveedor();
				if(id !=0) {
					request.setAttribute("estado", "true");
					request.setAttribute("status_consultar", "true");
					request.setAttribute("NIT", id);
					request.setAttribute("telefono", respuesta.getTelefono_proveedor());
					request.setAttribute("nombre", respuesta.getNombre_proveedor());
					request.setAttribute("ciudad", respuesta.getCiudad());
					request.setAttribute("direccion", respuesta.getDireccion_proveedor());
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			catch (Exception e) {
				request.setAttribute("estado", "true");
				request.setAttribute("status_consultar", "empty");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}catch(Exception e) {
			NIT = 0;
			request.setAttribute("estado", "true");
			request.setAttribute("status_consultar", "empty_id");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	public void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "proveedores");
		if(request.getParameter("NIT") == "" ||
				   request.getParameter("nombre_proveedor") == "" ||
				   request.getParameter("direccion") == "" ||
				   request.getParameter("ciudad") == "" ||
				   request.getParameter("telefono") == "") {
				   request.setAttribute("status_actualizar", "empty");
				   request.setAttribute("estado", "true");
				   request.getRequestDispatcher("index.jsp").forward(request, response);	
					}else {
						Proveedores proveedores = new Proveedores();
						proveedores.setNit_proveedor(Long.parseLong(request.getParameter(("NIT"))));
						proveedores.setNombre_proveedor(request.getParameter("nombre_proveedor"));
						proveedores.setDireccion_proveedor(request.getParameter("direccion"));
						proveedores.setCiudad(request.getParameter("ciudad"));
						proveedores.setTelefono_proveedor(Long.parseLong(request.getParameter("telefono")));
						try {
							int respuesta = TestJSONproveedores.postJSON(proveedores);
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
		request.setAttribute("status_form", "proveedores");
		long NIT = 0;
		try {
			NIT = Long.parseLong(request.getParameter("NIT"));
			int respuesta = TestJSONproveedores.getJSON2(NIT);
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
			NIT = 0;
			request.setAttribute("estado", "true");
			request.setAttribute("status_consultar", "empty");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}


