package app;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LeaveHome implements Servlet {
    private ServletConfig config;

    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        // Security Check
        if (session == null || session.getAttribute("SESSION_ID") == null) {
            response.sendRedirect("./login");
            return;
        }

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // ... rest of your styling ...
        out.println("<div class='header'><h1>HRMS: Leave Portal</h1>");
        out.println("<h3>User: " + session.getAttribute("UserActualName") + "</h3></div>");
        out.println("<div class='container'><div class='balance-card'>");
        out.println("<h2>Welcome back!</h2>");
        out.println("<p>Current Annual Leave Balance: <strong>21 Days</strong></p>");
        out.println("<a href='./apply' class='btn'>Apply for Leave</a>");
        out.println("</div></div></body></html>");
    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {

    }
    // ... config/info/destroy methods ...
}