package com.alexmanwell.impvocabapp.servlet;

import com.alexmanwell.impvocabapp.ConnectionDataBase;
import com.alexmanwell.impvocabapp.repository.WordDao;
import com.alexmanwell.impvocabapp.repository.WordDaoJdbcImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class ContextListener implements ServletContextListener {

    final static Logger logger = LogManager.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            WordDao wordDao = new WordDaoJdbcImpl(ConnectionDataBase.getConnection());
            ServletContext context = sce.getServletContext();
            context.setAttribute("wordDao", wordDao);
        } catch (SQLException e) {
            logger.debug("Failed connection in DataBase: {}", e);
        }
    }
}