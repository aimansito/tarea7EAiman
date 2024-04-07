/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author aiman
 */
public class Json {
    public static void crearJson(ArrayList<App> apps,String nombre) throws IOException{
        ObjectMapper mapeador = new ObjectMapper();
        
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de apps
        mapeador.writeValue(new File("./appsjson/"+nombre+".json"), apps);
    }
    public static void crearJsonIndividual(ArrayList<App> apps) throws IOException{
        ObjectMapper mapeador = new ObjectMapper();
        
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de apps
        for (App app : apps) {
            mapeador.writeValue(new File("./appsjson/"+app.getNombre()+".json"), apps);
        }
    }
    
    public static void leerJSON(ArrayList<App> catalogo, String nombre) throws IOException {         
        ObjectMapper mapeador = new ObjectMapper();         mapeador.registerModule(new JavaTimeModule());
        catalogo = mapeador.readValue(new File(nombre), 
                mapeador.getTypeFactory().constructCollectionType(ArrayList.class, App.class));     
        for (App apps : catalogo) {             
            System.out.println(apps);         
        }      
    }
}
