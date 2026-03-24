package app;

import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LeavePolicy extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><head><style>");
        out.println("body { font-family: 'Segoe UI', sans-serif; margin: 0; background-color: #f0f2f5; }");
        out.println(".navbar { background-color: #003366; color: white; padding: 1rem; text-align: center; }");
        out.println(".container { padding: 20px; max-width: 800px; margin: auto; }");
        out.println(".card { background: white; padding: 25px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }");
        out.println("h2 { color: #003366; border-bottom: 2px solid #003366; padding-bottom: 10px; margin-top: 0; }");
        out.println("ul { list-style-type: none; padding: 0; }");
        out.println("li { background: #f9f9f9; margin: 10px 0; padding: 15px; border-left: 5px solid #003366; border-radius: 3px; }");
        out.println(".nav-links { margin-top: 20px; display: flex; gap: 20px; }");
        out.println(".nav-links a { color: #003366; text-decoration: none; font-weight: bold; }");
        out.println(".nav-links a:hover { text-decoration: underline; }");
        out.println("</style></head><body>");

        out.println("<div class='navbar'><h1>HRMS: Official Policies</h1></div>");
        out.println("<div class='container'>");
        out.println("<div class='card'>");
        out.println("<h2>Company Leave Regulations</h2>");
        out.println("<ul>");
        out.println("<li><strong>Annual Leave:</strong> 21 days per calendar year.</li>");
        out.println("<li><strong>Sick Leave:</strong> 10 days (requires a valid medical certificate).</li>");
        out.println("<li><strong>Compassionate Leave:</strong> 5 days per specific incident.</li>");
        out.println("<li><strong>Study Leave:</strong> Available upon management approval for Cohort certifications.</li>");
        out.println("</ul>");
        out.println("<div class='nav-links'>");
        out.println("<a href='./apply'>Apply for Leave &rarr;</a> <br>");

        out.println("<a href='./'>&larr; Back to Dashboard</a>");
        out.println("</div>");

        out.println("</div>");
        out.println("</div>");
        out.println("</body></html>");
    }
}