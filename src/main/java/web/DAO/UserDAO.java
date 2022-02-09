package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public User showUser(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);
}
