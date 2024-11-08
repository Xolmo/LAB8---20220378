<%--
  Created by IntelliJ IDEA.
  User: Sebastian
  Date: 8/11/2024
  Time: 01:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.Beans.Actor" %>
<%@ page import="com.example.Beans.Protagonistas" %>
<%@ page import="com.example.Beans.Pelicula" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="listaActores" type="java.util.ArrayList<com.example.Beans.Protagonistas>" scope="request"/>
<html>
<head>
    <title><%= Protagonistas %></title>
</head>
<body>
  <h1><%= Pelicula.getTitulo()%></h1>
    <table>
      <thead>
        <tr>
          <th>idActor</th>
          <th>Nombre</th>
          <th>Apellido</th>
          <th>Año Nacimiento</th>
          <th>Ganador Premio Oscar</th>
        </tr>
      </thead>
      <tbody>
        <%
            int i=1;
            for(Protagonistas p : listaActores){
        <tr>
          <td></td>
        </tr>
      </tbody>
    </table>
</body>
</html>
