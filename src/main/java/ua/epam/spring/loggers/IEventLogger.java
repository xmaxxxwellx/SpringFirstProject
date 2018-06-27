package ua.epam.spring.loggers;

import ua.epam.spring.beans.Event;

import java.io.IOException;

public interface IEventLogger {
    void logEvent(Event event) throws IOException;
}
