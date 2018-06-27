package ua.epam.spring.loggers;

import ua.epam.spring.beans.Event;

public class ConsoleEventLogger implements IEventLogger {
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
