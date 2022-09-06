package com.jap.ticketing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TicketDataAnalyzer {
    public List<Ticket> readFile(String fileName) {
        List<Ticket> tickets = new ArrayList<>();
        FileReader f1 = null;
        try {
            f1 = new FileReader(fileName);
            BufferedReader br = new BufferedReader(f1);
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                tickets.add(new Ticket(arr[0],arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]),arr[6],arr[7],
                        Double.parseDouble(arr[8]),Double.parseDouble(arr[9])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tickets;
    }
    public List<Ticket> getAllTicketsSortedByDistanceTravelled(List<Ticket>ticketList,Travelled_KM travelled_km){
        Collections.sort(ticketList,travelled_km);
        return ticketList;
    }
    public double calculateTheTotalCollectionMadeFromTheSaleOfTheseTickets(List<Ticket>list){
        CalculateTheTotalCollection calculateTheTotalCollection=new CalculateTheTotalCollection() {
            @Override
            public double totalCollection(List<Ticket> list1) {
                double sum=0.0;
                for (int i = 0; i < list.size(); i++) {
                    double total_ticket_amount = list.get(i).getTotal_ticket_amount();
                    sum+=total_ticket_amount;
                }
                return sum;
            }
        };

        return calculateTheTotalCollection.totalCollection(list);
    }
}
