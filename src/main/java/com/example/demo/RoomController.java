package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    RoomsService roomsService;



    @PostMapping("/create")
    public ResponseEntity<String> createRoom(@RequestBody User user) {
        roomsService.createRoom(user);
        System.out.println("Room created");
        String roomId = roomsService.getRoomIdByUser(user);

        return new ResponseEntity<String>(roomId, HttpStatus.OK);
    }


    @PostMapping("/join/{room}")
    public ResponseEntity<String> joinRoom(@PathVariable String room,@RequestBody User user) {
        Room room1 = roomsService.getRoomById(room);
        if (room1 == null) {
            return new ResponseEntity<>("Room already joined", HttpStatus.FORBIDDEN);
        }
        if (room1.addUser(user)) {
            roomsService.updateRoom(room1.getId(), room1);
            return new ResponseEntity<>("Room joined", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Room full", HttpStatus.FORBIDDEN);
        }


    }
}
    /**
    @PostMapping("register")
    public ResponseEntity<String> registerUser() {



        return null;
    }

  @PostMapping("/test")
      public void test(@RequestBody User user){
      System.out.println(user.test);

  }

}
 */

