package org.jointheleague.scerruti;/*
 * Copyright 2016, The League of Amazing Programmers, All Rights Reserved
 */

import com.googlecode.objectify.ObjectifyService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OfyHelper implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ObjectifyService.register(Guestbook.class);
        ObjectifyService.register(Greeting.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        throw new UnsupportedOperationException();
    }
}
