package org.example;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

//TODO make nice menu
//TODO make input from file choice
//TODO create program logic
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scannerObj = new Scanner(System.in);

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

        ObjectMapper mapper = new ObjectMapper();
//        Ticket ticket = mapper.readValue(json, Ticket.class);

        List<Ticket> tickets = mapper.readValue(json, new TypeReference<List<Ticket>>() {});

        for(Ticket ticket:tickets) {
            setCategories(ticket);
            displayTicket(ticket);
        }



//        Ticket[] ticketList = jsonThroughInput(scannerObj);

//        System.out.println(ticketList[0].getTicket_id());
//        System.out.println(ticketList[1].getTicket_id());
//        System.out.println(ticketList[2].getDate());


        scannerObj.close();
    }

    public static Ticket[] jsonThroughInput(Scanner scannerObj) {

        StringBuilder jsonInput = new StringBuilder();
        String currentLine;

        System.out.println("Please input how many elements you will add:");
        Ticket[] ticketList = new Ticket[scannerObj.nextInt()];
        int ticketPos = 0;
//        System.out.println(ticketList.length);

        System.out.println("Enter input: (note that the input stream will end when an enclosing square bracket is presented ']')");

        while (scannerObj.hasNextLine()){
//            System.out.println("hi");
            currentLine = scannerObj.nextLine();
            if (currentLine.contains("[") || currentLine.contains("{")) {
                continue;
            } else if (currentLine.contains("}")){
//                currentLine
                jsonInput.append(currentLine).append("\n");

//                ticketList[ticketPos++] = createTicket(jsonInput.toString());
                jsonInput.setLength(0);

//                ticketList[ticketPos++] = new Ticket("TKT-101","Flat 4, 12 High Street","There is a massive water leak from the ceiling in the bathroom.","2026-07-21",Priority.Urgent, Contractor.Electrician, false);
            } else if (currentLine.contains("\"ticket_id\"") || currentLine.contains("\"address\"") || currentLine.contains("\"issue_description\"") || currentLine.contains("\"reported_date\"")) {
                jsonInput.append(currentLine).append("\n");
            } else if (currentLine.equals("]") ) break;


        }
        return ticketList;

    }

    public static void setCategories(Ticket ticket) {
        ticket.setPriority(Priority.Urgent);
        ticket.setContractor(Contractor.Plumber);
    }

    public static void displayTicket(Ticket ticket) {
        System.out.println("\nTicket: "+ticket.getTicketId());
        System.out.println("Address: "+ticket.getAddress());
        System.out.println("Assigned Contractor: "+ticket.getContractor());
        System.out.println("Priority: "+ticket.getPriority());
    }

}