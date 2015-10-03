/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

/**
 * Registro de la venta de una entrada a un cliente
 * @author subiza.79082
 * @author izu.78236
 * @version 03/10/2015
 */
public class Sales {
    
    private Ticket ticket;
    private Client client;
    private float price;
    private String cCard;
    private FechasHoras dateSale;
    
    /**
     * Método constructor, inicialización de variables
     * @param ticket Entrada que se ha comprado
     * @param client Cliente que ha realizado la compra
     * @param price Precio de la entrada que se ha comprado
     * @param cCard Tarjeta de crédito con la que se ha realizado la compra
     * @param dateSale Momento en el que la venta se ha producido
     */
    public Sales (Ticket ticket, Client client, float price, String cCard, FechasHoras dateSale) {
        
        this.ticket = ticket;
        this.client = client;
        this.price = price;
        this.cCard = cCard;
        this.dateSale = dateSale;
        
    }
    
    /**
     * Establecer cliente
     * @param client Cliente comprador de la entrada
     */
    public void setClient (Client client) {
        this.client = client;
    }
    
    /**
     * Obtener cliente
     * @return Cliente comprador de la entrada
     */
    public Client getClient () {
        return this.client;
    }
    
    /**
     * Establecer entrada
     * @param ticket Entrada comprada
     */
    public void setTicket (Ticket ticket) {
        this.ticket = ticket;
    }
    
    /**
     * Obtener entrada
     * @return Entrada comprada
     */
    public Ticket getTicket () {
        return this.ticket;
    }
    
    /**
     * Establecer precio de la entrada
     * @param price Precio de la entrada
     */
    public void setPrice (float price) {
        this.price = price;
    }
    
    /**
     * Obtener precio de la entrada
     * @return Precio de la entrada
     */
    public float getPrice () {
        return this.price;
    }
    
    /**
     * Establecer tarjeta de crédito
     * @param cCard Número de la tarjeta de crédito con la que se ha realizado la compra
     */
    public void setCCard (String cCard) {
        this.cCard = cCard;
    }
    
    /**
     * Obtener tarjeta de crédito
     * @return Número de la tarjeta de crédito
     */
    public String getCCard () {
        return this.cCard;
    }
    
    /**
     * Establecer fecha de venta
     * @param dateSale Fecha de venta
     */
    public void setDateSale (FechasHoras dateSale) {
        this.dateSale = dateSale;
    }
    
    /**
     * Obtener fecha de venta
     * @return Fecha de venta
     */
    public FechasHoras getDateSale () {
        return this.dateSale;
    }
    
    /**
     * Representación por pantalla
     * @return Información a mostrar
     */
    @Override
    public String toString() {
        return "SALE\nClient: " + client.getName() + " " + client.getLastName() + 
                "\nPrice of the ticket: " + price + "€\nCredit card: " +
                cCard + "\nDate: " + dateSale.fechaToString() + "\nHour: " +
                dateSale.horaToString() + "\n";
    }
}