package booking.ticket.services;

import booking.ticket.entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;
    private List<User> userList;
    private static final String USERS_PATH="../localdb/users.json";  //path of the local user database
    private ObjectMapper objectMapper=new ObjectMapper();    //serialise: map data to json, deserialise: map data from json to java

    public UserBookingService(User user1) throws IOException
    {
        this.user=user1;
        File users=new File(USERS_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>(){});

    }

    public boolean loginUser(){
        Optional<User> foundUser=userList.stream().filter( user1->{
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword, user1.getPassword);
        }).findFirst() ;

        return foundUser.isPresent();
    }
}
