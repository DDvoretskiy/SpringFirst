package by.izone.spring.core.beans;

import by.izone.spring.core.util.DateTimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String msg;
    private LocalDate date;

    public Event(LocalDateTime date) {
        this.date = date.toLocalDate();
        id = count.incrementAndGet();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "id: "+id+"\t"+DateTimeUtil.toString(date)+"\t"+msg+"\n";
    }

}
