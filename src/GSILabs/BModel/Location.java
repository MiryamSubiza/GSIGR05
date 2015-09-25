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
    
    private String name; //Nombre de la localización
    private int maxCapacity; //Aforo máximo 
    private String geographicPosition; //Posición geográfica de la localización
    private String webSite = "-"; //Enlace web oficial de la localización, puede no tener
    
    //Localización con enlace web oficial
    public Location (String name, int maxCapacity, String geographicPosition, String webSite) {
        
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.geographicPosition = geographicPosition;
        this.webSite = webSite;
        
    }
    
    //Localización sin enlace web oficial
    public Location (String name, int maxCapacity, String geographicPosition) {
        
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.geographicPosition = geographicPosition;
        
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setMaxCapacity (int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    
    public int getMaxCapacity () {
        return maxCapacity;
    }
    
    public void setGeographicPosition (String geographicPosition) {
        this.geographicPosition = geographicPosition;
    }
    
    public String getGeographicPosition () {
        return geographicPosition;
    }
    
    public void setWebSite (String webSite) {
        this.webSite = webSite;
    }
    
    public String getWebSite(){
        return webSite;
    }
    
    @Override
    public boolean equals (Object o) {
        
        if (o instanceof Location) {
            Location l = (Location)o;
            if (this.getName().equalsIgnoreCase(l.getName())) return true;
            else return false;
        }
        else return false;
        
    }
    
    @Override
    public String toString() {
        return "LOCATION\nLocation's name: " + name + "\nMaximum capacity: " + 
                maxCapacity + "\nGeographic position: " + geographicPosition + 
                "\nWebsite: " + webSite + "\n";
    }
    
}