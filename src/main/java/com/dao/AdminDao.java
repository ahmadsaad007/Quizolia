package com.dao;

import com.config.HibernateConfigUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AdminDao {
    public static boolean isAdmin(String username, String password){
        //establish a hibernate session
        Session session = HibernateConfigUtil.openSession();
        if(session == null)
            System.out.println("Could not create session");

        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();

            Query query = session.createQuery("select username, pwd from AdminUser where username = :username and pwd =: password");
            query.setParameter("username",username);
            query.setParameter("password", password);
            List l = query.list();
            if(l.size() != 0) {
                Object[] result = (Object[]) (l.get(0));
                String name = (String) result[0];
                System.out.println("Result: " + name);
                //if(name != null)
                return true;
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return false;
    }
}
