package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.TeamRepository;
import com.melnyk.teammanager.service.TeamService;

import java.util.Set;

public class TeamServiceImpl implements TeamService {
    private final TeamRepository repo;

    public TeamServiceImpl(TeamRepository repo) {
        this.repo = repo;
    }

    @Override
    public Team get(Integer integer) {
        return repo.getById(integer);
    }

    @Override
    public Team save(Team team) {
        return repo.add(team);
    }

    @Override
    public Team update(Team team) {
        return repo.update(team);
    }

    @Override
    public Team remove(Integer integer) {
        return repo.removeById(integer);
    }

    @Override
    public Set<Team> getAll() {
        return repo.getAll();
    }
}
