package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;
import com.melnyk.teammanager.service.SkillService;

import java.util.Set;

public class SkillServiceImpl implements SkillService{
    private SkillRepository repo;

    public SkillServiceImpl(SkillRepository repo) {
        this.repo = repo;
    }

    @Override
    public Skill get(Integer integer) {
        return repo.getById(integer);
    }

    @Override
    public Skill save(Skill skill) {
        return repo.add(skill);
    }

    @Override
    public Skill update(Skill skill) {
        return repo.update(skill);
    }

    @Override
    public Skill remove(Integer integer) {
        return repo.removeById(integer);
    }

    @Override
    public Set<Skill> getAll() {
        return repo.getAll();
    }
}
