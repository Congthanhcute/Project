import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class JobSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword").toLowerCase();
        List<Job> jobs = getAllJobs(); // Giả sử có phương thức này để lấy danh sách công việc từ DB

        List<Job> filteredJobs = new ArrayList<>();
        for (Job job : jobs) {
            if (job.getTitle().toLowerCase().contains(keyword) || 
                job.getLocation().toLowerCase().contains(keyword) ||
                job.getSkills().toLowerCase().contains(keyword)) {
                filteredJobs.add(job);
            }
        }

        request.setAttribute("jobs", filteredJobs);
        request.getRequestDispatcher("searchResults.jsp").forward(request, response);
    }
}
