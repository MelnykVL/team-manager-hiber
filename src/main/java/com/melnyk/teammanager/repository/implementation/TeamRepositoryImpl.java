package com.melnyk.teammanager.repository.implementation;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.TeamRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class TeamRepositoryImpl implements TeamRepository {
    @Override
    public Team getById(Integer integer) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Team team = session.get(Team.class, integer);
        tx.commit();
        session.close();
        return team;
    }

    @Override
    public Team add(Team team) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(team);
        tx.commit();
        session.close();
        return team;
    }

    @Override
    public Team update(Team team) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.update(team);
        tx.commit();
        session.close();
        return team;
    }

    @Override
    public Team removeById(Integer integer) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Team team = session.load(Team.class, integer);
        session.delete(team);
        tx.commit();
        session.close();
        return team;
    }

    @Override
    public Set<Team> getAll() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Set<Team> teams = new HashSet<>(session.createQuery("FROM Team").getResultList());
        tx.commit();
        session.close();
        return teams;
    }
}
