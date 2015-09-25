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
public class Concert implements ImpermanentEvent, Event {
    
    private String concertName; //Nombre asociado con el evento
    private Performer p; //Puede ser Artista o Colectivo, pero solamente uno
    private Date startDateConcert; //Fecha del concierto (un solo día)
    private Date startTimeConcert; //Hora de comienzo
    private Date doorOpeningTimeConcert; //Hora de apertura de puertas
    private Date closingTimeConcert; //Hora de cierre
    private Location location; //Esta localización es única
    
    public Concert (String concertName, Performer p, Date startDateConcert, 
            Date startTimeConcert, Date doorOpeningTimeConcert, 
            Date closingTimeConcert, Location location) {
        
        this.concertName = concertName;
        this.p = p;
        this.startDateConcert = startDateConcert;
        this.startTimeConcert = startTimeConcert;
        this.doorOpeningTimeConcert = doorOpeningTimeConcert;
        this.closingTimeConcert = closingTimeConcert;
        this.location = location;
        
    }
    
    public void setConcertName (String concertName) {
        this.concertName = concertName;
    }
    
    public void setPerformer (Performer p) {
        this.p = p;
    }
    
    public Performer getPerformer () {
        return p;
    }
    
    public void setStartDateConcert (Date startDateConcert) {
        this.startDateConcert = startDateConcert;
    }
    
    //Sobreescribe el método de ImpermanentEvent
    @Override
    public Date getStartDate () {
        return startDateConcert;
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
        this.closingTimeConcert = closingTimeConcert;
    }
    
    public Date getClosingTimeConcert () {
        return closingTimeConcert;
    }
    
    public void setLocation (Location location) {
        this.location = location;
    }
    
    //Sobreescribe el método de ImpermanentEvent
    @Override
    public Location getLocation () {
        return location;
    }

    //Sobreescribe el método de Event
    @Override
    public String getName() {
        return concertName;
    }
    
    //Sobreescribe el método de Event
    @Override
    public Date[] getDates() {
        
        Date[] dates;
        dates = new Date[1];
        dates[0] = startDateConcert;
        
        return dates;
        
    }

    //Sobreescribe el método de Event
    //p es el performer que tenemos almacenado en la clase Concert
    //pAskedFor es el performer por el que preguntan si actúa en el concierto
    @Override
    public boolean involvesPerformer (Performer pAskedFor) {

        //Utilización del operador instanceof para determinar si el tipo de cierto objeto Performer es Artist
        if (p instanceof Artist) {
            //Conversión descendente de la referencia de Performer a una referencia de Artist
            Artist aInvolved = (Artist) p;
            
            //Preguntan por un artista y tenemos un artista, comparación por nombre
            if (pAskedFor instanceof Artist) {
                Artist aAskedFor = (Artist) pAskedFor;
                if (aInvolved.equals(aAskedFor)) return true;
                else return false;
            }
            //Preguntan por un colectivo y tenemos un artista, directamente no está involucrado
            else if (pAskedFor instanceof Collective) return false;
            else return false;
        }
        else if (p instanceof Collective) {
            Collective cInvolved = (Collective) p;
            
            //Preguntan por un artista y tenemos un colectivo, mirar si el artista está en el colectivo
            if (pAskedFor instanceof Artist) {
                Artist aAskedFor = (Artist) pAskedFor;
                if (cInvolved.isArtistInCollective(aAskedFor)) return true;
                else return false;
                
            }
            //Preguntan por un colectivo y tenemos un colectivo, comparación por nombre
            else if (pAskedFor instanceof Collective) {
                Collective cAskedFor = (Collective) pAskedFor;
                if (cInvolved.equals(cAskedFor)) return true;
                else return false;
            }
            else return false;
        }
        else return false;
        
    }
    
    //Sobreescribe el método de Event
    public Performer[] getPerformers() {
        
        Performer[] performers;
        performers = new Performer[1];
        performers[0] = p;
        
        return performers;
        
    }
    
    @Override
    public boolean equals (Object o) {
        
        if (o instanceof Concert) {
            Concert c = (Concert)o;
            if (this.getName().equalsIgnoreCase(c.getName())) return true;
            else return false;
        }
        else return false;
        
    }
    
    @Override
    public String toString() {
        return "CONCERT\nConcert's name: " + concertName + "\nPerformer's name: " +
                p.getName() + "\nDate: " + startDateConcert.getDay() + "/" +
                startDateConcert.getMonth() + "/" + startDateConcert.getYear() +
                "\nDoor opening: " + doorOpeningTimeConcert.getHours() + ":" +
                doorOpeningTimeConcert.getMinutes() + "h\nStart time: " + 
                startTimeConcert.getHours() + ":" + startTimeConcert.getMinutes() + 
                "h\nClosing time: " + closingTimeConcert.getHours() + ":" +
                closingTimeConcert.getMinutes() + "h\nLocation: " + location.getName();
    }
    
}