package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RoomsService {
    HashMap<String,Room> rooms=new HashMap<>();

    public RoomsService()
    {

    }

    boolean isRoomCreated(String id){
        return rooms.containsKey(id);
    }

    boolean createRoom(User user)
    {
        for (Room room : rooms.values()){
           if(room.getUsers().containsKey(user.getId()))
               return false;
        }
        Room nwerRoom = new Room(user.getId());
        nwerRoom.addUser(user);
        rooms.put(nwerRoom.getId(), nwerRoom);
        System.out.println("Room created");
        return true;
    }


    boolean deleteRoom(String id)
    {
        if (!rooms.containsKey(id)) return false;
        rooms.remove(id);

        return true;

    }
    public String getRoomIdByUser(User user){

        return rooms.get(user.getId()).getId();

    }
    public  Room getRoomById(String id)
    {
        return rooms.get(id);
    }
    public  void updateRoom(String id, Room room)
    {
        rooms.put(id, room);
    }


}
