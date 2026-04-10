package app;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class RegisterPage extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Accessing both Config (Local) and Context (Global)
        ServletConfig config = getServletConfig();
        ServletContext context = getServletContext();

        // 1. Check for the password in the URL
        String passwordParam = req.getParameter("password");

        // 2. Fetch the password set in web.xml context-param
        String systemPassword = context.getInitParameter("systemPassword");

        // 3. Logic Check: If password is wrong or missing, forward to Home
        if (passwordParam == null || !passwordParam.equals(systemPassword)) {
            System.out.println("Access Denied: Incorrect or missing password.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/");
            dispatcher.forward(req, resp);
            return; // Stop execution here
        }

        // If password is correct, proceed to show the registration form
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + config.getInitParameter("pageName") + "</title>");
        writer.println("<style>");
        writer.println("body { font-family: Arial; margin: 0; background-color: #f4f6f8; }");
        writer.println("header { background-color: #2c3e50; color: white; padding: 20px; text-align: center; }");
        writer.println("section { margin: 40px auto; padding: 20px; background: white; border-radius: 5px; max-width: 400px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }");
        writer.println("input { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ddd; box-sizing: border-box; }");
        writer.println("button { padding: 12px; background-color: #3498db; color: white; border: none; width: 100%; cursor: pointer; font-size: 16px; }");
        writer.println("a { display: block; text-align: center; margin-top: 15px; color: #3498db; text-decoration: none; }");
        writer.println("</style>");
        writer.println("</head>");
        writer.println("<body>");

        writer.println("<header><h1>" + config.getInitParameter("pageHeader") + "</h1></header>");

        writer.println("<section>");
        writer.println("<h2>Register for a Course</h2>");
        writer.println("<form method='post' action='./register'>");
        writer.println("<label>Full Name:</label>");
        writer.println("<input type='text' name='name' placeholder='Enter your full name' required />");
        writer.println("<label>National ID:</label>");
        writer.println("<input type='text' name='nationalId' placeholder='Enter your ID number' required />");
        writer.println("<button type='submit'>Register</button>");
        writer.println("</form>");
        writer.println("<a href='./'>&larr; Back to Home</a>");
        writer.println("</section>");

        // Including the Footer via RequestDispatcher
        RequestDispatcher footerDispatcher = req.getRequestDispatcher("footer");
        footerDispatcher.include(req, resp);

        writer.println("</body></html>");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("<html><body style='font-family: Arial; padding: 40px; text-align: center;'>");
        writer.println("<h1 style='color: #2c3e50;'>Registration Successful</h1>");
        writer.println("<div style='background: white; padding: 20px; display: inline-block; border-radius: 8px; border: 1px solid #ddd;'>");

        Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();
            String value = req.getParameter(name);
            writer.println("<p><strong>" + name.toUpperCase() + ":</strong> " + value + "</p>");
        }

        writer.println("</div><br><br>");
        writer.println("<a href='./register?password=12345' style='color: #3498db;'>Register Another Student</a>");
        writer.println("</body></html>");
    }
}