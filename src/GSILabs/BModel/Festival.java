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
import java.util.Set;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (22/09/2015)
 */
public class Festival {
    
    /* Este conjunto no admite duplicados, es decir, no puede contener dos elementos 
    * e1 y e2 tal que e1.equals(e2))
    */
    private Set <Concert> concerts; //Puede haber uno o varios conciertos
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
    
    public Festival (Concert c, Date startDateFestival, Date closingDateFestival,
            Date startTimeFestival, Date closingTimeFestival) {
        
        concerts.add(c);
        this.startDateFestival = startDateFestival;
        this.closingDateFestival = closingDateFestival;
        this.startTimeFestival = startTimeFestival;
        this.closingTimeFestival = closingTimeFestival;
        
    }
    
    public void addConcert (Concert c) {
        concerts.add(c);
    }
    
    public void setStartDateFestival (Date startDateFestival) {
        this.startDateFestival = startDateFestival;
    }
    
    public Date getStartDateFestival () {
        return startDateFestival;
    }
    
    public void setClosingDateFestival (Date closingDateFestival) {
        this.closingDateFestival = closingDateFestival;
    }
    
    public Date getClosingDateFestival () {
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
    
}
