package ua.kiev.prog.javaPro.lesson1.Task3.utils.marshallers;

import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;

@Slf4j
public class TimeMarshaller extends XmlAdapter<String, Date> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");

    @Override public Date unmarshal(String v) {
        Date date = null;
        try {
            date = dateFormat.parse(v);
        } catch (ParseException e) {
            log.error(format("Can't parse string %s into date ",v));
        }
        return date;
    }

    @Override public String marshal(Date v) {
        return dateFormat.format(v);
    }
}
