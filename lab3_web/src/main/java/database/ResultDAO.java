package database;

import model.Result;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class ResultDAO {
    public void save(Result result){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(result);
        transaction.commit();
        session.close();
    }

    public List<Result> findAll(){
        List<Result> results = HibernateSessionFactory.getSessionFactory().openSession()
                .createQuery("From Result").list();
        return results;


    }

    public void deleteAll(){
        String stringQuery = "DELETE FROM Result";
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        session.createQuery(stringQuery).executeUpdate();
        session.getTransaction().commit();

        session.close();
    }
}
