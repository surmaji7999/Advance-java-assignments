package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.ConnectionProvider;
import Dao.UserDao;
import entity.User;

@WebServlet("/registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Registration() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    
	       response.setContentType("Text/html");
	        PrintWriter out=response.getWriter();
	        out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration page</title>");
            out.println("</head>");
            out.println("</html>");
	        String firstName=request.getParameter("inputFristName");
	        String lastName=request.getParameter("inputLastName");
	        String address=request.getParameter("inputAddress");
	        String city=request.getParameter("inputCity");
	        String zip=request.getParameter("inputZip");
	        String state=request.getParameter("inputState");
	        String country=request.getParameter("inputCountry");
	        String phone=request.getParameter("inputPhone");
	        String email=request.getParameter("inputEmail");
	        String password=request.getParameter("inputPassword");
	        int zipCode=Integer.valueOf(zip);
	        
	        User user=new User(firstName,lastName,address, city, zipCode, state, country, phone, email,password);
	       
	        UserDao dao = new UserDao(ConnectionProvider.getConnection());
	        boolean status=false;
	        status= dao.insertIntoDB(user);
	        System.out.println(status);
	        if(status) { 
	            
	        HttpSession httpSession = request.getSession();
	        httpSession.setAttribute("MSG", "User successfully ragistered");
	        response.sendRedirect("Registration.jsp");
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
//            requestDispatcher.forward(request, response);
//	      
	        } else {
	            HttpSession httpSession = request.getSession();
	            httpSession.setAttribute("MSG", "User already axists!");
	            response.sendRedirect("Registration.jsp");
	        }
	        
	    }

	}


