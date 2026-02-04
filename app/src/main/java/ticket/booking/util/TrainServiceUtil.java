package ticket.booking.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TrainServiceUtil {
    private static final String TRAIN_PATH = "LocalDb/trains.json";

    public static List<Train> loadTrains() throws IOException {
        ObjectMapper om = new ObjectMapper();
        File trainFile = new File(TRAIN_PATH);

        return om.readValue(trainFile, new TypeReference<List<Train>>() {});
    }
}
