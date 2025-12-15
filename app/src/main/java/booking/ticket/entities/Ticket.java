package booking.ticket.entities;

import java.util.Date;

public class Ticket {


    private String ticketID;

    private String userId;
    private String source;
    private String destination;

    private String dateOfTravel;

    private Train train;

    public Ticket(){}

    public Ticket(String ticketID, String userId, String source, String destination, String dateOfTravel, Train train){
        this.ticketID=ticketID;
        this.userId=userId;
        this.source=source;
        this.destination=destination;
        this.dateOfTravel=dateOfTravel;
        this.train=train;

    }

    public String getTicketInfo(){
        return String.format("Ticket ID: %s belongs to User %s from %s to %s on %s", ticketID, userId, source, destination, dateOfTravel);
    }


    public String getTicketID(){
        return  ticketID;
    }

    public void setTicketID(String ticketID){
        this.ticketID=ticketID;
    }


}
    ;
