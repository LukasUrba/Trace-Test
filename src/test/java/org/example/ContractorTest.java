package org.example;

import org.example.Contractor.Contractor;
import org.example.Contractor.ContractorAssign;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContractorTest {
    Assign<Contractor> contractorAssign = new ContractorAssign();
    Ticket ticket = new Ticket();
    @Test
    void settingAndGettingContractor() {
        String issueDescription = "There is a massive water leak from the ceiling in the bathroom.";

        ticket.setIssueDescription(issueDescription);
        ticket.setContractor(contractorAssign.assign(ticket.getIssueDescription()));

        assertEquals(Contractor.Plumber, ticket.getContractor());

    }

    @Test
    void settingContractorMissingInfo() {

        ticket.setIssueDescription(null);
        ticket.setContractor(contractorAssign.assign(ticket.getIssueDescription()));

        assertEquals(Contractor.HelpDesk, ticket.getContractor());

    }
}
