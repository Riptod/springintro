package mate.academy.spring.dao;

import java.util.List;
import mate.academy.spring.model.User;

public interface UserDao {
    User add(User user);

    List<User> listUsers();

    User get(Long id);
}
