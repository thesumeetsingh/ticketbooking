package booking.ticket.services;

import booking.ticket.entities.Train;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrainService {
    private static final String trainPath="app/src/main/java/booking.ticket/localdb/trains.json";
    private final static ObjectMapper objectMapper=new ObjectMapper();
    public   List<Train> allTrain;


    public TrainService()throws IOException{
        allTrain=loadTrains();

    }
    public List<Train> loadTrains() throws IOException{
        File trains=new File(trainPath) ;
        return objectMapper.readValue(trains, new TypeReference<List<Train>>() {});
    }

    public  List<Train> searchTrain(String source, String destination)throws IOException {
        allTrain=loadTrains();

        return  allTrain.stream().filter(train ->
            validTrain(train, source, destination)
        ).collect(Collectors.toList());
    }


    public boolean validTrain(Train train, String source, String destination){
        List<String> stations= train.getStations().stream().map(String::toLowerCase).collect(Collectors.toList());
        return stations.contains(source.toLowerCase()) && stations.contains(destination.toLowerCase());
    }
}
