package app;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LeavePolicy extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // Manual Casting for GenericServlet
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // Session Check
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("SESSION_ID") == null) {
            response.sendRedirect("./login");
            return;
        }

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><head><style>");
        out.println("body { font-family: 'Segoe UI', sans-serif; margin: 0; background-color: #f0f2f5; }");
        out.println(".navbar { background-color: #003366; color: white; padding: 1rem; text-align: center; }");
        out.println(".container { padding: 20px; max-width: 600px; margin: auto; }");
        out.println(".card { background: white; padding: 25px; border-radius: 8px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }");
        out.println("h2 { color: #003366; border-bottom: 2px solid #003366; padding-bottom: 10px; margin-top: 0; }");
        out.println("ul { list-style-type: none; padding: 0; }");
        out.println("li { background: #f9f9f9; margin: 10px 0; padding: 15px; border-left: 5px solid #003366; border-radius: 3px; }");
        out.println("</style></head><body>");

        out.println("<div class='navbar'><h1>HRMS Policy Guide</h1></div>");
        out.println("<div class='container'>");
        out.println("<div class='card'>");
        out.println("<h2>Official Leave Rules</h2>");
        out.println("<p>Logged in user: <strong>" + session.getAttribute("UserActualName") + "</strong></p>");
        out.println("<ul>");
        out.println("<li><strong>Annual Leave:</strong> 21 days (requires manager sync).</li>");
        out.println("<li><strong>Sick Leave:</strong> 10 days (requires certificate).</li>");
        out.println("<li><strong>Compassionate Leave:</strong> 5 days.</li>");
        out.println("</ul>");
        out.println("<hr>");
        out.println("<a href='./apply' style='color: #003366; font-weight: bold; text-decoration: none;'>Apply Now &rarr;</a><br><br>");
        out.println("<a href='./' style='color: #666; text-decoration: none;'>&larr; Back to Dashboard</a>");
        out.println("</div></div></body></html>");
    }
}