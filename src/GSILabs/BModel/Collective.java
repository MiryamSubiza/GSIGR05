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
public class Collective {
    
    private String name; // EL nombre del colectivo de artistas
    private ArrayList <Artist> artists; // Todos los artistas que componen el colectivo
    private String descripcion; // Descripcion del colectivo de artistas
    private String website; // Página web de dicho colectivo de artistas
    
    public Collective (String name, Artist primerArtista, String descripcion, String website){
        
        this.name = name;
        artists.add(primerArtista);
        this.descripcion = descripcion;
        this.website = website;
        
    }
    
    public void addArtistToCollective (Artist newArtist){
        
        artists.add(newArtist);
        
    }
    
    public void setName(String name){
        
        this.name = name;
        
    }
    
    public void setDescripcion(String descripcion){
        
        this.descripcion = descripcion;
        
    }
    
    public void setWebsite(String websit){
        
        this.website = website;
        
    }
    
    public boolean isArtistInCollective (Artist auxArtist){
        
        Iterator i = artists.iterator();
        Artist artista = null;
        while(i.hasNext()){
            artista = (Artist)i.next();
            if(auxArtist.equals(artista)){
                break;
            }
        }
        if(auxArtist.equals(artista)){
            return true;
        }
        else{
            return false;
        }
    }
            
}
