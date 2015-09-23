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
    
    public void setStartDateExhibition (Date startDateExhibition) {
        this.startDateExhibition = startDateExhibition;
    }
    
    public Date getStartDate () {
        return startDateExhibition;
    }
    
    public void setEndingDate (Date closingDateExhibition) {
        this.closingDateExhibition = closingDateExhibition;
    }
    
    public Date getClosingDateExhibition () {
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
        Date[] datesExhibition;
        Date auxDate = startDateExhibition;
        for(int i=0;i<(calcularDiasExibicion(startDateExhibition, closingDateExhibition));i++){
            datesExhibition[i] = auxDate;
            auxDate = aumentarDia(auxDate);
        }
        return datesExhibition;
    }
    
    // HAY QUE IMPLEMENTAR LOS DOS METODOS INVENTADOS DE ARRIBA
    
}
