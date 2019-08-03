package DAO;

import entity.Descriere;
import entity.Produs;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoDescriere extends DaoInitializer {
    private Session session;
    private Transaction transaction;

    public void getSessionAndTransaction() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public void commitTransactionAndCloseSession() {
        transaction.commit();
        session.close();
    }

    public Descriere getDescriere(int id){
        getSessionAndTransaction();
        Descriere descriere=session.find(Descriere.class, id);
        commitTransactionAndCloseSession();
        return descriere;
    }
}
