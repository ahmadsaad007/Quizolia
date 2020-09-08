package com.dao;

import com.Exception.DaoException;
import com.domain.QuizSubmissions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultsDao {

    private static List<QuizSubmissions> list;
    private static Connection connection;
    static {
        list = new ArrayList<>();
        connection = ConnectionProvider.getConnection();
    }

    public static List<QuizSubmissions> getResults(String username){

        boolean results = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("SELECT * FROM quiz_submission WHERE username = ?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                results = true;
                String submissionId = rs.getString("submissionId");
                int quizId = rs.getInt("quizId");
                String startTime = rs.getString("startTime");
                String endTime = rs.getString("endTime");
                int totalScore = rs.getInt("totalScore");
                QuizSubmissions quiz = new QuizSubmissions();
                quiz.setSubmissionId(submissionId);
                quiz.setUsername(username);
                quiz.setQuizId(quizId);
                quiz.setStartTime(startTime);
                quiz.setEndTime(endTime);
                quiz.setTotalScore(totalScore);
                list.add(quiz);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error fetching results of previous submissions");

        }
        return list;
    }
}
