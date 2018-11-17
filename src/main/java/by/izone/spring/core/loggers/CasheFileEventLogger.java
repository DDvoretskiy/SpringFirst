package by.izone.spring.core.loggers;

import by.izone.spring.core.beans.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component("cacheFileEventLogger")

public class CasheFileEventLogger extends FileEventLogger {
    @Value("${cache.size:5}")
    private int casheSize;
    private List<Event> cash = new ArrayList<>();

    public CasheFileEventLogger() {
    }
    public CasheFileEventLogger(String fileName, int casheSize) {
        super(fileName);
        this.casheSize = casheSize;

    }

    @Override
    public void logEvent(Event event) {
        cash.add(event);
        if (cash.size() == casheSize) {
            cash.forEach(super::logEvent);
            cash.clear();
        }
    }

    @PostConstruct
    void init() {
        super.init();
    }

    @PreDestroy
    private void destroy(){
        if(!cash.isEmpty()){
            cash.forEach(super::logEvent);
            cash.clear();
        }
    }
}
