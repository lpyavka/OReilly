package com.bionic4.socket.dao;

import com.bionic4.socket.dto.Message;

import java.util.List;

/**
 * Created by Sony on 19.12.2015.
 */
public interface MessageDao {
    List<Message> getMessages();

    void addMessage(Message message);

}
