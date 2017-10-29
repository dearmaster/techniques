package com.master.web.servlet;

import com.master.web.model.Article;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BaseServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(BaseServlet.class);

    public BaseServlet() {
        logger.debug("Servlet Created: " + this);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        if(null == methodName || methodName.isEmpty())
            throw new RuntimeException("No method specified!");
        Class c = this.getClass();
        Method method;
        try {
            /**
             * The type of parameters must 100% match, that is (HttpServletRequest req, HttpServletResponse resp)
             * it won't work even if you specify the parent class (ServletRequest req, ServletResponse res)
             * **/
            method =  c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("method not found: " + methodName);
        }

        try {
            method.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Article> loadAllArticle(HttpServletRequest req, HttpServletResponse resp) {
        List<Article> list = new ArrayList<>();
        Article article = new Article("test", "tset123");
        list.add(article);
        logger.debug(list);
        return list;
    }

    public List<Article> postLoadAllArticle(HttpServletRequest req, HttpServletResponse resp) {
        List<Article> list = new ArrayList<>();
        String name = req.getParameter("name");
        Article article;
        if("lily".equalsIgnoreCase(name))
        {
            article = new Article("lily", "lily123");
        } else {
            article = new Article("test", "123");
        }
        list.add(article);
        logger.debug(list);
        return list;
    }

    @Override
    public void destroy() {
        logger.debug("Servlet destroyed: " + this.getClass().getSimpleName());
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Servlet initialized: " + this.getClass().getSimpleName());
        super.init();
    }

}