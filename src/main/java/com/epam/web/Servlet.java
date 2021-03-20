package com.epam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        process(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
//        String name = req.getParameter("name");
//        resp.getWriter().write("<html><body><H2>Hello, "+ name + "!</H2></body></html>");
        try {
            String commandParam = req.getParameter("command");
            Command command = CommandFactory.create(commandParam);
            String page = command.execute(req, resp);
            dispatch(page, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dispatch(final String page, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(page).forward(req, resp);
    }

}
