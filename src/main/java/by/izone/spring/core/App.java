package by.izone.spring.core;


import by.izone.spring.core.beans.Client;
import by.izone.spring.core.loggers.ConsoleEventLogger;
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
        app.logEvent("Some event for 1");
        app.logEvent("Some event for 2");

    }

    public void logEvent(String msg) {
        String resendingMsg = msg.replaceAll(client.getId(),client.getFullName());
        consoleEventLogger.logEvent(resendingMsg);
    }
}
