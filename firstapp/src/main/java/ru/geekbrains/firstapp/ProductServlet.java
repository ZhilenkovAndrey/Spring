package ru.geekbrains.firstapp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        for (int i = 0; i < 10; i++) {

            int id = i + 1;
            String title = req.getParameter("product title: ");
            double cost = Double.parseDouble(req.getParameter("product cost: "));

            out.println("<html><body><h1>" + new Product(id, title, cost) + "<h1></body></html>");
            out.close();
        }
    }
}
