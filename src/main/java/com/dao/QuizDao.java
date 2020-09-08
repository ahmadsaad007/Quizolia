package com.dao;

import com.Exception.DaoException;
import com.domain.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizDao {

    private static List<Question> list;
    private static Connection connection;
    static {
        list = new ArrayList<>();
    }

    public static List<Question> getQuestionsByType(String type) throws DaoException {
        connection = ConnectionProvider.getConnection();
        boolean results = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT q.questionId, q.questionText, q.questionType, " +
                    "q.optionText, q.correctIndex FROM question q WHERE q.questionType = ? ORDER BY RAND() LIMIT 10;");
            statement.setString(1,type);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                results = true;
                int questionId = rs.getInt(1);
                String text = rs.getString(2);
                String qType = rs.getString(3);
                String options = rs.getString(4);
                int correctIndex = rs.getInt(5);
                list.add(new Question(questionId,text,qType,options,correctIndex));
            }
        } catch (Exception e) {
            System.out.println("Error getting connection");
        }

        if(!results){
            throw new DaoException("Question is not found in DB by " + type);
        }

        return list;
    }
}
