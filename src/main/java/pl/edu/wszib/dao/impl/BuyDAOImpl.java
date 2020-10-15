package pl.edu.wszib.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IBuyDAO;
import pl.edu.wszib.model.Buy;




public class BuyDAOImpl implements IBuyDAO {

    @Autowired
    SessionFactory sessionFactory;

    public BuyDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBuy(Buy buy){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(buy);
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public Buy getBuy(int idBuy){
        Session session = this.sessionFactory.openSession();
        Buy buy =
                (Buy) session.createQuery("FROM pl.edu.wszib.model.Buy WHERE idBuy = " + idBuy).uniqueResult();

        session.close();
        return buy;
    }

    @Override
    public Buy removeBuyId(int idBuy){
        Session session = null;
        Transaction tx = null;

        try{
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            Buy buy =
                    (Buy) session.get(Buy.class, idBuy);
            session.delete(buy);
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
        }finally {
            session.close();
        }
        return null;
    }
}
