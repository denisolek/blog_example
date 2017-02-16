package pl.denisolek.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.denisolek.model.User;
import pl.denisolek.model.request.AddUserRequest;
import pl.denisolek.repository.UserRepository;

import java.util.List;

@RestController(value = "users")
@RequestMapping(value = "/api/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public void addUser(@RequestBody AddUserRequest addUserRequest) {
        User user = new User();
        user.setUsername(addUserRequest.getUsername());
        user.setPassword(addUserRequest.getPassword());
        user.setDisplayName(addUserRequest.getUsername());
        userRepository.save(user);
    }
}
