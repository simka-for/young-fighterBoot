package yungfighter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yungfighter.dto.UserDto;
import yungfighter.entity.User;
import yungfighter.service.UserService;

@RestController
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "user/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Integer id){
        User user = userService.findById(id);

        if (user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDto result = UserDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
