package GSILabs.BModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
