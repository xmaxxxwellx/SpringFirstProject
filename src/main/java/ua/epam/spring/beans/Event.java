package ua.epam.spring.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df){
        this.id = (int) (Math.random() * 10);
        this.date = date;
        this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", \nmsg: " + msg + ",\ndate: " + df.format(date) + "\n\n";
    }
}
