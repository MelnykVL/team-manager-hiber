package com.melnyk.teammanager.service.implementation;

import com.melnyk.teammanager.model.Developer;
import com.melnyk.teammanager.repository.DeveloperRepository;
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
public class DeveloperServiceImplTest {
    @Mock
    private DeveloperRepository devRep;
    @InjectMocks
    private DeveloperServiceImpl devSer;

    @Test
    public void shouldReturnNotNull() {
        Developer dev = new Developer();
        dev.setId(1);

        given(devSer.get(1)).willReturn(dev);

        dev = devSer.get(1);

        assertNotNull(dev);
    }

    @Test
    public void shouldReturnNull() {
        Developer dev = new Developer();
        dev.setId(1);

        given(devSer.get(1)).willReturn(null);

        dev = devSer.get(1);

        assertNull(dev);
    }

    @Test
    public void save() {
        Developer dev = new Developer();

        given(devSer.save(dev)).willReturn(dev);

        dev = devSer.save(dev);

        assertNotNull(dev);
    }

    @Test
    public void update() {
        Developer dev = new Developer();

        given(devSer.update(dev)).willReturn(dev);

        dev = devSer.update(dev);

        assertNotNull(dev);
    }

    @Test
    public void remove() {
        Developer dev = new Developer("Some", "Name");

        given(devSer.remove(1)).willReturn(dev);

        assertNotNull(devSer.remove(1));
    }

    @Test
    public void shouldReturnFulledSet() {
        Set<Developer> developers = new HashSet<>(Arrays.asList(
                new Developer("Name", "Surname"),
                new Developer("Some", "Name")
        ));

        given(devSer.getAll()).willReturn(developers);

        Set<Developer> returnedList = devSer.getAll();

        assertTrue(returnedList.size() > 0);
    }

    @Test
    public void shouldReturnEmptySet() {
        given(devSer.getAll()).willReturn(new HashSet<>());

        Set<Developer> returnedList = devSer.getAll();

        assertTrue(returnedList.size() == 0);
    }
}