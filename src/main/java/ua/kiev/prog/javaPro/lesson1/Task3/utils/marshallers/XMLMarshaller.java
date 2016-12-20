package ua.kiev.prog.javaPro.lesson1.Task3.utils.marshallers;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static java.lang.String.format;


@Slf4j
public class XMLMarshaller {


    public static <T> void marshal(File file, T object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, file);
        } catch (JAXBException e) {
            log.error(format("Can't convertToString file: %s", file.getName()));
        }
    }

    public static <T> T unmarshal(File file, Class<T> destinationClass) {
        Object unmarshal = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(destinationClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshal = unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            log.error(format("Can't convertToDate to file: %s", file.getName()));
        }
        return (T) unmarshal;
    }
}
