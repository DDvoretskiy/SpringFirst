package by.izone.spring.core.loggers;

public class ConsoleEventLogger implements EventLogger {

    public void logEvent(String logEvent) {
        System.out.println(logEvent);
    }
}