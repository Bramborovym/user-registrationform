package com.xvitcoder.springmvcangularjs.controller;

import com.xvitcoder.springmvcangularjs.beans.User;
import com.xvitcoder.springmvcangularjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:22 AM
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("userslist.json")
    public @ResponseBody List<User> getUserList() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public @ResponseBody void addUser(@RequestBody User user) {userService.addUser(user); userService.save(user);}

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public @ResponseBody void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/removeUser/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void removeUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @RequestMapping(value = "/removeAllUsers", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllUsers() {
        userService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getUserPartialPage(ModelMap modelMap) {
        return "users/layout";
    }
}
