package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Contractor.Contractor;
import org.example.Priority.Priority;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class InputTest {

    @Test
    void inputFromFile() {
        String jsonFromFile = assertDoesNotThrow(
                () -> Parsing.jsonThroughFile("src/test/java/org/example/test-data/input.json")
        );

        assertTrue(jsonFromFile.contains("TKT-101"));
    }

    @Test
    void inputFromText() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = """
                                  {
                                    "ticket_id": "TKT-101",
                                    "address": "Flat 4, 12 High Street",
                                    "issue_description": "There is a massive water leak from the ceiling in the bathroom.",
                                    "reported_date": "2026-07-21"  }
                """;

        Ticket ticket = mapper.readValue(jsonString, Ticket.class);
        assertAll("ticket fields",
                () -> assertEquals("TKT-101", ticket.getTicketId()),
                () -> assertEquals("Flat 4, 12 High Street", ticket.getAddress()),
                () -> assertEquals("There is a massive water leak from the ceiling in the bathroom.", ticket.getIssueDescription())
        );

    }
    @Test
    void inputMissingFile() {

        assertThrows(RuntimeException.class, () ->
                Parsing.jsonThroughFile(""));
    }
    @Test
    void inputWithMissingInfo() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = """
                                  {
                                    "ticket_id": "TKT-101",
                                    "address": "Flat 4, 12 High Street",
                                    "reported_date": "2026-07-21"  }
                """;
        Ticket ticket = mapper.readValue(jsonString, Ticket.class);
        Main.assignFields(ticket);
        assertAll(
                () -> assertNull(ticket.getIssueDescription()),
                () -> assertEquals(Priority.Medium, ticket.getPriority()),
                () -> assertEquals(Contractor.HelpDesk, ticket.getContractor())
        );

    }
}
