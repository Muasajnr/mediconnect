//package src.main.java;

// MedicineDataServlet.java
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;


public class MedicineDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            List<Medicine> medicines = fetchMedicines();
            String json = new Gson().toJson(medicines);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Error fetching medicines", e);
        }
    }

    private List<Medicine> fetchMedicines() throws SQLException, ClassNotFoundException {
        List<Medicine> medicines = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM medicine")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Medicine medicine = new Medicine();
                medicine.setImage(rs.getString("image"));
                medicine.setName(rs.getString("name"));
                medicine.setCost(rs.getDouble("cost"));
                medicines.add(medicine);
            }
        }
        return medicines;
    }
}
