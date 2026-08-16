package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class TicketTest {
    Ticket ticket = new Ticket();

    @Test
    void gettingTicketIDNoInfo() {
        assertNull(ticket.getTicketId());
    }
    @Test
    void settingAndGettingTicketID() {
        ticket.setTicketId("T-100");
        assertEquals("T-100",
                ticket.getTicketId());
    }

    @Test
    void gettingAddressNoInfo() {
        assertNull(ticket.getAddress());
    }
    @Test
    void settingAndGettingAddress() {
        ticket.setAddress("Flat 4, 12 High Street");
        assertEquals("Flat 4, 12 High Street",
                ticket.getAddress());
    }

    @Test
    void gettingIssueDescriptionNoInfo() {
        assertNull(ticket.getIssueDescription());
    }
    @Test
    void settingAndGettingIssueDescription() {
        ticket.setIssueDescription("There is a massive water leak from the ceiling in the bathroom.");
        assertEquals("There is a massive water leak from the ceiling in the bathroom.",
                ticket.getIssueDescription());

    }


}