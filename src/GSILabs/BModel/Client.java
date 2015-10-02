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
import java.util.Iterator;

/**
 * Información sobre clientes, que pueden comprar entradas para asistir a eventos
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (18/09/2015)
 */
public class Client {
    
    private int id;
    private String dni;
    private String name;
    private String lastName;
    private FechasHoras birthday;
    private HashSet <String> creditCards; //Tarjetas de crédito (puede haber una o varias)
    private HashSet <Ticket> salesOfTickets; //Tickets vendidos a este cliente
    
    /**
     * Método constructor, inicialización de variables
     * @param id Identificador numérico único
     * @param name Nombre del cliente
     * @param lastName Apellido(s) del cliente
     * @param birthday Fecha de nacimiento (>= 18)
     * @param cCard Número de una tarjeta de crédito
     */
    public Client (int id, String name, String lastName, FechasHoras birthday, String cCard) {
        
        this.id = id;
        calculateLetterDNI(id);
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
        creditCards = new HashSet();
        creditCards.add(cCard);
        salesOfTickets = new HashSet();
        
    }
    
    /**
     * Establecer identificador numérico
     * @param id Identificador numérico único
     */
    public void setId (int id) {
        this.id = id;
    }
    
    /**
     * Obtener identificador numérico
     * @return Identificador numérico único
     */
    public int getId () {
        return id;
    }
    
    /**
     * Calcular la letra del dni numérico y asignar id + letra a la variable dni
     * @param id Identificador numérico único
     */
    public void calculateLetterDNI (int id) {
        
        String letters = "TRWAGMYFPDXBNJZSQVHLCKET";
        int rest = id % 23;
        char letter = letters.charAt(rest);
        this.dni = (id + Character.toString(letter));
        
    }
    
    /**
     * Obtener DNI
     * @return DNI = id + letra
     */
    public String getDNI () {
        return dni;
    }
    
    /**
     * Establecer nombre de cliente
     * @param name Nombre del cliente
     */
    public void setName (String name) {
        this.name = name;
    }
    
    /**
     * Obtener nombre de cliente
     * @return Nombre del cliente
     */
    public String getName () {
        return name;
    }
    
    /**
     * Establecer apellidos o apellidos de cliente
     * @param lastName Apellido o apellidos del cliente
     */
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Obtener apellido o apellidos de cliente
     * @return Apellido o apellidos del cliente
     */
    public String getLastName () {
        return lastName;
    }
    
    /**
     * Establecer fecha de nacimiento
     * @param birthday Fecha de nacimiento, ha de ser >= 18
     */
    public void setBirthday (FechasHoras birthday) {
        Date actualDate = new Date();
        if ((actualDate.getYear() + 1900) - (birthday.getYear() + 1900) >= 18)
            this.birthday = birthday;
    }
    
    /**
     * Obtener fecha de nacimiento
     * @return Fecha de nacimiento
     */
    public Date getBirthday () {
        return birthday;
    }
    
    /**
     * Añadir tarjeta de crédito, si el número ya existe para este cliente no se añade
     * @param cCard Número de tarjeta de crédito a añadir
     */
    public void addCreditCard (String cCard) {
        creditCards.add(cCard);
    }
    
    /**
     * Añadir la venta de una entrada a este cliente
     * @param t Ticket comprado por el cliente
     */
    public void addSaleToClient (Ticket t) {
        salesOfTickets.add(t);
    }
    
    /**
     * Comprobar si existe una tarjeta de crédito para el cliente dado
     * @param cCard Número de tarjeta de crédito a comprobar
     * @return True si el cliente ya tenía almacenado este número de tarjeta de crédito.
     *  False en caso contrario
     */
    public boolean isCreditCard (String cCard) {
        return creditCards.contains(cCard);
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
        String cards = "";
        Iterator i = creditCards.iterator();
        String cCardAux = null;
        int cont = 0;
        while (i.hasNext()) {
            cCardAux = (String)i.next();
            if (cont == 0) cards = (cards + cCardAux);
            else cards = (cards + ", " + cCardAux);
            cont++;
        }
        return "CLIENT\nDNI: " + dni + "\nName: " + name + "\nLast name: " +
                lastName + "\nBirthday: " + birthday + "Credit cards: "
                + cards + "\n";
    }

}