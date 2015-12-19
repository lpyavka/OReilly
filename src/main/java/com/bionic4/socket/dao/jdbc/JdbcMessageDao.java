package com.bionic4.socket.dao.jdbc;

import com.bionic4.socket.dao.MessageDao;
import com.bionic4.socket.dto.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sony on 19.12.2015.
 */
public class JdbcMessageDao implements MessageDao {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/world";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "lena";

    public List<Message> getMessages() {
        List<Message> result = new ArrayList<>();
        Statement stmt = null;
        Connection conn = getConnection();
        try {
            stmt = conn.createStatement();

            String sql = "select ID, NAME, text, cr_date from t_message";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String text = rs.getString("text");
                Date crDate = rs.getDate("cr_date");

                Message message = new Message(id, name, text, crDate);
                result.add(message);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void addMessage(Message message) {
        try {
            String query = " insert into t_message(id, name, text, cr_date)"
                    + " values (?, ?, ?, ?)";
            Connection conn = getConnection();
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, message.getId());
            preparedStmt.setString(2, message.getName());
            preparedStmt.setString(3, message.getText());
            java.sql.Date date = new java.sql.Date(message.getCrDate().getTime());
            preparedStmt.setDate(4, date);

            preparedStmt.execute();

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            stmt = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
