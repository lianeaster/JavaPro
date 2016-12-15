package ua.kiev.prog.javaPro.lesson1.Task2;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@SaveTo(path = "src\\main\\resources\\task2.txt")
public class TextContainer {
    public static String TEXT_TO_SAVE = "This text should be saved!";

    @Saver
    public void save(String path) {
        List<String> linesToWrite = new ArrayList<>();
        linesToWrite.add(TEXT_TO_SAVE);

        try {
//            File file = new File(path);
//            if (!file.exists())
//                file.createNewFile();
            Optional.of(new File(path))
                    .filter(file -> !file.exists())
                    .get().createNewFile();

            Files.write(Paths.get(path), linesToWrite);
        } catch (IOException e) {
            log.error("Can't write to file!");
        }
    }
}
