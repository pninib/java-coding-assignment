import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TaskRepository repository = new TaskRepository();
        TaskService service = new TaskService(repository);

        // Infinite loop for menu options
        while (true) {
            System.out.println("\n*** ניהול משימות ***");
            System.out.println("1. הוסף משימה");
            System.out.println("2. מחק משימה");
            System.out.println("3. עדכן סטטוס ל-DONE");
            System.out.println("4. חפש משימות לפי טקסט");
            System.out.println("5. הצג כל המשימות");
            System.out.println("6. הצג משימות ממויינות לפי סטטוס");
            System.out.println("7. יציאה");
            System.out.print("בחר אפשרות: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("הזן ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("הזן כותרת: ");
                    String title = scanner.nextLine();

                    System.out.print("הזן תיאור: ");
                    String desc = scanner.nextLine();

                    Task newTask = new Task(id, title, desc, Status.NEW);
                    repository.add(newTask);
                    System.out.println("✓ המשימה נוספה!");
                    break;

                case 2:
                    System.out.print("הזן ID למחיקה: ");
                    int deleteId = scanner.nextInt();
                    repository.delete(deleteId);
                    System.out.println("✓ המשימה נמחקה!");
                    break;

                case 3:
                    System.out.print("הזן ID לסימון DONE: ");
                    int doneId = scanner.nextInt();
                    service.SetTaskDone(doneId);
                    System.out.println("✓ המשימה סומנה כ-DONE!");
                    break;

                case 4:
                    System.out.print("חפש טקסט: ");
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
                    System.out.println("להתראות!");
                    return;

                default:
                    System.out.println("בחירה לא תקינה");
            }
        }
    }
}