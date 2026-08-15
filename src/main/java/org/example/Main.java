package org.example;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

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

//        String jsonInput = Parsing.jsonThroughInput();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Ticket> tickets = mapper.readValue(json, new TypeReference<List<Ticket>>() {});

        for(Ticket ticket:tickets) {
            Assign<Priority> priorityAssign = new PriorityAssign();
            ticket.setPriority(priorityAssign.assign(ticket.getIssueDescription()));

            Assign<Contractor> contractorAssign = new ContractorAssign();
            ticket.setContractor(contractorAssign.assign(ticket.getIssueDescription()));

            Display.displayTicket(ticket);
        }

    }

}