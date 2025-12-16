package booking.ticket.services;

import booking.ticket.entities.Ticket;
import booking.ticket.entities.User;
import booking.ticket.util.UserServiceUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class UserBookingService {

    private User user;
    private List<User> userList;
    private static final String USERS_PATH="app/src/main/java/booking.ticket/localdb/users.json";  //path of the local user database
    private ObjectMapper objectMapper=new ObjectMapper();    //serialise: map data to json, deserialise: map data from json to java

    public UserBookingService(User user1) throws IOException
    {
        this.user=user1;
        loadUsers();

    }

    public UserBookingService()throws IOException{
        loadUsers();
    }

    public List<User> loadUsers()throws IOException{
        File users=new File(USERS_PATH);
        return objectMapper.readValue(users,new TypeReference<List<User>>(){});
    }

    public boolean loginUser(){
        Optional<User> foundUser=userList.stream().filter( user1->{
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getPassword());
        }).findFirst() ;

        return foundUser.isPresent();
    }

    public Boolean signUp(User user1){
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }

    public void saveUserListToFile() throws IOException{
        File usersFile=new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }

    public void fetchBooking(){
        user.printTicket();
    }

    public Boolean cancelBooking(String ticketID){

        Optional<Ticket> validTicket=user.getTicketsBooked().stream().filter( ticket->{
            return ticket.getTicketID().equals(ticketID);
        } ).findFirst();
        if(!validTicket.isPresent()){
            System.out.println("Ticket with %ticketID TICKET ID NOT FOUND!");
            return Boolean.FALSE;
        }

        user.getTicketsBooked().remove(validTicket.get());


        for(User u : userList){
            if(u.getUserId().equals(user.getUserId())){
                u.setTicketsBooked(user.getTicketsBooked());
                break;
            }
        }

        try{
            saveUserListToFile();
            return Boolean.TRUE;
        }catch (IOException ex){
            return Boolean.FALSE;
        }
    }
}
