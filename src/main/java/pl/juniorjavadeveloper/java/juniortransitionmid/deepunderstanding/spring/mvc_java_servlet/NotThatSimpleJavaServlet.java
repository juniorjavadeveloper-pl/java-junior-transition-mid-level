package pl.juniorjavadeveloper.java.juniortransitionmid.deepunderstanding.spring.mvc_java_servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NotThatSimpleJavaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dashboardMode = request.getParameter("dashboardMode");
        if (dashboardMode != null) {
            request.setAttribute("dashboardMode", dashboardMode);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
        requestDispatcher.forward(request, response);
    }
}
