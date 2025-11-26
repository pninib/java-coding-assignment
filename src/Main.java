import java.util.List;
import java.util.Scanner;

public class Main {
    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.nextLine();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        // Infinite loop for menu options
        while (true) {
            System.out.println("\n*** Task Management ***");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Mark Task as DONE");
            System.out.println("4. Search Tasks by Text");
            System.out.println("5. Display All Tasks");
            System.out.println("6. Display Tasks Sorted by Status");
            System.out.println("7. Exit");

            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1:
                    int id = readInt(scanner, "Enter ID: ");

                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = scanner.nextLine();

                    Task newTask = new Task(id, title, desc, Status.NEW);
                    repository.add(newTask);
                    System.out.println("✓ Task added!");
                    break;

                case 2:
                    int idd = readInt(scanner, "Enter ID to delete: ");
                    repository.delete(idd);
                    System.out.println("✓ Task deleted!");
                    break;

                case 3:
                    int idD = readInt(scanner, "Enter ID to mark as DONE: ");
                    service.SetTaskDone(idD);
                    System.out.println("✓ Task marked as DONE!");
                    break;

                case 4:
                    System.out.print("Enter text to search: ");
                    String text = scanner.nextLine();
                    List<Task> results = service.SearchByText(text);
                    results.forEach(System.out::println);
                    break;

                case 5:
                    repository.allList().forEach(System.out::println);
                    break;

                case 6:
                    service.getTasksSortedByStatus().forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}