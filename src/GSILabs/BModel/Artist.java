/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

/**
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (21/09/2015)
 */
public class Artist {
    
    private String name; // Nombre del artista
    private String workDescription; // Descripción de la obra o trabajo que realiza
    private String webSite; // Página web del artista en concreto
    
    public Artist (String name, String workDescription, String website) {
        
        this.name = name;
        this.workDescription = workDescription;
        this.webSite = website;
        
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }
    
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    
    public String getName() {
        return name;
    }
    
    public String getWorkDescription() {
        return workDescription;
    }
    
    public String getWebSite() {
        return webSite;
    }
    
}
