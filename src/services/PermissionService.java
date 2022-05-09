package services;

import model.Performers;
import model.PermissionType;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class PermissionService implements IPermissionService {
    public static PermissionService instance;
    public final static String PATH = "data/permissions.csv";

    private PermissionService() {
    }

    public static PermissionService getInstance() {
        if (instance == null)
            instance = new PermissionService();
        return instance;
    }

    @Override
    public List<Performers> getPerformers() {
        List<Performers> performers = new ArrayList<>();
        List<String> lines = CSVUtils.read(PATH);
        for (String line : lines) {
            performers.add(Performers.parsePermission(line));
        }
        return performers;
    }


    @Override
    public Performers findById(int id) {
        List<Performers> performers = getPerformers();
        for (Performers performer : performers) {
            if (performer.getId() == id) {
                return performer;
            }
        }
        return null;
    }

    @Override
    public List<Performers> findByTaskId(long taskId) {
        List<Performers> result = new ArrayList<>();
        List<Performers> performers = getPerformers();
        for (Performers performer : performers) {
            if (performer.getTaskId() == taskId) {
                result.add(performer);
            }
        }
        return result;
    }

    @Override
    public void add(Performers newPermission) {
        List<Performers> permissions = getPerformers();
        permissions.add(newPermission);
        CSVUtils.write(PATH, permissions);
    }


    @Override
    public void updateForTask(Performers newPerformer) {

//        List<Performers> performersOfTask = findByTaskId(taskId);
        List<Performers> performers = getPerformers();
        for (Performers performer : performers) {
            if (performer.getId() == newPerformer.getId()) {
                performer.setPermissionType(newPerformer.getPermissionType());
                break;
            }
        }
        CSVUtils.write(PATH, performers);
    }


    @Override
    public void removePerformerOutOfTask(Performers performer,long taskId ) {
        System.out.println(performer);
        List<Performers> performers = getPerformers();
        performers.remove(performer);
        CSVUtils.write(PATH, performers);
    }

    @Override
    public boolean existById(int id) {
        return findById(id) != null;
    }


    public PermissionType findPermissionType(long taskId, String fullName){
        List<Performers> performers = findByTaskId(taskId);
        for (Performers performer : performers) {
            if (performer.getFullName().equals(fullName)) {
               return performer.getPermissionType();
            }
        }
        return null;
    }

    public boolean existByIdInEachTask(long taskId, int performerID){

        List<Performers> performersOfTask = findByTaskId(taskId);
        for (Performers performer : performersOfTask) {
            if (performer.getUserId()==performerID) {
                return true;
            }
        }
        return false;
    }

    public Performers findPerformerByTaskIdAndUserID(long taskId, int UserID){
        List<Performers> performers = findByTaskId(taskId);
        for (Performers performer : performers) {
            if (performer.getUserId()==UserID) {
                return performer;
            }
        }
        return null;
    }

    @Override
    public void addPerformerToTask(Performers performer, long taskId) {
        System.out.println(performer);
        List<Performers> performersOfTask = findByTaskId(taskId);
        performersOfTask.add(performer);
        List<Performers> performers = getPerformers();
        CSVUtils.write(PATH, performers);
    }


}
