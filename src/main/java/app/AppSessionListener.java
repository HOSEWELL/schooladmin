package app;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.ServletContext;

@WebListener

public class AppSessionListener implements HttpSessionListener {

    // Triggers when a new user starts a session
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();

        // Use a synchronized block to ensure the counter is accurate
        // even if 100 people log in at the exact same second.
        synchronized (context) {
            Integer activeUsers = (Integer) context.getAttribute("ACTIVE_USERS");
            if (activeUsers == null) activeUsers = 0;

            activeUsers++;
            context.setAttribute("ACTIVE_USERS", activeUsers);
        }

        System.out.println("[SESSION CREATED] A new user has entered. Total Active: "
                + context.getAttribute("ACTIVE_USERS"));
    }

    // Triggers when session.invalidate() is called
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();

        synchronized (context) {
            Integer activeUsers = (Integer) context.getAttribute("ACTIVE_USERS");
            if (activeUsers != null && activeUsers > 0) {
                activeUsers--;
                context.setAttribute("ACTIVE_USERS", activeUsers);
            }
        }

        System.out.println("[SESSION DESTROYED] A user has left. Total Active: "
                + context.getAttribute("ACTIVE_USERS"));
    }
}