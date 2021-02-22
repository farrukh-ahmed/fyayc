package com.fyayc.Interview.controllers;

import com.fyayc.Interview.common.Meta;
import com.fyayc.Interview.common.Response;
import com.fyayc.Interview.dto.PurchaseOrTradeDto;
import com.fyayc.Interview.dto.UserDto;
import com.fyayc.Interview.entities.UserEntity;
import com.fyayc.Interview.mapping.MappingContext;
import com.fyayc.Interview.mapping.UserMapper;
import com.fyayc.Interview.services.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    MappingContext mappingContext;

    @PostMapping("/")
    public ResponseEntity<Response<UserEntity>> add(@Valid @RequestBody UserEntity user){

        return new ResponseEntity<>(new Response<>(userService.addUser(user),
                new Meta("User has been added to the system successfully.",HttpStatus.OK.value())),HttpStatus.OK);
    }
    @PutMapping("/")
    public ResponseEntity<Response<UserEntity>> update(@Valid @RequestBody UserEntity user){
        return new ResponseEntity<>(new Response<>(userService.addUser(user),
                new Meta("User has been updated to the system successfully.",HttpStatus.OK.value())),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Response<List<UserEntity>>> list(){
        return new ResponseEntity<>(
                new Response<>(userService.getAllUsers(),
                        new Meta("All users fetched from the system.",HttpStatus.OK.value())),HttpStatus.OK);
    }

    public ResponseEntity<Response<UserEntity>> getUserById(@PathVariable Integer userId){
        return new ResponseEntity<>(new Response<>(userService.addUser(user),
                new Meta("User has been updated to the system successfully.",HttpStatus.OK.value())),HttpStatus.OK);
    }

    public ResponseEntity<Response<UserEntity>> addProductsInTheCart(@Valid @RequestBody UserDto userDto){
        return null;
    }
    @PutMapping("/purchaseOrTrade")
    public ResponseEntity<Response<UserEntity>> purchaseOrTradeProduct(@RequestBody PurchaseOrTradeDto purchaseOrTradeDto){
        return null;
    }
}
