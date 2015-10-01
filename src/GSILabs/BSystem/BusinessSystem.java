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
import java.util.HashMap;
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
    
    private HashMap <Integer, Client> clients;
    private HashSet <Sales> sales;
    private HashMap <Integer, Ticket> tickets;
    private AtomicInteger atomicInteger;
    private HashMap <String, Artist> artists;
    private HashMap <String, Collective> collectives;
    private HashMap <String, Concert> concerts;
    private HashMap <String, Exhibition> exhibitions;
    private HashMap <String, Festival> festivals;
    private HashMap <String, Location> locations;
    private AtomicInteger AISales;
    private AtomicInteger AITickets;
    
    public BusinessSystem () {
        clients = new HashMap();
        sales = new HashSet();
        tickets = new HashMap();
        atomicInteger = new AtomicInteger();
        artists = new HashMap();
        collectives = new HashMap();
        concerts = new HashMap();
        exhibitions = new HashMap();
        festivals = new HashMap();
        locations = new HashMap();
        AISales = new AtomicInteger();
        AITickets = new AtomicInteger();
    }
    
    public AtomicInteger getAtomicInteger () {
        return atomicInteger;
    }
    
    // Añadir un nuevo concierto siempre y cuando no sea null o
    // tenga el mismo nombre que otro evento guardado
    @Override
    public boolean addNewConcert(Concert c){
        
        if(c != null){ // si el concierto c no es nulo compruebo si se puede introducir                               
            if(!(concerts.containsKey(c.getName()) || festivals.containsKey(c.getName()) || exhibitions.containsKey(c.getName()))){// Si la respuesta es true entonces puedo añadir el concierto
            
                if(isConcertOK(c)){
                // Dentro del metodo comprueba que las condiciones para añadir el concierto son correctas
                    concerts.put(c.getName(), c);
                    return true;
                }                
                else{
                    return false;
                }
                
            }
            else{ // El nombre del concierto ya existe
                return false;
            }
            
        }
        else{ // el concierto c es nulo y por tanto no se puede introducir            
            return false;           
        }
        
    }
    
    @Override
    public boolean replaceConcert(Concert c){ // NO ESTA BIEN DEL TODO CREO
        
        if(c != null){ // si el concierto no es null continuo
            
            if(concerts.containsKey(c.getName())){ 
            // Si encuentra el concierto a reemplazar procede a mirar si es correcto dicho concierto
                if(isConcertOK(c)){
                // Dentro del metodo comprueba que las condiciones para reemplazar el concierto son correctas
                    concerts.replace(c.getName(),c);
                    return true;
                }
                else{ // El concierto a reemplazar no es correcto
                    return false;
                }
            }
            else{ // El conciert no lo ha encontrado
                return false;
            }
            
        } // El concierto es nulo
        else{
            
            return false;
            
        }
        
    }
    
    @Override
    public boolean deleteConcert(Concert c){ // NO ESTOY SEGURO SI ESTA BIEN HECHO
        
        if(c !=null){ // Si el concierto c no es nulo procedo a su eliminacion
            
            if(concerts.containsKey(c.getName())){ // Si el concierto existe en el HashMap lo eliminará
                
                ArrayList al = new ArrayList(festivals.values());
                Iterator i = al.iterator();
                Festival festivalAux = null;
                while(i.hasNext()){     
                    festivalAux = (Festival)i.next();
                    if(festivalAux.isConcertInFestival(c)){
                        // Si entro querra decir que hemos encontrado el concierto en un festival
                        festivalAux.removeConcert(c);
                        festivals.replace(festivalAux.getName(), festivalAux);
                        break;
                    }
                }
                
                return concerts.remove(c.getName(),c); // Devolvera true si esta y lo borra false en caso contrario
            }
            else{
                return false;
            }
            
        }
        else{
            
            return false;
           
        }
    }
    
    @Override
    public boolean addNewFestival(Festival f){
        
        if(f != null){ // si el concierto c no es nulo compruebo si se puede introducir                               
            if(!(concerts.containsKey(f.getName()) || festivals.containsKey(f.getName()) || exhibitions.containsKey(f.getName()))){// Si la respuesta es true entonces puedo añadir el concierto
                
                festivals.put(f.getName(), f); 
                return true;
                
            }
            else{ // El nombre del concierto ya existe
                return false;
            }
            
        }
        else{ // el concierto c es nulo y por tanto no se puede introducir            
            return false;           
        }
        
    }
    
    @Override
    public boolean addConcertToFestival(Festival f, Concert c){
        
        if((f != null) && (c != null)){ // Si los argumentos no son nulos procedo en el metodo
            if(festivals.containsKey(f.getName()) && concerts.containsKey(c.getName())){
                // Si el festival y el concierto existen procedo a mirar si dicho concierto esta en ese festival
                HashSet <Concert> concertsFestival = f.getConcerts();
                if(concertsFestival.contains(c)){
                    // El concierto existe dentro del festival
                    return false;
                }
                else{ // El concierto no existe dentro del festival
                    f.addConcert(c);
                    if(f.getEndingDate().before(c.getClosingTimeConcert())){
                        // Si la fecha del ultimo concierto del festival es antes que el concierto añadido
                        // actualizo la hora de fin del festival
                        f.setClosingDateFestival(c.getClosingTimeConcert());
                        f.setClosingTimeFestival(c.getClosingTimeConcert());                        
                    }
                    else if(f.getStartDate().after(c.getStartDate())){
                        // Si la fecha del concierto que abre el festival es posterior a la
                        // fecha del nuevo concierto añadido al festival actualizo las fechas
                        f.setStartDateFestival(c.getStartDate());
                        f.setStartTimeFestival(c.getStartTimeConcert());  
                    }
                    return true;
                    
                }
                
            }
            else{ // Si el concierto o el festival no existen en el sistema
                return false;
            }
        }
        else{ // Alguno de los argumentos o ambos son nulos
            return false;
        }
    }
    
    @Override
    public boolean replaceFestival(Festival f){
        
        if(f != null){ // Si el festival a reemplazar no es nulo procedo a su reemplazo
            
            if(festivals.containsKey(f.getName())){ // Si encuentra el festival a reemplazar lo reemplaza
                festivals.replace(f.getName(), f);
                return true;
            }
            else{ // El festival que quiere reemplazar no existe
                return false;
            }
        }
        else{ // El festival f es nulo
            return false;
        }
        
    }
    
    @Override
    public boolean deleteFestival(Festival f){
        
        if(f != null){ // Si no es null procedo a su eliminacion
            
            if(festivals.containsValue(f)){ 
                // Si el festival que quiere eliminar existe dentro de mi coleccion
                // procedo a su eliminacion junto a la de sus conciertos
                Festival festivalToRemove = festivals.get(f.getName());
                // Creo un iterador del HashSet que contiene todos los conciertos del festival
                // a eliminar y voy eliminando uno a uno los conciertos de mi coleccion
                Iterator i = festivalToRemove.getConcerts().iterator();
                Concert concertAux = null;
                while(i.hasNext()){
                    concertAux = (Concert)i.next();
                    concerts.remove(concertAux.getName(), concertAux);
                }
                // Una vez he eliminado todos los conciertos del festival f
                // procedo a eliminar el festival de la colección.
                return festivals.remove(f.getName(), f);
                
            }
            else{ // El festival no existe dentro de la colección
                return false;
            }
        }
        else{ // El festival f es nulo
            return false;
        }
    }
    
    @Override
    public boolean addNewExhibition(Exhibition e){
        
        if(e != null){ 
            // Si la exhibicion e no es nula procedo a comprobar si se puede añadir a la colección            
            if(!(concerts.containsKey(e.getName()) || festivals.containsKey(e.getName()) || exhibitions.containsKey(e.getName()))){
                // Si entra aqui quiere decir que el nombre de la exhibicion es
                // único dentro de los eventos del sistema, ahora compruebo si es correcto
                if(isExhibitionOK(e)){
                    // Si entra quiere decir que la exhibicion cumple los requisitos necesarios
                    // para poder ser introducido al sistema
                    exhibitions.put(e.getName(),e);
                    return true;
                }
                else{ 
                    // La exhibition no cumple los requisitos necesarios
                    return false;
                }
            }
            else{ 
                // La exhibicion tiene el mismo nombre que otro evento por lo tanto no se introduce
                return false;
            }
        }
        else{ 
            // La exhibición e es nula
            return false;
        }
    }
    
    @Override
    public boolean replaceExhibition(Exhibition e){
        
        if(e != null){
            // Si la exhibicion e no es nula paso a reemplazarla
            if(exhibitions.containsKey(e.getName())){
                // Si entra quiere decir que ha encontrado la exhibicion en el sistema
                // ahora procedo a comprobar que la exhibicion e es correcta para poder
                // reemplazarla
                if(isExhibitionOK(e)){
                    // Si ha pasado por aqui quiere decir que cumple 
                }
            }
        }
    }
    
    @Override
    public boolean existsEvent(Event e){
        
        if(e instanceof Concert){
            return concerts.containsValue(e);
        }
        else if(e instanceof Festival){
            return festivals.containsValue(e);
        }
        else if(e instanceof Exhibition){
            return exhibitions.containsValue(e);
        }
        return false;
        
    }
    
    @Override
    public Event[] retrieveEvents(String name){
        
        Iterator i = concerts.values().iterator();
        Iterator j = festivals.values().iterator();
        Iterator z = exhibitions.values().iterator();
        int x = 0; // Contador para ir añadiendo eventos al array
        Event[] eventos = null;
        // Recorro todos los eventos mirando uno a uno si los nombres de los mismos
        // tiene parcial o totalmente el nombre que me pasan como argumento y los guardo
        // en el array de eventos
        while(i.hasNext()){
            Concert concertAux = (Concert)i.next();
            if(concertAux.getName().contains(name)){
                eventos[x] = concertAux;
                x = x + 1;
            }
        }
        while(j.hasNext()){
            Festival festivalAux = (Festival)j.next();
            if(festivalAux.getName().contains(name)){
                eventos[x] = festivalAux;
                x = x + 1;
            }
        }
        while(z.hasNext()){
            Exhibition exhibitionAux = (Exhibition)z.next();
            if(exhibitionAux.getName().contains(name)){
                eventos[x] = exhibitionAux;
                x = x + 1;
            }
        }
        return eventos;
        
    }
    
    @Override
    public Event[] retrieveEvents(Location loc){
        
        Iterator i = concerts.values().iterator();
        Iterator z = exhibitions.values().iterator();
        int x = 0; // Contador para ir añadiendo localizaciones al array
        Event[] eventos = null;
        // Miro las localizaciones de todos los conciertos y exhibiciones y las comparo
        // con la localizacion que han pasado como argumento a ver si es la que busco
        // en tal caso lo guardo en mi array de localizaciones
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
    
    /**
     *
     * @param d
     * @return
     */
    @Override
    public Event[] retrieveEvents(Date d){
        
        Iterator i = concerts.values().iterator();
        Iterator j = festivals.values().iterator();
        Iterator z = exhibitions.values().iterator();
        int x = 0; // Contador para ir añadiendo eventos al array
        Event[] eventos = null;
        // Compruebo todos los eventos comparando su fecha de inicio con la fecha
        // que me han pasado como argumento y los que coincidan los introduzco en
        // el array de eventos
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
        if ((c != null) && ((actualDate.getYear() + 1900) - (c.getBirthday().getYear() + 1900) >= 18)) {
            clients.put(c.getId(), c);
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
        Date actualDate = new Date();
        if (clients.containsKey(c.getId())) { //Si una versión previa del cliente existe
            if ((actualDate.getYear() + 1900) - (c.getBirthday().getYear() + 1900) >= 18) {
                clients.replace(c.getId(), clients.get(c.getId()), c);
                return true;
            }
            else return false;
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
        
        if (clients.containsKey(c.getId())) { //Si el cliente existe
            clients.get(c.getId()).addCreditCard(cCard);
            return true;
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
            return clients.containsKey(c.getId());
        }
        else return false;
    }
    
    /**
     * Checks whether there exits a client with an identifier matching the argument
     * @param id Identifier of interest
     * @return True if an only if a client has the given identifier
     */
    public boolean containsClient(int id) {
        return clients.containsKey(id);
    }
    
    /**
     * Retrieves the client associated with an identifier
     * @param identifier Idenfifier of interest
     * @return The client, or null if no such Client exists
     */
    public Client retrieveClient(int identifier) {
        if (clients.containsKey(identifier)) {
            return clients.get(identifier);
        }
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
            tickets.put(AITickets.getAndIncrement(), t);
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
        
        HashSet<Ticket> ticketsObjects = (HashSet<Ticket>) tickets.values();

        int[] identifiers = t.getIdentifiers();
        for (int j = 0; j < identifiers.length; j++) {
            Iterator i = ticketsObjects.iterator();
            Ticket ticketAux = null;
            while (i.hasNext()) {
                ticketAux = (Ticket)i.next();
                if ((ticketAux.checkIdentifierInTicket(identifiers[j])) && (ticketAux.getEvent().equals(t.getEvent()))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
    * Checks whether an identifier is not assigned to any ticket.
    * @param e The event of interest
    * @param id    The identifier of interest
    * @return True if and only if the Event e exists in the system, and no ticket
    *      includes the identifier id
    */
    public boolean availableTicketID(Event e, int id) {

        if (existsEvent(e)) {
            HashSet<Ticket> ticketsObjects = (HashSet<Ticket>) tickets.values();
            Iterator i = ticketsObjects.iterator();
            Ticket ticketAux = null;
            while (i.hasNext()) {
                ticketAux = (Ticket)i.next();
                if (ticketAux.getEvent().equals(e)) {
                    if (ticketAux.checkIdentifierInTicket(id)) return false;
                }
            }
            return true;
        }
        else return false;
        
    }
    
    /**
     * Let the system know that the identifier id, as part of the ticket t,
     *  has been used to access the event e.
     * @param t The ticket
     * @param e The event
     * @param id    The identifier
     * @return True if and only if the Ticket exists, is associated with the Event e,
     *      contains the identifier id and it was not used before.
     */
    public boolean setIDUsed(Ticket t,Event e, int id) {
        if (tickets.containsValue(t)) { //Si el ticket existe
            if (t.getEvent().equals(e)) { //Si el ticket está asociado al evento e
                if (t.checkIdentifierInTicket(id)) { //Si el ticket contiene el identificador
                    return (t.setIDUsed(id)); //Devuelve verdadero si el id no había sido usado previamente
                }
                else return false;
            }
            else return false;
        }
        else return false;
    }
    
    //Sales and so
    /**
     * Registers the sale of an existing ticket to an existing client.
     * @param t     The ticket to be sold
     * @param c     The client who buys the ticket
     * @param price The price of the sale
     * @param cCard The card the transaction was performed with
     * @return  True if and only if the ticket, client and card existed, and the 
     *      sale could be registered (e.g. the ticket was not sold in beforehand, etc.)
     */
    public boolean addSale(Ticket t,Client c,Float price,String cCard) {
        Date actualDate = new Date();
        if (tickets.containsValue(t) && clients.containsValue(c) && c.isCreditCard(cCard) && !t.isSold()) {
            c.addSaleToClient(t);
            t.setSold(true);
            sales.add(new Sales(t, c, price, cCard, actualDate));
            return true;
        }
        else return false;
    }
    
    
    // Mira si un concierto cumple los requisitos para poder ser añadido al sistema
    private boolean isConcertOK(Concert c){
        
        // Si el performer pertenece o a un colectivo o a un artista y ademas la localizacion existe procedo a añadir el concierto
        if( (artists.containsValue(c.getPerformer()) || collectives.containsValue(c.getPerformer())) && (locations.containsValue(c.getLocation())) ){        

            ArrayList al = new ArrayList(concerts.values());
            Iterator i = al.iterator();
            while(i.hasNext()){
                Concert concertAux = (Concert)i.next();
                if(concertAux.getPerformer().equals(c.getPerformer()) && concertAux.getStartDate().equals(c.getStartDate())){

                    //Quiere decir que el performer de dicho concierto actua el mismo dia
                    //por lo tanto no puede introducirse el concierto
                    return false;

                }
                else if(concertAux.getLocation().equals(c.getLocation()) && concertAux.getStartDate().equals(c.getStartDate())){
                    
                    //Quiere decir que ambos conciertos tienen lugar en la
                    //misma localizacion en la misma fecha
                    return false;
                    
                }
            }
            // Si ha salido del bucle y el programa sigue leyendo quiere decir no ha encontrado
            // un concierto donde el performer del concierto c actue el mismo día 
            return true;

        }
        else{ // El performer o la localizacion del concierto no existen en el sistema
            return false;
        }        
        
    }

    // Mira si un exhibición cumple los requisitos para poder ser añadido al sistema
    private boolean isExhibitionOK(Exhibition e) {
       
        // Si el performer pertenece o a un colectivo o a un artista y ademas la localizacion existe
        // procedo a seguir comprobando la exhibicion
        if( (artists.containsValue(e.getPerformer()) || collectives.containsValue(e.getPerformer())) && (locations.containsValue(e.getLocation())) ){        

            // Creo un iterador para recorrer todas las exhibiciones del sistema
            // y poder comprobar que la exhibicion e es correcta para poder ser
            // añadida al sistema
            Iterator i = exhibitions.values().iterator();
            while(i.hasNext()){
                Exhibition exhibitionAux = (Exhibition)i.next();
                if(exhibitionAux.getPerformer().equals(e.getPerformer()) && exhibitionAux.getStartDate().equals(e.getStartDate())){

                    //Quiere decir que el performer de dicha exhibicion actua el mismo dia
                    //por lo tanto no puede introducirse la exhibicion
                    return false;

                }
                else if(exhibitionAux.getLocation().equals(e.getLocation()) && exhibitionAux.getStartDate().equals(e.getStartDate())){
                    
                    //Quiere decir que ambas exhibiciones tienen lugar en la
                    //misma localizacion en la misma fecha
                    return false;
                    
                }
            }
            // Si ha salido del bucle y el programa sigue leyendo quiere decir no ha encontrado
            // una exhibicion donde el performer de la exhibicion e actue el mismo día o la localizacion
            // donde se situa se encuentra ocupada el mismo dia
            return true;

        }
        else{ // El performer o la localizacion de la exhibicion no existen en el sistema
            return false;
        }  
        
    }
    
}
