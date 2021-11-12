package co.edu.unbosque.tiendavirtual1_front.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.Bean;

import co.edu.unbosque.tiendavirtual1_front.model.Clientes;
import co.edu.unbosque.tiendavirtual1_front.model.Detalleventas;
import co.edu.unbosque.tiendavirtual1_front.model.Productos;
import co.edu.unbosque.tiendavirtual1_front.model.Proveedores;
import co.edu.unbosque.tiendavirtual1_front.model.Usuarios;
import co.edu.unbosque.tiendavirtual1_front.model.Ventas;

@WebServlet("/VentasServlet")
public class VentasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public VentasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Bean
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;	
		request.setAttribute("status_form", "ventas");
		request.setAttribute("estado", "true");
		String consultacliente = request.getParameter("consultaCliente");
		String consultaproducto1 = request.getParameter("consultaProducto1");
		String consultaproducto2 = request.getParameter("consultaProducto2");
		String consultaproducto3 = request.getParameter("consultaProducto3");
		String calcular = request.getParameter("Calcular");
		String confirmar = request.getParameter("Confirmar");
		String usuario = request.getParameter("usuarioreg");
		String consecutivo = request.getParameter("consecutivo");
		
		request.setAttribute("consecutivo", consecutivo);
		
		Usuarios usuario1 = new Usuarios();		
		if(usuario != null) {
			String usuariotxt = (String) request.getParameter("usuarioreg");
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonu;
			try {
				jsonu = (JSONObject) jsonParser.parse(usuariotxt);
				usuario1.setCedula_usuario((long) jsonu.get("cedula_usuario"));
				usuario1.setUsuario((String) jsonu.get("usuario"));
				request.setAttribute("usuarioreg", usuariotxt);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		Productos producto1 = new Productos();
		Productos producto2 = new Productos();
		Productos producto3 = new Productos();
		
		String cliente2 = request.getParameter("cliente");
		Clientes cliente = new Clientes();
		
		if (cliente2!="") {
			String clientetxt = request.getParameter("cliente");
			JSONParser jsonParser = new JSONParser();
			try {
				JSONObject json = (JSONObject) jsonParser.parse(clientetxt);
				cliente.setCedula_cliente((long) json.get("cedula_cliente"));
				cliente.setNombre_cliente((String) json.get("nombre_cliente"));
				request.setAttribute("cliente", cliente.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String productoget1 = request.getParameter("producto1");
		if (productoget1!="") {
			String productotxt = request.getParameter("producto1");
			JSONParser jsonParser = new JSONParser();
			try {
				JSONObject json = (JSONObject) jsonParser.parse(productotxt);
				producto1.setCodigo_producto((long) json.get("codigo_producto"));
				producto1.setNombre_producto((String) json.get("nombre_producto"));
				producto1.setPrecio_venta((long) json.get("precio_venta"));
				Proveedores proveedor = new Proveedores();
				producto1.setProveedor(proveedor);
				producto1.setIva_compra((long) json.get("iva_compra"));
				request.setAttribute("producto1", producto1.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String productoget2 = request.getParameter("producto2");
		if (productoget2!="") {
			String producto2txt = request.getParameter("producto2");
			JSONParser jsonParser = new JSONParser();
			try {
				JSONObject json2 = (JSONObject) jsonParser.parse(producto2txt);
				producto2.setCodigo_producto((long) json2.get("codigo_producto"));
				producto2.setNombre_producto((String) json2.get("nombre_producto"));
				producto2.setPrecio_venta((long) json2.get("precio_venta"));
				Proveedores proveedor = new Proveedores();
				producto2.setProveedor(proveedor);
				producto2.setIva_compra((long) json2.get("iva_compra"));
				request.setAttribute("producto2", producto2.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String productoget3 = request.getParameter("producto3");
		if (productoget3!="") {
			String producto3txt = request.getParameter("producto3");
			JSONParser jsonParser = new JSONParser();
			try {
				JSONObject json3 = (JSONObject) jsonParser.parse(producto3txt);
				producto3.setCodigo_producto((long) json3.get("codigo_producto"));
				producto3.setNombre_producto((String) json3.get("nombre_producto"));
				producto3.setPrecio_venta((long) json3.get("precio_venta"));
				Proveedores proveedor = new Proveedores();
				producto3.setProveedor(proveedor);
				producto3.setIva_compra((long) json3.get("iva_compra"));
				request.setAttribute("producto3", producto3.toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		float totalventa = 0;
		float totaliva = 0;
		
		if (producto1.getCodigo_producto()>0) {
			String cantidad1 = request.getParameter("cantidad1");
			if (cantidad1 !="") {
				long valor1 = (Long.parseLong(request.getParameter("cantidad1")))*(producto1.getPrecio_venta());
				request.setAttribute("cantidad1", cantidad1);
				request.setAttribute("valor1",valor1);
				
				totaliva = totaliva + (producto1.getIva_compra()*valor1)/100;
				totalventa = totalventa+valor1;
			}
		}
		else {
			request.setAttribute("cantidad1", 0);
			request.setAttribute("valor1", 0);
		}
		
		if (producto2.getCodigo_producto()>0) {
			String cantidad2 = request.getParameter("cantidad2");
			if (cantidad2 !="") {
				long valor2 = (Long.parseLong(request.getParameter("cantidad2")))*(producto2.getPrecio_venta());
				request.setAttribute("cantidad2", cantidad2);
				request.setAttribute("valor2",valor2 );
				totaliva = totaliva + (producto2.getIva_compra()*valor2)/100;
				totalventa = totalventa+valor2;
			}
		}
		else {
			request.setAttribute("cantidad2", 0);
			request.setAttribute("valor2", 0);
		}
		
		if (producto3.getCodigo_producto()>0) {
			String cantidad3 = request.getParameter("cantidad3");
			if (cantidad3 !="") {
				long valor3 = (Long.parseLong(request.getParameter("cantidad3")))*(producto3.getPrecio_venta());
				request.setAttribute("cantidad3", cantidad3);
				request.setAttribute("valor3",valor3);
				totaliva = totaliva + (producto3.getIva_compra()*valor3)/100;
				totalventa = totalventa+valor3;
			}
		}
		else {
			request.setAttribute("cantidad3", 0);
			request.setAttribute("valor3", 0);
			request.setAttribute("iva", 0);
		}
		
		int totaliva1 = (int)(Math.round(totaliva));
		int totalventa1 = (int)(Math.round(totalventa));
		request.setAttribute("valortotal", totalventa1);
		request.setAttribute("iva", totaliva1);
		request.setAttribute("total", totalventa1+totaliva1);
		
		if (consultacliente != null) {
			consultarcliente(request,response);
		}
		else if(consultaproducto1 != null) {
			consultaproducto1(request,response);			
		}
		else if(consultaproducto2 != null) {
			consultaproducto2(request,response);			
		}
		else if(consultaproducto3 != null) {
			consultaproducto3(request,response);			
		}
		else if(calcular != null) {
			calcular(request,response);
		}
		else if(confirmar != null) {
			
			Ventas venta = new Ventas();
			venta.setCliente(cliente);
			venta.setUsuario(usuario1);
			venta.setIvaventa(totaliva1);
			venta.setTotal_venta(totalventa1);
			venta.setValor_venta(totalventa1+totaliva1);
			try {
				long codventa = VentasTestJSON.getJSON3(venta);
				venta.setCodigoventa(codventa);
				request.setAttribute("consecutivo", codventa);

			} catch (Exception e) {
				e.printStackTrace();
			}
			/* AQUI SE REGISTRA LA VENTA*/
			
			
			Detalleventas detalle1 = new Detalleventas();
			Detalleventas detalle2 = new Detalleventas();
			Detalleventas detalle3 = new Detalleventas();
			
			if(producto1.getCodigo_producto()>0) {
				detalle1.setProducto(producto1);
				int cantidad = Integer.parseInt(request.getParameter("cantidad1"));
				detalle1.setCantidad_producto(cantidad);
				detalle1.setProducto(producto1);
				detalle1.setVenta1(venta);
				long valortotal = cantidad*producto1.getPrecio_venta();
				float valoriva = (valortotal*producto1.getIva_compra())/100;
				int valoriva1 = (int)(Math.round(valoriva));
				detalle1.setValor_total(valortotal);
				detalle1.setValoriva(valoriva1);
				detalle1.setValor_venta(valortotal+valoriva1);
				try {
					int respuesta = VentasTestJSON.getJSON4(detalle1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(producto2.getCodigo_producto()>0) {
				detalle2.setProducto(producto2);
				int cantidad = Integer.parseInt(request.getParameter("cantidad2"));
				detalle2.setCantidad_producto(cantidad);
				detalle2.setProducto(producto2);
				detalle2.setVenta1(venta);
				long valortotal = cantidad*producto2.getPrecio_venta();
				float valoriva = (valortotal*producto2.getIva_compra())/100;
				int valoriva1 = (int)(Math.round(valoriva));
				detalle2.setValor_total(valortotal);
				detalle2.setValoriva(valoriva1);
				detalle2.setValor_venta(valortotal+valoriva1);
				try {
					int respuesta = VentasTestJSON.getJSON4(detalle2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			if(producto3.getCodigo_producto()>0) {
				detalle3.setProducto(producto3);
				int cantidad = Integer.parseInt(request.getParameter("cantidad3"));
				detalle3.setCantidad_producto(cantidad);
				detalle3.setProducto(producto3);
				detalle3.setVenta1(venta);
				long valortotal = cantidad*producto3.getPrecio_venta();
				float valoriva = (valortotal*producto3.getIva_compra())/100;
				int valoriva1 = (int)(Math.round(valoriva));
				detalle3.setValor_total(valortotal);
				detalle3.setValoriva(valoriva1);
				detalle3.setValor_venta(valortotal+valoriva1);
				try {
					int respuesta = VentasTestJSON.getJSON4(detalle3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void consultarcliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "ventas");
		long cedula = 0;
		try {
			cedula =  Long.parseLong(request.getParameter("cedula"));
			Clientes cliente = new Clientes();	
			try {
				cliente = (Clientes) VentasTestJSON.getJSON1(cedula);
				long id = cliente.getCedula_cliente();
				if (id != 0) {
					request.setAttribute("estado", "true");
					request.setAttribute("status_consultarcliente", "true");
					String cliente1 = cliente.toString();
					
					request.setAttribute("cliente", cliente1);
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			catch (Exception e) {
				request.setAttribute("estado", "true");
				request.setAttribute("status_consultarcliente", "empty");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}catch(Exception e) {
			cedula = 0;
			request.setAttribute("estado", "true");
			request.setAttribute("status_consultarcliente", "empty_id");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	public void consultaproducto1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "ventas");
		request.setAttribute("estado", "true");
		try {
			long codigo_pro = Long.parseLong(request.getParameter("codigo1"));
			Productos producto = new Productos();
			try {
				producto = (Productos) VentasTestJSON.getJSON2(codigo_pro);
				long id = producto.getCodigo_producto();
				if (id != 0) {
					request.setAttribute("producto1", producto.toString());
					request.setAttribute("status_consultarpro1", "true");
				}else {
					request.setAttribute("status_consultarpro1", "empty");
				}
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("status_consultarpro1", "empty");
			}
			
		}catch(Exception e){
			request.setAttribute("status_consultarpro1", "empty_id");
			
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	public void consultaproducto2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "ventas");
		request.setAttribute("estado", "true");

		try {
			long codigo_pro = Long.parseLong(request.getParameter("codigo2"));
			Productos producto = new Productos();
			try {
				producto = (Productos) VentasTestJSON.getJSON2(codigo_pro);
				long id = producto.getCodigo_producto();
				if (id != 0) {
					request.setAttribute("producto2", producto.toString());
					request.setAttribute("status_consultarpro1", "true");
				}else {
					request.setAttribute("status_consultarpro1", "empty");
				}
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("status_consultarpro1", "empty");
			}
			
		}catch(Exception e){
			request.setAttribute("status_consultarpro1", "empty_id");
			
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	public void consultaproducto3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "ventas");
		request.setAttribute("estado", "true");
	
		try {
			long codigo_pro = Long.parseLong(request.getParameter("codigo3"));
			Productos producto = new Productos();
			try {
				producto = (Productos) VentasTestJSON.getJSON2(codigo_pro);
				long id = producto.getCodigo_producto();
				if (id != 0) {
					request.setAttribute("producto3", producto.toString());
					request.setAttribute("status_consultarpro1", "true");
				}else {
					request.setAttribute("status_consultarpro1", "empty");
				}
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("status_consultarpro1", "empty");
			}
			
		}catch(Exception e){
			request.setAttribute("status_consultarpro1", "empty_id");
			
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	protected void calcular(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("status_form", "ventas");
		request.setAttribute("estado", "true");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
}
