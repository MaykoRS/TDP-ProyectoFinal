<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración</title>
        <link rel="shortcut icon" href="Imagenes/logo.jpg" type="image/x-icon">
    </head>
    <body>
        <h1> ADMINISTRACIÓN </h1>
        <center>
            <h1> <s:actionmessage/> </h1>
        </center>
        
        <s:if test="%{#session.USER == 'ADMIN'}">
            <s:form action="siguiente">
                <s:select list="{'futbol','basquet','voley','paddle'}" name="deporte" label="Seleccionar Deporte"/>
                <s:submit value="Siguiente" />
            </s:form>
            <br />  <br />
            <s:form action="logout">
                <s:submit value="Cerrar Sesión"/>
            </s:form>
            
        </s:if>
        
    
        <br />
        <s:else>
            <h3> Si eres el administrador, debes abrir sesión </h3>
            
        </s:else>

        </br>
        <s:a action="home">Ir a la página principal</s:a>
        
                
        
    </body>
</html>

