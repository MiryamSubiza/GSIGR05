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
    private FechasHoras startDateFestival;
    // Fecha de cierre, que coincide con la fecha del último concierto
    private FechasHoras closingDateFestival;
    // Hora de apertura, que coincide con la hora de apertura de puertas
    // del primer concierto
    private FechasHoras startTimeFestival;
    // Hora de cierre, que coincide con la hora de cierre del último concierto
    private FechasHoras closingTimeFestival;
    // Nombre del festival
    private String festivalName;
    
    public Festival (String festivalName, Concert c, FechasHoras startDateFestival, FechasHoras closingDateFestival,
            FechasHoras startTimeFestival, FechasHoras closingTimeFestival) {
        
        this.festivalName = festivalName;
        concerts = new HashSet();
        concerts.add(c);
        this.startDateFestival = startDateFestival;
        this.closingDateFestival = closingDateFestival;
        this.startTimeFestival = startTimeFestival;
        this.closingTimeFestival = closingTimeFestival;
        
    }
	
    public Festival (String festivalName, HashSet<Concert> concerts, FechasHoras startDateFestival, FechasHoras closingDateFestival,
        FechasHoras startTimeFestival, FechasHoras closingTimeFestival) {

        this.festivalName = festivalName;
        this.concerts = concerts;
        this.startDateFestival = startDateFestival;
        this.closingDateFestival = closingDateFestival;
        this.startTimeFestival = startTimeFestival;
        this.closingTimeFestival = closingTimeFestival;
        
    }
    
    public void addConcert (Concert c) {
        concerts.add(c);
    }
	
    public boolean removeConcert (Concert c) {
        return concerts.remove(c);
    }
	
    public HashSet<Concert> getConcerts(){
        return concerts;
    }
    
    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }
    
    @Override
    public String getName() {
        return this.festivalName;
    }
    
    public void setStartDateFestival (FechasHoras startDateFestival) {
        this.startDateFestival = startDateFestival;
    }
    
    @Override
    public Date getStartDate () {
        return startDateFestival;
    }
    
    public void setClosingDateFestival (FechasHoras closingDateFestival) {
        this.closingDateFestival = closingDateFestival;
    }
    
    @Override
    public Date getEndingDate () {
        return closingDateFestival;
    }
    
    public void setStartTimeFestival (FechasHoras startTimeFestival) {
        this.startTimeFestival = startTimeFestival;
    }
    
    public Date getStartTimeFestival () {
        return startTimeFestival;
    }
    
    public void setClosingTimeFestival (FechasHoras closingTimeFestival) {
        this.closingTimeFestival = closingTimeFestival;
    }
    
    public Date getClosingTimeFestival () {
        return closingTimeFestival;
    }
    
    /* Devuelve verdadero si el concierto se encuentra en el festival
    *  y falso en caso contrario
    */
    public boolean isConcertInFestival (Concert auxConcert) {
        
        if (concerts.contains(auxConcert)) return true;
        else return false;
        
    }
    
    @Override
    public Date[] getDates() {
        ArrayList <Date> al = new ArrayList();
        FechasHoras auxDate = startDateFestival;
        for (int i=0; i<(calculateFestivalDays(startDateFestival, closingDateFestival)); i++) {
            al.add(auxDate);
            auxDate = incrementDay(auxDate);
        }
        Date[] datesFestival = new Date[al.size()];
        al.toArray();
        return datesFestival;
    }
    
    private int calculateFestivalDays (FechasHoras dia1, FechasHoras dia2) {
        
        // Variable a devolver que contendrá el número de días de diferencia entre una fecha y otra
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
    
    public Performer[] getPerformers() {
        
        ArrayList <Performer> al = new ArrayList();
        Iterator i = concerts.iterator();
        Concert concertAux = null;
        int j = 0;
        while(i.hasNext()){
            concertAux = (Concert)i.next();
            al.add(concertAux.getPerformer());
            j = j + 1;
        }
        Performer[] performers = new Performer[al.size()];
        al.toArray();
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
