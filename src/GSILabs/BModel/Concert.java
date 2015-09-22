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
    private Date startTime; //Hora de comienzo
    private Date doorOpeningTime; //Hora de apertura de puertas
    private Date closingTime; //Hora de cierre
    private Location location;
    
    public Concert (Performer p, Date startTime, Date doorOpeningTime, Date closingTime, Location location) {
        
        this.p = p;
        this.startTime = startTime;
        this.doorOpeningTime = doorOpeningTime;
        this.closingTime = closingTime;
        this.location = location;
        
    }
    
    public void setPerformer (Performer p) {
        this.p = p;
    }
    
    public Performer getPerformer () {
        return p;
    }
    
    public void setStartTime (Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getStartTime () {
        return startTime;
    }
    
    public void setDoorOpeningTime (Date doorOpeningTime) {
        this.doorOpeningTime = doorOpeningTime;
    }
    
    public Date getDoorOpeningTime () {
        return doorOpeningTime;
    }
    
    public void setClosingTime (Date closingTime) {
        this.doorOpeningTime = doorOpeningTime;
    }
    
    public Date getClosingTime () {
        return closingTime;
    }
    
    public void setLocation (Location location) {
        this.location = location;
    }
    
    public Location getLocation () {
        return location;
    }
    
}
