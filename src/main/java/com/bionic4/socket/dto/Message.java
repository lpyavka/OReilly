package com.bionic4.socket.dto;

import java.util.Date;

/**
 * Created by Sony on 19.12.2015.
 */
public class Message {
    private final int id;
    private final String name;
    private final String text;
    private final Date crDate;

    public Message(int id, String name, String text, Date crDate) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.crDate = crDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Date getCrDate() {
        return crDate;
    }
}
