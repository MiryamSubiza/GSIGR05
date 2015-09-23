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
 * @version 1.0 (23/09/2015)
 */
public class Location {
    
    private String name; // Nombre de la localización
    private int aforoMax; // Aforo máximo 
    private String posicionGeografica; // Posición geográfica de la localización
    private String website = ""; // Página web de la localización, puede no tener página web
    
    public Location (String name, int aforoMax, String posicionGeografica, String website){
        
        this.name = name;
        this.aforoMax = aforoMax;
        this.posicionGeografica = posicionGeografica;
        this.website = website;
        
    }
    
    public Location (String name, int aforoMax, String posicionGeografica){
        
        this.name = name;
        this.aforoMax = aforoMax;
        this.posicionGeografica = posicionGeografica;
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAforoMax(int aforoMax){
        this.aforoMax = aforoMax;
    }
    
    public void setPosicionGeografica(String posicionGeografica){
        this.posicionGeografica = posicionGeografica;
    }
    
    public void setWebsite(String website){
        this.website = website;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAforoMax(){
        return aforoMax;
    }
    
    public String getPosicionGeografica(){
        return posicionGeografica;
    }
    
    public String getWebsite(){
        return website;
    }
}
