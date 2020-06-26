package com.alexmanwell.impvocabapp.servlet;

import com.alexmanwell.impvocabapp.model.*;
import com.alexmanwell.impvocabapp.repository.UserWordDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@WebServlet("/addUserWord")
public class AddUserWordServlet extends HttpServlet {

    private final static Logger logger = LogManager.getLogger(AddUserWordServlet.class);

    private UserWordDao userWordDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final int wordId = Integer.parseInt(req.getParameter("wordId"));
        final String wordName = req.getParameter("wordName");
        final String wordExplanation = req.getParameter("wordExplanation");
        final int wordExplanationId = Integer.parseInt(req.getParameter("wordExplanationId"));
        final String[] examples = req.getParameterValues("example");

        Collection<TextExample> textExamples = new ArrayList<>(examples.length);
        for (String example : examples) {
            textExamples.add(new TextExample(example));
        }
        Explanation explanation = new Explanation(wordExplanationId, wordExplanation, textExamples);

        final Word word = new Word(wordId, wordName, Collections.singletonList(explanation));
        User user = (User) req.getSession().getAttribute("user");
        try {
            userWordDao.addWord(user, word);
            req.getRequestDispatcher("/WEB-INF/views/translateWordsByName.jsp").forward(req, resp);
        } catch (SQLException e) {
            logger.warn("Failed connection in DataBase: {}", e);
        }
    }

    @Override
    public void destroy() {
        userWordDao = null;
    }

    @Override
    public void init() {
        ServletContext context = getServletConfig().getServletContext();
        userWordDao = (UserWordDao) context.getAttribute("userWordDao");
    }
}