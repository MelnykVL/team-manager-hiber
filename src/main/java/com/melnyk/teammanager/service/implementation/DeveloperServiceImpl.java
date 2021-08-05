package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.DeveloperRepository;
import com.melnyk.teammanager.service.DeveloperService;

import java.util.Set;

public class DeveloperServiceImpl implements DeveloperService {
    private DeveloperRepository repo;

    public DeveloperServiceImpl(DeveloperRepository repo) {
        this.repo = repo;
    }

    @Override
    public Developer get(Integer integer) {
        return repo.getById(integer);
    }

    @Override
    public Developer save(Developer developer) {
        return repo.add(developer);
    }

    @Override
    public Developer update(Developer developer) {
        return repo.update(developer);
    }

    @Override
    public Developer remove(Integer integer) {
        return repo.removeById(integer);
    }

    @Override
    public Set<Developer> getAll() {
        return repo.getAll();
    }
}
