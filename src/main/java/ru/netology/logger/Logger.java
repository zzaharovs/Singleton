package ru.netology.logger;

import java.util.Date;

public class Logger {

    protected int num = 1;
    private static Logger instance;
    private Date date = new Date();

    private Logger() { }

    public void log(String msg) {
        System.out.println("[" + date + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

}
