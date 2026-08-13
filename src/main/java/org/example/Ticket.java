package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class Ticket {
    @JsonProperty("ticket_id")
    private String ticketId;
    private String address;
    @JsonProperty("issue_description")
    private String issueDescription;
    @JsonProperty("reported_date")
    private LocalDate reportedDate;
    private Priority priority;
    private Contractor contractor;
    private boolean manualReview;

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

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reportedDate = reportedDate;
    }
}
