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
public class Concert implements ImpermanentEvent {
    
    private String concertName; //Nombre asociado con el evento
    private Performer p; //Puede ser Artista o Colectivo, pero solamente uno
    private Date startDateConcert; //Fecha del concierto
    private Date startTimeConcert; //Hora de comienzo
    private Date doorOpeningTimeConcert; //Hora de apertura de puertas
    private Date closingTimeConcert; //Hora de cierre
    private Location location;
    
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
    /*
    public String getConcertName () {
        return concertName;
    }
    */
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
    @Override
    public boolean involvesPerformer (Performer pEvent) {

        //Utilización del operador instanceof para determinar si el tipo de cierto objeto Performer es Artist
        if (p instanceof Artist) {
            //Conversión descendente de la referencia de Performer
            //a una referencia de Artist
            Artist a = (Artist) p;
            
            if (a.equals
            
        }
        
    }
    
    //Devuelve true si dos artistas son iguales y false si no son iguales
    public boolean equals (Artist a2) {
        
        if (this.p instanceof Artist) {
            Artist a1 = (Artist)this.p;
            if ((a1.getName().equalsIgnoreCase(a2.getName())) && 
                    (a1.getWorkDescription().equalsIgnoreCase(a2.getWorkDescription())) &&
                    (a1.getWebSite().equalsIgnoreCase(a2.getWorkDescription()))) return true;
            else return false;
        }
        else return false;
        
    }   
    
    //Sobreescribe el método de Event
    @Override
    public Performer[] getPerformers() {
        
        Performer[] performers;
        performers = new Performer[1];
        performers[0] = p;
        
        return performers;
        
    }
    
}

        // Conversión descendente de la referencia de Employee
        // a una referencia de BasePlusCommissionEmployee
        BasePlusCommissionEmployee employee =
                                (BasePlusCommissionEmployee) currentEmployee ;

        double oldBaseSalary = employee.getBaseSalary();
        employee.setBaseSalary( 1.10 * oldBaseSalary );
        System.out.printf(
                "new base salary with 10%% increase is: $%,.2f\n",
                                                                employee.getBaseSalary() );
} // end if