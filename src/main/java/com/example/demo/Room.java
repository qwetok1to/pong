package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

public class Room {
    private String id;
    private  int amountUsers = 2 ;

    private ArrayList<Room> rooms = new ArrayList<>();
    private HashMap <String,User> users=new  HashMap<>();
    public Room(String id) {
        this.id = id;
    }

    public  boolean isFull(){
        return users.size() >= amountUsers;
    }

    public int getUserCount(){
        return users.size();
    }

    boolean addUser(User user){
        if(users.size()>=amountUsers || users.containsKey(user.getId()))
            return false;
         users.put(user.getId(),user);

         return true;
    }

    boolean removeUser(String id){
        if(users.containsKey(id)){
            users.remove(id);
            return true;
        }
        return  false;
    }

    String getId(){
        return id;
    }
    HashMap <String,User> getUsers(){
        return users;
    }

}
