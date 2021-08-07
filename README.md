[![Build Status](https://travis-ci.com/MelnykVL/team-manager-hiber.svg?branch=master)](https://travis-ci.com/MelnykVL/team-manager-hiber)
[![codecov](https://codecov.io/gh/MelnykVL/team-manager-hiber/branch/master/graph/badge.svg?token=5RG53C1C1H)](https://codecov.io/gh/MelnykVL/team-manager-hiber)
# team-manager-hiber

## Overview

The small console application for managing teams, developers, and their skills using Hibernate and RDBMS PostgreSQL.

## Prerequisites

- Install the latest version of Java and set up environment variables *(if necessary)*.

  > [JDK](https://www.oracle.com/java/technologies/javase-downloads.html)<br>
  > **or**<br>
  > [OpenJDK](https://openjdk.java.net/install/)

- Install the Git.

  > [Git](https://git-scm.com/downloads)

- Install the PostgreSQL server.

  > [PostgreSQL](https://www.postgresql.org/download/)

- Install a Java IDE (for example: Intellij IDEA, Eclipse, NetBeans).

  > [Intellij IDEA](https://www.jetbrains.com/idea/download/#section=windows) (recommended)<br>
  > [Eclipse](https://www.eclipse.org/downloads/)<br>
  > [NetBeans](https://netbeans.apache.org/download/)

## Run the example

1. Clone the repository.<br>

    `git clone https://github.com/MelnykVL/team-manager-hiber.git`

2. Open the project with the Intellij IDEA.
3. Load Maven changes.
4. Set your settings in **flyway.poperties** and **hibernate.cfg.xml** files.
5. Create the database called ***team_manager***.
6. Using Maven in Intellij IDEA, run `flyway:migrate` to create tables in the database.
7. Run the project.
