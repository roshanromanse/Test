package com.test.user.repository;

import com.test.HibernateConfiguration;
import com.test.user.dto.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository("userDao")
public class UserDaoImpl implements UserDao{
   /* HibernateConfiguration hibernateConfig= new HibernateConfiguration();
    private SessionFactory sessionFactory = (SessionFactory) hibernateConfig.sessionFactory();
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    private Session session = this.sessionFactory.getCurrentSession();*/
	/*@Autowired
	 private HibernateConfiguration hibernateConfig;
	private SessionFactory sessionFactory = (SessionFactory) hibernateConfig.sessionFactory();
	//private SessionFactory sessionFactory;
	private Session session= this.sessionFactory.getCurrentSession();*/
	
	private Session session;
	@Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    	//this.session = this.sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<User> getUser() {
    	 List<User> userList = session.createQuery("from User").list();
         return userList;
    	
    }
    public User getUser(int id) {
        //Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, new Integer(id));
        return user;
    }

    public User saveUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        return user;
    }
    public User updateUser(Integer id, User user) {
        //Session session = this.sessionFactory.getCurrentSession();
        User user1 = session.get(User.class, id);
        user1.setEmail(user.getEmail());
        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setPassword(user.getPassword());
        session.update(String.valueOf(id), user1);
        return user1;
    }

    @Override
    public void deleteUser(int id) {
    	//Session session = this.sessionFactory.getCurrentSession();
    	User p = (User) session.load(User.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
    }

   
}
