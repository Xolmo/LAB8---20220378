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
<table>
  <tbody>
    <tr>
      <td>Título</td>
      <td><%= Pelicula.getTitulo()%></td>
    </tr>
    <tr>
      <td>Director</td>
      <td><%= Pelicula.getDirector()%></td>
    </tr>
    <tr>
      <td>Año Publicación</td>
      <td><%= Pelicula.getAnoPublicacion()%></td>
    </tr>
    <tr>
      <td>Rating</td>
      <td><%= Pelicula.getRating()%></td>
    </tr>
    <tr>
      <td>Box Office</td>
      <td><%= Pelicula.getBoxOffice()%></td>
    </tr>
    <tr>
      <td>Actores</td>
      <td>Ver Actores</td>
    </tr>
  </tbody>
</table>

</body>
</html>
