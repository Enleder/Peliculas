package Datos;

import java.util.List;
import Domain.*;
import Excepciones.*;

public interface AccesoDatosInterface {

    public boolean existe (String nombreArchivo) throws AccesoDatosEx;

    public List<Pelicula> listar(String nombre) throws LecturaDatosEx;

    public void escribir (Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;

    public String buscar (String nombreArchivo, String buscar) throws LecturaDatosEx;

    public void crear (String nombreArchivo) throws AccesoDatosEx;

    public void borrar (String nombreArvhivo) throws AccesoDatosEx;
}

