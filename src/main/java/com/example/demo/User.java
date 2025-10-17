package com.example.demo;

public class User {

    private String id;
    public    String nick;

    User(String nick ){
        this.nick = nick;
        this.id=nick.hashCode()+"";

    }

    String getNick(){
        return nick;
    }

    String getId(){
        return id;
    }

}
