package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.SkillRepository;
import com.melnyk.teammanager.repository.implementation.SkillRepositoryImpl;
import org.junit.Before;
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
public class SkillServiceImplTest {
    @Mock
    private SkillRepository skillRep;
    @InjectMocks
    private SkillServiceImpl skillSer;

    @Test
    public void shouldReturnNotNull() {
        Skill skill = new Skill();

        given(skillSer.get(1)).willReturn(skill);

        skill = skillSer.get(1);

        assertNotNull(skill);
    }

    @Test
    public void shouldReturnNull() {
        Skill skill = new Skill();

        given(skillSer.get(1)).willReturn(null);

        skill = skillSer.get(1);

        assertNull(skill);
    }

    @Test
    public void save() {
        Skill skill = new Skill();

        given(skillSer.save(skill)).willReturn(skill);

        skill = skillSer.save(skill);

        assertNotNull(skill);
    }

    @Test
    public void update() {
        Skill skill = new Skill();

        given(skillSer.update(skill)).willReturn(skill);

        skill = skillSer.update(skill);

        assertNotNull(skill);
    }

    @Test
    public void remove() {
        Skill skill = new Skill(1, "Name");

        given(skillSer.remove(1)).willReturn(skill);

        assertNotNull(skillSer.remove(1));
    }

    @Test
    public void shouldReturnFulledSet() {
        Set<Skill> skills = new HashSet<>(Arrays.asList(
                new Skill(1,"Java"),
                new Skill(2,"Hiber")
        ));

        given(skillSer.getAll()).willReturn(skills);

        Set<Skill> returnedList = skillSer.getAll();

        assertTrue(returnedList.size() > 0);
    }

    @Test
    public void shouldReturnEmptySet() {
        given(skillSer.getAll()).willReturn(new HashSet<>());

        Set<Skill> returnedSet = skillSer.getAll();

        assertTrue(returnedSet.size() == 0);
    }
}