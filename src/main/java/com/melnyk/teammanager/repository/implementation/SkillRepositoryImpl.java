package com.melnyk.teammanager.repository.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class SkillRepositoryImpl implements SkillRepository {
    @Override
    public Skill getById(Integer integer) {
        Session session = HibernateUtil.getSession();
        Skill skill = session.get(Skill.class, integer);
        session.close();
        return skill;
    }

    @Override
    public Skill add(Skill skill) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.save(skill);
        tx.commit();
        session.close();
        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.update(skill);
        tx.commit();
        session.close();
        return skill;
    }

    @Override
    public Skill removeById(Integer integer) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Skill skill = session.load(Skill.class, integer);
        session.delete(skill);
        tx.commit();
        session.close();
        return skill;
    }

    @Override
    public Set<Skill> getAll() {
        Session session = HibernateUtil.getSession();
        Set<Skill> skills = new HashSet<>(session.createQuery("FROM Skill").getResultList());
        session.close();
        return skills;
    }
}
