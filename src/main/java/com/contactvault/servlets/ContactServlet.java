package com.contactvault.servlets;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");

        // Mask phone number
        String maskedPhone = maskPhoneNumber(phoneNumber);

        // Hash phone number
        String hashedPhone = hashPhoneNumber(phoneNumber);

        // Print output (for testing)
        response.getWriter().println("Masked Phone: " + maskedPhone);
        response.getWriter().println("Hashed Phone: " + hashedPhone);
    }

    private String maskPhoneNumber(String phone) {
        if (phone.length() < 7) return phone;  
        return phone.substring(0, 3) + "***" + phone.substring(phone.length() - 3);
    }

    private String hashPhoneNumber(String phone) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(phone.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return "Error hashing";
        }
    }
}
