package ua.kiev.prog.javaPro.lesson1.Task3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.kiev.prog.javaPro.lesson1.Task3.utils.marshallers.DateMarshaller;
import ua.kiev.prog.javaPro.lesson1.Task3.utils.marshallers.TimeMarshaller;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@XmlRootElement(name = "train")
@XmlAccessorType(XmlAccessType.FIELD)
public class Train  implements Serializable {
    @XmlJavaTypeAdapter(DateMarshaller.class)
    private Date date;
    @XmlJavaTypeAdapter(TimeMarshaller.class)
    private Date departure;
    @XmlElement
    private String from;
    @XmlAttribute
    private String id;
    @XmlElement
    private String to;

    public Train(Date date, Date departure, String from, String id, String to) {
        this.date = date;
        this.departure = departure;
        this.from = from;
        this.id = id;
        this.to = to;
    }

    @Override public String toString() {
        return "Train{" +
                "date=" + date +
                ", departure=" + departure +
                ", from='" + from + '\'' +
                ", id='" + id + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
