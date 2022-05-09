package management;

import model.Performers;
import model.Task;
import services.IPermissionService;
import services.PermissionService;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class TasksManagement implements ITasksManagement {
    IPermissionService permissionService = PermissionService.getInstance();
    public static String path = "data/tasks.csv";
    List<Task> tasksList = new ArrayList<>();

    @Override
    public List<Task> getTasks() {
        List<Task> curtasksList = new ArrayList<>();
        List<String> lines = CSVUtils.read(path);
        for (String line : lines) {
            Task task = new Task(line);
            List<Performers> permissions = permissionService.findByTaskId(task.getId());
            task.setPermissions(permissions);
            curtasksList.add(task);
        }
        return tasksList = curtasksList;
    }

    @Override
    public void update() {
        CSVUtils.write(path, tasksList);
    }


    @Override
    public void addTask(Task newTask) {
        tasksList.add(newTask);
        CSVUtils.write(path, tasksList);
    }

    @Override
    public Task getByTaskId(long TaskId) {
        for (Task task : getTasks()) {
            if (task.getId() == TaskId) {
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean existById(long TaskId) {
        return getByTaskId(TaskId) != null;
    }

    @Override
    public boolean checkDuplicateId(long id) {
        for (Task task : tasksList) {
            if (task.getId() == id) return true;
        }
        return false;
    }

    @Override
    public void update(Task newTask) {
        Task task = getByTaskId(newTask.getId());
        task.setTaskName(newTask.getTaskName());


    }

    @Override
    public void remove(Task task) {
        tasksList.remove(task);
        CSVUtils.write(path, tasksList);
    }
}
