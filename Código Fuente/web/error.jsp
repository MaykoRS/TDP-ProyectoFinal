<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="shortcut icon" href="Imagenes/logo.jpg" type="image/x-icon">
    </head>
    <body>
        <h3> <s:actionerror/> </h3>
        
        <s:if test="%{estadoF == 'error'}">
            <s:a href="bienvenida">Ir a la página administrativa </s:a>
        </s:if>
        <s:else>
            <s:a href="home">Regresar</s:a>
        </s:else>
    </body>
</html>
