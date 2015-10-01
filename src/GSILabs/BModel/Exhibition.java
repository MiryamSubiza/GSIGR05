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
import java.util.HashSet;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (21/09/2015)
 */
public class Exhibition implements LastingEvent {
    
    /* La exposición puede extenderse durante varios días o semanas */
    private String exhibitionName; //Nombre de la exposición
    private String title; //Título de la exposición
    private String organizerName; //Nombre de la entidad organizadora
    private Date startDateExhibition; //Fecha de apertura
    private Date closingDateExhibition; //Fecha de cierre
    private Date startTimeExhibition; //Hora de apertura
    private Date closingTimeExhibition; //Hora de cierre
    private Performer p; //Puede ser un artista o varios, en cuyo caso se considerará colectivo
    private HashSet <String> webLinks; //Enlaces web (número indeterminado)
    private Location location; //Esta localización es única
    
    public Exhibition (String exhibitionName, String title, String organizerName, 
            Date startDateExhibition, Date closingDateExhibition, Date startTimeExhibition,
            Date closingTimeExhibition, Performer p, String webLink, Location location) {
        
        this.exhibitionName = exhibitionName;
        this.title = title;
        this.organizerName = organizerName;
        this.startDateExhibition = startDateExhibition;
        this.closingDateExhibition = closingDateExhibition;
        this.startTimeExhibition = startTimeExhibition;
        this.closingTimeExhibition = closingTimeExhibition;
        this.p = p;
        webLinks = new HashSet();
        webLinks.add(webLink);
        this.location = location;
        
    }
    
    public void setExhibitionName (String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }
    
    @Override
    public String getName () {
        return exhibitionName;
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
    
    public String getOrganizerName () {
        return organizerName;
    }
    
    public void setStartDateExhibition (Date startDateExhibition) {
        this.startDateExhibition = startDateExhibition;
    }
    
    @Override
    public Date getStartDate () {
        return startDateExhibition;
    }
    
    public void setClosingDateExhibition (Date closingDateExhibition) {
        this.closingDateExhibition = closingDateExhibition;
    }
    
    @Override
    public Date getEndingDate () {
        return closingDateExhibition;
    }
    
    public void setStartTimeExhibition (Date startTimeExhibition) {
        this.startTimeExhibition = startTimeExhibition;
    }
    
    public Date getStartTimeExhibition () {
        return startTimeExhibition;
    }
    
    public void setClosingTimeExhibition (Date closingTimeExhibition) {
        this.closingTimeExhibition = closingTimeExhibition;
    }
    
    public Date getClosingTimeExhibition () {
        return closingTimeExhibition;
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
    
    @Override
    public Date[] getDates() {
        ArrayList <Date> al = new ArrayList();
        Date auxDate = startDateExhibition;
        for(int i=0; i<(calculateExhibitionDays(startDateExhibition, closingDateExhibition)); i++) {
            al.add(auxDate);
            auxDate = incrementDay(auxDate);
        }
        Date[] datesExhibition = new Date[al.size()];
        al.toArray();
        return datesExhibition;
    }
    
    private int calculateExhibitionDays (Date dia1, Date dia2) {
        
        // Variable a devolver que contendra el numero de dias de diferencia entre una fecha y otra
        int numDias;
        if ((dia2.getMonth() - dia1.getMonth()) >= 1) {
            numDias = 30*(dia2.getMonth() - dia1.getMonth() - 1) + dia2.getDay() + 
                    (numDiasMes(dia1.getMonth()) - dia1.getDay());
        }
        else {
            numDias = dia2.getDay() - dia1.getDay();
        }
        
        return numDias;
    }
    
    private int numDiasMes (int mes) {
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
    
    private Date incrementDay (Date day) {
        Date nextDay = null;
        switch (day.getMonth()) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (day.getDay() == 31) {
                    if (day.getMonth() == 12) {
                        nextDay = new Date(day.getYear()+1, 1, 1);
                    }
                    else {
                        nextDay = new Date(day.getYear(), day.getMonth() + 1, 1);
                    }
                }
                else {
                    nextDay = new Date(day.getYear(), day.getMonth(), day.getDay() + 1);
                }
                break;
                
            case 4: case 6: case 9: case 11:
                if (day.getDay() == 30) {
                    nextDay = new Date(day.getYear(), day.getMonth() + 1, 1);
                }
                else {
                    nextDay = new Date(day.getYear(), day.getMonth(), day.getDay() + 1);
                }
                break;
                
            case 2:
                if (day.getDay() == 28) {
                    nextDay = new Date(day.getYear(), day.getMonth() + 1, 1);
                }
                else {
                    nextDay = new Date(day.getYear(), day.getMonth(), day.getDay() + 1);
                }
                break;
        }
        
        return nextDay;
    }
    
    @Override
    public boolean involvesPerformer (Performer p) {
        
        if (p.equals(this.p)) return true;
        else return false;
        
    }
    
    @Override
    public Performer[] getPerformers() {
        
        Performer[] performers = null;
        performers[0] = p;
        return performers;
        
    }
    
    @Override
    public boolean equals (Object o) {
        
        if (o instanceof Exhibition) {
            Exhibition e = (Exhibition)o;
            if (this.getName().equalsIgnoreCase(e.getName())) return true;
            else return false;
        }
        else return false;
        
    }
    
    @Override
    public String toString() {
        return "EXHIBITION\nExhibition's name: " + exhibitionName + "\nTitle: " +
                title + "\nOrganizer name: " + organizerName + "\nStart date: " + 
                startDateExhibition + "\nStart time: " + 
                startTimeExhibition + "h\nClosing date: " + 
                closingDateExhibition + "\nClosing time: " + 
                closingTimeExhibition+ "h\nPerformer: " + p.getName() + 
                "\nLocation: " + location.getName() + "\n";
    }
    
}