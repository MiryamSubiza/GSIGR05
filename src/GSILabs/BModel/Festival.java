/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.BModel;

import java.util.Date;
import java.util.Iterator;
import java.util.HashSet;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (22/09/2015)
 */
public class Festival implements LastingEvent {
    
    /* Este conjunto no admite duplicados, es decir, no puede contener dos elementos 
    * e1 y e2 tal que e1.equals(e2))
    */
    private HashSet <Concert> concerts; //Puede haber uno o varios conciertos
    /* El festival puede extenderse durante varios días o semanas */
    // Fecha de apertura, que coincide con la fecha del primer concierto
    private Date startDateFestival;
    // Fecha de cierre, que coincide con la fecha del último concierto
    private Date closingDateFestival;
    // Hora de apertura, que coincide con la hora de apertura de puertas
    // del primer concierto
    private Date startTimeFestival;
    // Hora de cierre, que coincide con la hora de cierre del último concierto
    private Date closingTimeFestival;
    // Nombre del festival
    private String festivalName;
    
    public Festival (String festivalName, Concert c, Date startDateFestival, Date closingDateFestival,
            Date startTimeFestival, Date closingTimeFestival) {
        
        this.festivalName = festivalName;
        concerts = new HashSet();
        concerts.add(c);
        this.startDateFestival = startDateFestival;
        this.closingDateFestival = closingDateFestival;
        this.startTimeFestival = startTimeFestival;
        this.closingTimeFestival = closingTimeFestival;
        
    }
    
    public void addConcert (Concert c) {
        concerts.add(c);
    }
    
    public void setFestivalName(String festivalName){
        this.festivalName = festivalName;
    }
    
    @Override
    public String getName(){
        return this.festivalName;
    }
    
    public void setStartDateFestival (Date startDateFestival) {
        this.startDateFestival = startDateFestival;
    }
    
    @Override
    public Date getStartDate () {
        return startDateFestival;
    }
    
    public void setClosingDateFestival (Date closingDateFestival) {
        this.closingDateFestival = closingDateFestival;
    }
    
    @Override
    public Date getEndingDate () {
        return closingDateFestival;
    }
    
    public void setStartTimeFestival (Date startTimeFestival) {
        this.startTimeFestival = startTimeFestival;
    }
    
    public Date getStartTimeFestival () {
        return startTimeFestival;
    }
    
    public void setClosingTimeFestival (Date closingTimeFestival) {
        this.closingTimeFestival = closingTimeFestival;
    }
    
    public Date getClosingTimeFestival () {
        return closingTimeFestival;
    }
    
    /* Devuelve verdadero si el concierto se encuentra en el festival
    *  y falso en caso contrario
    */
    public boolean isConcertInFestival (Concert auxConcert) {
        
        Iterator i = concerts.iterator();
        Concert concert = null;
        while (i.hasNext()) {
            concert = (Concert)i.next();
            if (auxConcert.equals(concert)) {
                break;
            }
        }
        if (auxConcert.equals(concert)) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    @Override
    public Date[] getDates() {
        Date[] datesFestival = null;
        Date auxDate = startDateFestival;
        for (int i=0; i<(calculateFestivalDays(startDateFestival, closingDateFestival)); i++) {
            datesFestival[i] = auxDate;
            auxDate = incrementDay(auxDate);
        }
        return datesFestival;
    }
    
    private int calculateFestivalDays (Date dia1, Date dia2) {
        
        // Variable a devolver que contendrá el número de días de diferencia entre una fecha y otra
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
        switch (mes) {
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
        switch (day.getMonth()){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if(day.getDay() == 31){
                    if(day.getMonth() == 12){
                        nextDay = new Date(day.getYear()+1, 1, 1);
                    }
                    else{
                        nextDay = new Date(day.getYear(), day.getMonth() + 1, 1);
                    }
                }
                else{
                    nextDay = new Date(day.getYear(), day.getMonth(), day.getDay() + 1);
                }
                break;
                
            case 4: case 6: case 9: case 11:
                if(day.getDay() == 30){
                    nextDay = new Date(day.getYear(), day.getMonth() + 1, 1);
                }
                else{
                    nextDay = new Date(day.getYear(), day.getMonth(), day.getDay() + 1);
                }
                break;
                
            case 2:
                if(day.getDay() == 28){
                    nextDay = new Date(day.getYear(), day.getMonth() + 1, 1);
                }
                else{
                    nextDay = new Date(day.getYear(), day.getMonth(), day.getDay() + 1);
                }
                break;
        }
        
        return nextDay;
    }
    
    @Override
    public boolean involvesPerformer (Performer p) {
        
        Iterator i = concerts.iterator();
        Concert concertAux = null;
        while (i.hasNext()) {
            concertAux = (Concert)i.next();
            if (concertAux.involvesPerformer(p)) {
                break;
            }
        }
        if (concertAux.involvesPerformer(p)) return true;
        else return false;
        
    }
    
    public Performer[] getPerformers(){
        
        Iterator i = concerts.iterator();
        Performer[] performers = null;
        Concert concertAux = null;
        int j = 0;
        while(i.hasNext()){
            concertAux = (Concert)i.next();
            performers[j] = concertAux.getPerformer();
            j = j + 1;
        }
        return performers;
    
    }
    
    @Override
    public boolean equals (Object o) {
        
        if (o instanceof Festival) {
            Festival f = (Festival)o;
            if (this.getName().equalsIgnoreCase(f.getName())) return true;
            else return false;
        }
        else return false;
        
    }
    
    @Override
    public String toString() {
        return "FESTIVAL\nFestival's name: " + festivalName + "\nStart date: " + 
                startDateFestival + "\nStart time: " + startTimeFestival + 
                "h\nClosing date: " + closingDateFestival +
                "\nClosing time: " + closingTimeFestival + "h\n";
    }

}