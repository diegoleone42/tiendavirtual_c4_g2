package co.edu.unbosque.tiendavirtual1_front.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.unbosque.tiendavirtual1_front.model.Clientes;
import co.edu.unbosque.tiendavirtual1_front.model.Detalleventas;
import co.edu.unbosque.tiendavirtual1_front.model.Productos;
import co.edu.unbosque.tiendavirtual1_front.model.Proveedores;
import co.edu.unbosque.tiendavirtual1_front.model.Ventas;

public class VentasTestJSON {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static Clientes getJSON1(long cedula) throws IOException, ParseException {
		url = new URL(sitio+"clientes/consultar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
			http.setRequestMethod("POST");
		} catch(ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		Clientes cliprueba = new Clientes();
		cliprueba.setCedula_cliente(cedula);
		String data = "{"
				+"\"cedula_cliente\":"+ cliprueba.getCedula_cliente()
				+", \"email_cliente\":\""+ cliprueba.getEmail_cliente()
				+"\", \"nombre_cliente\":\""+ cliprueba.getNombre_cliente()
				+"\", \"direccion_cliente\":\""+ cliprueba.getDireccion_cliente()
				+"\", \"telefono_cliente\":\""+ cliprueba.getTelefono_cliente()
				+"\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		Clientes cliente = new Clientes();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			String respuestatxt = response.toString();
			JSONParser jsonParser = new JSONParser();
			JSONObject respuesta2 = (JSONObject) jsonParser.parse(respuestatxt);
			cliente.setCedula_cliente((long) respuesta2.get("cedula_cliente"));
			cliente.setEmail_cliente((String) respuesta2.get("email_cliente"));
			cliente.setNombre_cliente((String) respuesta2.get("nombre_cliente"));
			cliente.setDireccion_cliente((String) respuesta2.get("direccion_cliente"));
			cliente.setTelefono_cliente((long) respuesta2.get("telefono_cliente"));
			
		}
		http.disconnect();
		return cliente;
	}
	
	public static Productos getJSON2(long codigo) throws IOException, ParseException {
		
		url = new URL(sitio+"productos/consultar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
			http.setRequestMethod("POST");
		} catch(ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		Productos producto = new Productos();
		producto.setCodigo_producto(codigo);
		Proveedores proveedor = new Proveedores();
		producto.setProveedor(proveedor);
		String data = "{"
				+"\"codigo_producto\": "+ producto.getCodigo_producto()
				+", \"nombre_producto\": \""+ producto.getNombre_producto()
				+"\", \"proveedor\": {"
										+"\"nit_proveedor\":"+ producto.getProveedor().getNit_proveedor()
										+", \"ciudad\":\""+ producto.getProveedor().getCiudad()
										+"\", \"nombre_proveedor\":\""+ producto.getProveedor().getNombre_proveedor()
										+"\", \"direccion_proveedor\":\""+ producto.getProveedor().getDireccion_proveedor()
										+"\", \"telefono_proveedor\":\""+ producto.getProveedor().getTelefono_proveedor()
										+"\"}"
				+", \"precio_compra\": "+ producto.getPrecio_compra()
				+", \"iva_compra\": "+ producto.getIva_compra()
				+", \"precio_venta\": "+ producto.getPrecio_venta()
				+"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		Productos producto1 = new Productos();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			String respuestatxt = response.toString();
			JSONParser jsonParser = new JSONParser();
			JSONObject respuesta2 = (JSONObject) jsonParser.parse(respuestatxt);
			producto1.setCodigo_producto((long) respuesta2.get("codigo_producto"));
			producto1.setNombre_producto((String) respuesta2.get("nombre_producto"));
			producto1.setPrecio_venta((long) respuesta2.get("precio_venta"));
			producto1.setProveedor(proveedor);
			producto1.setIva_compra((long) respuesta2.get("iva_compra"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		http.disconnect();
		return producto1;
	}
	
	

	public static long getJSON3(Ventas venta) throws IOException, ParseException {
		
		url = new URL(sitio+"ventas/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
			http.setRequestMethod("POST");
		} catch(ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		String data = venta.toString();
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		long indice = 0;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			String respuestatxt = response.toString();
			indice = Long.parseLong(respuestatxt);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		http.disconnect();
		return indice;
	}
	
	public static int getJSON4(Detalleventas detalle) throws IOException, ParseException {
		
		url = new URL(sitio+"detalleventas/guardar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
			http.setRequestMethod("POST");
		} catch(ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		String data = detalle.toString();
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);		
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
	
	

}
