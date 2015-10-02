/*
 * This document is part of the lab material for the subject:
 * Gestion de Sistemas de Informacion
 * to be released at the
 * Universidad Publica de Navarra
 * during the first semester of the Academic Year 2015-2016
 */

package GSILabs.BTesting;

import GSILabs.BModel.*;
import GSILabs.BSystem.BussinessSystem;

/**
 * Introducción de datos para comprobar y mostrar por la línea de comandos que
 * se cumplen una serie de sucesos de acuerdo a los requisitos.
 * @author subiza.79082
 * @author izu.78236
 * @version 02/10/2015
 */
public class P01Tester {
    
    //Creación de una instancia de la clase GSILabs.BSystem.BusinessSystem
    private static BussinessSystem bussinessSystem;
    
    public static void main (String[] args) {
        
        bussinessSystem = introduccionDatos();
        comprobacionDatos();
        
    }
    
    //Introducir una cierta cantidad de eventos, clientes, entradas, etc.
    public static BussinessSystem introduccionDatos () {
        
        bussinessSystem = new BussinessSystem();
        
        //Artists
        Artist a1 = new Artist("Andrés Suárez", "Cantautor gallego", "www.andressuarez.es");
        Artist a2 = new Artist("Funambulista", "Cantautor murciano", "www.funambulista.es");
        Artist a3 = new Artist("Rozalén", "Cantautora albaceteña");
        Artist a4 = new Artist("Nach", "Rapero alicantino", "www.nach.es");
        Artist a5 = new Artist("Kase-O", "Javier Ibarra, MC zaragozano");
        Artist a6 = new Artist("Lírico", "David Gilaberte, MC zaragozano");
        Artist a7 = new Artist("Sho-Hai", "Sergio Rodríguez, MC zaragozano");
        Artist a8 = new Artist("R de Rumba", "Rubén Cuevas, DJ zaragozano");
        Artist a9 = new Artist("Alex Papito", "Master BOSS del Karoke");
        Artist a10 = new Artist("Rasking", "Coros del famoso grupo Alex y los Rebujitos");
        
        bussinessSystem.addArtist(a1);
        bussinessSystem.addArtist(a2);
        bussinessSystem.addArtist(a3);
        bussinessSystem.addArtist(a4);
        bussinessSystem.addArtist(a5);
        bussinessSystem.addArtist(a6);
        bussinessSystem.addArtist(a7);
        bussinessSystem.addArtist(a8);
        bussinessSystem.addArtist(a9);
        bussinessSystem.addArtist(a10);
        
        //Collectives
        Collective col1 = new Collective(a1, "Cantautores", "Conjunto de cantautores");
        Collective col2 = new Collective(a5, "Violadores del verso", "Grupo de RAP", "violadoresdelverso.org");
        Collective col3 = new Collective(a9, "Alex y los Rebujitos", "Grupo number ONE en el canto de Karaoke", "www.losrebujitoslapetan.com");
        
        col1.addArtistToCollective(a2);
        col1.addArtistToCollective(a3);
        bussinessSystem.addCollective(col1);
        col2.addArtistToCollective(a6);
        col2.addArtistToCollective(a7);
        col2.addArtistToCollective(a8);
        bussinessSystem.addCollective(col2);
        col3.addArtistToCollective(a10);
        bussinessSystem.addCollective(col3);
        
        
        //Locations
        Location l1 = new Location("Interpeñas", 25000, "Zaragoza", "www.interpeñas.es");
        Location l2 = new Location("Palacio de deportes", 15500, "Madrid");
        Location l3 = new Location("BEC", 18000, "Bilbao", "bilbaoexhibitioncentre.com");
        Location l4 = new Location("Palau Olimpic", 12500, "Barcelona");
        Location l5 = new Location("Sala Totem", 200, "Pamplona", "www.salatotem.com");
        Location l6 = new Location("Kursaal", 1800, "San Sebastián", "www.kursaal.eus/es");
        Location l7 = new Location("Carpa Universitaria", 10000, "Pamplona", "www.carpauniversitaria.com");
        
        bussinessSystem.addLocation(l1);
        bussinessSystem.addLocation(l2);
        bussinessSystem.addLocation(l3);
        bussinessSystem.addLocation(l4);
        bussinessSystem.addLocation(l5);
        bussinessSystem.addLocation(l6);
        
        //Concerts
        Concert con1 = new Concert("Concierto uno", col1, new FechasHoras("01/02/2016", "22:00"),
            new FechasHoras("01/02/2016", "22:00"), new FechasHoras("01/02/2016", "21:00"),
            new FechasHoras("01/02/2016", "23:45"), l6);
        Concert con2 = new Concert("Concierto dos", a4, new FechasHoras("14/11/2015", "20:30"),
            new FechasHoras("14/11/2015", "20:30"), new FechasHoras("14/11/2015", "20:00"),
            new FechasHoras("14/11/2015", "23:30"), l3);
        Concert con3 = new Concert("Concierto tres", a5, new FechasHoras("02/02/2016", "21:00"),
            new FechasHoras("02/02/2016", "21:00"), new FechasHoras("02/02/2016", "20:30"),
            new FechasHoras("02/02/2016", "23:00"), l1);
        Concert con4 = new Concert("Concierto cuatro", col2, new FechasHoras("15/11/2015", "21:15"),
            new FechasHoras("15/11/2015", "21:15"), new FechasHoras("15/11/2015", "20:15"),
            new FechasHoras("15/11/2015", "23:50"), l2);
        Concert con5 = new Concert("Concierto cinco", a7, new FechasHoras("03/02/2016", "21:15"),
            new FechasHoras("03/02/2016", "21:15"), new FechasHoras("03/02/2016", "20:15"),
            new FechasHoras("03/02/2016", "23:50"), l2);
        Concert con6 = new Concert("Concierto seis", a8, new FechasHoras("02/06/2016", "21:15"),
            new FechasHoras("02/06/2016", "21:15"), new FechasHoras("02/06/2016", "20:15"),
            new FechasHoras("02/06/2016", "23:50"), l2);
        Concert con7 = new Concert("We are Back Rebujitos", col3, new FechasHoras("06/11/2015", "12:00"),
            new FechasHoras("06/11/2015", "12:00"), new FechasHoras("06/11/2015", "10:00"),
            new FechasHoras("06/11/2015", "14:00"), l7);
        
        bussinessSystem.addNewConcert(con1);
        bussinessSystem.addNewConcert(con2);
        bussinessSystem.addNewConcert(con3);
        bussinessSystem.addNewConcert(con4);
        
        //Festivals
        Festival f1 = new Festival("Festival uno", con2, new FechasHoras("14/11/2015", "20:00"),
            new FechasHoras("15/11/2015", "23:50"), new FechasHoras("14/11/2015", "20:00"),
            new FechasHoras("15/11/2015", "23:50"));
        Festival f2 = new Festival("Festival dos", con1, new FechasHoras("01/02/2016", "21:00"),
            new FechasHoras("03/02/2016", "23:50"), new FechasHoras("01/02/2016", "21:00"),
            new FechasHoras("03/02/2016", "23:50"));
        
        f1.addConcert(con4);
        bussinessSystem.addNewFestival(f1);
        f2.addConcert(con3);
        f2.addConcert(con5);
        bussinessSystem.addNewFestival(f2);
        
        
        
        
        /*
        
        */
        
        return bussinessSystem;
    }
    
    //Comprobar y mostrar por línea de comandos varios sucesos
    public static void comprobacionDatos () {
        
        
        
    }
    
    
}
