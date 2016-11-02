package org.jointheleague.scerruti;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
 * Copyright 2016, The League of Amazing Programmers, All Rights Reserved
 */
public class SignGuestbookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Greeting greeting;

        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();  // Find out who the user is.

        String guestbookName = request.getParameter("guestbookName");
        String content = request.getParameter("content");
        if (user != null) {
            greeting = new Greeting(guestbookName, content, user.getEmail(), user.getUserId());
        } else {
            greeting = new Greeting(guestbookName, content);
        }

        // Use Objectify to save the greeting and now() is used to make the call synchronously as we
        // will immediately get a new page using redirect and we want the data to be present.
        ObjectifyService.ofy().save().entity(greeting).now();

        response.sendRedirect("/guestbook.jsp?guestbookName=" + guestbookName);
    }

}
