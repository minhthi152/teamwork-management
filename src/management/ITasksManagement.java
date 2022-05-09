package management;

import model.Task;

import java.util.List;

public interface ITasksManagement {
    List<Task> getTasks() ;
    void update();

    void addTask(Task newTask) ;

    Task getByTaskId(long TaskId) ;

    boolean existById(long TaskId) ;
    boolean checkDuplicateId(long id);

    void update(Task task);

    void remove(Task task);
}
