package boot.service;

import boot.model.User;
import boot.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void deleteUserById(long id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public User findUserById(long id) {
        return userDAO.findUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
}
