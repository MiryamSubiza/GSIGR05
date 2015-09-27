/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BSystem;

import GSILabs.BModel.*;
import java.util.Date;
import java.util.HashSet;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (26/09/2015)
 */
public class BusinessSystem implements TicketOffice {
    
    private HashSet <Client> clients;
    
    public BusinessSystem () {
        clients = new HashSet();
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
    
    
    
}
