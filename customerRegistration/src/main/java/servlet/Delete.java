package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ConnectionProvider;
import Dao.UserDao;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Delete() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String userName = (String) session.getAttribute("USERNAME");
        if (userName == null) {
            response.sendRedirect("Login.jsp");
        }
        response.setContentType("Text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Delete</title>");
        out.println("</head>");

        out.println("<body> hello delete "
                + ""
                + "</body>");
        out.println("</html>");

        UserDao dao = new UserDao(ConnectionProvider.getConnection());
        String id = request.getParameter("id");
        
        boolean check = dao.deleteData(id,userName);
        System.out.println(check);

        if (check = true) {
     
            response.sendRedirect("Home");
        } else {
            out.println("user can not delete ");
            
        }

    }

}
