/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BModel;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (01/10/2015)
 */
public class FechasHoras extends java.util.Date {
    
    private int dia;
    private int mes;
    private int anio;
    private int hora;
    private int minuto;
    
    public FechasHoras (int dia, int mes, int anio, int hora, int minuto) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.hora = hora;
        this.minuto = minuto;
    }
    
    public FechasHoras (String fecha, String hora) {
        //Suponemos que el String fecha recibido tiene el formato "dd/mm/aaaa"
        String dd = fecha.substring(0,2);
        this.dia = Integer.parseInt(dd);
        String mm = fecha.substring(3,5);
        this.mes = Integer.parseInt(mm);
        String aaaa = fecha.substring(6,10);
        this.anio = Integer.parseInt(aaaa);
        //Suponemos que el String hora recibido tiene el formato "hh:mm"
        String hh = hora.substring(0,2);
        this.hora = Integer.parseInt(hh);
        String min = hora.substring(3,5);
        this.minuto = Integer.parseInt(min);
    }
    
    //MÉTODOS PARA ESTABLECER Y OBTENER ATRIBUTOS
    
    public void setDia (int dia) {
        this.dia = dia;
    }
    
    public int getDia () {
        return dia;
    }
    
    public void setMes (int mes) {
        this.mes = mes;
    }
    
    public int getMes () {
        return mes;
    }
    
    public void setAnio (int anio) {
        this.anio = anio;
    }
    
    public int getAnio () {
        return anio;
    }
    
    public void setHora (int hora) {
        this.hora = hora;
    }
    
    public int getHora () {
        return hora;
    }
    
    public void setMinuto (int minuto) {
        this.minuto = minuto;
    }
    
    public int getMinuto () {
        return minuto;
    }
    
    //MÉTODOS PARA MOSTRAR FECHA Y HORA COMO STRING
    
    public String fechaToString () {
        return dia + "/" + mes + "/" + anio;
    }
    
    public String horaToString () {
        return hora + ":" + minuto;
    }
    
}
