package by.izone.spring.core.loggers;


import by.izone.spring.core.beans.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class FileEventLogger implements EventLogger {

    private String fileName;
    @Value("d:\\test.txt")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public FileEventLogger(){}

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @PostConstruct
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
