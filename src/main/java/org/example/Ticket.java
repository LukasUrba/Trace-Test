package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.Contractor.Contractor;
import org.example.Priority.Priority;

public class Ticket {
    @JsonProperty("ticket_id")
    private String ticketId;
    private String address;
    @JsonProperty("issue_description")
    private String issueDescription;
    @JsonProperty("reported_date")
    private String reportedDate;
    private Priority priority;
    private Contractor contractor;

    public Ticket() {}

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }
}
