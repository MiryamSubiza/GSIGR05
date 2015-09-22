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
public class Exhibition {
    
    private String title;
    private String organizerName; //Nombre de la entidad organizadora
    private Date startDate; //Fecha de apertura
    private Date closingDate; //Fecha de cierre
    private Date startTime; //Hora de apertura
    private Performer p; //Puede ser un artista o varios, en cuyo caso se considerará colectivo
    private ArrayList <String> webLinks; //Enlaces web (número indeterminado)
    private Location location;
    
    public Exhibition (String title, String organizerName, Date startDate, Date closingDate, Date startTime, 
            Performer p, String webLink, Location location) {
        
        this.title = title;
        this.organizerName = organizerName;
        this.startDate = startDate;
        this.closingDate = closingDate;
        this.startTime = startTime;
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
    
    public String getOrganizerName () {
        return organizerName;
    }
    
    public void setStartDate (Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getStartDate () {
        return startDate;
    }
    
    public void setClosingDate (Date closingDate) {
        this.closingDate = closingDate;
    }
    
    public Date getClosingDate () {
        return closingDate;
    }
    
    public void setStartTime (Date startTime) {
        this.startTime = startTime;
    }
    
    public Date getStartTime () {
        return startTime;
    }
    
    public void setPerformer (Performer p) {
        this.p = p;
    }
    
    public Performer getPerformer () {
        return p;
    }
    
    public void addWebLinks (String webLink) {
        webLinks.add(webLink);
    }
    
    public void setLocation (Location location) {
        this.location = location;
    }
    
    public Location getLocation () {
        return location;
    }
    
}
