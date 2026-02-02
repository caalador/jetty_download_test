package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setResourceBase(App.class.getClassLoader().getResource("static").toExternalForm());

        context.addServlet(new ServletHolder("index", IndexServlet.class), "/");
        context.addServlet(new ServletHolder("download", DownloadServlet.class), "/download");
        context.addServlet(new ServletHolder("default", DefaultServlet.class), "/*");

        server.setHandler(context);
        server.start();

        System.out.println("Server started at http://localhost:8080");
        server.join();
    }
}
