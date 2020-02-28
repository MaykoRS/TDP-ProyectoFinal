<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fútbol</title>
        <link rel="shortcut icon" href="Imagenes/logo.jpg" type="image/x-icon">
        <style type="text/css">
            table td{
                padding: 10px 20px 10px 20px;
            }
            
            table thead{
                background: #000;
                color: #fff;
            }
            
            table tbody{
                text-align: left;
            }
            
            table{
                font-family: Verdana;
            }
        </style>
    </head>
    <body>
        <h1> DEPORTE </h1>
           
        <s:if test="%{estadoF == 'inscribir'}">
            <h4>Máxima cantidad de cupos: <s:property value="maxCantidadJugadores"/></h4>
            <h4>Cantidad de jugadores inscriptos: <s:property value="cantJugadores"/></h4>
            <h4>Lugar: Av. Alem 1253, 8000 Bahía Blanca, Buenos Aires</h4>
            <h4>Hora: 10 pm </h4>
            <h4>Precio: $50</h4>
            <br />
            
            <h2> Datos Personales: </h2>

            <s:form action="inscribirFutbol">
                <s:textfield name="legajoF" label="Legajo" required="true" />
                <s:textfield name="nombreF" label="Nombre" required="true"/>
                <s:textfield name="apellidoF"   label="Apellido" required="true"/>
                <s:submit value="Inscribirse"/>          
            </s:form>

            <s:form action="home">
                <s:submit value="Cancelar"/>
            </s:form>
            
                
        </s:if>

        <s:elseif test="%{estadoF == 'verLista'}">
            <center>
            <table border="1px" style="text-align: center;">
                <thead>
                    <tr>
                        <td colspan="3">Lista de Jugadores</td>
                    </tr>
                    
                    <tr>
                        <td>Legajo </td>
                        <td>Nombre </td>
                        <td>Apellido</td>
                    </tr>
                </thead>
                
                <tbody>
                    
                    <s:iterator value="jugadores">
                        <tr>
                            <td> <s:property value="legajo"/> </td>
                            <td> <s:property value="nombre"/> </td>
                            <td> <s:property value="apellido"/> </td>
                        </tr>
                    </s:iterator>
                    
                    
                    
                </tbody>
            </table>
            </center>
        
        <s:a action="bienvenida">Atrás</s:a>
        </s:elseif>
            
    </body>
</html>
