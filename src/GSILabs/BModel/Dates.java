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
public class Dates {
    
    private Date fecha;
    
    public Dates (String fecha) {
        this.fecha = DateFormat(fecha);
    }
    
    public Date DateFormat (String fecha) {
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
        Date date = null;
        try {
            date = format.parse(fecha);
        }
        catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;
    }
    
    public Date getDate() {
        return fecha;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        return formato.format(fecha);
    }
    
}