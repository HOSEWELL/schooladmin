package app;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.http.HttpServletRequest;

public class AppRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String uri = request.getRequestURI();
        String method = request.getMethod();

        System.out.println("[CCTV LOG] Request Incoming: " + method + " " + uri);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // This triggers when the response is fully sent to the user's browser
        // System.out.println("[CCTV LOG] Request Finished.");
    }
}