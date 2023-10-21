package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final IUserRepository userRepo;

    @Autowired
    private UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User create(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public User read(String userId) {
        return this.userRepo.findById(userId).orElse(null);
    }

    @Override
    public User update(User user) {
        if (this.userRepo.existsById(user.getUserId()))
            return this.userRepo.save(user);
        return null;
    }

    @Override
    public boolean delete(String userId) {
        if (this.userRepo.existsById(userId)) {
            this.userRepo.deleteById(userId);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
