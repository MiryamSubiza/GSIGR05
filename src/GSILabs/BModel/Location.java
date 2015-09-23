package GSILabs.BModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Location {
    
    private String name;
    private int aforoMax;
    private String posicionGeografica;
    private String website = "";
    
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
