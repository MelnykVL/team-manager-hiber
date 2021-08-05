package com.melnyk.teammanager.view;

import com.melnyk.teammanager.model.Skill;
import com.melnyk.teammanager.repository.implementation.SkillRepositoryImpl;
import com.melnyk.teammanager.service.SkillService;
import com.melnyk.teammanager.service.implementation.SkillServiceImpl;

import java.util.Set;

public class SkillView {
    private SkillService skillService = new SkillServiceImpl(new SkillRepositoryImpl());

    public void showListOfCommands() {
        System.out.println("\n|----Робота со списком навыков----|".toUpperCase());
        System.out.println("\t1. show (показать список навыков)");
        System.out.println("\t2. get (перейти к навыку по идентификатору)");
        System.out.println("\t3. create (создать навык)");
        System.out.println("\t4. remove (удалить навык по идентефикатору)");
        System.out.println("\t5. return (вернуться в главное меню)");
    }

    public void show() {
        System.out.println("Список всех навыков");
        Set<Skill> list = skillService.getAll();
        for (Skill skill : list)
            System.out.println(skill);
    }

    public void show(Integer id) {

        Skill skill = skillService.get(id);

        if (skill != null) {
            System.out.println("Навык с идентификатором " + id);
            System.out.println(skill);
        } else {
            System.out.println("Навыка с таким id не существует");
        }

    }

    public void showObjectActions() {
        System.out.println("Действия над объектом:");
        System.out.println("\tchange name (изменить имя навыка)");
        System.out.println("\tremove (удалить навык)");
    }
}
