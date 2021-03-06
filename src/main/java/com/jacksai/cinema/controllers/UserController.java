package com.jacksai.cinema.controllers;

import com.jacksai.cinema.model.User;
import com.jacksai.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method= RequestMethod.POST)
    public User create(@RequestBody @Valid User user) {
        return userService.save(user);
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<User> list() {
        return userService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User get(@PathVariable long id) {
        return userService.findOne(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public User update(@PathVariable("id") long id, @RequestBody @Valid User user) {
        return userService.save(user);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        userService.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}
