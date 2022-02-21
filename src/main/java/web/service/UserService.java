package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);
}
