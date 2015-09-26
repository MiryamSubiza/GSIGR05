/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */
package GSILabs.BModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author subiza.79082
 * @author izu.78236
 * @version 1.0 (26/09/2015)
 */
public class Times {
    
    private Date hora;
    
    public Times (String hora) {
        this.hora = this.TimeFormat(hora);
    }
    
    public Date TimeFormat (String hora) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        Date hour = null;
        try {
            hour = format.parse(hora);
        }
        catch (ParseException ex) {
            ex.printStackTrace();
        }
        return hour;
    }
    
    public Date getHour() {
        return hora;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm");
        return formato.format(hora);
    }
    
}
