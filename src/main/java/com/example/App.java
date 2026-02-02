package com.example;

import org.eclipse.jetty.ee10.servlet.DefaultServlet;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.ResourceFactory;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setBaseResource(ResourceFactory.of(context).newClassLoaderResource("static"));

        context.addServlet(new ServletHolder("index", IndexServlet.class), "/");
        context.addServlet(new ServletHolder("download", DownloadServlet.class), "/download");
        context.addServlet(new ServletHolder("default", DefaultServlet.class), "/*");

        server.setHandler(context);
        server.start();

        System.out.println("Server started at http://localhost:8080");
        server.join();
    }
}
