package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuizQuestionDao {

    public static void submit(int questionId, String submissionId, String userAnswer) {

        Connection connection = ConnectionProvider.getConnection();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO quiz_question VALUES (?,?,?)");
            statement.setInt(1, questionId);
            statement.setString(2, submissionId);
            statement.setString(3, userAnswer);
            int rs = statement.executeUpdate();
            System.out.println("Rows affected: "+rs);
        } catch (SQLException throwables) {
            System.out.println("Error submitting User Answer "+ userAnswer + " with questionId " + questionId +
                    " with ubmissionId "+submissionId + " to db");
            throwables.printStackTrace();
        }

    }
}
