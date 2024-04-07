/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

/**
 *
 * @author aiman
 */
public class Main_2 {
    public static void main(String[] args) throws JAXBException {
        Scanner teclado = new Scanner(System.in);
        ArrayList<App> apps = App.crearApps();
        // ej 1
        try {
            Xml.crearXML(apps, "./appsxml");
        } catch (JAXBException jaxbe) {
            System.out.println("Error");
        } 
        // ej 2
        Directorios.crearDirectorio("./appsjson");
        try {
            Json.crearJson(apps, "./appssjson");
        } catch (IOException ex) {
            System.out.println("Error");
        }
        // ej 3
        try {
            Json.crearJsonIndividual(apps);
        } catch (IOException ex) {
            System.out.println("Error");
        }
        // lectura xml
        System.out.println("Lectura XML: ");
        try {
            Xml.leerXML(apps);
        } catch (JAXBException jaxbe) {
            System.out.println("Error");
        } 
        // lectura JSON 
        System.out.println("Lectura JSON: ");
        try {
            Json.leerJSON(apps,"./appsjson/appssjson.json");
        } catch (IOException ex) {
            System.out.println("Error");
        }
        //mostrar ficheros
        Directorios.listarDirectorio("./appsjson");
        //Pregunta al usuario el nombre del fichero json (de los anteriores) 
        //que quiere leer. Una vez leído muestra los datos de esta app por consola.
        System.out.println("Introduce el archivo a buscar: ");
        String nombre = teclado.nextLine();
        Directorios.mostrarFicheros(new File(nombre));
        
        //borrar archivo
        Directorios.borrarElemento("./appsjson/appssjson.json");
        
        Directorios.listarDirectorio("./appsjson");
    }
}
