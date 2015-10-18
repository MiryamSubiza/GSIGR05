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
import java.util.Iterator;

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
    
    private static Artist a1;
    private static Artist a2;
    private static Artist a3;
    private static Artist a4;
    private static Artist a5;
    private static Artist a6;
    private static Artist a7;
    private static Artist a8;
    private static Artist a9;
    private static Artist a10;
    private static Artist artistS3;
    
    private static Collective col1;
    private static Collective col2;
    private static Collective col3;
    private static Collective colEx1;
    private static Collective collectiveS3;
    
    private static Location l1;
    private static Location l2;
    private static Location l3;
    private static Location l4;
    private static Location l5;
    private static Location l6;
    private static Location l7;
    
    private static Concert con1;
    private static Concert con2;
    private static Concert con3;
    private static Concert con4;
    private static Concert con5;
    private static Concert con6;
    private static Concert con7;
    
    private static Festival f1;
    private static Festival f2;
    
    private static Exhibition ex1;
    private static Exhibition ex2;
    private static Exhibition ex3;
    
    private static Ticket t1;
    private static Ticket t2;
    private static Ticket t3;
    private static Ticket t4;
    private static Ticket t5;
    private static Ticket t6;
    private static Ticket t7;
    private static Ticket t8;
    private static Ticket t9;
    private static Ticket t10;
    private static Ticket t11;
    private static Ticket t12;
    
    private static Client cli1;
    private static Client cli2;
    private static Client cli3;
    private static Client cli4;
    private static Client cli5;
    private static Client cli6;
    private static Client cli7;
    private static Client cli8;
    
    public static void main (String[] args) {
        
        System.out.println("Bienvenido/a a la clase Tester01 para la realización\nde pruebas sobre nuestra práctica 01\n");
        System.out.println("Creación de algunos datos con los que empezar el testeo...");
        bussinessSystem = introduccionDatos();
        mostrarDatos();
        System.out.println("Una vez creados, comienza el testeo:\n");
        comprobacionDatos();
        
    }
    
    //Introducir una cierta cantidad de eventos, clientes, entradas, etc.
    public static BussinessSystem introduccionDatos () {
        
        bussinessSystem = new BussinessSystem();
        
        //Artists
        a1 = new Artist("Andrés Suárez", "Cantautor gallego", "www.andressuarez.es");
        a2 = new Artist("Funambulista", "Cantautor murciano", "www.funambulista.es");
        a3 = new Artist("Rozalén", "Cantautora albaceteña");
        a4 = new Artist("Nach", "Rapero alicantino", "www.nach.es");
        a5 = new Artist("Kase-O", "Javier Ibarra, MC zaragozano");
        a6 = new Artist("Lírico", "David Gilaberte, MC zaragozano");
        a7 = new Artist("Sho-Hai", "Sergio Rodríguez, MC zaragozano");
        a8 = new Artist("R de Rumba", "Rubén Cuevas, DJ zaragozano");
        a9 = new Artist("Alex Papito", "Master BOSS del Karaoke");
        a10 = new Artist("Rasking", "Coros del famoso grupo Alex y los Rebujitos");
        
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
        col1 = new Collective(a1, "Cantautores", "Conjunto de cantautores");
        col2 = new Collective(a5, "Violadores del verso", "Grupo de RAP", "violadoresdelverso.org");
        col3 = new Collective(a9, "Alex y los Rebujitos", "Grupo number ONE en el canto de Karaoke", "www.losrebujitoslapetan.com");
        
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
        l1 = new Location("Interpeñas", 25000, "Zaragoza", "www.interpeñas.es");
        l2 = new Location("Palacio de deportes", 15500, "Madrid");
        l3 = new Location("BEC", 18000, "Bilbao", "bilbaoexhibitioncentre.com");
        l4 = new Location("Palau Olimpic", 12500, "Barcelona");
        l5 = new Location("Sala Totem", 200, "Pamplona", "www.salatotem.com");
        l6 = new Location("Kursaal", 1800, "San Sebastián", "www.kursaal.eus/es");
        l7 = new Location("Carpa Universitaria", 10000, "Pamplona", "www.carpauniversitaria.com");
        
        bussinessSystem.addLocation(l1);
        bussinessSystem.addLocation(l2);
        bussinessSystem.addLocation(l3);
        bussinessSystem.addLocation(l4);
        bussinessSystem.addLocation(l5);
        bussinessSystem.addLocation(l6);
        bussinessSystem.addLocation(l7);
        
        //Concerts
        con1 = new Concert("Concierto uno", col1, new FechaCompleta("01/02/2016", "22:00"),
            new FechaCompleta("01/02/2016", "22:00"), new FechaCompleta("01/02/2016", "21:00"),
            new FechaCompleta("01/02/2016", "23:45"), l6);
        con2 = new Concert("Concierto dos", a4, new FechaCompleta("14/11/2015", "20:30"),
            new FechaCompleta("14/11/2015", "20:30"), new FechaCompleta("14/11/2015", "20:00"),
            new FechaCompleta("14/11/2015", "23:30"), l3);
        con3 = new Concert("Concierto tres", a5, new FechaCompleta("02/02/2016", "21:00"),
            new FechaCompleta("02/02/2016", "21:00"), new FechaCompleta("02/02/2016", "20:30"),
            new FechaCompleta("02/02/2016", "23:00"), l1);
        con4 = new Concert("Concierto cuatro", col2, new FechaCompleta("15/11/2015", "21:15"),
            new FechaCompleta("15/11/2015", "21:15"), new FechaCompleta("15/11/2015", "20:15"),
            new FechaCompleta("15/11/2015", "23:50"), l2);
        con5 = new Concert("Concierto cinco", a7, new FechaCompleta("03/02/2016", "21:15"),
            new FechaCompleta("03/02/2016", "21:15"), new FechaCompleta("03/02/2016", "20:15"),
            new FechaCompleta("03/02/2016", "23:50"), l3);
        con6 = new Concert("Concierto seis", a8, new FechaCompleta("02/06/2016", "21:15"),
            new FechaCompleta("02/06/2016", "21:15"), new FechaCompleta("02/06/2016", "20:15"),
            new FechaCompleta("02/06/2016", "23:50"), l5);
        con7 = new Concert("We are Back Rebujitos", col3, new FechaCompleta("06/11/2015", "12:00"),
            new FechaCompleta("06/11/2015", "12:00"), new FechaCompleta("06/11/2015", "10:00"),
            new FechaCompleta("06/11/2015", "14:00"), l7);
        
        bussinessSystem.addNewConcert(con1);
        bussinessSystem.addNewConcert(con2);
        bussinessSystem.addNewConcert(con3);
        bussinessSystem.addNewConcert(con4);
        bussinessSystem.addNewConcert(con5);
        bussinessSystem.addNewConcert(con6);
        bussinessSystem.addNewConcert(con7);
        
        //Festivals
        f1 = new Festival("Festival uno", con2, new FechaCompleta("14/11/2015", "20:00"),
            new FechaCompleta("15/11/2015", "23:50"), new FechaCompleta("14/11/2015", "20:00"),
            new FechaCompleta("15/11/2015", "23:50"));
        f2 = new Festival("Festival dos", con1, new FechaCompleta("01/02/2016", "21:00"),
            new FechaCompleta("03/02/2016", "23:50"), new FechaCompleta("01/02/2016", "21:00"),
            new FechaCompleta("03/02/2016", "23:50"));
        
        f1.addConcert(con4);
        bussinessSystem.addNewFestival(f1);
        f2.addConcert(con3);
        f2.addConcert(con5);
        bussinessSystem.addNewFestival(f2);
        
        //Exhibitions
        colEx1 = new Collective(a4, "Raperos", "Varios MC's");
        colEx1.addArtistToCollective(a5);
        colEx1.addArtistToCollective(a7);
        bussinessSystem.addCollective(colEx1);
        ex1 = new Exhibition("Exposición uno", "Exposición de RAP", "Eterno miusik",
            new FechaCompleta("15/05/2016", "15:30"), new FechaCompleta("20/05/2016", "20:30"),
            new FechaCompleta("15/05/2016", "15:30"), new FechaCompleta("20/05/2016", "20:30"),
            colEx1, "www.eternomiusik.org", l1);
        ex2 = new Exhibition("Exposición dos", "Exposición de Nach", "Universal music",
            new FechaCompleta("21/08/2016", "17:30"), new FechaCompleta("28/08/2016", "20:00"),
            new FechaCompleta("21/08/2016", "17:30"), new FechaCompleta("28/08/2016", "20:00"),
            a4, "www.universalmusic.es", l6);
        ex3 = new Exhibition("Exposición tres", "Exposición de Kase-O", "Rap solo",
            new FechaCompleta("26/09/2016", "16:45"), new FechaCompleta("26/09/2016", "21:00"),
            new FechaCompleta("26/09/2016", "16:45"), new FechaCompleta("26/09/2016", "21:00"),
            a5, "www.rapsolozgz.com", l3);
        
        bussinessSystem.addNewExhibition(ex1);
        bussinessSystem.addNewExhibition(ex2);
        bussinessSystem.addNewExhibition(ex3);
        
        //Tickets
        t1 = new Ticket(con1, bussinessSystem.getAtomicInteger(1), 1);
        t2 = new Ticket(con2, bussinessSystem.getAtomicInteger(2), 2);
        t3 = new Ticket(con3, bussinessSystem.getAtomicInteger(1), 1);
        t4 = new Ticket(con4, bussinessSystem.getAtomicInteger(1), 1);
        t5 = new Ticket(con5, bussinessSystem.getAtomicInteger(4), 4);
        t6 = new Ticket(con6, bussinessSystem.getAtomicInteger(1), 1);
        t7 = new Ticket(con7, bussinessSystem.getAtomicInteger(1), 1);
        t8 = new Ticket(f1, bussinessSystem.getAtomicInteger(1), 1);
        t9 = new Ticket(f2, bussinessSystem.getAtomicInteger(3), 3);
        t10 = new Ticket(ex1, bussinessSystem.getAtomicInteger(1), 1);
        t11 = new Ticket(ex2, bussinessSystem.getAtomicInteger(1), 1);
        t12 = new Ticket(ex3, bussinessSystem.getAtomicInteger(1), 1);
        
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
        cli1 = new Client(11111111, "Alexandre", "Izu Carmona", new FechaCompleta("25/01/1994", "00:00"),
            "1111 1111 1111 1111");
        cli2 = new Client(22222222, "Miryam", "Subiza Erro", new FechaCompleta("02/06/1994", "00:00"),
            "2222 2222 2222 2222");
        cli3 = new Client(33333333, "Ana", "Larráyoz Jiménez", new FechaCompleta("09/07/1994", "00:00"),
            "3333 3333 3333 3333");
        cli4 = new Client(44444444, "Diego", "Razquin Elcano", new FechaCompleta("24/08/1994", "00:00"),
            "4444 4444 4444 4444");
        cli5 = new Client(55555555, "Christian", "Goñi Rebollo", new FechaCompleta("14/08/1989", "00:00"),
            "5555 5555 5555 5555");
        cli6 = new Client(66666666, "Raquel", "Castillo Pérez", new FechaCompleta("26/12/1992", "00:00"),
            "6666 6666 6666 6666");
        cli7 = new Client(77777777, "José Miguel", "Carrillo", new FechaCompleta("21/09/1993", "00:00"),
            "7777 7777 7777 7777");
        cli8 = new Client(88888888, "Josu", "Goñi", new FechaCompleta("02/02/1991", "00:00"),
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
        bussinessSystem.addSale(t1, cli1, (float)13.5, "1111 1111 1111 1111");
        bussinessSystem.addSale(t2, cli1, (float)27, "1000 1000 1000 1000");
        bussinessSystem.addSale(t3, cli2, (float)17, "2222 2222 2222 2222");
        bussinessSystem.addSale(t4, cli2, (float)19, "2000 2000 2000 2000");
        bussinessSystem.addSale(t5, cli2, (float)60.5, "2111 2111 2111 2111");
        bussinessSystem.addSale(t6, cli3, (float)20.5, "3333 3333 3333 3333");
        
        return bussinessSystem;
    }
    
    //Mostrar por pantalla los datos que tenemos actualmente en el sistema
    public static void mostrarDatos() {
        
        //Show data
        System.out.println("\n************* PRESENTACIÓN DE DATOS *************");
        
        //Artists
        Iterator i = bussinessSystem.getArtists().values().iterator();
        Artist artistAux;
        while (i.hasNext()) {
            artistAux = (Artist)i.next();
            System.out.println(artistAux.toString());
        }
        
        //Collectives
        i = bussinessSystem.getCollectives().values().iterator();
        Collective collectiveAux;
        while (i.hasNext()) {
            collectiveAux = (Collective)i.next();
            System.out.println(collectiveAux.toString());
        }
        
        //Locations
        i = bussinessSystem.getLocations().values().iterator();
        Location locationAux;
        while (i.hasNext()) {
            locationAux = (Location)i.next();
            System.out.println(locationAux.toString());
        }
        
        //Concerts
        i = bussinessSystem.getConcerts().values().iterator();
        Concert concertAux;
        while (i.hasNext()) {
            concertAux = (Concert)i.next();
            System.out.println(concertAux.toString());
        }
        
        //Festivals
        i = bussinessSystem.getFestivals().values().iterator();
        Festival festivalAux;
        while (i.hasNext()) {
            festivalAux = (Festival)i.next();
            System.out.println(festivalAux.toString());
        }
        
        //Exhibitions
        i = bussinessSystem.getExhibitions().values().iterator();
        Exhibition exhibitionAux;
        while (i.hasNext()) {
            exhibitionAux = (Exhibition)i.next();
            System.out.println(exhibitionAux.toString());
        }
        
        //Tickets
        i = bussinessSystem.getTickets().values().iterator();
        Ticket ticketAux;
        while (i.hasNext()) {
            ticketAux = (Ticket)i.next();
            System.out.println(ticketAux.toString());
        }
        
        //Clients
        i = bussinessSystem.getClients().values().iterator();
        Client clientAux;
        while (i.hasNext()) {
            clientAux = (Client)i.next();
            System.out.println(clientAux.toString());
        }
        
        //Sales
        i = bussinessSystem.getSales().iterator();
        Sales saleAux;
        while (i.hasNext()) {
            saleAux = (Sales)i.next();
            System.out.println(saleAux.toString());
        }

        System.out.println("***************************************************\n");
        
    }
    
    //Comprobar y mostrar por línea de comandos varios sucesos
    public static void comprobacionDatos () {
        
        pruebaS1 ();
        pruebaS2 ();
        pruebaS3 ();
        pruebaS4 ();
        pruebaS5 ();
        pruebaS6 ();
        pruebaS7 ();
        pruebaS8 ();
        pruebaS9 ();
        pruebaS10();
        
    }
    
    public static void pruebaS1 () {
                
        // PRUEBA S1)
        System.out.println("PRUEBA S1)");
        System.out.println("Si introduce a un cliente, este puede ser luego localizado a partir de su ID\n");
        System.out.println("Búsqueda del cliente con ID 11111111");
        Client clientS1 = bussinessSystem.retrieveClient(cli1.getId());
        
        System.out.println("Obtenemos el siguiente cliente:");
        System.out.println(clientS1);
        
    }
    
    public static void pruebaS2 () {
        
        // PRUEBA S2)
        System.out.println("\nPRUEBA S2)");
        System.out.println("Si busca a un cliente que no existe con findClient, el resultado es null\n");
        System.out.println("Búsqueda del cliente con ID 00000000");
        Client clientS2 = bussinessSystem.retrieveClient(00000000);
        
        System.out.println("Obtenemos el siguiente cliente:");
        System.out.println(clientS2);
        
    }
    
    public static void pruebaS3 () {
        
        // PRUEBA S3)
        System.out.println("\n\nPRUEBA S3)");
        System.out.println("No se pueden introducir un artista y un colectivo con el mismo nombre\n");
        System.out.println("Introducción del siguiente artista:");
        artistS3 = new Artist("Stardust", "Cantante de rock");
        System.out.println(artistS3);
        
        if (bussinessSystem.addArtist(artistS3)) System.out.println("El artista ha sido añadido correctamente");
        else System.out.println("Artista no añadido, el nombre del artista ya existe en otro artista o colectivo");
        
        System.out.println("\nIntroducción del siguiente colectivo:");
        collectiveS3 = new Collective(artistS3, "Stardust", "Cantante de rock");
        System.out.println(collectiveS3);
        if (bussinessSystem.addCollective(collectiveS3)) System.out.println("El colectivo ha sido añadido correctamente");
        else System.out.println("Colectivo no añadido, el nombre del colectivo ya existe en otro artista o colectivo");
        
    }
        
    public static void pruebaS4 () {
        
        // PRUEBA S4)
        System.out.println("\n\nPRUEBA S4)");
        System.out.println("Si se añade un artista, y se elimina posteriormente, se puede introducir un colectivo con "
                + "el mismo nombre\n");
        System.out.println("Borrado del artista añadido en S3)");
        System.out.println("El artista a eliminar es:");
        System.out.println(artistS3);
        
        if (bussinessSystem.removePerformer(artistS3.getName())) System.out.println("El artista ha sido eliminado correctamente\n");
        else System.out.println("El artista no ha sido eliminado\n");
        
        System.out.println("Introducción del siguiente colectivo:");        
        System.out.println(collectiveS3);
        
        if (bussinessSystem.addCollective(collectiveS3)) System.out.println("El colectivo ha sido añadido correctamente");
        else System.out.println("El colectivo no ha sido añadido, el nombre del colectivo ya existe en otro artista o colectivo");
        
    }
    
    public static void pruebaS5 () {
    
        // PRUEBA S5)
        System.out.println("\n\nPRUEBA S5)");
        System.out.println("No se pueden añadir dos eventos diferentes del mismo artista el mismo día\n");
        System.out.println("Concierto existente:");
        System.out.println(con2);
        System.out.println("Introducción del siguiente concierto:");
        Concert concertS5 = new Concert("Hola hola", bussinessSystem.retrievePerformer("Nach"), new FechaCompleta("14/11/2015", "20:30"),
            new FechaCompleta("14/11/2015", "20:30"), new FechaCompleta("14/11/2015", "20:00"),
            new FechaCompleta("14/11/2015", "23:30"), bussinessSystem.getLocation("Carpa Universitaria"));
        System.out.println(concertS5);
        
        // Compruebo si el concierto se puede introducir o no
        if (bussinessSystem.addNewConcert(concertS5)) System.out.println("El concierto ha sido añadido correctamente");
        else System.out.println("El concierto no ha sido añadido, el performer (artista) actúa el mismo día en otro evento");
        
    }
    
    public static void pruebaS6 () {
        
        // PRUEBA S6)
        System.out.println("\n\nPRUEBA S6)");
        System.out.println("El sistema calcula de manera adecuada el gasto de cada cliente en entradas (probar con más de \n"
            + "dos entradas, así como con entradas asociadas a diferentes clientes)\n");
        System.out.println("Cálculo del gasto en entradas del cliente 22222222. Historial de entradas compradas:");
        Ticket[] historial;
        historial = bussinessSystem.getListOfTickets(cli2);
        for (int i = 0; i < historial.length; i++) {
            System.out.println(historial[i]);
        }
        System.out.println("El gasto del cliente 22222222 en entradas es de " + bussinessSystem.getTotalSpending(cli2) + "€");

    }
    
    public static void pruebaS7 () {
        
        // PRUEBA S7)
        System.out.println("\n\nPRUEBA S7)");
        System.out.println("No se puede asociar un evento a una localización que no existe\n");
        System.out.println("Introducción del siguiente concierto en una supuesta localización llamada 'S7'");
        Concert concertS7 = new Concert("Hola hola", bussinessSystem.retrievePerformer("Alex y los Rebujitos"), 
            new FechaCompleta("14/11/2015", "20:30"), new FechaCompleta("14/11/2015", "20:30"), 
            new FechaCompleta("14/11/2015", "20:00"), new FechaCompleta("14/11/2015", "23:30"), 
            new Location("S7", 100, "Navarra"));
        System.out.println(concertS7);
        
        // Compruebo si el concierto se puede introducir o no
        if (bussinessSystem.addNewConcert(concertS7)) System.out.println("El concierto ha sido añadido correctamente");
        else System.out.println("El concierto no ha sido añadido, la localización no existe en el sistema");
        
    }
    
    public static void pruebaS8 () {
        
        // PRUEBA S8)
        System.out.println("\n\nPRUEBA S8)");
        System.out.println("No se puede añadir a un festival un concierto que ya se le hubiera añadido\n");
        System.out.println("Introducción del siguiente concierto al siguiente festival:");
        System.out.println(con5);
        System.out.println(bussinessSystem.getEvent("Festival dos"));
        
        if (bussinessSystem.addConcertToFestival((Festival)bussinessSystem.getEvent("Festival dos"), con5)) 
            System.out.println("El concierto ha sido añadido al festival");
        else System.out.println("El concierto no ha sido añadido al festival porque ya existe dentro del mismo");
        
    }
    
    public static void pruebaS9 () {
        
        // PRUEBA S9)
        System.out.println("\n\nPRUEBA S9)");
        System.out.println("No se puede asignar una venta a un cliente que no existe\n");
        System.out.println("Introducción de la siguiente venta a un supuesto cliente de ID 00000000:");
        Sales salesS9 = new Sales(t10, new Client(00000000, "Perico", "De Andrés", new FechaCompleta("02/01/1990", "00:00"), 
            "1111 1111 1111 1111"), 10, "0000 0000 0000 0000", new FechaCompleta("03/10/2015", "14:00"));
        System.out.println(salesS9);
        if (bussinessSystem.addSale(t10, new Client(00000000, "Perico", "De Andrés", new FechaCompleta("02/01/1990", "00:00"), 
            "1111 1111 1111 1111"), (float)10, "1111 1111 1111 1111")) 
            System.out.println("La venta ha sido asignada al cliente");
        else System.out.println("La venta no ha sido asignada, el cliente no existe");
        
    }
    
    public static void pruebaS10 () {
        
        // PRUEBA S10)
        System.out.println("\n\nPRUEBA S10)");
        System.out.println("No se puede introducir un usuario menor de edad\n");
        System.out.println("Introducción del siguiente supuesto:");
        Client clientS10 = new Client(12345678, "Maria", "De la o", new FechaCompleta("16/02/2000", "00:00"),
            "1234 1234 1234 1234");
        System.out.println(clientS10);
        if (bussinessSystem.addClient(clientS10)) System.out.println("El cliente ha sido introducido\n");
        else System.out.println("El cliente no ha sido introducido, es menor de edad\n");
        
    }
    
}
