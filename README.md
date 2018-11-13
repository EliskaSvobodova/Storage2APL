2APL (pronounced as double-a-p-l) is an agent-oriented programming 
language that facilitates the implementation of multi-agent systems. 
At the multi-agent level, it provides programming constructs to specify 
a multi-agent system in terms of a set of individual agents and a set 
of environments in which they can perform actions. At the individual 
agent level, it provides programming constructs to implement cognitive 
agents based on the BDI architecture. In particular, it provides 
programming constructs to implement an agent’s beliefs, goals, plans, 
actions (such as belief updates, external actions, or communication 
actions), events, and a set of rules through which the agent can 
decide which actions to perform. 2APL is a modular programming 
language allowing the encapsulation of cognitive components in 
modules. 2APL supports the implementation of both reactive and 
pro-active agents.

The 2APL programming language comes with its corresponding execution 
platform and an Eclipse plug-in editor. They are developed to support 
the development and execution of multi-agent programs. The platform 
provides a graphical interface through which a user can load, execute, 
and debug 2APL multi-agent programs using different execution modes 
and several debugging/observation tools. The platform can be used in 
two modes. In the stand-alone mode or in distributed mode using the 
Jade platform. The last option allows a multi-agent program to be run 
on different machines connected in a network. 

![2APL platform](http://apapl.sourceforge.net/wordpress/wp-content/uploads/2009/10/2APL-platform.png)

Instructions for using this application can be found on [http://www.projects.science.uu.nl/Net2APL/](http://www.projects.science.uu.nl/Net2APL/)

## Dependencies
This code has been tested in **Java 1.8**. The code was originally 
developed in Java 1.6, but since the transition to GIT, this was not
tested. Java versions more recent than 1.8 **do not work**, and there 
are no plans to support these versions in the future.

The recommended JDK / JRE is version 1.8.

## Installing the Code
The code for this project is controlled by Git (previously subversion). 
Building and packaging is handled by maven.

There are three ways to run the code:

1. Download the JAR and execute it directly (no access to source code)
1. Checkout the project from source control in your favorite IDE
1. Checkout the project from source control manually, and build using maven

The first option will not be described here - as running a JAR file is a
relatively standard operation and differs from operating system to 
operating system - except to say the JAR file can be found on the 
releases page.

## Opening this project in an IDE
Since this project is controlled by Maven, most IDE's should be able
to import this project automatically. For most IDE's, you'll click
`file` --> `import` `checkout from source control (git)` (or something
similar), which will automatically download the code, if you give it the
git URL of this repository. An extensive guide is available for setting up
the code with Eclipse Oxygen is available on the 
[2APL website](http://www.projects.science.uu.nl/Net2APL/prototype.html).

If the Maven settings are not automatically recognized, you will have to configure
the build manually. Some pointers for this are:
1. Add all the JAR files in `src/main/resources/jade` and `src/main/
resources/jiprolog` to your classpath. 
1. Set `src/main/java` as your source directory
1. Run `src/main/java/nl/uu/cs/is/apapl/APAPL.java` as your main class

In some cases, images are loaded, which are located in the source directory,
right next to the source code. If your IDE gives a null pointer exception after
manual setup, make sure during building, the images are moved to sit right next
to the compiled class files.

## Checking out manually
You can manually download this project from git, using

```bash
$ git clone https://bitbucket.org/goldenagents/2apl.git
$ cd 2apl
$ mvn install
``` 

The last command compiles the code. Alternatively, 

`$ mvn install exec:java`

can be used to compile the code and run the main class automatically.

This process requires Git and Maven (setup to use the Java 1.8 JRE / JDK).



