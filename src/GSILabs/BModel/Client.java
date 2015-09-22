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
    private String name;
    private String lastName;
    private Date birthday;
    private ArrayList <String> creditCards;
    
    public Client (int id, String name, String lastName, Date birthday, String cCard) {
        
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        creditCards.add(cCard);
        
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public int getId () {
        return id;
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
    
    public void setBirthday (Date birthday) {
        this.birthday = birthday;
    }
    
    public Date getBirthday () {
        return birthday;
    }
    
    public void addCreditCard (String cCard) {
        creditCards.add(cCard);
    }

}