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
    private FechasHoras startDateExhibition; //Fecha de apertura
    private FechasHoras closingDateExhibition; //Fecha de cierre
    private FechasHoras startTimeExhibition; //Hora de apertura
    private FechasHoras closingTimeExhibition; //Hora de cierre
    private Performer p; //Puede ser un artista o varios, en cuyo caso se considerará colectivo
    private HashSet <String> webLinks; //Enlaces web (número indeterminado)
    private Location location; //Esta localización es única
    
    public Exhibition (String exhibitionName, String title, String organizerName, 
            FechasHoras startDateExhibition, FechasHoras closingDateExhibition, FechasHoras startTimeExhibition,
            FechasHoras closingTimeExhibition, Performer p, String webLink, Location location) {
        
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
    
    public void setStartDateExhibition (FechasHoras startDateExhibition) {
        this.startDateExhibition = startDateExhibition;
    }
    
    @Override
    public Date getStartDate () {
        return startDateExhibition;
    }
    
    public void setClosingDateExhibition (FechasHoras closingDateExhibition) {
        this.closingDateExhibition = closingDateExhibition;
    }
    
    @Override
    public Date getEndingDate () {
        return closingDateExhibition;
    }
    
    public void setStartTimeExhibition (FechasHoras startTimeExhibition) {
        this.startTimeExhibition = startTimeExhibition;
    }
    
    public Date getStartTimeExhibition () {
        return startTimeExhibition;
    }
    
    public void setClosingTimeExhibition (FechasHoras closingTimeExhibition) {
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
        FechasHoras auxDate = startDateExhibition;
        for(int i=0; i<(calculateExhibitionDays(startDateExhibition, closingDateExhibition)); i++) {
            al.add(auxDate);
            auxDate = incrementDay(auxDate);
        }
        Date[] datesExhibition = new Date[al.size()];
        al.toArray();
        return datesExhibition;
    }
    
    private int calculateExhibitionDays (FechasHoras dia1, FechasHoras dia2) {
        
        // Variable a devolver que contendra el numero de dias de diferencia entre una fecha y otra
        int numDias;
        if ((dia2.getMes() - dia1.getMes()) >= 1) {
            numDias = 30*(dia2.getMes() - dia1.getMes() - 1) + dia2.getDia() + 
                    (numDiasMes(dia1.getMes()) - dia1.getDia());
        }
        else {
            numDias = dia2.getDia() - dia1.getDia();
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
    
    // El método coge la fecha que se le pasa como argumento y
    // aumenta un día (cambiando si es necesario el mes o año de la fecha)
    private FechasHoras incrementDay (FechasHoras day) {
        FechasHoras nextDay = null;
        switch (day.getMes()){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if(day.getDia() == 31){
                    if(day.getMes() == 12){
                        nextDay = new FechasHoras(1, 1, day.getAnio()+1, day.getHora(), day.getMinuto());
                    }
                    else{
                        nextDay = new FechasHoras(1, day.getMes() + 1, day.getAnio(), day.getHora(), day.getMinuto());
                    }
                }
                else{
                    nextDay = new FechasHoras(day.getDay() + 1, day.getMes(), day.getAnio(), day.getHora(), day.getMinuto());
                }
                break;
                
            case 4: case 6: case 9: case 11:
                if(day.getDia() == 30){
                    nextDay = new FechasHoras(1, day.getMes() + 1, day.getAnio(), day.getHora(), day.getMinuto());
                }
                else{
                    nextDay = new FechasHoras(day.getDia() + 1, day.getMes(), day.getAnio(), day.getHora(), day.getMinuto());
                }
                break;
                
            case 2:
                if(day.getDia() == 28){
                    nextDay = new FechasHoras(1, day.getMes() + 1, day.getAnio(), day.getHora(), day.getMinuto());
                }
                else{
                    nextDay = new FechasHoras(day.getDia() + 1, day.getMes(), day.getAnio(), day.getHora(), day.getMinuto());
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
        
        Performer[] performers = new Performer[1];
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