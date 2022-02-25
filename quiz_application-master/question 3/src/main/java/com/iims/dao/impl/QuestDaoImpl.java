package com.iims.dao.impl;

import com.iims.dao.QuestDao;
import com.iims.database.ConnectionFactory;
import com.iims.model.Quest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QuestDaoImpl implements QuestDao {
    @Override
    public List<Quest> getRand10Quest() throws SQLException, ClassNotFoundException {
        final String sqlQuery = "SELECT * FROM quiz ORDER BY RAND() LIMIT 10";
        Connection connection = ConnectionFactory.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        List<Quest> questions = new ArrayList<>();

        while (resultSet.next()){
            Quest question = new Quest();
            question.setId(resultSet.getInt("id"));
            question.setQuest(resultSet.getString("question"));
            question.setOptionOne(resultSet.getString("optionOne"));
            question.setOptionTwo(resultSet.getString("optionTwo"));
            question.setOptionThree(resultSet.getString("optionThree"));
            question.setCorrectAns(resultSet.getString("correctAns"));
            questions.add(question);
        }

        return questions;
    }
}
