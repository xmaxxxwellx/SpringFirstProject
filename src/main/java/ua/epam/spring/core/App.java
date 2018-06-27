package ua.epam.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.epam.spring.beans.Client;
import ua.epam.spring.beans.Event;
import ua.epam.spring.beans.EventType;
import ua.epam.spring.loggers.ConsoleEventLogger;
import ua.epam.spring.loggers.FileEventLogger;
import ua.epam.spring.loggers.IEventLogger;

import java.io.IOException;
import java.util.Map;

public class App {
    private Client client;
    private IEventLogger eventLogger;
    private ConsoleEventLogger consoleEventLogger;
    private Event event;
    private FileEventLogger fileEventLogger;
    private Map<EventType, IEventLogger> loggers;

    public App(Event event, IEventLogger eventLogger, Map<EventType, IEventLogger> loggers) {
        this.event = event;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App) ctx.getBean("app");

        app.logEvent(EventType.INFO, "First message");
        app.logEvent(EventType.ERROR, "Second message");

//        app.event.setMsg("Hello");
//        app.fileEventLogger.logEvent(app.event);

        //app.logEvent("Some event for User 1");
        //app.logEvent("Some event for User 2");
    }

    private void logEvent(EventType type, String msg) throws IOException {
        IEventLogger logger = loggers.get(type);
        if(logger == null){
            logger = consoleEventLogger;
        }
        event.setMsg(msg);
        logger.logEvent(event);
    }
}
