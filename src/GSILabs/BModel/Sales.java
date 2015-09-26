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
 * @version 1.0 (18/09/2015)
 */
public class Sales {
    
    private Ticket ticket; //Entrada que se ha comprado
    private Client client; //Cliente que ha realizado la compra
    private float price; //Precio de la entrada que se ha comprado
    private String cCard; //Tarjeta de crédito con la que se ha realizado la compra
    private Dates dateSale; //Momento en el que la venta se ha producido
    
    public Sales (Ticket ticket, Client client, float price, String cCard, Dates dateSale) {
        
        this.ticket = ticket;
        this.client = client;
        this.price = price;
        this.cCard = cCard;
        this.dateSale = dateSale;
        
    }
    
    public void setClient (Client client) {
        this.client = client;
    }
    
    public Client getClient () {
        return this.client;
    }
    
    public void setTicket (Ticket ticket) {
        this.ticket = ticket;
    }
    
    public Ticket getTicket () {
        return this.ticket;
    }
    
    public void setPrice (float price) {
        this.price = price;
    }
    
    public float getPrice () {
        return this.price;
    }
    
    public void setCCard (String cCard) {
        this.cCard = cCard;
    }
    
    public String getCCard () {
        return this.cCard;
    }
    
    public void setDateSale (Dates dateSale) {
        this.dateSale = dateSale;
    }
    
    public Date getDateSale () {
        return this.dateSale.getDate();
    }
    
    @Override
    public String toString() {
        return "SALE\nClient: " + client.getName() + client.getLastName() + 
                "\nPrice of the ticket: " + price + "\nCredit card: " +
                cCard + "\nDate: " + dateSale.getDate() + "\n";
    }
}