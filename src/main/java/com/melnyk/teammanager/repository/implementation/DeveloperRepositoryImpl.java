package com.melnyk.teammanager.repository.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.DeveloperRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class DeveloperRepositoryImpl implements DeveloperRepository {
    @Override
    public Developer getById(Integer integer) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Developer dev = (Developer) session.createQuery("FROM Developer d LEFT JOIN FETCH d.team t WHERE d.id IN :i")
                .setParameter("i", integer)
                .uniqueResult();
        tx.commit();
        session.close();
        return dev;
    }

    @Override
    public Developer add(Developer developer) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(developer);
        tx.commit();
        session.close();
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.update(developer);
        tx.commit();
        session.close();
        return developer;
    }

    @Override
    public Developer removeById(Integer integer) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Developer dev = session.load(Developer.class, integer);
        session.delete(dev);
        tx.commit();
        session.close();
        return dev;
    }

    @Override
    public Set<Developer> getAll() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Set<Developer> developers = new HashSet<>(session.createQuery("FROM Developer d LEFT JOIN FETCH d.team t").getResultList());
        tx.commit();
        session.close();
        return developers;
    }
}
