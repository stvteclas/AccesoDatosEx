package ar.com.teclas.peliculas.datos;

import ar.com.teclas.peliculas.domain.Pelicula;
import ar.com.teclas.peliculas.excepciones.AccesoDatosEx;
import ar.com.teclas.peliculas.excepciones.EscrituraDatosEx;
import ar.com.teclas.peliculas.excepciones.LecturaDatosEx;

import java.util.List;

public interface AccesoDatos {
    public boolean existe(String nombreRecurso) throws AccesoDatosEx;
    List<Pelicula> listar(String nombreRecurso)throws LecturaDatosEx;

     void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;
}
