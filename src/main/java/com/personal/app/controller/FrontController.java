package com.personal.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.personal.app.handler.HandlerRegistry;
import com.personal.app.handler.RequestHandler;

@WebServlet(name="app",value="/app")
public class FrontController extends HttpServlet {

    public static ControllerManager cm;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        RequestHandler<?> handler = HandlerRegistry.getHandler(type);

        if(handler == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        request.setAttribute("list", handler.getController().getList());

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/" + type.toLowerCase() + ".jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        RequestHandler<?> handler = HandlerRegistry.getHandler(type);

        addEntity(handler, request);
    }

    private <T> void addEntity(RequestHandler<T> handler, HttpServletRequest request) {
        GenericController<T> controller = handler.getController();
        T entity = handler.buildEntity(request);
        controller.add(entity);
    }
    
}
