/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Date;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (21/09/2015)
 */
public class Concert {
    
    private Performer p; //Puede ser Artista o Colectivo, pero solamente uno
    private Date startTimeConcert; //Hora de comienzo
    private Date doorOpeningTimeConcert; //Hora de apertura de puertas
    private Date closingTimeConcert; //Hora de cierre
    private Location location;
    
    public Concert (Performer p, Date startTimeConcert, Date doorOpeningTimeConcert, 
            Date closingTimeConcert, Location location) {
        
        this.p = p;
        this.startTimeConcert = startTimeConcert;
        this.doorOpeningTimeConcert = doorOpeningTimeConcert;
        this.closingTimeConcert = closingTimeConcert;
        this.location = location;
        
    }
    
    public void setPerformer (Performer p) {
        this.p = p;
    }
    
    public Performer getPerformer () {
        return p;
    }
    
    public void setStartTimeConcert (Date startTimeConcert) {
        this.startTimeConcert = startTimeConcert;
    }
    
    public Date getStartTimeConcert () {
        return startTimeConcert;
    }
    
    public void setDoorOpeningTimeConcert (Date doorOpeningTimeConcert) {
        this.doorOpeningTimeConcert = doorOpeningTimeConcert;
    }
    
    public Date getDoorOpeningTimeConcert () {
        return doorOpeningTimeConcert;
    }
    
    public void setClosingTimeConcert (Date closingTimeConcert) {
        this.doorOpeningTimeConcert = doorOpeningTimeConcert;
    }
    
    public Date getClosingTimeConcert () {
        return closingTimeConcert;
    }
    
    public void setLocation (Location location) {
        this.location = location;
    }
    
    public Location getLocation () {
        return location;
    }
    
}
