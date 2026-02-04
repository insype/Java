package ticket.booking.services;

import ticket.booking.entities.Train;

import java.util.List;
import java.util.stream.Collectors;

public class TrainService {
   private List<Train> trains;

   public TrainService(List<Train> trains){
       this.trains = trains;
   }
   public List<Train> searchTrains(String source , String destination){
       return trains.stream().filter(train -> train.getStations().contains(source))
                .filter(train -> train.getStations().contains(destination))
                .filter(train -> train.getStations().indexOf(source) < train.getStations().indexOf(destination))
                .collect(Collectors.toList());
   }

}