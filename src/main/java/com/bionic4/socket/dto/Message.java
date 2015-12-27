package com.bionic4.socket.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Sony on 19.12.2015.
 */
@Entity
@Table(name = "t_message")
public class Message {
    @Id
    private final int id;
    @Column
    private final String name;
    @Column
    private final String text;
    @Column(name = "cr_date")
    private final Date crDate;

    protected Message() {
        id = 0;
        name = null;
        text = null;
        crDate = null;
    }

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
