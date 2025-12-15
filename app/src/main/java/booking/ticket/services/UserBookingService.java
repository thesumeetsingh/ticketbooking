package booking.ticket.services;

import booking.ticket.entities.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserBookingService {

    private User user;
    private static final String USERS_PATH="../localdb/users.json";  //path of the local user database
    private ObjectMapper objectMapper=new ObjectMapper();    //serialise: map data to json, deserialise: map data from json to java
    private List<User> userList;

    public UserBookingService(User user) throws IOException
    {
        this.user=user;
        File users=new File(USERS_PATH);
        userList = objectMapper.readValue(users, new TypeReference<List<User>>(){});

    }
}
