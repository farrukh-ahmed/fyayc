package com.fyayc.Interview.controllers;

import com.fyayc.Interview.common.Meta;
import com.fyayc.Interview.common.Response;
import com.fyayc.Interview.dto.PurchaseOrTradeDto;
import com.fyayc.Interview.entities.ProductEntity;
import com.fyayc.Interview.entities.UserEntity;
import com.fyayc.Interview.services.UserService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Response<UserEntity>> getUserById(@PathVariable Integer id){
        return new ResponseEntity<>(new Response<>(userService.findUserById(id),
                new Meta("User with give id fetched successfully.",HttpStatus.OK.value())),HttpStatus.OK);
    }

    @PutMapping("/purchaseOrTrade")
    public ResponseEntity<Response<List<UserEntity>>> purchaseOrTradeProduct(@RequestBody PurchaseOrTradeDto purchaseOrTradeDto){
        return new ResponseEntity<>(
                new Response<>(
                        userService.purchaseOrTrade(purchaseOrTradeDto),
                        new Meta("Purchasing or trading of product/products done successfully.",HttpStatus.OK.value())),HttpStatus.OK);
    }
    @GetMapping("/list/{id}")
    public ResponseEntity<Response<List<ProductEntity>>> getUserProductList(@PathVariable Integer id){
        return new ResponseEntity<>(
                new Response<>(userService.getUserProducts(id),
                        new Meta("All product of user fetched from the system.",HttpStatus.OK.value())),HttpStatus.OK);
    }
}
