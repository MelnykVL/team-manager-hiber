package com.melnyk.teammanager;


import com.melnyk.teammanager.controller.DeveloperController;
import com.melnyk.teammanager.controller.SkillController;
import com.melnyk.teammanager.controller.TeamController;
import com.melnyk.teammanager.model.Team;
import com.melnyk.teammanager.repository.implementation.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        TeamController tc = new TeamController();
        DeveloperController dc = new DeveloperController();
        SkillController sc = new SkillController();

        String command = "";
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 - перейти к командам разработчиков");
            System.out.println("2 - перейти к разработчикам");
            System.out.println("3 - перейти к умениям");
            System.out.println("exit - завершение программы");

            System.out.print("Введите команду: ");
            command = scan.nextLine();

            if (command.equals("1"))
                tc.execute();
            else if (command.equals("2"))
                dc.execute();
            else if (command.equals("3"))
                sc.execute();
            else if (command.equalsIgnoreCase("exit"))
                return;
            else
                System.out.println("Команда не найдена");
        }
    }
}
