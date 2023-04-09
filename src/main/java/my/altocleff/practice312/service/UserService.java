package my.altocleff.practice312.service;

import my.altocleff.practice312.model.User;

import java.util.List;

public interface UserService {


    void add(User user);

    User get(Long id);


    void delete(Long id);

    List<User> getAll();
}
