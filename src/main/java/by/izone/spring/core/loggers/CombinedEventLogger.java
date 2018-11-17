package by.izone.spring.core.loggers;

import by.izone.spring.core.beans.Event;
import org.springframework.stereotype.Component;


import java.util.Collection;

@Component
public class CombinedEventLogger implements EventLogger  {

    private final Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger logger :
                loggers) {
            logger.logEvent(event);
        }

    }
}
