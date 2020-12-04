# WEB Java Fundamentals Sprint Challenge

**Read these instructions carefully. Understand exactly what is expected _before_ starting this Sprint Challenge.**

This challenge allows you to practice the concepts and techniques learned over the past sprint and apply them in a concrete project. This sprint explored **Java Fundamentals**. During this sprint, you studied **Java Fundamentals*. In your challenge this week, you will demonstrate your mastery of these skills by creating **a Java Spring Database Application using Object Oriented Programming**.

This is an individual assessment. All work must be your own. Your challenge score is a measure of your ability to work independently using the material covered through this sprint. You need to demonstrate proficiency in the concepts and objectives introduced and practiced in preceding days.

You are not allowed to collaborate during the sprint challenge. However, you are encouraged to follow the twenty-minute rule and seek support from your TL if you need direction.

_You have **three hours** to complete this challenge. Plan your time accordingly._

## Introduction

This sprint challenge combines the knowledge from this week's Java Fundamentals lessons to create a Magical Piggy Bank using Java and the Spring Frame. We have a magical "piggy bank" (a piggy bank is the traditional name of a place to store coins, bills, money). The piggy bank is magical because it can hold unlimited amounts of money. However, you can not get the money out of it.

### Commits

Commit your code regularly and meaningfully. This helps both you (in case you ever need to return to old code for any number of reasons) and your team lead as the evaluate your solution.

## Interview Questions

Be prepared to demonstrate your understanding of this week's concepts by answering questions on the following topics. You might prepare by writing down your own answers before hand.

1. Explain how you took advantage of Java's Object Oriented approach to solve the sprint challenge.

Answer: Java by default is an OOP language so in this sprint for example we have a Model, we have a controller etc. Inside these files are classes, methods etc but if you take a step back you can see that are representitive of things that have to work together. Honestly not the best answer. 

2. Explain the three steps needed to run a Java application (using the JDK) including what each step does and how those step correlate to running a JavaScript application.

