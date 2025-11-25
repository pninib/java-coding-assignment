import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task SetTaskDone(int id) {
        Task task = repository.getById(id);
        if (task != null) {
            task.setStatus(Status.DONE);
            repository.update(task);
            return task;
        }
        return null;
    }

    public List<Task> SearchByText(String text) {
        List<Task> returnTask = new ArrayList<>();
        String lowerSearchText = text.toLowerCase();

        for (Task task : repository.allList()) {
            if (task.getTitle().toLowerCase().contains(lowerSearchText) || task.getDescription().toLowerCase().contains(lowerSearchText)) {
                returnTask.add(task);
            }
        }
        return returnTask;
    }

    public List<Task> getTasksSortedByStatus() {
        List<Task> sortedTasks = new ArrayList<>(repository.allList());
        sortedTasks.sort((t1, t2) -> t1.getStatus().ordinal() - t2.getStatus().ordinal());
        return sortedTasks;
    }
}

