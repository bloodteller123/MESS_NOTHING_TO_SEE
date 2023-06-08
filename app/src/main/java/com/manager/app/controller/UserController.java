package com.manager.app.controller;

import com.manager.app.exception.ApiRequestException;
import com.manager.app.model.User;
import com.manager.app.model.UserCourse;
import com.manager.app.result.CommonResult;
import com.manager.app.service.UserService;
import com.manager.app.utils.PasswordUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
@Slf4j
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

//    https://www.baeldung.com/javax-validation
    @PostMapping
    public CommonResult insertUser(@RequestBody @Valid User record){
        log.info("new user insertion {}", record);
        // default id should be 0 on the frontend
        User user = userService.findUserById(record.getId());
//        if(user!=null) return CommonResult.error("User exists");

        if(record.getPassword()!=null){
            if(user==null){
                if(userService.findUserByName(record.getName())!=null){
                    return CommonResult.error("UserName exits");
                }
                // new user, save password
                PasswordUtils.encrypt(record);
            }else{
                log.info("Should we update password?");
            }
        }
        log.info("saving");
        userService.insertUser(record);
        return CommonResult.success();
    }
    @GetMapping
    public CommonResult getUsers(){
        log.info("get all users custom exception");
//        throw new ApiRequestException("No Users");
        return CommonResult.success(userService.getAllUsers());
//        return userService.getAllUsers();
    }

    @GetMapping(path = "{id}/courses")
    public List<UserCourse> getAllCoursesForStudent(@PathVariable("id") long id){
        log.info(Long.toString(id));
        User user = userService.findUserById(id);
        if(user==null) return new ArrayList<>();



    }

    @DeleteMapping(path={"userId"})
    public CommonResult deleteUser(@PathVariable("userId") Long id){
        userService.deleteUserById(id);
        return CommonResult.success();
    }
}
