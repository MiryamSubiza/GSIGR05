/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (21/09/2015)
 */
public class Collective extends Artist implements Performer {
    
    private ArrayList <Artist> artists; // Todos los artistas que componen el colectivo
    /** ¡HERENCIA!
     * private String name; // Nombre del colectivo de artistas
     * private String workDescription; // Descripción del colectivo de artistas
     * private String webSite; // Página web de dicho colectivo de artistas
     */
    
    //Colectivo con página web
    public Collective (Artist firstArtist, String name, String workDescription, String webSite) {
        
        super(name, workDescription, webSite);
        artists.add(firstArtist);
        /**
         * this.name = name;
         * this.workDescription = workDescription;
         * this.webSite = webSite;
         */
        
    }
    
    //Colectivo sin página web
    public Collective (Artist firstArtist, String name, String workDescription) {
        
        super(name, workDescription);
        artists.add(firstArtist);
        /**
         * this.name = name;
         * this.workDescription = workDescription;
         */
        
    }
    
    public void addArtistToCollective (Artist newArtist) {
        artists.add(newArtist);
    }
    
    /*
    public void setName (String name) {
        this.name = name;
    }
    
    //Sobreescribe el método de Performer
    @Override
    public void setWorkDescription (String description) {
        this.workDescription = description;
    }
    
    public void setWebSite (String webSite) {
        this.webSite = webSite;
    }
    
    //Sobreescribe el método de Performer
    @Override
    public String getName() {
        return name;
    }
    
    //Sobreescribe el método de Performer
    @Override
    public String getWorkDescription(){
        return workDescription;
    }
    
    public String getWebSite () {
        this.webSite = webSite;
    }
    */
    
    /* Devuelve verdadero si el artista se encuentra en el colectivo
    *  y falso en caso contrario
    */
    public boolean isArtistInCollective (Artist auxArtist) {
        
        Iterator i = artists.iterator();
        Artist artist = null;
        while (i.hasNext()) {
            artist = (Artist)i.next();
            if (auxArtist.equals(artist)) {
                break;
            }
        }
        if (auxArtist.equals(artist)) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    //Devuelve true si dos colectivos son iguales y false si no son iguales
    @Override
    public boolean equals (Object o) {
        
        if (o instanceof Collective) {
            Collective c = (Collective)o;
            if (this.getName().equalsIgnoreCase(c.getName())) return true;
            else return false;
        }
        else return false;

    }
            
}