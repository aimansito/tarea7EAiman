/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author aiman
 */
public class Xml {
    public static void crearXML(ArrayList<App> apps, String nomFichero) throws JAXBException{
        CatalogoApps catApps = new CatalogoApps();
        ArrayList<App> app = new ArrayList(apps);
        catApps.setApps(app);
        catApps.setNombre("Mis Apps");
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);
        Marshaller serializador = contexto.createMarshaller();
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        serializador.marshal(catApps, System.out);
        serializador.marshal(catApps, new File("./appsxml/" + nomFichero));
        System.out.println("Fichero " + nomFichero + ".xml creado correctamente.");
    }
    public static void leerXML(ArrayList<App> apps ) throws JAXBException{
        
       // Crea el contexto JAXB 
       JAXBContext contexto = JAXBContext.newInstance(CatalogoApps.class);
       // Crea el objeto Unmarshaller
       Unmarshaller um = contexto.createUnmarshaller();
       CatalogoApps catalogo = (CatalogoApps) um.unmarshal(new File("./appsXml/appsxml.xml"));
       ArrayList<App> listaApps = catalogo.getApps();
       
       listaApps.forEach(System.out::println);
    }
}
