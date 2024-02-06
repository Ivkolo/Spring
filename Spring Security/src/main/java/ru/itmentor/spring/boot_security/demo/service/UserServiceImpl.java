package ru.itmentor.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itmentor.spring.boot_security.demo.DAO.RoleDAO;
import ru.itmentor.spring.boot_security.demo.DAO.UserDAO;

import ru.itmentor.spring.boot_security.demo.model.User;


import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
        private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
                this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User passwordCoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(passwordCoder(user));
    }

    @Override
    public void deleteById(long id) {
        userDAO.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

}