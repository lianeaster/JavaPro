package ua.kiev.prog.javaPro.lesson1.Task3.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Data
@XmlRootElement(name = "trains")
@XmlAccessorType(XmlAccessType.FIELD)
public class Trains implements Serializable {
    @XmlElement
    private List<Train> train;
}
