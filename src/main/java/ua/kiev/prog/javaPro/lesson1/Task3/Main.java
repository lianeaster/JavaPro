package ua.kiev.prog.javaPro.lesson1.Task3;

import lombok.extern.slf4j.Slf4j;
import ua.kiev.prog.javaPro.lesson1.Task3.utils.PrintManager;

@Slf4j
public class Main {

    public static void main(String[] args) {
        PrintManager.print(TrainManager.findTrainsByTime("15:00", "19:00"));
        TrainManager.addNewTrain("19.12.2016","21:00","Kharkiv","3","Odesa");
    }
}
