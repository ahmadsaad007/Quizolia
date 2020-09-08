package com.dao;

import com.config.HibernateConfigUtil;
import com.domain.AdminQuizSubmission;
import com.domain.QuizSubmissions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AdminUserSubmissionsDao {

    public static List getUserResults() {

        Session session = HibernateConfigUtil.openSession();
        if(session == null)
            System.out.println("Could not create session");

        Transaction transaction = null;
        List list = null;
        try{
            transaction = session.beginTransaction();

            Query query = session.createQuery("select submissionId,username, quizId, totalScore from AdminQuizSubmission q");
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
