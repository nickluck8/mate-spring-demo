package com.nick.dao;


import com.nick.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public User findById(Long id) {
        String query = "select u from  User as u " +
                "inner join ProductOrder as o " +
                "on u.id = o.id " +
                "where u.id =:id";

        User user = (User) sessionFactory
                .getCurrentSession()
                .createQuery(query)
                .setParameter("id", id)
                .uniqueResult();
        return user;
    }


}
