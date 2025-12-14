package booking.ticket.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {

    private String trainId;
    private Integer trainNo;
    private String trainName;  //name of the train

    private List<List<Integer>> seats;  //2d matrix of seats avaiable with 0 and 1 marked for occupied or not
    private Map<String, Date> stationTimes;  //map of station name to time of arrival

    private List<String> stations;  //where the train stops

}
