package app;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener

public class AppContextListener implements ServletContextListener {

    // Triggers exactly when the server starts up
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        // 1. Fetch the name from web.xml
        String appName = context.getInitParameter("applicationName");

        // 2. Set a global attribute that ALL servlets can see immediately
        context.setAttribute("GLOBAL_TITLE", appName + " - Training Portal");

        System.out.println("**********");
        System.out.println(appName + " has STARTED successfully.");
        System.out.println("**********");
    }

    // Triggers exactly when the server is shutting down
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("**********");
        System.out.println("COHORT 12 IS SHUTTING DOWN. Cleaning up resources...");
        System.out.println("**********");
    }
}