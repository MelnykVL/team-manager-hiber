package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TeamServiceImplTest {

    @Mock
    private TeamRepository teamRep;
    @InjectMocks
    private TeamServiceImpl teamSer;

    @Test
    public void shouldReturnNotNull() {
        Team team = new Team();
        team.setId(1);

        given(teamSer.get(1)).willReturn(team);

        team = teamSer.get(1);

        assertNotNull(team);
    }

    @Test
    public void shouldReturnNull() {
        Team team = new Team();
        team.setId(1);

        given(teamSer.get(1)).willReturn(null);

        team = teamSer.get(1);

        assertNull(team);
    }

    @Test
    public void save() {
        Team team = new Team();

        given(teamSer.save(team)).willReturn(team);

        team = teamSer.save(team);

        assertNotNull(team);
    }

    @Test
    public void update() {
        Team team = new Team();

        given(teamSer.update(team)).willReturn(team);

        team = teamSer.update(team);

        assertNotNull(team);
    }

    @Test
    public void remove() {
        Team team = new Team("Name");

        given(teamSer.remove(1)).willReturn(team);

        assertNotNull(teamSer.remove(1));
    }

    @Test
    public void shouldReturnFulledSet() {
        Set<Team> teams = new HashSet<>(Arrays.asList(
                new Team("Team-1"),
                new Team("Team-2")
        ));

        given(teamSer.getAll()).willReturn(teams);

        Set<Team> returnedList = teamSer.getAll();

        assertTrue(returnedList.size() > 0);
    }

    @Test
    public void shouldReturnEmptySet() {
        given(teamSer.getAll()).willReturn(new HashSet<>());

        Set<Team> returnedList = teamSer.getAll();

        assertTrue(returnedList.size() == 0);
    }
}