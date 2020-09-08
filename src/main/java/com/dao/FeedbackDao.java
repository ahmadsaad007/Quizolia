package com.dao;

import com.config.HibernateConfigUtil;
import com.domain.AdminQuizSubmission;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FeedbackDao {

    public static void submitFeedback(int starValue, String comment){
        Connection connection = ConnectionProvider.getConnection();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO feedback VALUES (1,?,?)");
            statement.setInt(1, starValue);
            statement.setString(2, comment);
            int rs = statement.executeUpdate();
            System.out.println("Rows affected: "+rs);
        } catch (SQLException throwables) {
            System.out.println("Error submitting Feedback");
            throwables.printStackTrace();
        }
    }

    public static List getFeedback(){
        Session session = HibernateConfigUtil.openSession();
        if(session == null)
            System.out.println("Could not create session");

        Transaction transaction = null;
        List list = null;
        try{
            transaction = session.beginTransaction();

            Query query = session.createQuery("select feedbackId,starValue,text from Feedback f");
            list = query.list();

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
