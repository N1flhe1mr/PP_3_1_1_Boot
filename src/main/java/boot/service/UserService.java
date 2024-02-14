package boot.service;

import boot.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(User user);

    void deleteUserById(long id);

    User findUserById(long id);

    List<User> getUsers();
}
