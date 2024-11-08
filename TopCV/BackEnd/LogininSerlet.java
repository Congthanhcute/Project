import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Giả sử có một user hợp lệ với username: "admin" và password: "password123"
    private final String validUsername = "admin";
    private final String validPassword = "password123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Chuẩn bị phản hồi dạng JSON
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // Kiểm tra thông tin đăng nhập
        if (validUsername.equals(username) && validPassword.equals(password)) {
            // Lưu session cho user
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            
            // Trả về phản hồi thành công
            out.println("{\"status\": \"success\", \"message\": \"Login successful\"}");
        } else {
            // Trả về phản hồi lỗi
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            out.println("{\"status\": \"error\", \"message\": \"Invalid username or password\"}");
        }

        out.close();
    }
}
