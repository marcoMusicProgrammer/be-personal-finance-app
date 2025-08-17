package com.personal.app.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="prova",value="/prova")
public class FrontController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        GenericController<?> controller = new ControllerManager(type).getController();

        request.setAttribute("list", controller.getList());

        // String view = "";
        // switch (type.toLowerCase()) {
        //     case "expense":
        //         view = "webapp/WEB-INF/views/expense.jsp";
        //         break;
        //     case "income":
        //         view = "webapp/WEB-INF/views/income.jsp";
        //         break;
        //     default:
        //         response.sendError(HttpServletResponse.SC_NOT_FOUND);
        //         break;
        // }


        request.getRequestDispatcher( "income.jsp").forward(request, response);
    }
    
}
