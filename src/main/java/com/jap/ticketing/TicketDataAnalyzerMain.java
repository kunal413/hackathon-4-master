package com.jap.ticketing;

import java.util.List;

public class TicketDataAnalyzerMain {

    public static void main(String[] args) {
        String fileName = "sample.csv";
        TicketDataAnalyzer ticketDataAnalyzer=new TicketDataAnalyzer();
        List<Ticket> output = ticketDataAnalyzer.readFile(fileName);

        List<Ticket> tickets = ticketDataAnalyzer.readFile(fileName);
       // System.out.println(tickets);
        for (Ticket t :output) {
            System.out.println(t);
        }
        System.out.println("=====================================");
        List<Ticket> allTicketsSortedByDistanceTravelled = ticketDataAnalyzer.getAllTicketsSortedByDistanceTravelled(output, new Travelled_KM());
        for (Ticket t1 :
                allTicketsSortedByDistanceTravelled) {
            System.out.println(t1);
        }
        System.out.println("==============================================");
        double v = ticketDataAnalyzer.calculateTheTotalCollectionMadeFromTheSaleOfTheseTickets(output);
        System.out.println(v);
    }
}
