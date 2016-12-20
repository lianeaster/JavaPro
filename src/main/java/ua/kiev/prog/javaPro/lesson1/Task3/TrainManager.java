package ua.kiev.prog.javaPro.lesson1.Task3;

import lombok.extern.slf4j.Slf4j;
import ua.kiev.prog.javaPro.lesson1.Task3.dto.Train;
import ua.kiev.prog.javaPro.lesson1.Task3.dto.Trains;
import ua.kiev.prog.javaPro.lesson1.Task3.utils.marshallers.DateMarshaller;
import ua.kiev.prog.javaPro.lesson1.Task3.utils.marshallers.TimeMarshaller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static ua.kiev.prog.javaPro.lesson1.Task3.utils.marshallers.XMLMarshaller.marshal;
import static ua.kiev.prog.javaPro.lesson1.Task3.utils.marshallers.XMLMarshaller.unmarshal;

@Slf4j
public class TrainManager {

    private static String PATHNAME = "src\\main\\resources\\task3.xml";

    private TrainManager() {
    }

    public static Train addNewTrain(String date, String departure, String from, String id, String to) {
        Train newTrain = null;
        try {
            Date unmarshalledDate = new DateMarshaller().unmarshal(date);
            Date unmarshalledTime = new TimeMarshaller().unmarshal(departure);
            newTrain = new Train(unmarshalledDate, unmarshalledTime, from, id, to);
            Trains trains = unmarshal(new File(PATHNAME), Trains.class);
            trains.getTrain().add(newTrain);
            marshal(new File(PATHNAME), trains);
        } catch (Exception e) {
            log.error(format("Can't add new entity to file %s",PATHNAME));
        }
        return newTrain;
    }

    public static List<Train> findTrainsByTime(String from, String to) {
        List<Train> collect = null;
        try {
            collect = unmarshal(new File(PATHNAME), Trains.class)
                    .getTrain()
                    .stream()
                    .filter(train -> {
                        Date departure = train.getDeparture();
                        return departure.after(new TimeMarshaller().unmarshal(from)) &&
                                departure.before(new TimeMarshaller().unmarshal(to));
                    })
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error(format("Can't find entities in file %s",PATHNAME));
        }
        return collect;

    }
}
