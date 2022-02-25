package com.iims.controller;

import com.iims.dao.QuestDao;
import com.iims.dao.impl.QuestDaoImpl;
import com.iims.model.Quest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "main", urlPatterns = "/main")
public class Main extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("username", req.getParameter("username"));

        if(session.getAttribute("points")== null) {
            session.setAttribute("points", 0);
        }

        QuestDao quest = new QuestDaoImpl();

        try {
            if (session.getAttribute("buttonName") == null) {
//                List <Quest> quests = quest.getRand10Quest();
//                for (Quest q: quests) {
//                    System.out.println(q);
//                }
                session.setAttribute("quests", quest.getRand10Quest());
                session.setAttribute("buttonName", "Submit");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Quest> quests = (List<Quest>) session.getAttribute("quests");
        int points = 0;

        for (Quest question : quests) {
            String chosenAnswer = req.getParameter(String.valueOf(question.getId()));
            if (Objects.equals(chosenAnswer, question.getCorrectAns()))
                points++;
        }

        session.setAttribute("points", points);

        resp.sendRedirect("main?username=" + session.getAttribute("username"));
    }
}