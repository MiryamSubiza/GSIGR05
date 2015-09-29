/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BSystem;

import GSILabs.BModel.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (26/09/2015)
 */
public class BusinessSystem implements TicketOffice {
    
    private HashSet <Client> clients;
    private HashSet <Sales> sales;
    /*
    //Almacenamos los tickets que aún NO han sido vendidos a ningún cliente
    //Cuando vendamos un ticket lo eliminamos de este HashSet
    private HashSet <Ticket> notSoldTickets;
    //Almacenamos los tickets vendidos (utilizamos dos hashset para mirar los ids en hasIDCollision)
    private HashSet <Ticket> soldTickets;
    */
    private HashSet <Ticket> tickets;
    private AtomicInteger atomicInteger;
    private HashSet <Artist> artists;
    private HashSet <Collective> collectives;
    private HashSet <Concert> concerts;
    private HashSet <Exhibition> exhibitions;
    private HashSet <Festival> festivals;
    private HashSet <Location> locations;
    
    public BusinessSystem () {
        clients = new HashSet();
        sales = new HashSet();
        tickets = new HashSet();
        atomicInteger = new AtomicInteger();
    }
    
    public AtomicInteger getAtomicInteger () {
        return atomicInteger;
    }
    
    // Añadir un nuevo concierto siempre y cuando no sea null o
    // tenga el mismo nombre que otro evento guardado
    public boolean addNewConcert(Concert c){
        
        if(c != null){ // si el concierto c no es nulo compruebo si se puede introducir
            
            Iterator i = concerts.iterator();
            Concert concertAux = null;
            boolean respuesta = true;
            while(i.hasNext()){

                concertAux = (Concert)i.next();
                if(concertAux.equals(c)){
                    respuesta = false;
                    break;
                }

            }
            if(respuesta){ // Si la respuesta es true entonces puedo añadir el concierto
                concerts.add(c);
            }
            return respuesta;
            
        }
        else{ // el concierto c es nulo y por tanto no se puede introducir
            
            return false;
            
        }
        
    }
    
    public boolean replaceConcert(Concert c){ // NO ESTA BIEN DEL TODO CREO
        
        if(c != null){ // si el concierto no es null continuo
            
            Iterator i = concerts.iterator();
            Concert concertAux = null;
            boolean respuesta = false;
            while(i.hasNext()){
                
                concertAux = (Concert)i.next();
                if(concertAux.getName().equalsIgnoreCase(c.getName())){
                    // Una vez he encontrado el antiguo concierto lo elimino y añado el editado
                    concerts.remove(concertAux);
                    concerts.add(c);
                    respuesta = true;
                }
                
            }
            return respuesta;
            
        }
        else{
            
            return false;
            
        }
        
    }
    
    public boolean deleteConcert(Concert c){ // NO ESTOY SEGURO SI ESTA BIEN HECHO
        
        if(c !=null){ // Si el concierto c no es nulo procedo a su eliminacion
            
            if(concerts.contains(c)){ // Si el concierto existe en el HashSet lo eliminará
                
                Iterator i = festivals.iterator();
                Festival festivalAux = null;
                while(i.hasNext()){     
                    festivalAux = (Festival)i.next();
                    if(festivalAux.isConcertInFestival(c)){
                        break;
                    }
                }
                if(festivalAux.isConcertInFestival(c)){ // Si entro querra decir que hemos encontrado el concierto en un festival
                    
                    // HABRIA QUE ACCEDER AL FESTIVAL EN MI HASHSET Y ENTONCES ACCEDER AL SU HASHSET
                    // DE CONCIERTOS Y BORRAR EL CONCIERTO CON UN METODO YA IMPLEMENTADO EN LA CLASE FESTIVAL
                    
                    festivals.remove(festivalAux); // NO ESTOY SEGURO SI HAY QUE BORRARLO ASI O NO
                    festivalAux.removeConcert(c);
                    Festival festivalEditado = new Festival(festivalAux.getName(), festivalAux.getConcerts(), festivalAux.getStartDate(), festivalAux.getEndingDate(), festivalAux.getStartDate(), festivalAux.getEndingDate());
                    festivals.add(festivalEditado);
                    
                }
                return concerts.remove(c); // Devolvera true si esta y lo borra false en caso contrario
            }
            else{
                return false;
            }
            
        }
        else{
            
            return false;
           
        }
    }
    
