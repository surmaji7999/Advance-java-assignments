package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ConnectionProvider;
import Dao.UserDao;
import entity.User;

@WebServlet("/Search")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Search() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("Text/html");
        PrintWriter out = response.getWriter();

        String searchValue = (String) request.getParameter("searchData");
        String searchType = request.getParameter("searchType");

        UserDao userDao = new UserDao(ConnectionProvider.getConnection());
        List<User> searchList = userDao.search(searchType, searchValue);
//         request.setAttribute("SEARCH",searchList);
//         request.getRequestDispatcher("search.jsp").forward(request, response);
//     
        out.write("<!DOCTYPE html>\r\n");
        out.write("<html>\r\n");
        out.write("<head>\r\n");
        out.write("<meta charset=\"ISO-8859-1\">\r\n");
        out.write("<title>Search-page</title>\r\n");
        out.write("\r\n");
        out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\r\n");
        out.write("     rel=\"stylesheet\"\r\n");
        out.write("     integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\r\n");
        out.write("     crossorigin=\"anonymous\">\r\n");
        out.write(
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
        out.write("\r\n");
        out.write("</head>\r\n");
        out.write("<body>\r\n");
        out.write("   <!-- nav bar satrted -->\r\n");
        out.write("\r\n");
        out.write("   <nav class=\"navbar navbar-expand-lg navbar-dark  bg-dark\">\r\n");
        out.write("       <div class=\"container-fluid\">\r\n");
        out.write("           <a class=\"navbar-brand\" href=\"#\">HOTWAX system</a>\r\n");
        out.write("           <button class=\"navbar-toggler\" type=\"button\"\r\n");
        out.write("               data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\"\r\n");
        out.write("               aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\r\n");
        out.write("               aria-label=\"Toggle navigation\">\r\n");
        out.write("               <span class=\"navbar-toggler-icon\"></span>\r\n");
        out.write("           </button>\r\n");
        out.write("           <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
        out.write("               <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n");
        out.write("                   <li class=\"nav-item\"><a class=\"nav-link\" href=\"Home\">Home </a></li>\r\n");
        out.write(
                "                   <li class=\"nav-item\"><a class=\"nav-link\" href='Search.jsp'>Search </a></li>\r\n");

        out.write("                   </ul>\r\n");

        out.write("                   \r\n");
        out.write("               <ul class=\"navbar-nav mr-right\">\r\n");
        out.write("               <li  class=\"nav-item\"><a class=\"nav-link\">");

        out.write(" </a></li>\r\n");
        out.write("               <li class=\"nav-item\"><a class=\"nav-link\" href='Logout'>Logout  </a></li>\r\n");
        out.write("                   \r\n");
        out.write("               </ul>\r\n");
        out.write("           </div>\r\n");
        out.write("       </div>\r\n");
        out.write("   </nav>\r\n");
        out.write("   <!-- nav bar end -->\r\n");
        out.write("<div class=\"container text-center mt-5 mb-3  \"><h3 > <b>Search records</b> </h3></div>");
        if(!searchList.isEmpty()) {
            
        out.write("<table  class=\"table table-striped table-bordered \">\r\n");
        out.write("  <thead>\r\n");
        out.write("    <tr>\r\n");
        out.write("      <th scope=\"col\">PartyId</th>\r\n");
        out.write("      <th scope=\"col\">FirstName</th>\r\n");
        out.write("      <th scope=\"col\">LastName</th>\r\n");
        out.write("      <th scope=\"col\">Address</th>\r\n");
        out.write("      <th scope=\"col\">City</th>\r\n");
        out.write("      <th scope=\"col\">State</th>\r\n");
        out.write("      <th scope=\"col\">Zip</th>\r\n");
        out.write("      <th scope=\"col\">Country</th>\r\n");
        out.write("      <th scope=\"col\">phone</th>\r\n");
        out.write("      <th scope=\"col\">Email</th>\r\n");
        out.write("    </tr>\r\n");
        out.write("  </thead>\r\n");
        out.write("  <tbody>\r\n");
        User user = new User();
       
        for (int i = 0; i < searchList.size(); i++) {
            user = searchList.get(i);
            out.write("    <tr>\r\n");
            out.write("  \r\n");
            out.write("       \r\n");
            out.write("      <td>" + user.getId() + "</td>\r\n");
            out.write("      <td>" + user.getFirstName() + "</td>\r\n");
            out.write("      <td>" + user.getLastName() + "</td>\r\n");
            out.write("      <td>" + user.getAddress() + "</td>\r\n");
            out.write("      <td>" + user.getCity() + "</td>\r\n");
            out.write("      <td>" + user.getState() + "</td>\r\n");
            out.write("      <td>" + user.getZip() + "</td>\r\n");
            out.write("      <td>" + user.getCountry() + "</td>\r\n");
            out.write("      <td>" + user.getPhone() + "</td>\r\n");
            out.write("      <td>" + user.getEmail() + "</td>\r\n");
            out.write("    </tr>\r\n");
        }
        out.write("  </tbody></div>\r\n");
        out.write("</table>\r\n");
        }
        else {
            
            out.write("<div class='container text-center mt-5 'style=\"color:red;\"><h5>Records not found!</h5> </div>");
        }
        out.write("<div class='container text-center'><a class=\"nav-link\" href='Search.jsp'><i class=\"fa fa-refresh \" style=\"font-size:24px; color:'';\"></i></a></div>");
        out.write("</body>\r\n");
        out.write("</html>");

    }
}
