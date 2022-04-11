package servlet;

import java.sql.Connection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ConnectionProvider;
import Dao.UserDao;
import entity.User;

@WebServlet("/Login")

public class Login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();

        String username = request.getParameter("user-id");
        String password = request.getParameter("password");

        httpSession.setAttribute("USERNAME", username);
        try {
            Connection conn = ConnectionProvider.getConnection();
            UserDao userDao1 = new UserDao(conn);
            User user = userDao1.getByUsername(username);

            String dbPassword = user.getPassword();
            String dbuserId = user.getEmail();
            if (username.equalsIgnoreCase(dbuserId)) {
                if (password.equalsIgnoreCase(dbPassword)) {
                    httpSession.setAttribute("USERNAME", username);
                    response.sendRedirect("Home");

                } else {

                    httpSession.setAttribute("MSG", "Login id and password deos not match");
                    response.sendRedirect("Login.jsp");
                }

            } else {

                httpSession.setAttribute("MSG", "user not registered ");
                response.sendRedirect("Login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