    public boolean existsEvent(Event e){
        
        if(e instanceof Concert){
            return concerts.contains(e);
        }
        else if(e instanceof Festival){
            return festivals.contains(e);
        }
        else if(e instanceof Exhibition){
            return exhibitions.contains(e);
        }
        return false;
        
    }
    
    public Event[] retrieveEvents(String name){
        
        Iterator i = concerts.iterator();
        Iterator j = festivals.iterator();
        Iterator z = exhibitions.iterator();
        int x = 0; // Contador para ir añadiendo eventos al array
        Event[] eventos = null;
        
        while(i.hasNext()){
            Concert concertAux = (Concert)i.next();
            if(concertAux.getName().equalsIgnoreCase(name)){
                eventos[x] = concertAux;
                x = x + 1;
            }
        }
        while(j.hasNext()){
            Festival festivalAux = (Festival)j.next();
            if(festivalAux.getName().equalsIgnoreCase(name)){
                eventos[x] = festivalAux;
                x = x + 1;
            }
        }
        while(z.hasNext()){
            Exhibition exhibitionAux = (Exhibition)z.next();
            if(exhibitionAux.getName().equalsIgnoreCase(name)){
                eventos[x] = exhibitionAux;
                x = x + 1;
            }
        }
        return eventos;
        
    }
    
    public Event[] retrieveEvents(Location loc){
        
        Iterator i = concerts.iterator();
        Iterator z = exhibitions.iterator();
        int x = 0; // Contador para ir añadiendo eventos al array
        Event[] eventos = null;
        
        while(i.hasNext()){
            Concert concertAux = (Concert)i.next();
            if(concertAux.getLocation().equals(loc)){
                eventos[x] = concertAux;
                x = x + 1;
            }
        }
        while(z.hasNext()){
            Exhibition exhibitionAux = (Exhibition)z.next();
            if(exhibitionAux.getLocation().equals(loc)){
                eventos[x] = exhibitionAux;
                x = x + 1;
            }
        }
        return eventos;
        
    }
    
    public Event[] retreiveEvent(Date d){
        
        Iterator i = concerts.iterator();
        Iterator j = festivals.iterator();
        Iterator z = exhibitions.iterator();
        int x = 0; // Contador para ir añadiendo eventos al array
        Event[] eventos = null;
        
        while(i.hasNext()){
            Concert concertAux = (Concert)i.next();
            if(concertAux.getStartDate().equals(d)){
                eventos[x] = concertAux;
                x = x + 1;
            }
        }
        while(j.hasNext()){
            Festival festivalAux = (Festival)j.next();
            if(festivalAux.getStartDate().equals(d)){
                eventos[x] = festivalAux;
                x = x + 1;
            }
        }
        while(z.hasNext()){
            Exhibition exhibitionAux = (Exhibition)z.next();
            if(exhibitionAux.getStartDate().equals(d)){
                eventos[x] = exhibitionAux;
                x = x + 1;
            }
        }
        return eventos;
    }
    
    // Client introduction, update and modification
    
    /**
     * Adds a new client to the system
     * @param c The client to be added
     * @return True if and only if c is not null, well formed and could be added
     *  to the system
     */
    @Override
    public boolean addClient(Client c) {
        Date actualDate = new Date();
        if ((c != null) && ((actualDate.getYear() + 1900) - (c.getBirthday().getDate().getYear() + 1900) >= 18)) {
            clients.add(c);
            return true;
        }
        else return false;
    }
    
    /**
     * Replaces the information in the sytem related to the Client c.
     * @param c The new version of the client
     * @return True if an only if a previous version of the client existed,
     *  c is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    public boolean modifyClient(Client c) {
        
        Iterator i = clients.iterator();
        Client clientAux = null;
        while (i.hasNext()) {
            clientAux = (Client)i.next();
            if (clientAux.equals(c)) {
                break;
            }
        }
        if (clientAux.equals(c)) {
            clients.remove(clientAux);
            clients.add(c);
            return true;
        }
        else return false;
        
    }
    
    /**
     * Adds a new card to the list of cards of a given client
     * @param c     The client
     * @param cCard The identified of the new card
     * @return  True if and only if the client exists, cCard is well formed and 
     *      the card did not exist already for that client.
     */
    public boolean addCardToClient(Client c, String cCard) {
        
        Iterator i = clients.iterator();
        Client clientAux = null;
        while (i.hasNext()) {
            clientAux = (Client)i.next();
            if (clientAux.equals(c)) {
                break;
            }
        }
        if (clientAux.equals(c)) {
            if (cCard != null) {
                c.addCreditCard(cCard);
                return true;
            }
            else return false;
        }
        else return false;
        
    }
    
