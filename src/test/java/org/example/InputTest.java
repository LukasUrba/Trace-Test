package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {

    @Test
    void inputFromFile() {
        File inputFile = new File("src/main/java/org/example/data/input.json");

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
//    @Test
//    void inputMissingFile() {
//        String testString = Parsing.jsonThroughFile("");
//        assertThrows(FileNotFoundException e, )
//
//
//    }
    @Test
    void inputMissingInfo() {

    }
}
