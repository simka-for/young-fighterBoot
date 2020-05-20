package yungfighter.service;

import yungfighter.entity.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUserName(String username);

    User findById(Integer id);

    void delete(Integer id);

}
