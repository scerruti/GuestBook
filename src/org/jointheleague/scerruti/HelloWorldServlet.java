package org.jointheleague.scerruti;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * Copyright 2016, The League of Amazing Programmers, All Rights Reserved
 */
public class HelloWorldServlet extends HttpServlet {
    static int staticCounter = 0;
    int dynamicCounter = 0;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Hello, World!");
        staticCounter++;
        dynamicCounter++;
        out.format("Static: %d Dynamic: %d\n", staticCounter, dynamicCounter);
        out.println(request.getQueryString());
        out.close();
    }
}
