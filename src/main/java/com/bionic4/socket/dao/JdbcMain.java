package com.bionic4.socket.dao;

import com.bionic4.socket.dao.jdbc.JPAMessageDao;
import com.bionic4.socket.dao.jdbc.JdbcMessageDao;
import com.bionic4.socket.dto.Message;

import java.util.Date;
import java.util.List;

/**
 * Created by Sony on 19.12.2015.
 */
public class JdbcMain {
    public static void main(String[] args) {
        MessageDao messageDao = new JPAMessageDao();
        List<Message> messages = messageDao.getMessages();
        print(messages);
        messageDao.addMessage(new Message(3, "Zikf", "Stupidors", new Date()));
        print(messageDao.getMessages());

    }

    private static void print(List<Message> messages) {
        for (Message message : messages) {

            System.out.print("ID: " + message.getId());
            System.out.print(", name: " + message.getName());
            System.out.print(", text: " + message.getText());
            System.out.println(", crDate: " + message.getCrDate());
        }
    }
}
