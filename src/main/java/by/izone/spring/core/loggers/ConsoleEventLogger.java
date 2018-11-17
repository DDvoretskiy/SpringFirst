package by.izone.spring.core.loggers;

import by.izone.spring.core.beans.Event;
import org.springframework.stereotype.Component;

@Component
public class ConsoleEventLogger implements EventLogger {
    @Override
    public void logEvent(Event event) {
        System.out.print(event);
    }
}