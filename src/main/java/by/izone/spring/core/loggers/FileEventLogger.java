package by.izone.spring.core.loggers;


import by.izone.spring.core.beans.Event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileEventLogger implements EventLogger {
    private String fileName;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    void init() {
        if (!Files.isWritable(Paths.get(fileName))) {
            System.out.println("невозможно писать в файл");

        }
    }

    @Override
    public void logEvent(Event event) {
        String content = event.toString();

        try {
            Files.write(Paths.get(fileName), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
