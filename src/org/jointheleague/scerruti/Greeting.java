package org.jointheleague.scerruti;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.util.Date;

@Entity
public class Greeting {

    @Parent
    Key<Guestbook> theBook;

    @Id
    public Long id;
    public String author_email;
    public String author_id;
    public String content;

    @Index
    public Date date;

    public Greeting() {
        date = new Date();
    }

    public Greeting(String book, String content) {
        this();
        if( book != null ) {
            theBook = Key.create(Guestbook.class, book);
        } else {
            theBook = Key.create(Guestbook.class, "default");
        }
        this.content = content;
    }

    public Greeting(String book, String content, String author_email, String author_id) {
        this(book, content);
        this.author_email = author_email;
        this.author_id = author_id;
    }
}
