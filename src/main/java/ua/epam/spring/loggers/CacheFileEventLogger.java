package ua.epam.spring.loggers;

import ua.epam.spring.beans.Event;

import java.io.IOException;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        cache.add(event);

        if(cache.size() == cacheSize){
            for (Event e : cache){
                super.logEvent(e);
            }
            cache.clear();
        }
    }

    public void destroy() throws IOException {
        if(!cache.isEmpty()){
            for (Event e : cache){
                super.logEvent(e);
            }
        }
    }
}
