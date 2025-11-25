import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        Task task1 = new Task(1, "ללמוד Java", "לסיים את השיעורים", Status.NEW);
        Task task2 = new Task(2, "לקנות מצרכים", "לחמניות, חלב, ביצים", Status.IN_PROGRESS);
        Task task3 = new Task(3, "לסיים פרויקט", "להגיש את הפרויקט למורה", Status.NEW);

        repository.add(task1);
        repository.add(task2);
        repository.add(task3);

        System.out.println("כל המשימות:");
        for (Task t : repository.allList()) {
            System.out.println(t);
        }

        service.SetTaskDone(1);

        List<Task> searchResults = service.SearchByText("פרויקט");
        System.out.println("\nחיפוש משימות לפי 'פרויקט':");
        for (Task t : searchResults) {
            System.out.println(t);
        }
        List<Task> sortedTasks = service.getTasksSortedByStatus();
        System.out.println("\nמשימות ממויינות לפי סטטוס:");
        for (Task t : sortedTasks) {
            System.out.println(t);
        }
    }
}