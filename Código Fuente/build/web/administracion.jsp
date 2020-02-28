<%-- 
    Document   : administracion
    Created on : 11/03/2017, 18:01:36
    Author     : mayko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración</title>
    </head>
    <body>
        <h1> ADMINISTRAR PARTIDO </h1>
        
        <s:form action="verLista">
            <s:submit value="Ver Lista"/>                
        </s:form>
        
        <s:form action="eliminar">                
            <s:submit value="Eliminar jugador"/>
        </s:form>
        
        <s:form action="darBaja">
            <s:submit value="Dar baja partido" />
        </s:form>
        
        <br/> 
        <s:a action="bienvenida">Ir a la página administrativa</s:a>
    </body>
</html>
