package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IRentDAO;
import pl.edu.wszib.model.Rent;


public class RentDAOImpl implements IRentDAO {


    @Autowired
    SessionFactory sessionFactory;

    public RentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRent(Rent rent){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(rent);
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();
        }finally {
            session.close();
        }
    }
    @Override
    public Rent getRent(int idRent){
        Session session = this.sessionFactory.openSession();
        Rent rent =
                (Rent) session.createQuery("FROM pl.edu.wszib.model.Buy WHERE idRent = " + idRent).uniqueResult();

        session.close();
        return rent;
    }

    @Override
    public Rent removeRentId(int idRent){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            Rent rent =
                    (Rent) session.get(Rent.class, idRent);
            session.delete(rent);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
        return null;
    }
}
