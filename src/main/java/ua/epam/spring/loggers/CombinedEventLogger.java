package ua.epam.spring.loggers;

import ua.epam.spring.beans.Event;

import java.io.IOException;
import java.util.List;

public class CombinedEventLogger implements IEventLogger {
    private List<IEventLogger> loggers;

    public CombinedEventLogger(List<IEventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) throws IOException {
        for (IEventLogger e : loggers) {
            e.logEvent(event);
        }
    }
}
