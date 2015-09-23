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
public class Collective implements Performer{
    
    private String name; // EL nombre del colectivo de artistas
    private ArrayList <Artist> artists; // Todos los artistas que componen el colectivo
    private String workDescription; // Descripción del colectivo de artistas
    private String webSite; // Página web de dicho colectivo de artistas
    
    public Collective (String name, Artist primerArtista, String description, String webSite) {
        
        this.name = name;
        artists.add(primerArtista);
        this.workDescription = description;
        this.webSite = webSite;
        
    }
    
    public void addArtistToCollective (Artist newArtist) {
        artists.add(newArtist);
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    @Override
    public void setWorkDescription (String description) {
        this.workDescription = description;
    }
    
    public void setWebSite (String webSite) {
        this.webSite = webSite;
    }
    
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
    
    @Override
    public String getWorkDescription(){
        return workDescription;
    }

    @Override
    public String getName() {
        return name;
    }
            
}
