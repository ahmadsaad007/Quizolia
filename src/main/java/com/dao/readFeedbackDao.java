package com.dao;

import com.config.HibernateConfigUtil;
import com.domain.AdminQuizSubmission;
import com.domain.Feedback;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class readFeedbackDao {

    public static List<Feedback> getFeedback(){
        List list = null;
        Session session = HibernateConfigUtil.openSession();
        if(session == null)
            System.out.println("Could not create session");

        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();

            Query query = session.createQuery("select feedbackId, starValue from Feedback f");
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
