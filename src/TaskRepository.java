import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

//TaskRepository class manages tasks in memory and in JSON file
public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private final String filePath = "src/tasks.json";

    public TaskRepository() {
        loadFromFile();
    }

    // Save all tasks to JSON file
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("[\n");
            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);

                writer.write("  {\n");
                writer.write("    \"id\": " + t.getId() + ",\n");
                writer.write("    \"title\": \"" + escape(t.getTitle()) + "\",\n");
                writer.write("    \"description\": \"" + escape(t.getDescription()) + "\",\n");
                writer.write("    \"status\": \"" + t.getStatus().name() + "\"\n");
                writer.write("  }");

                if (i < tasks.size() - 1)
                    writer.write(",");

                writer.write("\n");
            }
            writer.write("]");
        } catch (IOException e) {
            System.out.println("שגיאה בכתיבה לקובץ: " + e.getMessage());
        }
    }

    // Load tasks from JSON file
    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                json.append(line.trim());
            }

            parseJson(json.toString());

        } catch (IOException e) {
            System.out.println("שגיאה בקריאת הקובץ: " + e.getMessage());
        }
    }


    private void parseJson(String json) {
        tasks.clear();

        if (json.equals("[]") || json.isEmpty()) return;


        json = json.substring(1, json.length() - 1).trim();

        String[] objects = json.split("\\},\\s*\\{");

        for (String obj : objects) {
            obj = obj.replace("{", "").replace("}", "").trim();

            String[] fields = obj.split(",");

            int id = 0;
            String title = "";
            String desc = "";
            Status status = Status.NEW;

            for (String f : fields) {
                String[] pair = f.split(":");
                String key = pair[0].replace("\"", "").trim();
                String value = pair[1].replace("\"", "").trim();

                switch (key) {
                    case "id":
                        id = Integer.parseInt(value);
                        break;
                    case "title":
                        title = value;
                        break;
                    case "description":
                        desc = value;
                        break;
                    case "status":
                        status = Status.valueOf(value);
                        break;
                }
            }

            tasks.add(new Task(id, title, desc, status));
        }
    }


    private String escape(String text) {
        return text.replace("\"", "\\\"");
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
