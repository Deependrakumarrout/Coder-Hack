package com.crio.in.CoderHack.CoderHack.Controller;

import com.crio.in.CoderHack.CoderHack.Request.UserDto;
import com.crio.in.CoderHack.CoderHack.Service.UserService;
import com.crio.in.CoderHack.CoderHack.Utility.FinalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crio/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public FinalResponse createUser(@RequestBody UserDto userRequest) {
        return userService.createUser(userRequest);
    }


    @GetMapping("/user-detail-by-id/{id}")
    public FinalResponse getUserDetailById(@PathVariable("id") Long id) {
        return userService.getUserDetailById(id);
    }


    @GetMapping("/get-all-user-detail")
    public FinalResponse getAllUserDetails() {
        return userService.getAllUserDetails();
    }

    @PutMapping("/update-user-score/{userId}/{score}")
    public FinalResponse updateUserDetail(@PathVariable("userId") Long id, @PathVariable("score") int score) {
        return userService.updateUserScore(id, score);
    }

    @DeleteMapping("/delete-user-detail/{id}")
    public FinalResponse deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUserById(id);
    }

}
