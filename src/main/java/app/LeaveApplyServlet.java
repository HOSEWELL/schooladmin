package app;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LeaveApplyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Session Check
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("SESSION_ID") == null) {
            res.sendRedirect("./login");
            return;
        }

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><head><style>");
        out.println("body{ font-family: sans-serif; background: #f4f6f8; padding: 20px; }");
        out.println(".form-container{ max-width: 400px; background: white; border: 1px solid #003366; padding: 25px; border-radius: 8px; margin: auto; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }");
        out.println("input, select { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }");
        out.println("</style></head><body>");

        out.println("<div class='form-container'>");
        out.println("<h2 style='color: #003366;'>New Leave Request</h2>");
        out.println("<p style='font-size: 0.9em;'>Logged in as: <strong>" + session.getAttribute("UserActualName") + "</strong></p>");
        out.println("<form method='POST' action='./apply'>");
        out.println("Leave Type: <select name='type'><option>Annual</option><option>Sick</option><option>Study</option></select>");
        out.println("Start Date: <input type='date' name='start' required>");
        out.println("End Date: <input type='date' name='end' required>");
        out.println("<button type='submit' style='background: #003366; color: white; width: 100%; border: none; padding: 12px; border-radius: 4px; cursor: pointer;'>Submit Request</button>");
        out.println("</form>");
        out.println("<a href='./' style='display: block; text-align: center; margin-top: 15px; color: #003366; text-decoration: none;'>&larr; Back to Dashboard</a>");
        out.println("</div></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("SESSION_ID") == null) {
            res.sendRedirect("./login");
            return;
        }

        String type = req.getParameter("type");
        String start = req.getParameter("start");
        String end = req.getParameter("end");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<div style='padding: 50px; font-family: sans-serif; text-align: center;'>");
        out.println("<h1 style='color: #28a745;'>Request Received</h1>");
        out.println("<div style='background: #fff; border: 1px solid #ddd; padding: 20px; display: inline-block; border-radius: 8px;'>");
        out.println("<p><strong>Type:</strong> " + type + "</p>");
        out.println("<p><strong>Duration:</strong> " + start + " to " + end + "</p>");
        out.println("<p><strong>Status:</strong> Pending Approval</p>");
        out.println("</div><br><br>");
        out.println("<a href='./' style='color: #003366;'>Return to Dashboard</a> | ");
        out.println("<a href='./apply' style='color: #003366;'>Apply for more</a>");
        out.println("</div>");
    }
}