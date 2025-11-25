# Java Todo List Application

Description:
A simple console-based Todo List application in Java.
Features:
- Add, update, delete tasks
- Mark tasks as DONE
- Search tasks by text in title or description
- List all tasks
- List tasks sorted by status (NEW -> IN_PROGRESS -> DONE)

Requirements:
- Java JDK 11 or higher
- IDE (IntelliJ, Eclipse, NetBeans) or command line

Project Files:
- Task.java        : Task entity class
- Status.java      : Enum for task status
- TaskRepository.java : Handles task storage in memory and JSON file
- TaskService.java : Business logic (mark DONE, search, sort)
- Main.java        : Main class with console menu
- tasks.json       : JSON file storing tasks (auto-created)

How to Run:

1. Using an IDE:
   - Open project in your IDE
   - Compile all Java files
   - Run Main.java
   - Use the console menu to manage tasks

2. Using Command Line:
   - Navigate to project folder
   - Compile all files: javac *.java
   - Run the app: java Main
   - Follow menu prompts in console

Notes:
- tasks.json is automatically created in the src folder when tasks are added
- Ensure write permission in the folder
- Uses only standard Java libraries
