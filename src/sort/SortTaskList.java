package sort;

import management.TasksManagement;
import model.Task;
import utils.ValidateUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static views.TaskList.showAllTasks;

public class SortTaskList {

    public static TasksManagement tasksManagement = new TasksManagement();
    public static void sortByTaskNameAsc() {
        List<Task> tasksList = tasksManagement.getTasks();
        Collections.sort(tasksList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getTaskName().compareTo(o2.getTaskName());
            }
        });

        tasksManagement.update();
        showAllTasks();
    }

    public static void sortByDeadlineAsc() {
        List<Task> tasksList = tasksManagement.getTasks();
        Collections.sort(tasksList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return (ValidateUtils.toISODate(o1.getDeadline())).compareTo((ValidateUtils.toISODate(o2.getDeadline())));
            }
        });

        tasksManagement.update();
        showAllTasks();
    }

    public static void sortByCreateDateAsc() {
        List<Task> tasksList = tasksManagement.getTasks();
        Collections.sort(tasksList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return (ValidateUtils.toISODate(o1.getCreateDate())).compareTo((ValidateUtils.toISODate(o2.getCreateDate())));
            }
        });

        tasksManagement.update();
        showAllTasks();
    }
}
