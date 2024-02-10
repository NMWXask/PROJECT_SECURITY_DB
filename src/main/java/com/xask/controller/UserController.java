package com.xask.controller;
import com.xask.database.dto.UserDTO;
import com.xask.database.entity.User;
import com.xask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/newUser")
    public ResponseEntity<User> create(@RequestBody UserDTO dto){
        return mappingResponseUser(userService.save(dto));
    }

    @DeleteMapping("/user{id}")
    public HttpStatus delete(@PathVariable Integer id){
        userService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping()
    public ResponseEntity<List<User>>readAll(){
        System.out.println("readAll Controller");
        return mappingResponseListUser(userService.findAll());
    }

    private ResponseEntity<User>mappingResponseUser(User user){
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    private ResponseEntity<List<User>>mappingResponseListUser(List<User>users){
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
}
