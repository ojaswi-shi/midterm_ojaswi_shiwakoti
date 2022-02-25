package com.iims.dao;

import com.iims.model.Quest;

import java.sql.SQLException;
import java.util.List;

public interface QuestDao {
    List<Quest> getRand10Quest() throws SQLException, ClassNotFoundException;
}
