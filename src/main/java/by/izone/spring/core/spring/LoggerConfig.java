package by.izone.spring.core.spring;

import by.izone.spring.core.beans.EventType;
import by.izone.spring.core.loggers.CasheFileEventLogger;
import by.izone.spring.core.loggers.EventLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;

@Configuration
public class LoggerConfig {



    @Resource(name = "consoleEventLogger")
    private EventLogger consoleEventLogger;

    @Resource(name = "cacheFileEventLogger")
    private EventLogger cacheFileEventLogger;

    @Resource(name = "fileEventLogger")
    private EventLogger fileEventLogger;

    @Resource(name = "combinedEventLogger")
    private EventLogger combinedEventLogger;



    @Bean("combinedLoggers")
    public Collection<EventLogger> combinedLoggers() {
        Collection<EventLogger> loggers = new ArrayList<EventLogger>(2);
        loggers.add(consoleEventLogger);
        loggers.add(cacheFileEventLogger);
        return loggers;
    }

    @Bean("loggerMap")
    public Map<EventType, EventLogger> loggerMap() {
        Map<EventType, EventLogger> map = new EnumMap<>(EventType.class);
        map.put(EventType.INFO, consoleEventLogger);
        map.put(EventType.ERROR, combinedEventLogger);
        return map;
    }

    @Bean("defaultLogger")
    public EventLogger defaultLogger() {
        return new CasheFileEventLogger();
    }

}