Answer: In order to run a java app using the JDK we need to go through three steps:
          - 1: Compile the program from source code to byte code so that your program can be executed in the Java Virtual Machine. Using command line or terminal navigate to the SRC file of the program and type: javac packagename/*.java.
          - 2: The above step creates a variety of *.class files so in this step we archive the many *.class files into a .jar file for easier distribution. Again in command line or terminal type the sytax --> jar cvfe chosenNameOfJarFile.jar package.directory package/*.class
          -3 Execute program ---> in terminal navigate to SRC file and type java -jar chosenNameOfJarFile.jar and then your program will run. 

3. Explain how Java being a strongly typed language affected your solution.

Answer: This is a great question becuase when building my Java Model for the data I orginally chose
to make my value field a long data type. When I went to get total value of all of the coins I was getting the wrong calculation. I was expecting 7.3 and I was getting as a result 6.5. When I went back and switched the total field from Long to double I then got the correct result. The lesson is that your choice of data type is extremely important. This server is working with money values, you cant afford to make mistakes in this situation. 

4. Can you explain the differences between Abstract Classes and Interfaces including how they are used in your application?

Answer: There are a variety of differences between Abstract Classes and Interfaces:
        1. In an interface you delcare variables but do not give them logic that is left for the class itself. Abstract classes can have variables and methods that have been fully fleshed out. The beuty of an interface is that 5 different classes can utilize it in 5 different ways.
        2. Interfaces can only extend other interfaces where as an abstract class can extend other classes.
        3. A java class can utilized multiple interfaces at once where as with an abstract class they can only use one. 

## Instructions

### Task 1: Project Set Up

- [ ] Create a forked copy of this project
- [ ] Add your team lead as collaborator on Github
- [ ] Clone your OWN version of the repository (Not Lambda's by mistake!)
- [ ] Create a new branch: git checkout -b `<firstName-lastName>`.
- [ ] Create the proper directory structure for developing a Java Application
- [ ] Push commits: `git push origin <firstName-lastName>`
- [ ] Implement the project on your newly created `<firstName-lastName>` branch, committing changes regularly
- [ ] Push commits: git push origin `<firstName-lastName>`

### Task 2: Project Requirements

- [ ] You are creating a project from scratch! There is no initial project from where to start.
- [ ] Using the wizard in IntelliJ, create a Java Spring Application
  - [ ] Name the application piggybank
  - [ ] Steps to remember in generating the initial application
    - [ ] Set the Group and Artifact Name
    - [ ] Set that this is a Maven Project
    - [ ] Select the proper Java Version
    - [ ] Select Spring Boot Version 2.2.X
    - [ ] Add the 4 Dependencies we need for a Java Spring Database Application
    - [ ] You do not need to use services or configuration packages
    - [ ] You do need to
      - [ ] update your POM.XML so H2 will work
      - [ ] update the applications.properties configuration file
      - [ ] add the data.sql file
      - [ ] create the necessary packages (at least 3 are needed) and classes
- [ ] Create a model Coin to represent the table for the piggy bank
  - Each row in the table contains: (use the provided data.sql as a guide)
    - The number of coins in this group
    - The face value of the coins in the group
    - The name of a single coin
    - The name of more than one coin
- [ ] Create an endpoint http://localhost:2019/total that prints to console the contents of the Piggy Bank as follows and returns an HTTP Status of OK:

In your console in IntelliJ you should see:

```TEXT
    1 Quarter
    1 Dime
    5 Dollars
    3 Nickels
    7 Dimes
    1 Dollar
    10 Pennies
    The piggy bank holds 7.3
```

In Postman you should see

![Postman Image](postman.png)

Note: 7.30 = ( 1 * 0.25) + ( 1 * 0.10) + ( 5 * 1.00) + ( 3 * 0.05) + ( 7 * 0.10) + ( 1 * 1.00) + (10 * 0.10)

Note: that when you have more than 1 coin, the plural of the coin's name is printed.

### Required best practices

- [ ] Consistent naming. Examples: variables, functions, Components, and file/folder organization.
- [ ] Consistent spacing. Examples: line breaks, around arguments and before/after functions.
- [ ] Consistent quotation usage.
- [ ] Spell-check.
- [ ] Schedule time to review, refine and reassess your work.

It is better to submit a challenge that meets [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product) than one that attempts too much and fails.

### Tips and Gotchas

In your solution, it is essential that you follow best practices and produce clean and professional results. You will be scored on your adherence to proper code style and good organization. Schedule time to review, refine, and assess your work and perform basic professional polishing including spell-checking and grammar-checking on your work. It is better to submit a challenge that meets MVP than one that attempts too much and does not.

### Task 3: Stretch Goals

After finishing your required elements, you can push your work further. These goals may or may not be things you have learned in this module but they build on the material you just studied. Time allowing, stretch your limits and see if you can deliver on the following optional goals:

- [ ] Add the ability to remove coins from the piggy bank
  - Prevent taking more coins than present in the piggy bank
  - Coins do not have to be removed in the same quantity that were added. For example based on the main program above, removing 3 dimes would be allowed. The Piggy Bank should adjust appropriately.
  - Just the amount to be removed should be given. The program will figure out which coins to remove.
  - You are to create an endpoint http://localhost:2019/money/{amount} that prints to the console the following (using 1.5 as the amount to remove) and returns an HTTP Status of OK

```TEXT
    $4
    7 Dimes
    $1
    10 Pennies
    The piggy bank holds $5.8
```

  - If the money cannot be removed, the following should be printed to the console and return an HTTP Status of OK

```TEXT
    Money not available
```

## Submission format

Follow these steps for completing your project.

- [ ] Submit a Pull-Request to merge <firstName-lastName> Branch into master (student's  Repo). **Please don't merge your own pull request**
- [ ] Add your team lead as a reviewer on the pull-request
- [ ] Your team lead will count the project as complete after receiving your pull-request
