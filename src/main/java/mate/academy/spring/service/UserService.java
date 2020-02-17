package mate.academy.spring.service;

import java.util.List;
import mate.academy.spring.model.User;

public interface UserService {
    User add(User user);

    List<User> listUsers();

    User get(Long id);
}
