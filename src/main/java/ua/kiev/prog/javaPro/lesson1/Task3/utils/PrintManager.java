package ua.kiev.prog.javaPro.lesson1.Task3.utils;

import ua.kiev.prog.javaPro.lesson1.Task3.dto.Train;

import java.util.List;

public class PrintManager {

    public static void print(List<Train> trains) {
        trains.stream()
                .forEach(train -> System.out.print(train.toString()));
    }
}
