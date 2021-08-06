package com.melnyk.teammanager.view;

import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.implementation.TeamRepositoryImpl;
import com.melnyk.teammanager.service.TeamService;
import com.melnyk.teammanager.service.implementation.TeamServiceImpl;

public class TeamView {
    private TeamService teamService = new TeamServiceImpl(new TeamRepositoryImpl());

    public void showListOfCommands() {
        System.out.println("\n|----Робота со списком команд----|".toUpperCase());
        System.out.println("\t1. show (показать список команд)");
        System.out.println("\t2. get (перейти к команде по идентификатору)");
        System.out.println("\t3. create (создать команду)");
        System.out.println("\t4. remove (удалить команду по идентефикатору)");
        System.out.println("\t5. return (вернуться в главное меню)");
    }

    public void show() {
        System.out.println("Список всех комманд");
        System.out.println(teamService.getAll());
    }

    public void show(Team team) {
        if (team != null)
            System.out.println(team);
        else
            System.out.println("Команды не существует");
    }

    public void showObjectActions() {
        System.out.println("Действия над объектом:");
        System.out.println("\tadd dev (добавить разработчика)");
        System.out.println("\tdelete dev (удалить разработчика)");
        System.out.println("\tchange name (изменить название команды)");
        System.out.println("\tchange status (изменить статус команды)");
        System.out.println("\tremove (удалить объект)");
    }
}
