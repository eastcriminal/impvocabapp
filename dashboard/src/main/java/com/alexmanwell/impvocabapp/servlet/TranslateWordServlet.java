package com.alexmanwell.impvocabapp.servlet;

import com.alexmanwell.impvocabapp.model.User;
import com.alexmanwell.impvocabapp.model.Word;
import com.alexmanwell.impvocabapp.repository.WordDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/translateWordsByName")
public class TranslateWordServlet extends HttpServlet {

    private final static Logger logger = LogManager.getLogger(TranslateWordServlet.class);

    private WordDao wordDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute("user", new User("alex", "alex@mail"));
        req.getRequestDispatcher("/WEB-INF/views/translateWordsByName.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        logger.debug("translate unknown word: {}", name);
        try {
            Map<Word, Word> words = wordDao.translate(name);
            req.setAttribute("words", words);
            req.getRequestDispatcher("/WEB-INF/views/translateWordsByName.jsp").forward(req, resp);
        } catch (SQLException e) {
            logger.warn("Failed connection in DataBase: {}", e);
        }
    }

    @Override
    public void destroy() {
        wordDao = null;
    }

    @Override
    public void init() {
        ServletContext context = getServletConfig().getServletContext();
        wordDao = (WordDao) context.getAttribute("wordDao");
    }
}