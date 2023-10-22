package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.exception.UserNotFoundException;
import za.ac.cput.repository.IUserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(String.valueOf(id))
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepository.findById(String.valueOf(id))
                .map(user -> {
                    user.setUserName(newUser.getUserName());
                    user.setUserAddress(newUser.getUserAddress());
                    user.setUserEmail(newUser.getUserEmail());
                    user.setUserPhone(newUser.getUserPhone());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if (!userRepository.existsById(String.valueOf(id))){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(String.valueOf(id));
        return "User with id " +id+ " has been deleted successfully.";
    }

    /* @Autowired
    private UserService userService;

    private IUserRepository userRepository;

    @PostMapping("/user")
    User newUser (@RequestBody User newUser){

        return userRepository.save(newUser);
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        User newUser = UserFactory.createUser(user.getUserName(), user.getUserAddress(), user.getUserEmail(), user.getUserPhone());
        return userService.create(newUser);
    }

    @GetMapping("/read/{userId}")
    public User read(@PathVariable String userId) {
        return userService.read(userId);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean delete(@PathVariable String userId) {
        return userService.delete(userId);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return userService.getAll();
    } */
}