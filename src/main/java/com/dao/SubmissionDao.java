package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubmissionDao {
    //quiz_Submission table in the Database
    public static void submit(String submissionId, String username,int quizId , String startTime, String endTime,int totalScore) {

        Connection connection = ConnectionProvider.getConnection();

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO quiz_submission VALUES (?,?,?,?,?,?)");
            statement.setString(2, username);
            statement.setString(1, submissionId);
            statement.setInt(3, quizId);
            statement.setString(4,"");
            statement.setString(5,"");
            statement.setInt(6, totalScore);
            int rs = statement.executeUpdate();
            System.out.println("Rows affected: "+rs);
        } catch (SQLException throwables) {
            System.out.println("Error submitting QuizSubmission Summary");
        }
    }
}
