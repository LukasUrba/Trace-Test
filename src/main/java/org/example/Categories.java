package org.example;

public class Categories {
    public static void setCategories(Ticket ticket) {
        ticket.setPriority(Priority.Urgent);
        ticket.setContractor(Contractor.Plumber);
    }
}
