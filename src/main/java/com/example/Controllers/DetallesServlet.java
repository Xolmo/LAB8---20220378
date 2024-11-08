package com.example.Controllers;

import com.example.Beans.Genero;
import com.example.Beans.Pelicula;
import com.example.Daos.PeliculasDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DetallesServlet", urlPatterns = {"/DetallesServlet"})
public class DetallesServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accion = request.getParameter("accion");

        RequestDispatcher view;
        PeliculasDao peliculasDao = new PeliculasDao();

        switch (accion) {
            case "editar":
                if(request.getParameter("id") != null) {
                    String idString = request.getParameter("id");
                    int id = 0;
                    try {
                        id = Integer.parseInt(idString);
                    } catch (NumberFormatException e) {
                        response.sendRedirect("PeliculasServlet");
                    }

                    Pelicula pelicula = peliculasDao.MostrarPelicula(id);
                    if(pelicula != null) {
                        request.setAttribute("pelicula", pelicula);
                        view = request.getRequestDispatcher("peliculas/viewPelicula.jsp");
                        view.forward(request, response);
                    } else{
                        response.sendRedirect("PeliculasServlet");
                    }
                } else {
                    response.sendRedirect("PeliculasServlet");
                }
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String accion = request.getParameter("accion");
        PeliculasDao peliculasDao = new PeliculasDao();

        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo(request.getParameter("titulo"));
        pelicula.setDirector(request.getParameter("director"));
        pelicula.setAnoPublicacion(Integer.parseInt(request.getParameter("anoPublicacion")));
        pelicula.setRating(Double.parseDouble(request.getParameter("rating")));
        pelicula.setBoxOffice(Double.parseDouble(request.getParameter("boxOffice")));

        Genero genero = new Genero();
        genero.setIdGenero(Integer.parseInt(request.getParameter("idGenero")));
        pelicula.setGenero(genero);

        switch (accion) {
            case "actualizar":
                pelicula.setIdPelicula(Integer.parseInt(request.getParameter("idPelicula")));
                peliculasDao.actualizarPelicula(pelicula);
                response.sendRedirect("PeliculasServlet");
                break;
        }
    }
}
