package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.impl.UserService;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    private IUserRepository userRepository;

    @PostMapping("/user")
    User newUser (@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    //@PostMapping("/create")
//    public User create(@RequestBody User user) {
//        User newUser = UserFactory.createUser("Khaya", "20 Smith Avenue, Cape Town, 8001", "khaya@gmail.com", "0123456789");
//        return userService.create(newUser);
//    }

//    @GetMapping("/read/{userId}")
//    public User read(@PathVariable String userId) {
//        return userService.read(userId);
//    }
//
//    @PostMapping("/update")
//    public User update(@RequestBody User user) {
//        return userService.update(user);
//    }
//
//    @DeleteMapping("/delete/{userId}")
//    public boolean delete(@PathVariable String userId) {
//        return userService.delete(userId);
//    }
//
//    @GetMapping("/getAll")
//    public List<User> getAll() {
//        return userService.getAll();
//    }
}