package marketplace.apirest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import marketplace.apirest.entities.User;
import marketplace.apirest.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        List<User> usersList = userService.findAll();
        return usersList;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return user;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void insert(@RequestBody User user) {
        userService.insert(user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody User user) {
        userService.update(id, user);
    }
}
