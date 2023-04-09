package my.altocleff.practice312.service;

import my.altocleff.practice312.dao.UserDao;
import my.altocleff.practice312.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public User get(Long id) {
        return userDao.findById(id).isPresent() ?  userDao.findById(id).get() : new User();
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }
}
