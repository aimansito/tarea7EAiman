/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBException;

/**
 *
 * @author aiman
 */
public class Main_2 {
    public static void main(String[] args) {
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
        // ej 4
        
    }
}
