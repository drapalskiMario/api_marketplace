package marketplace.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import marketplace.apirest.entities.User;
import marketplace.apirest.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User with id " + id + " not found.");
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with id " + id + " not found.");
        }

    }

    public void update(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            existingUser.get().setName(user.getName());
            existingUser.get().setEmail(user.getEmail());
            existingUser.get().setPhone(user.getPhone());
            userRepository.save(existingUser.get());
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User with id " + id + " not found.");
        }
    }
}
