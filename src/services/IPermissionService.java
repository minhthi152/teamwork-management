package services;

import model.Performers;
import model.PermissionType;

import java.util.List;

public interface IPermissionService {

    List<Performers> getPerformers();

    Performers findById(int id);

    List<Performers> findByTaskId(long taskId);

    void add(Performers newPermission);


    void updateForTask(Performers newPermission);

    void removePerformerOutOfTask(Performers performer, long taskId);

    boolean existById(int id);

    PermissionType findPermissionType(long taskId, String fullName);

    boolean existByIdInEachTask(long taskId, int userId);

    Performers findPerformerByTaskIdAndUserID(long taskId, int performerID);


    void addPerformerToTask(Performers performer,long taskId);
}