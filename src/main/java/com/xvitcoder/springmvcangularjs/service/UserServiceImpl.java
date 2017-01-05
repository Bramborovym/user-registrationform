package com.xvitcoder.springmvcangularjs.service;

import com.xvitcoder.springmvcangularjs.beans.User;
import com.xvitcoder.springmvcangularjs.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Exilion
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private static List<User> userList = new ArrayList<User>();
    private static Long id = 0L;


    private EntityManager em;






    @Override
    public List<User> getAllUsers() {
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        return findUserById(id);
    }

    @Override
    public void save(User user)
    {

        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessFact = hibernateUtil.getSessionFactory();
        Session session = sessFact.getCurrentSession();
        org.hibernate.Transaction tr = session.beginTransaction();





        System.out.println(tr.isActive());

        session.save(user);

        tr.commit();
    }


    @Override
    public void addUser(User user) {
        user.setId(++id);
        userList.add(user);

    }

    @Override
    public void deleteUserById(Long id) {
        User foundUser = findUserById(id);
        if (foundUser != null) {
            userList.remove(foundUser);
            id--;
        }
    }

    @Override
    public void deleteAll() {
        userList.clear();
        id = 0L;
    }

    @Override
    public void updateUser(User user) {
        User foundUser = findUserById(user.getId());
        if (foundUser != null) {
            userList.remove(foundUser);
            userList.add(user);
        }
    }



    private User findUserById(Long id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }
}
