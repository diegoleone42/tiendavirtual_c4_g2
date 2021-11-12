package co.edu.unbosque.tiendavirtual1_front.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.unbosque.tiendavirtual1_front.model.Proveedores;


public class TestJSONproveedores {
	
	private static URL url;
	private static String sitio = "http://localhost:5000/";
	
	public static ArrayList<Proveedores> getJSON() throws IOException, ParseException{
		url = new URL(sitio+"proveedores/listar");
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setRequestMethod("GET");
		http.setRequestProperty("Accept", "application/json");
		InputStream respuesta = http.getInputStream();
		byte[] inp = respuesta.readAllBytes();
		String json = "";
		for (int i = 0; i<inp.length ; i++) {
			json += (char)inp[i];
		}
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		lista = parsingProveedores(json);
		http.disconnect();
		return lista;
	}
	
	public static ArrayList<Proveedores> parsingProveedores(String json) throws ParseException{
		JSONParser jsonParser = new JSONParser();
		ArrayList<Proveedores> lista = new ArrayList<Proveedores>();
		JSONArray proveedores = (JSONArray) jsonParser.parse(json);
		Iterator i = proveedores.iterator();
		while(i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			Proveedores proveedor= new Proveedores();
			proveedor.setNit_proveedor((long) innerObj.get("nit_proveedor"));
			proveedor.setCiudad(innerObj.get("ciudad").toString());
			proveedor.setNombre_proveedor(innerObj.get("nombre_proveedor").toString());
			proveedor.setDireccion_proveedor(innerObj.get("direccion_proveedor").toString());
			proveedor.setTelefono_proveedor((long)innerObj.get("telefono_proveedor"));
			lista.add(proveedor);
		}
		
		return lista;
		
	}
	
	public static int postJSON(Proveedores proveedor) throws IOException{
		url = new URL(sitio+"proveedores/guardar");
		
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
		String data = "{"
				+"\"nit_proveedor\":"+ proveedor.getNit_proveedor()
				+", \"ciudad\":\""+ proveedor.getCiudad()
				+"\", \"nombre_proveedor\":\""+ proveedor.getNombre_proveedor()
				+"\", \"direccion_proveedor\":\""+ proveedor.getDireccion_proveedor()
				+"\", \"telefono_proveedor\":\""+ proveedor.getTelefono_proveedor()
				+"\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
		
	}
	
	public static Proveedores getJSON1(long NIT) throws IOException, ParseException{
		url = new URL(sitio+"proveedores/consultar");
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
		Proveedores proprueba = new Proveedores();
		proprueba.setNit_proveedor(NIT);
		String data = "{"
				+"\"nit_proveedor\":"+ proprueba.getNit_proveedor()
				+", \"ciudad\":\""+ proprueba.getCiudad()
				+"\", \"nombre_proveedor\":\""+ proprueba.getNombre_proveedor()
				+"\", \"direccion_proveedor\":\""+ proprueba.getDireccion_proveedor()
				+"\", \"telefono_proveedor\":\""+ proprueba.getTelefono_proveedor()
				+"\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		Proveedores proveedor = new Proveedores();
				try(BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream(), "utf-8"))) {
					StringBuilder response = new StringBuilder();
					String responseLine = null;
					while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
					}
					String respuestatxt = response.toString();
					JSONParser jsonParser = new JSONParser();
					JSONObject respuesta2 = (JSONObject) jsonParser.parse(respuestatxt);
					proveedor.setNit_proveedor((long) respuesta2.get("nit_proveedor"));
					proveedor.setNombre_proveedor((String) respuesta2.get("nombre_proveedor"));
					proveedor.setDireccion_proveedor((String) respuesta2.get("direccion_proveedor"));
					proveedor.setCiudad((String) respuesta2.get("ciudad"));
					proveedor.setTelefono_proveedor((long) respuesta2.get("telefono_proveedor"));
				}
				http.disconnect();
				return proveedor;
	}
	
	public static int getJSON2(long NIT) throws IOException, ParseException{
		url = new URL(sitio+"proveedores/eliminar");
		HttpURLConnection http;
		http = (HttpURLConnection)url.openConnection();
		try {
			http.setRequestMethod("DELETE");
		} catch(ProtocolException e) {
			e.printStackTrace();
		}
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		Proveedores proprueba = new Proveedores();
		proprueba.setNit_proveedor(NIT);
		String data = "{"
				+"\"nit_proveedor\":"+ proprueba.getNit_proveedor()
				+", \"ciudad\":\""+ proprueba.getCiudad()
				+"\", \"nombre_proveedor\":\""+ proprueba.getNombre_proveedor()
				+"\", \"direccion_proveedor\":\""+ proprueba.getDireccion_proveedor()
				+"\", \"telefono_proveedor\":\""+ proprueba.getTelefono_proveedor()
				+"\"}";
		byte[] out = data.getBytes(StandardCharsets.UTF_8);
		OutputStream stream = http.getOutputStream();
		stream.write(out);
		int respuesta = http.getResponseCode();
		http.disconnect();
		return respuesta;
	}
}
