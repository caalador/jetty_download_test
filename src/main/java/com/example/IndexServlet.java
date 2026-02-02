package com.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>File Download</title></head>");
        out.println("<body>");
        out.println("<h1>Welcome to Jetty Server</h1>");
        out.println("<p><a href=\"/download\">Click here to download the file</a></p>");
        out.println("</body>");
        out.println("</html>");
    }
}
