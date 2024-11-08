package com.example.Controllers;

import com.example.Beans.Pelicula;
import com.example.Daos.PeliculasDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PeliculasServlet", urlPatterns = {"/PeliculasServlet"})
public class PeliculaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        RequestDispatcher view;
        PeliculasDao peliculasDao = new PeliculasDao();

        switch (action) {
            case "lista":
                request.setAttribute("listaPeliculas", peliculasDao.ListarPeliculas());
                view = request.getRequestDispatcher("peliculas/listaPeliculas.jsp");
                view.forward(request, response);
                break;
            case "borrar":
                if (request.getParameter("id") != null) {
                    String peliculaIDString = request.getParameter("id");
                    int peliculaid = 0;
                    try {
                        peliculaid = Integer.parseInt(peliculaIDString);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("PeliculasServlet");
                    }

                    Pelicula pelicula = peliculasDao.MostrarPelicula(Integer.parseInt(peliculaIDString));

                    if (pelicula != null) {
                        peliculasDao.borrarPelicula(peliculaid);
                    }
                }
                response.sendRedirect("PeliculasServlet");
                break;
            case "mostrar":
                if(request.getParameter("id") != null) {
                    String peliculaIDString = request.getParameter("id");
                    int peliculaID = 0;
                    try {
                        peliculaID = Integer.parseInt(peliculaIDString);
                    } catch (NumberFormatException e) {
                        response.sendRedirect("PeliculasServlet");
                    }
                    Pelicula pelicula = peliculasDao.MostrarPelicula(peliculaID);
                    if (pelicula != null) {
                        request.setAttribute("Pelicula", pelicula);
                        view = request.getRequestDispatcher("peliculas/viewPelicula.jsp");
                        view.forward(request, response);
                    }
                    else {
                        response.sendRedirect("PeliculasServlet");
                    }
                } else {
                    response.sendRedirect("PeliculasServlet");
                }
                break;
        }

    }
}
