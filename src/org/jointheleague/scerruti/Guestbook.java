package org.jointheleague.scerruti;/*
 * Copyright 2016, The League of Amazing Programmers, All Rights Reserved
 */

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Guestbook {
    @Id
    public String book;
}
