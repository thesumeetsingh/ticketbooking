package booking.ticket.entities;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {

    private String trainId;
    private String trainNo;
//    private String trainName;  //name of the train

    private List<List<Integer>> seats;  //2d matrix of seats avaiable with 0 and 1 marked for occupied or not
    private Map<String, String> stationTimes;  //map of station name to time of arrival

    private List<String> stations;  //where the train stops

    public Train(){}

    //getters
    public Train(String trainId, String trainNo, List<List<Integer>> seats, Map<String, String> stationTimes, List<String> stations){
        this.trainId=trainId;
        this.trainNo=trainNo;

        this.seats=seats;
        this.stationTimes=stationTimes;
        this.stations=stations;
    }

    public List<String> getStations(){
        return stations;
    }

    public List<List<Integer>> getSeats(){
        return  seats;

    }

    public String getTrainId(){
        return trainId;
    }

    public String getTrainNo(){
        return trainNo;
    }

    public Map<String, String > getStationTimes(){
        return stationTimes;
    }

    public String getTrainInfo(){
        return String.format("Train ID: %s Train No: %s", trainId, trainNo);
    }

    //setters
    public void setTrainId(){
        this.trainId=trainId;
    }

    public void setTrainNo(){
        this.trainNo=trainNo;
    }

    public void setSeats(List<List<Integer>> seats){
        this.seats=seats;
    }

    public void setStationTimes(Map<String, String> stationTimes){
        this.stationTimes=stationTimes;
    }

    public  void setStations(List<String> stations){
        this.stations=stations;
    }





}
