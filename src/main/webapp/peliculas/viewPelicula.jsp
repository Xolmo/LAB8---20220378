<%--
  Created by IntelliJ IDEA.
  User: Sebastian
  Date: 7/11/2024
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.Beans.Pelicula" %>
<jsp:useBean id="Pelicula" type="com.example.Beans.Pelicula" scope="request"/>

<html>
<head>
    <title><%= Pelicula.getTitulo()%></title>
</head>
<body>
<h1><%="Pelicula Número " + Pelicula.getIdPelicula()%></h1>
<form method="POST" action="DetallesServlet?accion=actualizar">
  <input type="submit" value="Guardar Pelicula"/>
  <input type="hidden" name="idPelicula" id="idPelicula" value="<%=  Pelicula.getIdPelicula()%>">
  <input type="hidden" name="idGenero" id="idGenero"  value="<%= Pelicula.getGenero().getIdGenero()%>">
  <table>
    <tbody>
    <tr>
      <td><label for="titulo">Titulo</label></td>
      <td><input type="text" name="titulo" id="titulo" value="<%= Pelicula.getTitulo()%>"></td>
    </tr>
    <tr>
      <td><label for="director">Director</label></td>
      <td><input type="text" name="director" id="director" value="<%= Pelicula.getDirector()%>"></td>
    </tr>
    <tr>
      <td><label for="anoPublicacion">Año de Publicación</label></td>
      <td><input type="text" name="anoPublicacion" id="anoPublicacion" value="<%= Pelicula.getAnoPublicacion()%>"></td>
    </tr>
    <tr>
      <td><label for="rating">Rating</label></td>
      <td><input type="text" name="rating" id="rating" value="<%= Pelicula.getRating()%>"></td>
    </tr>
    <tr>
      <td><label for="boxOffice">Box Office</label></td>
      <td><input type="text" name="boxOffice" id="boxOffice" value="<%= Pelicula.getBoxOffice()%>"></td>
    </tr>
    <tr>
      <td>Actores</td>
      <td>Ver Actores</td>
    </tr>
    </tbody>
  </table>
</form>


</body>
</html>
