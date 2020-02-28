<%-- 
    Document   : eliminarJugador
    Created on : 10/03/2017, 02:49:36
    Author     : mayko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminando Jugador</title>
        <link rel="shortcut icon" href="Imagenes/logo.jpg" type="image/x-icon">
    </head>
    <body>
        <h1> Seleccione al jugador que desea eliminar de la lista: </h1>
        <s:form action="eliminarJugador">
            <s:select list="jugadores" listKey="legajo" listValue="nombre" name="legajoF"  label="Seleccionar">
            </s:select>
            <br/>
            <s:submit value="Eliminar"/>
        </s:form>
        
        <s:a action="bienvenida">Cancelar</s:a>
    </body>
</html>
