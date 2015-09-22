/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (18/09/2015)
 */
public class Ticket {
    
    private Event event; //Puede ser Concierto, Festival o Exposición
    //Clave: Identificador para una persona
    //Valor: False si no ha entrado y True si ha entrado al evento
    private HashMap people; 
    // PARA ACCEDER A LOS ELEMENTOS LOS BUSCAMOS CON containsKey() Y LUEGO PARA VER 
    //EL VALOR DE LA KEY ASOCIADA USAS get(Key K)
    private ArrayList al;
    
    //identifiers es un ArrayList de identificadores con tantos identificadores como personas puedan acceder con esta entrada
    public Ticket (Event event, ArrayList <Integer> identifiers) {
        
        this.event = event;
        people = new HashMap();
        for (int i = 1; i <= identifiers.size(); i++) {
            people.put(new Integer(identifiers.get(i)), false);
        }
        //Introducimos los valores del HashMap a un ArrayList para poder acceder a ellos
        al = new ArrayList(people.values());
        
    }
    
    public void setEvent (Event event) {
        this.event = event;
    }
    
    public Event getEvent () {
        return event;
    }    
    
    //Devuelve true si la entrada contiene este identificador
    //y false en caso contrario
    public boolean checkIdentifierInTicket (int identifier) {
        return people.containsKey(identifier);
    }
    
    //Devuelve true si el identificador ha sido utilizado
    //y false en caso contrario
    public boolean checkIdentifierIsUsed(int identifier){
        return (boolean)people.get(identifier);
    }
    
}