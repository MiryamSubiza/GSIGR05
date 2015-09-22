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
 * @version 1.0 (18/09/2015)
 */
public class Client {
    
    private int id;
    private String dni;
    private String name;
    private String lastName;
    private DateBirthday birthday;
    private ArrayList <String> creditCards;
    
    public Client (int id, String name, String lastName, int day, int month,
            int year, String cCard) {
        
        this.id = id;
        dni = calculateLetterDNI(id);
        this.name = name;
        this.lastName = lastName;
        birthday.setDay(day);
        birthday.setMonth(month);
        birthday.setYear(year);
        creditCards.add(cCard);
        
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public int getId () {
        return id;
    }
    
    //Calcula la letra del dni numérico
    public String calculateLetterDNI (int id) {
        
        String letters = "TRWAGMYFPDXBNJZSQVHLCKET";
        int rest = id % 23;
        char letter = letters.charAt(rest);
        return id + letter + "";
        
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
    
    public void setBirthday (DateBirthday birthday) {
        this.birthday = birthday;
    }
    
    public DateBirthday getBirthday () {
        return birthday;
    }
    
    public void addCreditCard (String cCard) {
        creditCards.add(cCard);
    }

}