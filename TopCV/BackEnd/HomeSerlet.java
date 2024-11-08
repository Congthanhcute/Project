import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jobs")
public class JobServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Giả sử có một danh sách công việc được lấy từ cơ sở dữ liệu
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Frontend Developer", "Hanoi", "JavaScript, HTML, CSS"));
        jobs.add(new Job("Backend Developer", "Ho Chi Minh City", "Java, Spring Boot, SQL"));
        jobs.add(new Job("UI/UX Designer", "Da Nang", "Adobe XD, Figma, Photoshop"));

        // Xuất dữ liệu công việc dưới dạng HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<section class='jobs'>");
        out.println("<h2>Latest Jobs</h2>");

        for (Job job : jobs) {
            out.println("<div class='job-listing'>");
            out.println("<div class='job-info'>");
            out.println("<h3>" + job.getTitle() + "</h3>");
            out.println("<p>Location: " + job.getLocation() + "</p>");
            out.println("<p>Skills: " + job.getSkills() + "</p>");
            out.println("</div>");
            out.println("<button>Apply Now</button>");
            out.println("</div>");
        }

        out.println("</section>");
    }
}
