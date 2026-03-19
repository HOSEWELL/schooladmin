package app;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class Hosewell implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Servlet is starting");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>This is Hosewell starting his first servlet !!! Hello Servlet world</h1>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    public String getServletInfo() {
        return "";
    }

    @Override
    public void destroy() {
        System.out.println("Servlet closing");

    }
}
