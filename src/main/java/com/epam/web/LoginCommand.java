package com.epam.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    @Override
    public String execute(final HttpServletRequest request, final HttpServletResponse response) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        LoginService service = new LoginService();
        boolean valid = service.login(login, password);
        if (valid) {
            HttpSession session = request.getSession(true);
            session.setAttribute("login", login);
            session.setAttribute("role", "admin");
            return "WEB-INF/view/main.jsp";
        } else {
            request.setAttribute("errorMessage", "Invalid creds");
            return "index.jsp";
        }

    }
}
