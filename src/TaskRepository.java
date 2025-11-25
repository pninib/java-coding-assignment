import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private final String filePath = "src/tasks.json";

    //public TaskRepository(){
//    loadFromFile();
//}
    private void saveToFile() {

    }

    public void add(Task task) {
        tasks.add(task);
        saveToFile();
    }

    public void update(Task task) {
        for (int i = 0; i < tasks.size(); i++) {
            if (task.getId() == tasks.get(i).getId()) {
                tasks.set(i, task);
                break;
            }
        }
        saveToFile();
    }

    public void delete(int id) {
        tasks.removeIf(t -> t.getId() == id);
        saveToFile();
    }

    public Task getById(int id) {
        for (Task t : tasks) {
            if (t.getId() == id)
                return t;
        }
        return null;
    }

    public List<Task> allList() {
        return tasks;
    }
}
