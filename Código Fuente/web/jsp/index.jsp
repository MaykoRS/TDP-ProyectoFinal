<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width-device-width, initial-scale-1,maximus-scale-1">
        <title> Home </title>
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/estilo.css">
        <link href="https://fonts.googleapis.com/css?family=Overlock:400,700" rel="stylesheet">
        <link rel="shortcut icon" href="Imagenes/logo.jpg" type="image/x-icon">

        <script src="../js/modernizr-custom.js"></script>
    </head>
    
    <body>
        
	<header>
		<figure>
			<img src="Imagenes/logo.jpg" alt="">
		</figure>
		<h1> PARTIDO DEPORTIVO </h1>
                <h3>Selecciona el deporte que te guste e inscríbete ya!! </h3>
		<nav>
			<ul>
                                <li><s:a href="home">Home</s:a></li>
				<li><a href="mailto:mayko_9412@hotmail.com" title="Enviar correo a Mayko Rodríguez">Contactar</a></li>
				<li><s:a action="bienvenida">Administración</s:a></li>
			</ul>
		</nav>
	</header>
        
        <div> 
            <s:if test="%{#session.USER != 'ADMIN'}">
                <s:form action="Validar">
                    <s:textfield name="userlogin" label="Usuario"/>
                    <s:password name="userpwd" label="Contraseña"/>
                    <s:submit value="Ingresar"/>
                </s:form>
            </s:if>
        </div>
                        
	<section>
		
		
            <article class="deporte futbol">
                    <!--Verifica si hay cupos disponibles para inscribirse a fútbol-->
                <s:a action="verificarCupoFutbol"><figure> <img src="Imagenes/futbol.jpg" alt=""></figure>
			<span class="tipo">FÚTBOL 5</span></s:a>
			<p>Se juega entre dos equipos de 5 jugadores cada uno, siendo uno de ellos el guardameta. Se juegan dos tiempos de 20 minutos cada uno. Cada encuentro se juega sobre una superficie de material sólido de unos 40 por 20 metros.
			</p>
		</article>
		
		<article class="deporte basquet">
			<s:a action="verificarCupoBasquet"><figure> <img src="Imagenes/basquet.jpeg" alt=""></figure>
			<span class="tipo">BASQUET</span></s:a>
			<p>Es un deporte de dos equipos, formados por cinco jugadores cada uno, ellos tienen que intentar anotar puntos, también llamados canastas o dobles y/o triples introduciendo un balón en un aro.
			</p>
		</article>
		
		<article class="deporte voley">
			<s:a action="verificarCupoVoley"><figure> <img src="Imagenes/voley.jpg" alt=""></figure>
			<span class="tipo">VÓLEY</span></s:a>
			<p>Es un deporte de equipo que se clasifica entre los juegos de pelota en el que dos equipos, integrados por seis jugadores cada uno, se enfrentan sobre un área de juego separada por una red central.
			</p>
		</article>
		
		<article class="deporte paddle">
			<s:a action="verificarCupoPaddle"><figure> <img src="Imagenes/paddle-tennis.jpg" alt=""></figure>
			<span class="tipo">PADDLE TENNIS</span></s:a>
			<p>El pádel se juega en parejas y consta de tres materiales fundamentales para su desarrollo: la pelota, la pala y el campo de juego o pista.
			</p>
		</article>
		
	</section>
	
        
        
	<footer> Copyright © 2017 Mayko Rodríguez </footer>
	
		
        
    </body>
</html>
