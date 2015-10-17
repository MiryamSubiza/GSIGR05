/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Información sobre colectivos, este tipo de performers son asociados a eventos
 * @author subiza.79082
 * @author izu.78236
 * @version 03/10/2015
 */
public class Collective implements Performer {
    
    //Ha de ser una colección sin ordenación -> HashSet no tiene ordenación y no permite duplicados
    private HashSet <Artist> artists; // Todos los artistas que componen el colectivo
    private String name;
    private String workDescription;
    private String webSite = "-";
    
    /**
     * Primer método constructor, inicialización de variables para un colectivo
     * con página web
     * @param firstArtist Primer artista que compone el colectivo
     * @param name Nombre del colectivo de artistas
     * @param workDescription Descripción del colectivo de artistas
     * @param webSite Página web
     */
    public Collective (Artist firstArtist, String name, String workDescription, String webSite) {
        
        artists = new HashSet();
        artists.add(firstArtist);
        this.name = name;
        this.workDescription = workDescription;
        this.webSite = webSite;
        
    }
    
    /**
     * Primer método constructor, inicialización de variables para un colectivo
     * sin página web
     * @param firstArtist Primer artista que compone el colectivo
     * @param name Nombre del colectivo de artistas
     * @param workDescription Descripción del colectivo de artistas
     */
    public Collective (Artist firstArtist, String name, String workDescription) {
        
        artists = new HashSet();
        artists.add(firstArtist);
        this.name = name;
        this.workDescription = workDescription;
        
    }
    
    /**
     * Añadir un artista al colectivo de artistas
     * @param newArtist Artista a añadir
     */
    public void addArtistToCollective (Artist newArtist) {
        artists.add(newArtist);
    }
    
    /**
     * Establecer nombre del colectivo
     * @param name Nombre del colectivo
     */
    public void setName (String name) {
        this.name = name;
    }
    
    /**
     * Establecer descripción del colectivo de artistas
     * @param description Descripción del colectivo de artistas
     */
    @Override
    public void setWorkDescription (String description) {
        this.workDescription = description;
    }
    
    /**
     * Establecer página web
     * @param webSite Página web
     */
    public void setWebSite (String webSite) {
        this.webSite = webSite;
    }
    
    /**
     * Obtener nombre artístico
     * @return Nombre artístico
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Obtener descripción del colectivo de artistas
     * @return Descripción del colectivo de artistas
     */
    @Override
    public String getWorkDescription(){
        return workDescription;
    }
    
    /**
     * Obtener página web
     * @return página web
     */
    public String getWebSite () {
        return webSite;
    }
    
    /**
     * Comprobar si un artista se encuentra en este colectivo
     * @return True si el artista se encuentra en el colectivo. False en caso contrario
     */
    public boolean isArtistInCollective (Artist auxArtist) {
        
        Iterator i = artists.iterator();
        Artist artist = null;
        while (i.hasNext()) {
            if (auxArtist.equals((Artist)i.next())) return true;
        }
        return false;
        
    }
    
    /**
     * Eliminar un artista del colectivo
     * @param a Artista a eliminar
     * @return True si el artista ha sido eliminado. False en caso contrario
     */
    public boolean removeArtist(Artist a){
        // Si el HashSet de artistas contiene dicho artista lo elimino
        if(artists.contains(a)) return artists.remove(a);
        // El artista no esta en el HashSet
        else return false;        
    }
    
    /**
     * Comparación entre dos objetos Coletivo
     * @param o Objeto a comparar
     * @return True si tienen el mismo nombre. False en caso contrario
     */
    @Override
    public boolean equals (Object o) {
        
        if (o instanceof Collective) {
            Collective c = (Collective)o;
            return this.getName().equalsIgnoreCase(c.getName());
        }
        else return false;

    }
    
    /**
     * Representación por pantalla
     * @return Información a mostrar
     */
    @Override
    public String toString () {
        return "COLLECTIVE\nName: " + name + "\nWork description: " + workDescription + 
                "\nWebsite: " + webSite + "\n";
    }
            
}