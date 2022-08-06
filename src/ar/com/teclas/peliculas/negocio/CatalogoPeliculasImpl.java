package ar.com.teclas.peliculas.negocio;

import ar.com.teclas.peliculas.datos.AccesoDatos;
import ar.com.teclas.peliculas.datos.AccesoDatosImpl;
import ar.com.teclas.peliculas.domain.Pelicula;
import ar.com.teclas.peliculas.excepciones.*;

import java.sql.SQLOutput;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }


    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula= new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar= datos.existe(NOMBRE_RECURSO);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPelicula() {
        try {
            var peliculas= this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula:peliculas) {
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);

        }
    }

    @Override
    public void buscarPelicula(String buscar) {
     String resultado=null;
        try {
            resultado= this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }
            else{
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error al iniciar catalogo de peliculas");
            e.printStackTrace(System.out);
        }
    }
}
