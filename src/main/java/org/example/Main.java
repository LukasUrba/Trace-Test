package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.example.Contractor.Contractor;
import org.example.Contractor.ContractorAssign;
import org.example.Priority.Priority;
import org.example.Priority.PriorityAssign;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        //change Parsing method calls for direct access from file or input without primary menu
        String jsonInput = Parsing.chooseInput();

    ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List<Ticket> tickets = mapper.readValue(jsonInput, new TypeReference<>() {});

        for(Ticket ticket:tickets) {
            assignFields(ticket);
            Display.displayTicket(ticket);
        }

    }

    public static void assignFields(Ticket ticket) {
        Assign<Priority> priorityAssign = new PriorityAssign();
        ticket.setPriority(priorityAssign.assign(ticket.getIssueDescription()));

        Assign<Contractor> contractorAssign = new ContractorAssign();
        ticket.setContractor(contractorAssign.assign(ticket.getIssueDescription()));
    }

}