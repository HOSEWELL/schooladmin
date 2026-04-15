package app.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

@WebListener

public class AppAttributeListener implements
        ServletContextAttributeListener,
        HttpSessionAttributeListener,
        ServletRequestAttributeListener {

    // --- 1. CONTEXT ATTRIBUTES (The Global Inventory) ---
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("[GLOBAL DATA] New System Property: " + scae.getName() + " = " + scae.getValue());
    }

    // --- 2. SESSION ATTRIBUTES (The User's Bag) ---
    @Override
    public void attributeAdded(HttpSessionBindingEvent hsbe) {
        // This triggers when you do: session.setAttribute("UserActualName", "Hosewell")
        System.out.println("[USER DATA] Attribute Saved: " + hsbe.getName() + " for Session: " + hsbe.getSession().getId());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent hsbe) {
        // Triggers when you update an existing attribute (like adding a new Person to your list)
        System.out.println("[USER DATA] Attribute Updated: " + hsbe.getName());
    }

    // --- 3. REQUEST ATTRIBUTES (The Single-Trip Cargo) ---
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        // Triggers when a servlet uses request.setAttribute()
        System.out.println("[TEMP DATA] Request Attribute Set: " + srae.getName());
    }
}