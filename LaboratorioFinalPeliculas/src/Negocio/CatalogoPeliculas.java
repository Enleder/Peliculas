package Negocio;

import java.util.Iterator;
import java.util.List;
import Datos.*;
import Domain.*;
import Excepciones.*;

public class CatalogoPeliculas implements CatalogoPeliculasInterface  {

    private final AccesoDatos datos;

    public CatalogoPeliculas () {
        this.datos = new AccesoDatos();
    }

    @Override
    public void agregarPelicula (String nombrePelicula, String nombreArchivo){
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;

        try{
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula, nombreArchivo, anexar);
        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas (String nombreArchivo){
        try{
            List<Pelicula> peliculas = datos.listar(nombreArchivo);
            for(int i = 0; peliculas.size() > i; i++) {
                System.out.println("Pelicula: " + peliculas.get(i));
            }

        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula (String nombreArchivo, String buscar){
        String result = null;
        result = datos.buscar(buscar, nombreArchivo);
        System.out.println("Resultado busqueda: " + result);
    }

    @Override
    public void iniciarArchivo (String nombreArchivo){
        try{
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            }else{
                datos.crear(nombreArchivo);
            }
        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
}
