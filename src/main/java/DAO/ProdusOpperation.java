package DAO;

import entity.Produs;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProdusOpperation extends DaoInitializer {
    private Session session;
    private Transaction transaction;

    public void insertProdus(Produs produs) {
        getSessionAndTransaction();

        session.persist(produs);
        // session.detach(produs);   //  trece inapoi in starea de transient;
        produs.setName("BARABULE");
        commitTransactionAndCloseSession();
    }

    public void insertProduse(List<Produs> produse) {
        getSessionAndTransaction();
        for (Produs produs : produse) {
            try {
                session.persist(produs);

            } catch (Exception e) {
                transaction.rollback();
            }
        }
        commitTransactionAndCloseSession();
    }


    public Produs getProduscByName(String name){
        getSessionAndTransaction();
        Query query=session.createNamedQuery("find_by_name");
        query.setParameter("name", name);
        Produs produs=(Produs)query.getSingleResult();
        commitTransactionAndCloseSession();
        return produs;
    }

    public void deleteProdus(int id) {
        getSessionAndTransaction();
        Produs produs = session.find(Produs.class, id);
        session.delete(produs);
        commitTransactionAndCloseSession();

    }

    public Produs getProdus(int id) {
        getSessionAndTransaction();
        Produs produs = session.find(Produs.class, id);
        commitTransactionAndCloseSession();
        return produs;

    }

    public void getSessionAndTransaction() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public void commitTransactionAndCloseSession() {
        transaction.commit();
        session.close();
    }

    public void updateProdus(Produs produs){
        getSessionAndTransaction();

        session.merge(produs);
        //    SAU (merge  creaza un produs daca nu gasesti id,
        //         partea de update crapa daca  nu gaseste id)
//        Produs produsVechi=session.find(Produs.class,produs.getId());
//        produsVechi.setName(produs.getName());
//        produsVechi.setPrice(produs.getPrice());
//        session.update(produsVechi);

        commitTransactionAndCloseSession();
    }

    public void updateProdusById(Produs produsnou){
        getSessionAndTransaction();
        Query query=session.createNamedQuery("update_produs_identified_by_id");
        query.setParameter("id",produsnou.getId()).setParameter("name",produsnou.getName());
        query.executeUpdate();
        commitTransactionAndCloseSession();
    }

}
