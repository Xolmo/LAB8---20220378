package com.example.Controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DetallesServlet", urlPatterns = {"/DetallesServlet"})
public class DetallesServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
