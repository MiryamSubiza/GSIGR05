/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (21/09/2015)
 */
public class Artist implements Performer {
    
    private String name; // Nombre del artista
    private String workDescription; // Descripción de la obra o trabajo que realiza
    private String webSite = ""; // Página web del artista en concreto, puede no tener
    
    //Artista con página web
    public Artist (String name, String workDescription, String webSite) {
        
        this.name = name;
        this.workDescription = workDescription;
        this.webSite = webSite;
        
    }
    
    //Artista sin página web
    public Artist (String name, String workDescription) {
        
        this.name = name;
        this.workDescription = workDescription;
        
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    //Sobreescribe el método de Performer
    @Override
    public String getName () {
        return name;
    }
    
    //Sobreescribe el método de Performer
    @Override
    public void setWorkDescription (String workDescription) {
        this.workDescription = workDescription;
    }
    
    //Sobreescribe el método de Performer
    @Override
    public String getWorkDescription () {
        return workDescription;
    }
    
    public void setWebSite (String webSite) {
        this.webSite = webSite;
    }
    
    public String getWebSite () {
        return webSite;
    }
    
    //Devuelve true si dos artistas son iguales y false si no son iguales
    @Override
    public boolean equals (Object o) {
        
        if (o instanceof Artist) {
            Artist a = (Artist)o;
            if (this.getName().equalsIgnoreCase(a.getName())) return true;
            else return false;
        }
        else return false;

    }

}
