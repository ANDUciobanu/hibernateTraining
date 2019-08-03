package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public abstract class DaoInitializer {



    protected SessionFactory sessionFactory;

    public DaoInitializer(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources=new MetadataSources(registry);
        Metadata metadata=sources.getMetadataBuilder().build();
        sessionFactory=metadata.getSessionFactoryBuilder().build();
    }
}
