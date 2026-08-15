package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

//TODO make nice menu
//TODO make input from file choice
//TODO create program logic

//TODO https://dev.to/sadiul_hakim/jackson-tutorial-comprehensive-guide-with-examples-2gdj
//https://www.baeldung.com/jackson
//
//if leak, gas, dangerous && not no leak not a leak not dangerous, set urgent
//else if broken, set medium
//else set low
public class Main {
    public static void main(String[] args) throws Exception{

        String json = """
                [
                  {
                    "ticket_id": "TKT-101",
                    "address": "Flat 4, 12 High Street",
                    "issue_description": "There is a massive water leak from the ceiling in the bathroom.",
                    "reported_date": "2026-07-21"  },
                  {
                    "ticket_id": "TKT-102",
                    "address": "Apt 12, Victoria Court",
                    "issue_description": "The kitchen lightbulb is flickering and needs replacing.",
                    "reported_date": "2026-07-21"  },
                  {
                    "ticket_id": "TKT-103",
                    "address": "34 Meadow Lane",
                    "issue_description": "The bedroom lock is sticking and the key is hard to turn.",
                    "reported_date": "2026-07-20"  }
                 ]
                """;

        String jsonInput = Parsing.jsonThroughInput();

        ObjectMapper mapper = new ObjectMapper();
//        Ticket ticket = mapper.readValue(json, Ticket.class);

        List<Ticket> tickets = mapper.readValue(jsonInput, new TypeReference<List<Ticket>>() {});

        for(Ticket ticket:tickets) {
            Categories.setCategories(ticket);
            Display.displayTicket(ticket);
        }


    }






}