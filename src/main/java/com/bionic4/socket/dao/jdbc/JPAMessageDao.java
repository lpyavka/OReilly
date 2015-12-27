package com.bionic4.socket.dao.jdbc;

import com.bionic4.socket.dao.MessageDao;
import com.bionic4.socket.dto.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by osv on 12/20/2015.
 */
public class JPAMessageDao implements MessageDao {

    private final EntityManagerFactory entityManagerFactory;

    public JPAMessageDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpa-example");
    }

    @Override
    public List<Message> getMessages() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Message> result = entityManager.createQuery("from Message", Message.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public void addMessage(Message message) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(message);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
