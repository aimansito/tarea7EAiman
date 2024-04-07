/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aiman
 */
public class Directorios {
    public static void crearDirectorio(String nomDir){
        Path directory = Paths.get(nomDir);
        try {
            Files.createDirectory(directory);
            System.out.println("Se ha creado la ruta con éxito");
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + nomDir + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + nomDir);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + nomDir);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }
    }
    public static void listarDirectorio(String ruta) {

        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }
    public static void mostrarFicheros(File file){
        List<File> ficheros = new ArrayList<>();
        List<File> carpetas = new ArrayList<>();
        
        String texto = file.isDirectory()?"D - "+file.getName():file.getName();
        System.out.println(texto);
        
        if (file.isDirectory()){ // Directorio - Tiene hijos
            File[] listaHijos = file.listFiles();
            // Por cada elemento separo en archivos y directorios
            for (File fichero : listaHijos) {
                if (fichero.isFile()){
                    ficheros.add(fichero);
                } else {
                    carpetas.add(fichero);
                }
            }
            // Ordena la lista de ficheros por nombre
            ficheros.sort((f1,f2)->f1.getName().compareTo(f2.getName()));
            // Muestra los nombres de los ficheros
            ficheros.forEach(f->System.out.println("\t" + f.getName()));
            // Por cada carpeta, llama a la recursividad
            carpetas.forEach(c->mostrarFicheros(c));
        } 
    }
    public static void borrarElemento(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.delete(file);
        } catch (NoSuchFileException nsfe) {
            System.out.println("No se puede borrar " + ruta + " porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No se puede borrar el directorio porque no está vacío");
        } catch (IOException e) {
            System.out.println("Problema borrando el elemento " + ruta);
        }
    }
}
