package by.izone.spring.core;


import by.izone.spring.core.beans.Client;
import by.izone.spring.core.beans.Event;
import by.izone.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    private Client client;
    private EventLogger consoleEventLogger;

    public App(Client client, EventLogger consoleEventLogger) {
        this.client = client;
        this.consoleEventLogger = consoleEventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring.xml");
        App app =  (App) applicationContext.getBean("app");
        app.logEvent((Event) applicationContext.getBean("event"));
        app.logEvent((Event) applicationContext.getBean("event"));

    }

    public void logEvent(Event msg) {
        consoleEventLogger.logEvent(msg);
    }
}
