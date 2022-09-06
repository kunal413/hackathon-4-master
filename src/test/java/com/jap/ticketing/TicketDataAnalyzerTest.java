package com.jap.ticketing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

public class TicketDataAnalyzerTest  {
    TicketDataAnalyzer ticketDataAnalyzer = null;
    Ticket ticket;
    String fileName = "sample.csv";
    @Before
    public void setUp() {
        ticketDataAnalyzer = new TicketDataAnalyzer();
    }
    @After
    public void tearDown(){
        ticketDataAnalyzer = null; ticket = null;
    }
    @Test
    public void givenWrongDataFormatThrowsNumberFormatException() {
        ticketDataAnalyzer.readFile(fileName);
    }
    @Test
    public void givenTicketDetailsFileReturnTheNUmberOfTicketRecordObjects() {
        List<Ticket> output = ticketDataAnalyzer.readFile(fileName);
        assertEquals("Sales record objects not returned correctly",49,output.size());

    }
    @Test
    public void givenTicketDetailsListReturnSortedListByTicketTravelledKM(){
        List<Ticket> output = ticketDataAnalyzer.readFile(fileName);
        assertEquals(49.5,ticketDataAnalyzer.getAllTicketsSortedByDistanceTravelled(output,new Travelled_KM()).get(0).getTravelled_KM(),0);
    }
    @Test
    public void givenTheTotalCollectionOfAmountOfTicket(){
        List<Ticket>output=ticketDataAnalyzer.readFile(fileName);
        assertEquals(10348.0,ticketDataAnalyzer.calculateTheTotalCollectionMadeFromTheSaleOfTheseTickets(output),0);
    }


}