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
        Team team = (Team) session.createQuery("FROM Team t LEFT JOIN FETCH t.developers d WHERE t.id IN :i")
                .setParameter("i", integer)
                .uniqueResult();
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
        Set<Team> teams = new HashSet<>(session.createQuery("FROM Team t LEFT JOIN FETCH t.developers d").getResultList());
        session.close();
        return teams;
    }
}
