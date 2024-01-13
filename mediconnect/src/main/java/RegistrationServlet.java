package src.main.java;

// RegistrationServlet.java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Form parameter retrieval
        String firstName = request.getParameter("firstName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Password verification
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        // Hash the password and create a user object
        User user = new User();
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPassword(hashPassword(password));

        // Save the user to the database
        try {
            saveUser(user);
            response.sendRedirect("registration-success.html");
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Registration error", e);
        }
    }

    private String hashPassword(String password) {
        // Implement password hashing here
        return password;
    }

    private void saveUser(User user) throws SQLException, ClassNotFoundException {
        // Database connection and insertion logic
        // ... (Similar to previous examples)
    }
}
