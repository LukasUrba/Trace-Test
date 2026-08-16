package org.example;

import org.example.Priority.Priority;
import org.example.Priority.PriorityAssign;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityTest {
    Assign<Priority> priorityAssign = new PriorityAssign();
    Ticket ticket = new Ticket();
    @Test
    void settingAndGettingPriority() {
        String issueDescription = "There is a massive water leak from the ceiling in the bathroom.";

        ticket.setIssueDescription(issueDescription);
        ticket.setPriority(priorityAssign.assign(ticket.getIssueDescription()));

        assertEquals(Priority.Urgent, ticket.getPriority());
    }

    @Test
    void settingPriorityMissingInfo() {
        ticket.setIssueDescription(null);
        ticket.setPriority(priorityAssign.assign(ticket.getIssueDescription()));

        assertEquals(Priority.Medium, ticket.getPriority());

    }
}
