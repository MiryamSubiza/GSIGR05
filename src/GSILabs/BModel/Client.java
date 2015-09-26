/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

import java.util.Date;
import java.util.HashSet;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (18/09/2015)
 */
public class Client {
    
    private int id; //Identificador numérico único
    private String dni; //DNI (id + letra dni)
    private String name; //Nombre del cliente
    private String lastName; //Apellido(s) del cliente
    private Dates birthday; //Fecha de nacimiento (>= 18)
    private HashSet <String> creditCards; //Tarjetas de crédito (puede haber una o varias)
    
    public Client (int id, String name, String lastName, Dates birthday, String cCard) {
        
        this.id = id;
        calculateLetterDNI(id);
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        //Si quisiera devolver de tipo Date haría this.birthday.fecha
        creditCards = new HashSet();
        creditCards.add(cCard);
        
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public int getId () {
        return id;
    }
    
    //Calcula la letra del dni numérico
    public void calculateLetterDNI (int id) {
        
        String letters = "TRWAGMYFPDXBNJZSQVHLCKET";
        int rest = id % 23;
        char letter = letters.charAt(rest);
        this.dni = (id + Character.toString(letter));
        
    }
    
    public String getDNI () {
        return dni;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getName () {
        return name;
    }
    
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName () {
        return lastName;
    }
    
    public void setBirthday (Dates birthday) {
        this.birthday = birthday;
    }
    
    public Dates getBirthday () {
        return birthday;
    }
    
    public void addCreditCard (String cCard) {
        creditCards.add(cCard);
    }
    
    @Override
    public boolean equals (Object o) {
        
        if (o instanceof Client) {
            Client c = (Client)o;
            if (this.getId() == c.getId()) return true;
            else return false;
        }
        else return false;
        
    }
    
    @Override
    public String toString() {
        return "CLIENT\nDNI: " + dni + "\nName: " + name + "\nLast name: " +
                lastName + "\nBirthday: " + birthday.toString() + "\n";
    }

}