/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (21/09/2015)
 */
public class Exhibition implements LastingEvent, Event{
    
    private String title;
    private String organizerName; //Nombre de la entidad organizadora
    private Date startDateExhibition; //Fecha de apertura
    private Date closingDateExhibition; //Fecha de cierre
    private Date startTimeExhibition; //Hora de apertura
    private Performer p; //Puede ser un artista o varios, en cuyo caso se considerará colectivo
    private ArrayList <String> webLinks; //Enlaces web (número indeterminado)
    private Location location;
    
    public Exhibition (String title, String organizerName, Date startDateExhibition, 
            Date closingDateExhibition, Date startTimeExhibition, 
            Performer p, String webLink, Location location) {
        
        this.title = title;
        this.organizerName = organizerName;
        this.startDateExhibition = startDateExhibition;
        this.closingDateExhibition = closingDateExhibition;
        this.startTimeExhibition = startTimeExhibition;
        this.p = p;
        webLinks.add(webLink);
        this.location = location;
        
    }
    
    public void setTitle (String title) {
        this.title = title;
    }
    
    public String getTitle () {
        return title;
    }
    
    public void setOrganizerName (String organizerName) {
        this.organizerName = organizerName;
    }
    
    public String getName () {
        return organizerName;
    }
    
    public void setStartDate (Date startDateExhibition) {
        this.startDateExhibition = startDateExhibition;
    }
    
    public Date getStartDate () {
        return startDateExhibition;
    }
    
    public void setEndingDate (Date closingDateExhibition) {
        this.closingDateExhibition = closingDateExhibition;
    }
    
    public Date getEndingDate () {
        return closingDateExhibition;
    }
    
    public void setStartTimeExhibition (Date startTimeExhibition) {
        this.startTimeExhibition = startTimeExhibition;
    }
    
    public Date getStartTimeExhibition () {
        return startTimeExhibition;
    }
    
    public void setPerformer (Performer p) {
        this.p = p;
    }
    
    public Performer getPerformer () {
        return p;
    }
    
    public void addWebLink (String webLink) {
        webLinks.add(webLink);
    }
    
    public void setLocation (Location location) {
        this.location = location;
    }
    
    public Location getLocation () {
        return location;
    }
    
    public Date[] getDates(){
        Date[] datesExhibition = null;
        Date auxDate = startDateExhibition;
        for(int i=0;i<(calcularDiasExibicion(startDateExhibition, closingDateExhibition));i++){
            datesExhibition[i] = auxDate;
            auxDate = aumentarDia(auxDate);
        }
        return datesExhibition;
    }
    
    private int calcularDiasExibicion(Date dia1, Date dia2){
        
        int numDias = 0; // Variable a devolver que contendra el numero de dias de diferencia entre una fecha y otra
        if((dia2.getMonth() - dia1.getMonth()) >= 1){

            numDias = 30*(dia2.getMonth() - dia1.getMonth() - 1) + dia2.getDay() + (numDiasMes(dia1.getMonth()) - dia1.getDay());
           
        }
        else{
            numDias = dia2.getDay() - dia1.getDay();
        }
        
        return numDias;
    }
    
    private int numDiasMes (int mes){
        int nDias;
        switch(mes){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                nDias = 31;
                break;
            case 4: case 6: case 9: case 11:
                nDias = 30;
                break;
            case 2:
                nDias = 28;
                break;
            default:
                nDias = 30;
        }
        
        return nDias;
    }
    
    private Date aumentarDia(Date dia){
        Date proximoDia = null;
        switch (dia.getMonth()){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if(dia.getDay() == 31){
                    if(dia.getMonth() == 12){
                        proximoDia = new Date(dia.getYear()+1, 1, 1);
                    }
                    else{
                        proximoDia = new Date(dia.getYear(), dia.getMonth() + 1, 1);
                    }
                }
                else{
                    proximoDia = new Date(dia.getYear(), dia.getMonth(), dia.getDay() + 1);
                }
                break;
                
            case 4: case 6: case 9: case 11:
                if(dia.getDay() == 30){
                    proximoDia = new Date(dia.getYear(), dia.getMonth() + 1, 1);
                }
                else{
                    proximoDia = new Date(dia.getYear(), dia.getMonth(), dia.getDay() + 1);
                }
                break;
                
            case 2:
                if(dia.getDay() == 28){
                    proximoDia = new Date(dia.getYear(), dia.getMonth() + 1, 1);
                }
                else{
                    proximoDia = new Date(dia.getYear(), dia.getMonth(), dia.getDay() + 1);
                }
                break;
        }
        
        return proximoDia;
    }
    
    public Performer[] getPerformers(){
        
        Performer[] performers = null;
        performers[0] = p;
        return performers;
        
    }
    
    public boolean involvesPerformer(Performer p){
        
        if(p.getName().equalsIgnoreCase(this.p.getName()))
            return true;
        else{
            return false;
        }
        
    }
    
    
    // HAY QUE IMPLEMENTAR LOS DOS METODOS INVENTADOS DE ARRIBA
    
}
