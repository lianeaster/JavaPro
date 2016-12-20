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
        Optional.of(new File(path))
                .filter(file -> !file.exists())
                .ifPresent(file -> writeToFile(path, linesToWrite, file));
    }

    private void writeToFile(String path, List<String> linesToWrite, File file) {
        try {
            file.createNewFile();
            Files.write(Paths.get(path), linesToWrite);
        } catch (IOException e) {
            log.error("Can't write to file!");
        }
    }
}
