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
    
    /**
     * Adds a new concert to the system. Note that setting up the concert should not produce
     *  any kind of clash with the existing concerts, etc.
     * @param c The concert to be added
     * @return True if an only if the concert c was not null, was well formed and did
     *  not clash with the information already in the system. False otherwise.
     */
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
    
    /**
     * Replace an existing concert. The system must be able to indentify the concert
     *  as "already existing", then proceed for its replacement.
     * @param c The concert to be added
     * @return True if an only if the concert c was not null, was well formed and did
     *  not clash with the information already in the system. False otherwise.
     */
    @Override
    public boolean replaceConcert(Concert c){ // NO ESTA BIEN DEL TODO CREO
        
        if(c != null){ // si el concierto no es null continuo
            
            if(concerts.containsKey(c.getName())){ 
            // Si encuentra el concierto a reemplazar procede a mirar si es correcto dicho concierto
                if(isConcertOKToReplace(c)){
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
    
    /**
     * Deletes a concert from the system. In case c did not exist in the system, 
     *  this action has no impact.
     * @param c The concert to be removed
     * @return True if an only if the concert c was not null, and existed 
     *  already in the system. False otherwise.
     */
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
    
    /**
     * Adds a new festival to the system
     * @param f The festival to be added
     * @return True if an only if f is not null, well formed and could be added to the system
     */
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
    
    /**
     * Adds a new concert to an existing festival
     * @param f The festival to which the concert is to be added
     * @param c The concert itself
     * @return True if and only if both arguments are not null, both are well formed 
     *  and the information could be added not causing any clash with the existing information
     */
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
    
    /**
     * Replaces the information in the sytem related to the Festival f.
     * @param f The new version of the festival
     * @return True if an only if a previous version of the festival existed,
     *  f is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
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
    
    /**
     * Deletes the festival f from the system. It also deletes all of the concerts 
     *      associated with it.
     * @param f The festival to be removed
     * @return True if the festival existed and could be removed, together with all 
     *  the concerts it was composed of.
     */
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
    
    /**
     * Adds an exhibition to the system.
     * @param e The exhibition to be added.
     * @return True if e is not null, well formed and does not produce a clash with 
     *  the information already in the system.
     */
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
    
    /**
     * Replaces the information in the sytem related to the Exhibition e.
     * @param e The new version of the exhibition
     * @return True if an only if a previous version of the exhibition existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    @Override
    public boolean replaceExhibition(Exhibition e){
        
        if(e != null){
            // Si la exhibicion e no es nula paso a reemplazarla
            if(exhibitions.containsKey(e.getName())){
                // Si entra quiere decir que ha encontrado la exhibicion en el sistema
                // ahora procedo a comprobar que la exhibicion e es correcta para poder
                // reemplazarla
                if(isExhibitionOKToReplace(e)){
                    // Si ha pasado por aqui quiere decir que cumple los requisitos
                    // para poder ser reemplazado
                    exhibitions.replace(e.getName(), e);
                    return true;
                }
                else{
                    // La exhibicion no es correcta y por lo tanto no se puede
                    // reemplazar
                    return false;
                }
            }
            else{
                // La exhibicion a reemplazar no se encuentra en el sistema
                return false;                        
            }
        }
        else{
            // La exhibicion a reemplazar es nula
            return false;
        }
    }
    
    /**
     * Deletes an exhibition from the system
     * @param e The exhibition to be deleted
     * @return True if and only if e is not null, e existed in the systema and it could be
     *  removed from the system
     */
    @Override
    public boolean deleteExhibition(Exhibition e){
        
        if(e != null){ // Compruebo que la exhibicion e no sea nula
            if(exhibitions.containsValue(e)){
                // Si el sistema contiene la exhibicion a eliminar procedemos a eliminarla
                return exhibitions.remove(e.getName(), e);
            }
            else{
                // El sistema no contiene a la exhibicion
                return false;
            }
        }
        else{
            // La exhibicion a eliminar es nula
            return false;
        }
        
    }
    
    /**
     * Checks whether an event is already registered in the system
     * @param e The event to be checked
     * @return True if and only if e is not null, well formed and did exist in the system
     */
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
    
    /**
     * Retrieves all the events whose name matches (partially) with the name
     * @param name Full or partial name of the events
     * @return A list of events, potentially being empty
     */
    @Override
    public Event[] retrieveEvents(String name){
        
        //Creamos un ArrayList porque un array no es dinámico
        ArrayList <Event> al = new ArrayList();
        Iterator i = concerts.values().iterator();
        Iterator j = festivals.values().iterator();
        Iterator z = exhibitions.values().iterator();

        // Recorro todos los eventos mirando uno a uno si los nombres de los mismos
        // tiene parcial o totalmente el nombre que me pasan como argumento y los guardo
        // en el array de eventos
        while (i.hasNext()) {
            Concert concertAux = (Concert)i.next();
            if (concertAux.getName().contains(name)) al.add(concertAux);
        }
        while (j.hasNext()){
            Festival festivalAux = (Festival)j.next();
            if (festivalAux.getName().contains(name)) al.add(festivalAux);
            
        }
        while (z.hasNext()) {
            Exhibition exhibitionAux = (Exhibition)z.next();
            if (exhibitionAux.getName().contains(name)) al.add(exhibitionAux);
        }
        Event[] eventos = new Event[al.size()];
        al.toArray();
        return eventos;
        
    }
    
    /**
     * Retrieves all the events associated with an specific location
     * @param loc Location of interest
     * @return A list of events, potentially being empty
     */
    @Override
    public Event[] retrieveEvents(Location loc){
        
        //Creamos un ArrayList porque un array no es dinámico
        ArrayList <Event> al = new ArrayList();
        Iterator i = concerts.values().iterator();
        Iterator z = exhibitions.values().iterator();
        
        // Miro las localizaciones de todos los conciertos y exhibiciones y las comparo
        // con la localizacion que han pasado como argumento a ver si es la que busco
        // en tal caso lo guardo en mi array de localizaciones
        while (i.hasNext()) {
            Concert concertAux = (Concert)i.next();
            if (concertAux.getLocation().equals(loc)) al.add(concertAux);
        }
        while (z.hasNext()) {
            Exhibition exhibitionAux = (Exhibition)z.next();
            if (exhibitionAux.getLocation().equals(loc)) al.add(exhibitionAux);
        }
        Event[] eventos = new Event[al.size()];
        al.toArray();
        return eventos;
        
    }
    
    /**
     * Retrieves all the events at some given date
     * @param d Date of interest
     * @return A list of events, potentially being empty
     */
    @Override
    public Event[] retrieveEvents(Date d){
        
        //Creamos un ArrayList porque un array no es dinámico
        ArrayList <Event> al = new ArrayList();
        Iterator i = concerts.values().iterator();
        Iterator j = festivals.values().iterator();
        Iterator z = exhibitions.values().iterator();
        
        // Compruebo todos los eventos comparando su fecha de inicio con la fecha
        // que me han pasado como argumento y los que coincidan los introduzco en
        // el array de eventos
        while (i.hasNext()) {
            Concert concertAux = (Concert)i.next();
            if (concertAux.getStartDate().equals(d)) al.add(concertAux);
        }
        while (j.hasNext()) {
            Festival festivalAux = (Festival)j.next();
            if (festivalAux.getStartDate().equals(d)) al.add(festivalAux);
        }
        while (z.hasNext()) {
            Exhibition exhibitionAux = (Exhibition)z.next();
            if (exhibitionAux.getStartDate().equals(d)) al.add(exhibitionAux);
        }
        Event[] eventos = new Event[al.size()];
        al.toArray();
        return eventos;
    }
    
    /**
     * Adds a new artist to the system
     * @param a The new artist
     * @return True if the artist a is not null, is well formed and could be added to the
     *  system
     */
    @Override
    public boolean addArtist(Artist a){
        if(a != null){ // Si el artista a no es nulo procedo a añadirlo
            
            if(!(artists.containsKey(a.getName())) || collectives.containsKey(a.getName())){
                // Si el nombre del nuevo artista no esta cogido por otro artista
                // o colectivo procedo a añadir
                artists.put(a.getName(), a);
                return true;
            }
            else{
                // El nombre del artista a añadir ya esta cogido
                return false;
            }
            
        }
        else{
            // El artista a es nulo
            return false;
        }
    }
    
    /**
     * Adds a new collective of artists to the system
     * @param c The new collective
     * @return True if the collective c is not null, is well formed and could be added to the
     *  system
     */
    @Override
    public boolean addCollective(Collective c){
        if(c != null){ // Si el colectivo a no es nulo procedo a añadirlo
            
            if(!(artists.containsKey(c.getName())) || collectives.containsKey(c.getName())){
                // Si el nombre del nuevo colectivo no esta cogido por otro artista
                // o colectivo procedo a añadir
                collectives.put(c.getName(), c);
                return true;
            }
            else{
                // El nombre del colectivo a añadir ya esta cogido
                return false;
            }
            
        }
        else{
            // El colectivo c es nulo
            return false;
        }
    }
    
    /**
     * Replaces the information in the sytem related to the artist e.
     * @param a The new version of the artist
     * @return True if an only if a previous version of the artist existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    @Override
    public boolean modifyArtist(Artist a){
        
        if(a != null){ // Si el artista a no es nulo procedo a ver si puedo modificarlo            
            if(artists.containsKey(a.getName())){
                // Si el artista a modificar existe en el sistema
                // procedo a modificarlo
                artists.replace(a.getName(), a);
                return true;
            }
            else{
                // El artista a no existe en el sistema
                return false;
            }
        }
        else{
            // El artista a es nulo
            return false;
        }
        
    }
    
    /**
     * Replaces the information in the sytem related to the collective e.
     * @param c The new version of the collective
     * @return True if an only if a previous version of the collective existed,
     *  e is well formed, and it does not produce clashes with the information already
     *  in the system.
     */
    @Override
    public boolean modifyCollective(Collective c){
        
        if(c != null){ // Si el colectivo c no es nulo procedo a ver si puedo modificarlo            
            if(artists.containsKey(c.getName())){
                // Si el colectivo a modificar existe en el sistema
                // procedo a modificarlo
                collectives.replace(c.getName(), c);
                return true;
            }
            else{
                // El colectivo c no existe en el sistema
                return false;
            }
        }
        else{
            // El colectivo c es nulo
            return false;
        }
        
    }
    
    /**
     * Deletes the record of a performer from the system, provided it has no
     *  events to which it is associated
     * @param performerName The name of the performer
     * @return True if and only if the performer with that name existed and could be removed.
     */
    @Override
    public boolean removePerformer(String performerName){
        
        if(artists.containsKey(performerName)){
            // Si entro aqui quiere decir que el performer a eliminar
            // es un artista, ahora procedo a eliminar los eventos
            Artist artista = artists.get(performerName);
            removeEventsOfPerformer(artista);
            // Ahora miro con un iterador a ver si dicho artista pertenecia a algun colectivo
            // en tal caso lo eliminare del colectivo
            Iterator i = collectives.values().iterator();
            Collective collectiveAux = null;
            while(i.hasNext()){
                collectiveAux = (Collective)i.next();
                if(collectiveAux.isArtistInCollective(artista)){
                    // Si el artista pertence al colectivo lo elimino
                    // de su HashSet de artistas
                    collectiveAux.removeArtist(artista);
                    break;
                }                              
            }
            return artists.remove(performerName, artista);
        }
        else if(collectives.containsKey(performerName)){
            // Si entro aqui quiere decir que el performer a eliminar
            // es un colectivo, ahora procedo a eliminar los eventos
            Collective colectivo = collectives.get(performerName);
            removeEventsOfPerformer(colectivo);
            return collectives.remove(performerName, colectivo);
        }
        else{
            // El nombre del performer no coincide con ningún performer
            // del sistema, por lo tanto no lo eliminamos
            return false;
        }
        
    }
    
    /**
     * Checkes whether there exist a performer with that name in the system
     * @param performerName Name of interest
     * @return True if and only if it exists
     */
    @Override
    public boolean existsPerformer(String performerName){
        
        if(artists.containsKey(performerName) || collectives.containsKey(performerName)){
            // Si el performerName coincide con algún nombre de
            // algún artista o colectivo entro aquí
            return true;
        }
        else{
            // El performer no existe
            return false;
        }
        
    }
    
    /**
     * Checkes whether there exist a performer with that name in the system
     * @param artistName Name of interest
     * @return True if and only if it exists
     */
    @Override
    public boolean existsArtist(String artistName){
        
        if(artists.containsKey(artistName)){
            // Si el performerName coincide con algún nombre de
            // algún artista o colectivo entro aquí
            return true;
        }
        else{
            // El performer no existe
            return false;
        }
    }
    
    /**
     * Checkes whether there exist a performer with that name in the system
     * @param artistName Name of interest
     * @return True if and only if it exists
     */
    public boolean existsCollective(String artistName){
        
        if(collectives.containsKey(artistName)){
            // Si el performerName coincide con algún nombre de
            // algún artista o colectivo entro aquí
            return true;
        }
        else{
            // El performer no existe
            return false;
        }
        
    }
    
    /**
     * Retrieves the record of a performer from the system by its name.
     * @param performerName The name of the performer
     * @return The performer, if existing. Null otherwise.
     */
    @Override
    public Performer retrievePerformer(String performerName){
        
        if(artists.containsKey(performerName)){
            // Si el performer es un artista
            return artists.get(performerName);
        }
        else if(collectives.containsKey(performerName)){
            // Si el performer es un colectivo
            return collectives.get(performerName);
        }
        else{
            // Si el performer no existe envio un performer nulo
            return null;
        }
        
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
        int[] identifiers = t.getIdentifiers();
        for (int j = 0; j < identifiers.length; j++) {
            Iterator i = tickets.values().iterator();
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
            Iterator i = tickets.values().iterator();
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
    
    // Locations
    
    /**
     * Adds a new location to the system
     * @param loc   The location
     * @return  True if and only if the location is not null, is well formed and 
     *  could be added to the system.
     */
    public boolean addLocation(Location loc) {
        if (loc != null) {
            locations.put(loc.getName(), loc);
            return true;
        }
        else return false;
    }
    
    /**
     * Retrieves a location by its exact name
     * @param name  The name of the location
     * @return  The location with that name, or null if it does not exist.
     */
    public Location getLocation(String name) {
        if (locations.containsKey(name)) return locations.get(name);
        else return null;
    }
    
    /**
     * Deletes a location from the system. This can only be done if there is no events
     *  associated with that location.
     * @param loc   The location to be removed
     * @return  True if an only if the location loc existed and could be removed.
     */
    public boolean deleteLocation(Location loc) {
        //exhibition y concert
        if (locations.containsValue(loc)) { //If loc exists
            Iterator i = concerts.values().iterator();
            Concert concertAux = null;
            while (i.hasNext()) {
                concertAux = (Concert)i.next();
                //If there is a concert associated with loc
                if (concertAux.getLocation().equals(loc)) {
                    return false;
                }
            }
            Iterator j = exhibitions.values().iterator();
            Exhibition exhibitionAux = null;
            while (i.hasNext()) {
                exhibitionAux = (Exhibition)j.next();
                //If there is an exhibition associated with loc
                if (exhibitionAux.getLocation().equals(loc)) {
                    return false;
                }
            }
            if (locations.remove(loc.getName(), loc)) return true;
            else return false;
        }
        else return false;        
    }
    
    /**
     * Retrieve the locations in the system with, at least, minCapacity attendance limit.
     * @param minCapacity   Attendance threshold
     * @return A list of 0+ locations
     */
    public Location[] getLocations(int minCapacity) {
        Location[] locsMinCapacity;
        Iterator i = locations.values().iterator();
        Location locationAux = null;
        while (i.hasNext()) {
            locationAux = (Location)i.next();
            if (locationAux.getMaxCapacity() >= minCapacity) {
                
            }
        }
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
    
    // Mira si un concierto cumple los requisitos para poder ser reemplazado al sistema
    private boolean isConcertOKToReplace(Concert c){
        
        // Si el performer pertenece o a un colectivo o a un artista y ademas la localizacion existe procedo a añadir el concierto
        if( (artists.containsValue(c.getPerformer()) || collectives.containsValue(c.getPerformer())) && (locations.containsValue(c.getLocation())) ){        

            ArrayList al = new ArrayList(concerts.values());
            Iterator i = al.iterator();
            while(i.hasNext()){
                Concert concertAux = (Concert)i.next();
                if(!concertAux.getName().equalsIgnoreCase(c.getName())){
                    // Si no es el concierto que quiero reemplazar miro si es correcta
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
    
    // Mira si un exhibición cumple los requisitos para poder ser reemplazado al sistema
    private boolean isExhibitionOKToReplace(Exhibition e) {
       
        // Si el performer pertenece o a un colectivo o a un artista y ademas la localizacion existe
        // procedo a seguir comprobando la exhibicion
        if( (artists.containsValue(e.getPerformer()) || collectives.containsValue(e.getPerformer())) && (locations.containsValue(e.getLocation())) ){        

            // Creo un iterador para recorrer todas las exhibiciones del sistema
            // y poder comprobar que la exhibicion e es correcta para poder ser
            // añadida al sistema
            Iterator i = exhibitions.values().iterator();
            while(i.hasNext()){
                Exhibition exhibitionAux = (Exhibition)i.next();
                if(!exhibitionAux.getName().equalsIgnoreCase(e.getName())){ 
                    // Si no es la exhibicion que quiero reemplazar miro si es correcta
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

    private void removeEventsOfPerformer(Performer p) {
        
        // Creo los iteradores para poder recorrer mis colecciones en busca
        // de los eventos que contengan al performer para eliminarlos del sistema.
        Iterator i = concerts.values().iterator();        
        Iterator j = exhibitions.values().iterator(); 
        
        // Voy a eliminar solo conciertos y exhibiciones ya que los festivales al
        // tener mas de un concierto no se puede suspende todo el festival porque se vaya
        // un concierto, además al eliminar el concierto este se elimina en cascada
        // del festival al que perteneciese en el caso que estuviera en algún festival
        Concert concertAux = null;
        Festival festivalAux = null;
        Exhibition exhibitionAux = null;
        // Elimino conciertos
        while(i.hasNext()){
            concertAux = (Concert)i.next();
            if(concertAux.involvesPerformer(p)){
                // Como el concierto involucra el performer elimino
                // dicho concierto
                deleteConcert(concertAux);
            }
        }
        // Elimino exhibiciones
        while(j.hasNext()){
            exhibitionAux = (Exhibition)j.next();
            if(exhibitionAux.involvesPerformer(p)){
                // Como el concierto involucra el performer elimino
                // dicho concierto
                deleteExhibition(exhibitionAux);
            }
        }
        
    }
    
}
