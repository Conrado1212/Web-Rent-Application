package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IUserAppDao;

import pl.edu.wszib.model.UserApp;
import pl.edu.wszib.model.Vehicle;

import java.util.List;

public class UserAppDAOImpl implements IUserAppDao {
    @Autowired
    SessionFactory sessionFactory;

    public UserAppDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUserApp(UserApp userApp){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(userApp);
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();
        }finally {
            session.close();
        }
    }
    @Override
    public UserApp getCustomer(int idUserApp){
        Session session = this.sessionFactory.openSession();
        UserApp userApp =
                (UserApp) session.createQuery("FROM pl.edu.wszib.model.UserApp WHERE idUserApp = " + idUserApp).uniqueResult();

        session.close();
        return userApp;
    }
    @Override
    public UserApp getUpdate(int idUserApp, UserApp userApp){
        Session session = null;
        Transaction tx = null;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.get(UserApp.class,idUserApp);

            session.update(userApp);
            tx.commit();
        }catch (HibernateException e){
            if(tx !=null); tx.rollback();
        }finally {
            session.close();
        }
        return  userApp;
        //sprawdzic update
    }

    @Override
    public  void updateUserApp(int idUserApp, UserApp userApp){
        Session session = null;
        Transaction tx = null;
        UserApp userApp1;
        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            userApp1 = (UserApp)session.load(UserApp.class,idUserApp);

            if(!(userApp.getLogin().equals(""))){
                userApp1.setLogin(userApp.getLogin());
            }
            if(!(userApp.getPassword().equals(""))){
                userApp1.setPassword(userApp.getPassword());
            }


        }catch (HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
    }




    @Override
    public UserApp removeUserAppId(int idUserApp){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            UserApp userApp =
                    (UserApp) session.get(Vehicle.class, idUserApp);
            session.delete(userApp);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
        return null;
    }
    @Override
    public java.util.List<UserApp> getAllUserApp() {
        //Session session = factory.openSession();

        Session session = this.sessionFactory.openSession();
        List<UserApp> allUserApp = session.createQuery("FROM pl.edu.wszib.model.UserApp").list();

        return allUserApp;
    }

    @Override
    public UserApp getUserByLogin(String login) {
        Session  session = this.sessionFactory.openSession();
        UserApp userApp =(UserApp) session.createQuery("FROM pl.edu.wszib.model.UserApp WHERE login = " + login + "'").uniqueResult();
        session.close();
        return userApp;

    }
}
