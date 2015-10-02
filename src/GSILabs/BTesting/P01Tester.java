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
        
        System.out.println("Bienvenido a la clase Tester01 para la realizacion\nde pruebas sobre nuestra práctica 1\n");
        System.out.println("Creo algunos datos con los que empezar el testeo...");
        bussinessSystem = introduccionDatos();
        System.out.println("Una vez creados, empiezo el testeo:\n\n");
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
        Artist a9 = new Artist("Alex Papito", "Master BOSS del Karaoke");
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
        bussinessSystem.addLocation(l7);
        
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
            new FechasHoras("03/02/2016", "23:50"), l3);
        Concert con6 = new Concert("Concierto seis", a8, new FechasHoras("02/06/2016", "21:15"),
            new FechasHoras("02/06/2016", "21:15"), new FechasHoras("02/06/2016", "20:15"),
            new FechasHoras("02/06/2016", "23:50"), l5);
        Concert con7 = new Concert("We are Back Rebujitos", col3, new FechasHoras("06/11/2015", "12:00"),
            new FechasHoras("06/11/2015", "12:00"), new FechasHoras("06/11/2015", "10:00"),
            new FechasHoras("06/11/2015", "14:00"), l7);
        
        bussinessSystem.addNewConcert(con1);
        bussinessSystem.addNewConcert(con2);
        bussinessSystem.addNewConcert(con3);
        bussinessSystem.addNewConcert(con4);
        bussinessSystem.addNewConcert(con5);
        bussinessSystem.addNewConcert(con6);
        bussinessSystem.addNewConcert(con7);
        
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
        
        //Exhibitions
        Collective colEx1 = new Collective(a4, "Raperos", "Varios MC's");
        colEx1.addArtistToCollective(a5);
        colEx1.addArtistToCollective(a7);
        Exhibition ex1 = new Exhibition("Exposición uno", "Exposición de RAP", "Eterno miusik",
            new FechasHoras("15/05/2016", "15:30"), new FechasHoras("20/05/2016", "20:30"),
            new FechasHoras("15/05/2016", "15:30"), new FechasHoras("20/05/2016", "20:30"),
            colEx1, "www.eternomiusik.org", l1);
        Exhibition ex2 = new Exhibition("Exposición dos", "Exposición de Nach", "Universal music",
            new FechasHoras("21/08/2016", "17:30"), new FechasHoras("28/08/2016", "20:00"),
            new FechasHoras("21/08/2016", "17:30"), new FechasHoras("28/08/2016", "20:00"),
            a4, "www.universalmusic.es", l6);
        Exhibition ex3 = new Exhibition("Exposición tres", "Exposición de Kase-O", "Rap solo",
            new FechasHoras("26/09/2016", "16:45"), new FechasHoras("26/09/2016", "21:00"),
            new FechasHoras("26/09/2016", "16:45"), new FechasHoras("26/09/2016", "21:00"),
            a5, "www.rapsolozgz.com", l3);
        
        bussinessSystem.addNewExhibition(ex1);
        bussinessSystem.addNewExhibition(ex2);
        bussinessSystem.addNewExhibition(ex3);
        
        //Tickets
        Ticket t1 = new Ticket(con1, bussinessSystem.getAtomicInteger(), 1);
        Ticket t2 = new Ticket(con2, bussinessSystem.getAtomicInteger(), 2);
        Ticket t3 = new Ticket(con3, bussinessSystem.getAtomicInteger(), 1);
        Ticket t4 = new Ticket(con4, bussinessSystem.getAtomicInteger(), 1);
        Ticket t5 = new Ticket(con5, bussinessSystem.getAtomicInteger(), 4);
        Ticket t6 = new Ticket(con6, bussinessSystem.getAtomicInteger(), 1);
        Ticket t7 = new Ticket(con7, bussinessSystem.getAtomicInteger(), 1);
        Ticket t8 = new Ticket(f1, bussinessSystem.getAtomicInteger(), 1);
        Ticket t9 = new Ticket(f2, bussinessSystem.getAtomicInteger(), 3);
        Ticket t10 = new Ticket(ex1, bussinessSystem.getAtomicInteger(), 1);
        Ticket t11 = new Ticket(ex2, bussinessSystem.getAtomicInteger(), 1);
        Ticket t12 = new Ticket(ex3, bussinessSystem.getAtomicInteger(), 1);
        
        bussinessSystem.addNewTicket(t1);
        bussinessSystem.addNewTicket(t2);
        bussinessSystem.addNewTicket(t3);
        bussinessSystem.addNewTicket(t4);
        bussinessSystem.addNewTicket(t5);
        bussinessSystem.addNewTicket(t6);
        bussinessSystem.addNewTicket(t7);
        bussinessSystem.addNewTicket(t8);
        bussinessSystem.addNewTicket(t9);
        bussinessSystem.addNewTicket(t10);
        bussinessSystem.addNewTicket(t11);
        bussinessSystem.addNewTicket(t12);
        
        //Clients
        Client cli1 = new Client(11111111, "Alexandre", "Izu Carmona", new FechasHoras("25/01/1994", "00:00"),
            "1111 1111 1111 1111");
        Client cli2 = new Client(22222222, "Miryam", "Subiza Erro", new FechasHoras("02/06/1994", "00:00"),
            "2222 2222 2222 2222");
        Client cli3 = new Client(33333333, "Ana", "Larráyoz Jiménez", new FechasHoras("09/07/1994", "00:00"),
            "3333 3333 3333 3333");
        Client cli4 = new Client(44444444, "Diego", "Razquin Elcano", new FechasHoras("24/08/1994", "00:00"),
            "4444 4444 4444 4444");
        Client cli5 = new Client(55555555, "Christian", "Goñi Rebollo", new FechasHoras("14/08/1989", "00:00"),
            "5555 5555 5555 5555");
        Client cli6 = new Client(66666666, "Raquel", "Castillo Pérez", new FechasHoras("26/12/1992", "00:00"),
            "6666 6666 6666 6666");
        Client cli7 = new Client(77777777, "José Miguel", "Carrillo", new FechasHoras("21/09/1993", "00:00"),
            "7777 7777 7777 7777");
        Client cli8 = new Client(88888888, "Josu", "Goñi", new FechasHoras("02/02/1991", "00:00"),
            "8888 8888 8888 8888");
        
        cli1.addCreditCard("1000 1000 1000 1000");
        bussinessSystem.addClient(cli1);
        cli2.addCreditCard("2000 2000 2000 2000");
        cli2.addCreditCard("2111 2111 2111 2111");
        bussinessSystem.addClient(cli2);
        bussinessSystem.addClient(cli3);
        bussinessSystem.addClient(cli4);
        bussinessSystem.addClient(cli5);
        bussinessSystem.addClient(cli6);
        cli7.addCreditCard("7000 7000 7000 7000");
        bussinessSystem.addClient(cli7);
        bussinessSystem.addClient(cli8);
        
        //Sales
        Sales s1 = new Sales(t1, cli1, (float)13.5, "1111 1111 1111 1111", new FechasHoras("02/10/2015", "19:43"));
        Sales s2 = new Sales(t2, cli1, 27, "1000 1000 1000 1000", new FechasHoras("03/10/2015", "10:00"));
        Sales s3 = new Sales(t3, cli2, 17, "2222 2222 2222 2222", new FechasHoras("05/11/2015", "17:13"));
        /*
        
        */
        
        return bussinessSystem;
    }
    
    //Comprobar y mostrar por línea de comandos varios sucesos
    public static void comprobacionDatos () {
        
        // PRUEBA S3)
        System.out.println("PRUEBA S3)");
        System.out.println("Intento introducir el siguiente Artista:");
        Artist artistaNew = new Artist("Stardust", "Cantante de rock");
        System.out.print(artistaNew.toString());
        if(bussinessSystem.addArtist(artistaNew)){
            System.out.println("El artista ha sido añadido correctamente");
        }
        else{
            System.out.println("El nombre del artista ya existe por otro arista o un colectivo\n");
        }
        System.out.println("Intento introducir el siguiente Colectivo:");
        Collective collectiveNew = new Collective(artistaNew, "Stardust", "Cantante de rock");
        System.out.print(collectiveNew.toString());
        if(bussinessSystem.addArtist(artistaNew)){
            System.out.println("El colectivo ha sido añadido correctamente");
        }
        else{
            System.out.println("El colectivo no se ha introducido porque el nombre del colectivo\nya existe por otro colectivo o un artista\n");
        }
        
        // PRUEBA S4)
        System.out.println("PRUEBA S4)");
        System.out.println("Ahora elimino el artista anterior y asi comprobar que puedo añadir\nel colectivo");
        System.out.println("El artista a eliminar es:");
        System.out.print(artistaNew.toString());
        if(bussinessSystem.removePerformer(artistaNew.getName())){
            System.out.println("El artista se ha eliminado correctamente.");
        }
        else{
            System.out.println("El artista no ha podido ser eliminado.");
        }
        System.out.println("Procedo a añadir el siguiente Colectivo:");        
        System.out.print(collectiveNew.toString());
        if(bussinessSystem.addArtist(artistaNew)){
            System.out.println("El colectivo ha sido añadido correctamente");
        }
        else{
            System.out.println("El colectivo no se ha introducido porque el nombre del colectivo\nya existe por otro colectivo o un artista\n");
        }
        
        // PRUEBA S5)
        System.out.println("PRUEBA S5)");
        System.out.println("Intento introducir el siguiente concierto:");
        Concert conciertoNew = new Concert("Hola hola", bussinessSystem.retrievePerformer("Nach"), new FechasHoras("14/11/2015", "20:30"),
        new FechasHoras("14/11/2015", "20:30"), new FechasHoras("14/11/2015", "20:00"),
        new FechasHoras("14/11/2015", "23:30"), bussinessSystem.getLocation("Carpa Universitaria"));
        System.out.print(conciertoNew.toString());
        // Compruebo si el concierto se puede introducir o no
        if(bussinessSystem.addNewConcert(conciertoNew)){
            System.out.println("El concierto se ha introducido correctamente");        
        }
        else{
            System.out.println("No se ha introducido el concierto porque el performer actua\nel mismo dia en la misma fecha en otro concierto");            
        }
        
        // PRUEBA S7)
        System.out.println("PRUEBA S5)");
        System.out.println("Intento introducir el siguiente concierto:");
        conciertoNew = new Concert("Hola hola", bussinessSystem.retrievePerformer("Alex y los Rebujitos"), new FechasHoras("14/11/2015", "20:30"),
        new FechasHoras("14/11/2015", "20:30"), new FechasHoras("14/11/2015", "20:00"),
        new FechasHoras("14/11/2015", "23:30"), bussinessSystem.getLocation("BEC"));
        System.out.print(conciertoNew.toString());
        // Compruebo si el concierto se puede introducir o no
        if(bussinessSystem.addNewConcert(conciertoNew)){
            System.out.println("El concierto se ha introducido correctamente");        
        }
        else{
            System.out.println("No se ha introducido el concierto porque la localizacion esta\nocupada para esa fecha.");            
        }
        
        // PRUEBA S8)
        System.out.println("PRUEBA S8)");
        System.out.println("Intento introducir el siguiente concierto al siguiente festival:");
        conciertoNew = new Concert("Concierto cinco", bussinessSystem.retrievePerformer("Sho-Hai"), new FechasHoras("03/02/2016", "21:15"),
            new FechasHoras("03/02/2016", "21:15"), new FechasHoras("03/02/2016", "20:15"),
            new FechasHoras("03/02/2016", "23:50"), bussinessSystem.getLocation("BEC"));
        System.out.println(conciertoNew.toString());
        System.out.println(bussinessSystem.getEvent("Festival dos").toString());
        System.out.println(bussinessSystem.getEvent("Festival dos").toString());
        
        if(bussinessSystem.addConcertToFestival((Festival)bussinessSystem.getEvent("Festival dos"), conciertoNew)){
            System.out.println("El concierto se ha añadido perfectamente al festival");
        }
        else{
            System.out.println("El concierto no se puede añadir al festival porque ya existe\ndentro del festival");
        }
    }
    
    
}
