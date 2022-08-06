package ar.com.teclas.peliculas.negocio;

public interface CatalogoPeliculas {
    String NOMBRE_RECURSO = "peliculas.txt";
    void agregarPelicula(String nombrePelicula);
    void listarPelicula();
    void buscarPelicula(String buscar);
    void iniciarCatalogoPeliculas();

}
