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
    
    private Ticket ticket;
    private Client client;
    private float price;
    private String cCard;
    private Date dateSale;
    
    public Sales (Ticket ticket, Client client, float price, String cCard, Date dateSale){
        
        this.ticket = ticket;
        this.client = client;
        this.price = price;
        this.cCard = cCard;
        this.dateSale = dateSale;
        
    }
    
    public Client getClient (){
        
        return this.client;
        
    }
    
    public Ticket getTicket (){
        
        return this.ticket;
        
    }
    
    public float getPrice(){
    
        return this.price;
    
    }
    
    public String getCCard(){
    
        return this.cCard;
    
    }
    
    public Date getDateSale(){
    
        return this.dateSale;
    
    }
    
    public void setClient(Client client){
    
        this.client = client;
    
    }
    
    public void setTicket(Ticket ticket){
    
        this.ticket = ticket;
    
    }
    
    public void setPrice(float price){
    
        this.price = price;
    
    }
    
    public void setCCard(String cCard){
    
        this.cCard = cCard;
    
    }
    
    public void setDateSale(Date dateSale){
    
        this.dateSale = dateSale;
    
    }
    
}
