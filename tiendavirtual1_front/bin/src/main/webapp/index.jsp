<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/estilo.css"/>
<meta charset="UTF-8"/>
<title>Pagina de ejemplo</title>
</head>
<body>
<h1>Bienvenido a Tienda Los chicos del Barrio</h1>

	<form method="get" action="./t_servlet">
		<table class="regitro">
			<tr>
				 <td><label class="regitro1" for="uname"><b>Usuario</b></label></td>
   				 <td><input class="regitro1" type="text" placeholder="Ingresa el usuario" name="uname" required></td>
			</tr>
			<tr>
				<td><label class="regitro1" for="passt"><b>Contraseña</b></label></td>
				<td><input class="regitro1" type="password" placeholder="Ingresa la contraseña" name="passt" required></td>
			</tr>

		</table>
			<div class="log">
     		 <button type="submit" class="signupbtn">Login</button>
    		</div>
	</form> 

<div class="cuadro-ventas" id="navbarResponsive">
          <ul class="navbar-nav1 ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" onClick="mostrar('interaccion-1');">Usuarios</a> 
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger " onClick="mostrar('interaccion-2');">Clientes</a>
            </li> 
           <li class="nav-item">
              <a class="nav-link js-scroll-trigger " onClick="mostrar('interaccion-3');">Proveedores</a>
            </li> 
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger " onClick="mostrar('interaccion-4');">Productos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger " onClick="mostrar('interaccion-5');">Ventas</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger " onClick="mostrar('interaccion-6');">Reportes</a>
            </li>
           </ul>
  </div>
    <section  id="interaccion-1" class="oculto info-1"> 
    <h3>Usuarios</h3>
			<table class="Usuarios">
				<tr>
					<td><label>Cédula:</label></td>
					<td><input type="text" name="cedula"></td>
					<td><label>Usuario:</label></td>
					<td><input type="text" name="usuario"></td>
				</tr>	
				<tr>
					<td><label>Nombre Completo:</label></td><br>
					<td><input type="text" name="nombre_completo"></td>
					<td><label>Contraseña:</label></td>
					<td><input type="text" name="contraseña"></td><br>
				</tr>	
				<tr>
					<td><label>Correo Electónico:</label></td>
					<td><input type="text" name="email"></td>
				</tr>
			</table>
			<br>
		<script type="text/javascript">
		function mostrar(name){
			closeAll();
			let el = document.getElementById(name);
			el.style.height = 'auto';
			irA(name);
		}
		function closeAll(){
			let info = document.getElementsByClassName('oculto');
			for(i = 0; i < info.length; i++){
				info[i].style.height = '0';
			} 
		}
		function irA(name){
			let el = document.getElementById(name);
			window.smoothScroll(el, 1000);
		}
		</script>
			<div class="botones">
					<button name="Consultar" type="button">Consulta</button>
					<button name="Crear" type="button">Crear</button>
					<button name="Actualizar" type="button">Actualizar</button>
					<button name="Borrar" type="button">Borrar</button>
			</div>
    </section>
    <section  id="interaccion-2" class="oculto info-2"> 
     <h3>Clientes</h3>
			<table class="Clientes">
				<tr>
					<td><label>Cédula:</label></td>
					<td><input type="text" name="cedula"></td>
					<td><label>Teléfono:</label></td>
					<td><input type="text" name="telefono"></td>
				</tr>	
				<tr>
					<td><label>Nombre Completo:</label></td><br>
					<td><input type="text" name="nombre_completo"></td>
					<td><label>Correo Electrónico:</label></td>
					<td><input type="text" name="email"></td><br>
				</tr>	
				<tr>
					<td><label>Dirección:</label></td>
					<td><input type="text" name="direccion"></td>
				</tr>
			</table>
			<br>
		<script type="text/javascript">
		function mostrar(name){
			closeAll();
			let el = document.getElementById(name);
			el.style.height = 'auto';
			irA(name);
		}
		function closeAll(){
			let info = document.getElementsByClassName('oculto');
			for(i = 0; i < info.length; i++){
				info[i].style.height = '0';
			} 
		}
		function irA(name){
			let el = document.getElementById(name);
			window.smoothScroll(el, 1000);
		}
		</script> 
			<div class="botones">
					<button name="Consultar" type="button">Consulta</button>
					<button name="Crear" type="button">Crear</button>
					<button name="Actualizar" type="button">Actualizar</button>
					<button name="Borrar" type="button">Borrar</button>
			</div>
    </section>
    </section>
    <section  id="interaccion-3" class="oculto info-3"> 
     <h3>Proveedores</h3>
     <form>
			<table class="proveedores">
				<tr>
					<td><label>NIT:</label></td>
					<td><input type="text" name="nit"></td>
					<td><label>Teléfono:</label></td>
					<td><input type="text" name="telefono"></td>
				</tr>	
				<tr>
					<td><label>Nombre Proveedor:</label></td><br>
					<td><input type="text" name="nombre_proveedor"></td>
					<td><label>Ciudad:</label></td>
					<td><input type="text" name="ciudad"></td><br>
				</tr>	
				<tr>
					<td><label>Dirección:</label></td>
					<td><input type="text" name="direccion"></td>
				</tr>
			</table>
			<br>
		<script type="text/javascript">
		function mostrar(name){
			closeAll();
			let el = document.getElementById(name);
			el.style.height = 'auto';
			irA(name);
		}
		function closeAll(){
			let info = document.getElementsByClassName('oculto');
			for(i = 0; i < info.length; i++){
				info[i].style.height = '0';
			} 
		}
		function irA(name){
			let el = document.getElementById(name);
			window.smoothScroll(el, 1000);
		}
		</script>
	</form> 
			<div class="botones">
					<button name="Consultar" type="button">Consulta</button>
					<button name="Crear" type="button">Crear</button>
					<button name="Actualizar" type="button">Actualizar</button>
					<button name="Borrar" type="button">Borrar</button>
			</div>
    </section>
    <section  id="interaccion-4" class="oculto info-4"> 
     <h3>Productos</h3>
			<table class="productos">
				<tr>
					<td><label>Nombre del archivo:</label></td>
					<td><input type="file" name="archioProduct"></td>
					<td><label></label></td>
					<td><input type="submit" value="Enviar datos"></td>
				</tr>	
			</table>
			<br>
		<script type="text/javascript">
		function mostrar(name){
			closeAll();
			let el = document.getElementById(name);
			el.style.height = 'auto';
			irA(name);
		}
		function closeAll(){
			let info = document.getElementsByClassName('oculto');
			for(i = 0; i < info.length; i++){
				info[i].style.height = '0';
			} 
		}
		function irA(name){
			let el = document.getElementById(name);
			window.smoothScroll(el, 1000);
		}
		</script>
    </section>
    <section  id="interaccion-5" class="oculto info-5"> 
     <h3>Ventas</h3>
     <form>
			<table class="ventas">
				<tr>
					<td><label>Cédula:</label></td>
					<td><input type="text" name="nit"></td>
					<td><button class="consultaVentas" name="Consultar" type="button">Consulta</button></td>
					<td><label>Clientes:</label></td>
					<td><input type="text" name="telefono"></td>
					<td><label>Consecutivo:</label></td>
					<td><input type="text" name="telefono"></td>
				</tr>
			</table>
			<table class="ventas2">		
				<tr>
					<th>Cod.Producto</th>
					<th></th>
					<th>Nombre Producto</th>
					<th>Cant.</th>
					<th>Vlr. Total</th>
				</tr>	
				<tr>
					<td><input type="text" name="codigo1"></td>
					<td><button class="consultaVentas" name="Consultar" type="button">Consulta</button></td>
					<td><input type="text" name="nom-product"></td>
					<td><input type="text" name="cantidad"></td>
					<td><input type="text" name="valor-total"></td>
				</tr>
				<tr>
					<td><input type="text" name="codigo2"></td>
					<td><button class="consultaVentas" name="Consultar" type="button">Consulta</button></td>
					<td><input type="text" name="nom-product2"></td>
					<td><input type="text" name="cantidad2"></td>
					<td><input type="text" name="valor-total2"></td>
				</tr>
				<tr>
					<td><input type="text" name="codigo3"></td>
					<td><button class="consultaVentas" name="Consultar" type="button">Consulta</button></td>
					<td><input type="text" name="nom-product3"></td>
					<td><input type="text" name="cantidad3"></td>
					<td><input type="text" name="valor-total3"></td>
				</tr>
			</table>
			<table class="totalventas">
				<tr>
					<td></td>
					<th class="ttv">Total Venta</th>
					<td><input type="text" name="total-venta"></td>
				</tr>
				<tr>
					<td></td>
					<th class="ttv">Total IVA</th>
					<td><input type="text" name="total-iva"></td>
				</tr>
				<tr>
					<td><button class="consultaVentas" name="Consultar" type="button">Consulta</button></td>
					<th>Total con IVA</th>
					<td><input type="text" name="total-con+iva"></td>
				</tr>
			</table>
			<br>
		<script type="text/javascript">
		function mostrar(name){
			closeAll();
			let el = document.getElementById(name);
			el.style.height = 'auto';
			irA(name);
		}
		function closeAll(){
			let info = document.getElementsByClassName('oculto');
			for(i = 0; i < info.length; i++){
				info[i].style.height = '0';
			} 
		}
		function irA(name){
			let el = document.getElementById(name);
			window.smoothScroll(el, 1000);
		}
		</script>
	</form> 
    </section>
     <section  id="interaccion-6" class="oculto info-6"> 
     <h3>Reportes</h3>
	<!-- contenido Reportes -->
    </section>
</body>
</html>
