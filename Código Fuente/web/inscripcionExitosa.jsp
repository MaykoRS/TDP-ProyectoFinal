<%-- 
    Document   : inscripcionExitosa
    Created on : 17/02/2017, 03:54:59
    Author     : mayko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscripción exitosa</title>
        <link rel="shortcut icon" href="Imagenes/logo.jpg" type="image/x-icon">
    </head>
    <body>
        <h1> <s:actionmessage/> </h1>

        <s:if test="%{#session.USER == 'ADMIN'}">
            <s:a href="bienvenida">Ir a la página administrativa </s:a>
        </s:if>
      
        <br /> <br />
        <s:a href="home">Ir a la página principal </s:a>
        
    </body>
</html>
