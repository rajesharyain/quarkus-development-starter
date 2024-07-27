package org.codekafe.service;


import org.codekafe.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public User createUser(User user) {
        if (user.getId() != null && entityManager.find(User.class, user.getId()) != null) {
            return entityManager.merge(user);
        } else {
            entityManager.persist(user);
            return user;
        }
    }

    @Transactional
    public User updateUser(Long id, User user) {
        User existingUser = entityManager.find(User.class, id);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            return entityManager.merge(existingUser);
        }
        return null;
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}

