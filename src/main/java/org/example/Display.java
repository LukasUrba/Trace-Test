package org.example;

public class Display {
    public static void displayTicket(Ticket ticket) {
        System.out.println("\nTicket: "+ticket.getTicketId());
        System.out.println("Address: "+ticket.getAddress());
        System.out.println("Assigned Contractor: "+ticket.getContractor());
        System.out.println("Priority: "+ticket.getPriority());
    }
}
