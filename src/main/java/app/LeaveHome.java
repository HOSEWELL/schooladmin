package app;

import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LeaveHome implements Servlet {
    private ServletConfig config;

    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><head><style>");
        out.println("body { font-family: sans-serif; background: #f4f4f4; margin: 0; }");
        out.println(".header { background: #003366; color: white; padding: 15px; text-align: center; }");
        out.println(".container { padding: 20px; }");
        out.println(".balance-card { background: white; padding: 20px; border-radius: 10px; border-top: 5px solid #003366; }");
        out.println(".btn { background: #003366; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px; display: inline-block; margin-top: 10px; }");
        out.println("</style></head><body>");

        out.println("<div class='header'><h1>HRMS: Leave Portal</h1></div>");
        out.println("<div class='container'>");
        out.println("<div class='balance-card'>");
        out.println("<h2>Welcome, Employee</h2>");
        out.println("<p>Current Annual Leave Balance: <strong>21 Days</strong></p>");
        out.println("<a href='./apply' class='btn'>Apply for Leave</a>");
        out.println("</div><br>");
        out.println("<a href='./policy' style='color: #003366;'>View Leave Policy</a>");
        out.println("</div></body></html>");
    }

    public ServletConfig getServletConfig() { return config; }
    public String getServletInfo() { return "Leave Home Servlet"; }
    public void destroy() {}
}