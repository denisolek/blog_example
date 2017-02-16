package pl.denisolek.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.denisolek.exceptions.UserNotFoundException;
import pl.denisolek.model.User;
import pl.denisolek.model.request.AddUserRequest;
import pl.denisolek.model.request.UpdateUserRequest;
import pl.denisolek.repository.UserRepository;

import java.util.Date;
import java.util.List;

@RestController(value = "users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> findAllUsers() {
        System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }

    @RequestMapping(value = "/api/users/{id}",method = RequestMethod.GET)
    public User findUser(@PathVariable("id") long id) {
        this.validateUser(id);
        return  userRepository.findOne(id);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST, headers = "Accept=application/json")
    public void addUser(@RequestBody AddUserRequest addUserRequest) {
        User user = new User();
        user.setUsername(addUserRequest.getUsername());
        user.setPassword(addUserRequest.getPassword());
        user.setDisplayName(addUserRequest.getUsername());
        userRepository.save(user);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateUser(@PathVariable("id") long id, @RequestBody UpdateUserRequest updateUserRequest) {
        this.validateUser(id);
        User user = userRepository.findOne(id);

        user.setPassword(updateUserRequest.getPassword());
        user.setDisplayName(updateUserRequest.getDisplayName());
        user.setDescription(updateUserRequest.getDescription());
        user.setUpdated_at(new Date());

        userRepository.save(user);
    }

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) {
        this.validateUser(id);
        userRepository.delete(id);
    }

    private void validateUser(long id) {
        if (this.userRepository.findOne(id) == null) {
            throw new UserNotFoundException(id);
        }
    }
}
