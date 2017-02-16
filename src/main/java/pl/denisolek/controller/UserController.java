package pl.denisolek.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.denisolek.model.User;
import pl.denisolek.model.request.AddUserRequest;
import pl.denisolek.model.request.UpdateUserRequest;
import pl.denisolek.repository.UserRepository;

import java.util.Date;
import java.util.List;

@RestController(value = "users")
@RequestMapping(value = "/api/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findUser(@PathVariable("id") long id) {
        return  userRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public void addUser(@RequestBody AddUserRequest addUserRequest) {
        User user = new User();
        user.setUsername(addUserRequest.getUsername());
        user.setPassword(addUserRequest.getPassword());
        user.setDisplayName(addUserRequest.getUsername());
        userRepository.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateUser(@PathVariable("id") long id, @RequestBody UpdateUserRequest updateUserRequest) {
        User user = userRepository.findOne(id);

        user.setPassword(updateUserRequest.getPassword());
        user.setDisplayName(updateUserRequest.getDisplayName());
        user.setDescription(updateUserRequest.getDescription());
        user.setUpdated_at(new Date());

        userRepository.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long id) {
        userRepository.delete(id);
    }
}
