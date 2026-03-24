package app;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LeaveApplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><head><style>");
        out.println("body{ font-family: sans-serif; padding: 20px; }");
        out.println(".form-container{ max-width: 400px; border: 1px solid #003366; padding: 20px; border-radius: 8px; }");
        out.println("input, select { width: 100%; padding: 8px; margin: 10px 0; }");
        out.println("</style></head><body>");

        out.println("<div class='form-container'>");
        out.println("<h2 style='color: #003366;'>New Leave Request</h2>");
        out.println("<form method='POST' action='./apply'>");
        out.println("Leave Type: <select name='type'><option>Annual</option><option>Sick</option></select>");
        out.println("Start Date: <input type='date' name='start' required>");
        out.println("End Date: <input type='date' name='end' required>");
        out.println("<button type='submit' style='background: #003366; color: white; width: 100%; border: none; padding: 10px;'>Submit Request</button>");
        out.println("</form></div></body></html>");

        out.println("<a href='./' style='color: #003366;'>Back to Home</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String type = req.getParameter("type");
        String start = req.getParameter("start");
        String end = req.getParameter("end");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<div style='padding: 40px; font-family: sans-serif; text-align: left;'>");
        out.println("<h1 style='color: green;'>Request Submitted!</h1>");
        out.println("<p>Your <strong>" + type + "</strong> leave request from " + start + " to " + end + " has been sent to management.</p>");
        out.println("<a href='./' style='color: #003366;'>Back to Home</a> <br>");
        out.println("<a href='./apply' style='color: #003366;'>Apply Another Leave</a>");
        out.println("</div>");
    }
}