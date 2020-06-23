package com.example.Firebase.Controller;

import com.example.Firebase.Person.Person;
import com.example.Firebase.servicePackage.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class Controller {

    @Autowired
    FirebaseService  firebaseService;
    @GetMapping("/get")
    public Person getuser(@RequestHeader String name) throws ExecutionException, InterruptedException {

        return firebaseService.getUserDetails(name);
    }

    @PostMapping("/create")
    public String createuser(@RequestBody Person person) throws ExecutionException, InterruptedException {
        return firebaseService.saveUserDetails(person);

    }

    @PutMapping("/update")
    public String updateuser(@RequestBody Person person) throws ExecutionException, InterruptedException {
        return firebaseService.updateUserDetails(person);
    }

    @DeleteMapping("/delete")
    public String deleteuser(@RequestHeader String name){
        return firebaseService.deleteUserDetails(name);
    }

}
