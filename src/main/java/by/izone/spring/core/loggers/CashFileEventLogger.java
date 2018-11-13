package by.izone.spring.core.loggers;

import by.izone.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CashFileEventLogger extends FileEventLogger {
    private int casheSize;
    private List<Event> cash = new ArrayList<>();

    public CashFileEventLogger(String fileName,int casheSize) {
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

    @Override
    void init() {
        super.init();
    }

    private void destroy(){
        if(!cash.isEmpty()){
            cash.forEach(super::logEvent);
            cash.clear();
        }
    }
}
