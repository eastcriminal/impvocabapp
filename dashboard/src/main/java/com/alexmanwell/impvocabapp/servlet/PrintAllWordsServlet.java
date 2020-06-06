package com.alexmanwell.impvocabapp.servlet;

import com.alexmanwell.impvocabapp.model.Word;
import com.alexmanwell.impvocabapp.repository.WordDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

public class PrintAllWordsServlet extends HttpServlet {

    final static Logger logger = LogManager.getLogger(PrintAllWordsServlet.class);

    private WordDao wordDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Collection<Word> words = wordDao.printAll();
            req.setAttribute("words", words);
            req.getRequestDispatcher("/WEB-INF/views/printAllWords.jsp").forward(req, resp);
        } catch (SQLException e) {
            logger.debug("Failed conecction in DataBase: {}", e);
        }
    }

    @Override
    public void destroy() {
        wordDao = null;
    }

    @Override
    public void init() {
        try {
            ServletContext context = getServletConfig().getServletContext();
            wordDao = (WordDao) context.getAttribute("wordDao");
        } catch (Exception e) {
            logger.debug("Failed conecction in DataBase: {}", e);
        }
    }
}