    /**
     * Checks whether a client exists in the system
     * @param c The client to be checked
     * @return True if an only if c is not null, well formed and exists in the system.
     */
    public boolean containsClient(Client c) {
        if (c != null) {
            Iterator i = clients.iterator();
            Client clientAux = null;
            while (i.hasNext()) {
                clientAux = (Client)i.next();
                if (clientAux.equals(c)) {
                    break;
                }
            }
            if (clientAux.equals(c)) return true;
            else return false;
        }
        else return false;
    }
    
    /**
     * Checks whether there exits a client with an identifier matching the argument
     * @param id Identifier of interest
     * @return True if an only if a client has the given identifier
     */
    public boolean containsClient(int id) {
        Iterator i = clients.iterator();
        Client clientAux = null;
        while (i.hasNext()) {
            clientAux = (Client)i.next();
            if (clientAux.getId() == id) {
                break;
            }
        }
        if (clientAux.getId() == id) return true;
        else return false;
    }
    
    /**
     * Retrieves the client associated with an identifier
     * @param identifier Idenfifier of interest
     * @return The client, or null if no such Client exists
     */
    public Client retrieveClient(int identifier) {
        Iterator i = clients.iterator();
        Client clientAux = null;
        while (i.hasNext()) {
            clientAux = (Client)i.next();
            if (clientAux.getId() == identifier) {
                break;
            }
        }
        if (clientAux.getId() == identifier) return clientAux;
        else return null;
    }
    
    /**
     * Retrieves the tickets associated to a given client
     * @param c The client of interest
     * @return The list of tickets that has been sold to the client, if any.
     */
    public Ticket[] getListOfTickets(Client c) {
        //Metemos todos los tickets en un ArrayList porque es dinámico y después
        //pasamos todos los tickets contenidos en el ArrayList a un array
        ArrayList <Ticket> alTickets = new ArrayList();
        
        Iterator i = sales.iterator();
        Sales saleAux;
        while (i.hasNext()) {
            saleAux = (Sales)i.next();
            if (saleAux.getClient().equals(c)) {
                alTickets.add(saleAux.getTicket());
            }
        }
        Ticket[] tickets;
        //Si no hay tickets vendidos al cliente dado, devolvemos null
        if (alTickets.isEmpty()) return null;
        else { 
            tickets = (Ticket[]) alTickets.toArray();
            return tickets;
        }
    }
    
    /**
     * Retrieves the amount of money spent by the client in tickets
     * @param c The client of interest
     * @return The sum of the prices of the tickets
     */
    public float getTotalSpending(Client c) {
        float totalSpent = 0;
        
        Iterator i = sales.iterator();
        Sales saleAux = null;
        while (i.hasNext()) {
            saleAux = (Sales)i.next();
            if (saleAux.getClient().equals(c)) {
                totalSpent += saleAux.getPrice();
            }
        }
        return totalSpent;
    }
    
    // Ticket management
    
    /**
     * Adds a new ticket to the pool
     * @param t The new ticket
     * @return True if an only if t is not null, it is well formed and can be added 
     *  to the system
     */
    public boolean addNewTicket(Ticket t) {
        if (t != null) {
            tickets.add(t);
            return true;
        }
        else return false;
    }
    
    /**
     * Checks whether there exists some collision of the tickets in the system and
     *  the ticket t
     * @param t The candidate ticket
     * @return True if an only if the ticket t contains event id's which are already
     *      part of another ticket.
     */
    public boolean hasIDCollision(Ticket t) {
        int[] identifiers = t.getIdentifiers();
        for (int j = 0; j < identifiers.length; j++) {
            Iterator i = tickets.iterator();
            Ticket ticketAux = null;
            while (i.hasNext()) {
                ticketAux = (Ticket)i.next();
                if (ticketAux.checkIdentifierInTicket(identifiers[j])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /*
    boolean addSale(Ticket t,Client c,Float price,String cCard);
    En este método llamar a c.addSaleToClient(t);
    Modificamos el atributo sold a true
    */
    
}