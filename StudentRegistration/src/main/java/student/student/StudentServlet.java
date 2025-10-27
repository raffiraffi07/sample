package main.java.student.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



@WebServlet("/register")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "yourpassword");

            String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            ps.executeUpdate();
            ps.close();
            con.close();

            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
