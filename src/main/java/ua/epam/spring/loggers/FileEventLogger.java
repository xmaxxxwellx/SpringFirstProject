package ua.epam.spring.loggers;

import org.apache.commons.io.FileUtils;
import ua.epam.spring.beans.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements IEventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) throws IOException {
        FileUtils.writeStringToFile(file, event.toString(), true);
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        file.canWrite();
    }
}
