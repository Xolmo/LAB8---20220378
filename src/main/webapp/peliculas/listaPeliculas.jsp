<%--
  Created by IntelliJ IDEA.
  User: Sebastian
  Date: 7/11/2024
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.example.Beans.Pelicula" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaPeliculas" type="java.util.ArrayList<com.example.Beans.Pelicula>" scope="request" />
<html>
<head>
    <title>Peliculas</title>
</head>
<body>
    <h1>Lista Peliculas</h1>
    <table>
        <thead>
            <tr>
                <th>Título</th>
                <th>Director</th>
                <th>Año Publicación</th>
                <th>Rating</th>
                <th>Box Office</th>
                <th>Género</th>
                <th>Actores</th>
                <th>Accionable</th>
            </tr>
        </thead>
        <tbody>
            <%
                int i = 1;
                for (Pelicula p: listaPeliculas) {
            %>
            <tr>
                <td><a href="<%=request.getContextPath()%>/PeliculasServlet?action=mostrar&id=<%= p.getIdPelicula()%>"><%= p.getTitulo()%></a>
                </td>
                <td><%= p.getDirector()%>
                </td>
                <td><%= p.getAnoPublicacion()%>
                </td>
                <td><%= p.getRating() + "/10"%>
                </td>
                <td><%= "$ " + p.getBoxOffice()%>
                </td>
                <td><%= p.getGenero().getNombre()%></td>
                <td>
                </td>
                <td></td>
            </tr>
            <%
                i++;
                }
            %>
        </tbody>
    </table>
</body>
</html>
