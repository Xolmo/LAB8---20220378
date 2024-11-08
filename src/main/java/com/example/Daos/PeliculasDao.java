package com.example.Daos;

import com.example.Beans.Genero;
import com.example.Beans.Pelicula;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;

public class PeliculasDao extends BaseDao{

    public ArrayList<Pelicula> ListarPeliculas(){

        ArrayList<Pelicula> peliculas = new ArrayList<>();

        String sql = "select * from Pelicula p\n"+
                "inner join Genero g on g.idGenero = p.idGenero\n"+
                "order by p.rating desc, p.boxOffice desc";

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                Pelicula pelicula = FetchPeliculaData(rs);
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    public Pelicula MostrarPelicula(int id) {
        Pelicula pelicula = null;
        String sql = "SELECT * FROM Pelicula p " +
                "INNER JOIN Genero g ON g.idGenero = p.idGenero " +
                "WHERE p.idPelicula = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pelicula = FetchPeliculaData(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pelicula;
    }

    public void actualizarPelicula(Pelicula pelicula) {

        String sql ="UPDATE pelicula " +
                "SET titulo = ?," +
                "director = ?," +
                "anoPublicacion = ?," +
                "rating = ?," +
                "boxOffice = ?" +
                "WHERE idPelicula = ?";
        try (Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            setPeliculaData(pelicula, pstmt);
            pstmt.setInt(6, pelicula.getIdPelicula());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setPeliculaData(Pelicula pelicula, PreparedStatement pstmt) throws SQLException {
        pstmt.setString(1, pelicula.getTitulo());
        pstmt.setString(2, pelicula.getDirector());
        pstmt.setInt(3, pelicula.getAnoPublicacion());
        pstmt.setDouble(4, pelicula.getRating());
        pstmt.setDouble(5, pelicula.getBoxOffice());
    }

    public void borrarPelicula(int id) {
        try (Connection conn = getConnection();
            PreparedStatement pstmt =conn.prepareStatement("DELETE FROM pelicula WHERE idPelicula= ?")){

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
        }
    }


    private Pelicula FetchPeliculaData(ResultSet rs) throws SQLException{
        Pelicula pelicula = new Pelicula();
        pelicula.setIdPelicula(rs.getInt(1));
        pelicula.setTitulo(rs.getString(2));
        pelicula.setDirector(rs.getString(3));
        pelicula.setAnoPublicacion(rs.getInt(4));
        pelicula.setRating(rs.getDouble(5));
        pelicula.setBoxOffice(rs.getInt(6));

        Genero genero = new Genero();
        genero.setIdGenero(rs.getInt("idGenero"));
        genero.setNombre(rs.getString("nombre"));
        pelicula.setGenero(genero);
        return pelicula;
    }
}

