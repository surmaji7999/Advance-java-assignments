package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionProvider;
import Dao.UserDao;
import entity.User;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Edit() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("Text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>edit-page</title>");
        out.println("</head>");
        out.println("</html>");

        String partyid = request.getParameter("inputPartyId");
        String firstName = request.getParameter("inputFristName");
        String lastName = request.getParameter("inputLastName");
        String address = request.getParameter("inputAddress");
        String city = request.getParameter("inputCity");
        String zip = request.getParameter("inputZip");
        String state = request.getParameter("inputState");
        String country = request.getParameter("inputCountry");
        String phone = request.getParameter("inputPhone");
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");
        int zipCode = Integer.valueOf(zip);
       
        int id = Integer.valueOf(partyid);

        User user = new User(id, firstName, lastName, address, city, zipCode, state, country, phone, email, password);

        UserDao dao = new UserDao(ConnectionProvider.getConnection());

        boolean check=dao.updateDb(user);
        if(check=true) {
            response.sendRedirect("Home");
        }
        else {
            
        }

        doGet(request, response);
    }

}
