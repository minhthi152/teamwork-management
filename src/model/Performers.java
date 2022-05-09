package model;

import java.util.Objects;

public class Performers {
    private int id;
    private int userId;

//    nguoi dang nhap co nam trong danh sach ko? truyen vao full name, lay ra quyen
//    UserView.findUserByUsername(SignIn.currentUsername).getFullName()


    private long taskId;
    private String fullName;
    private PermissionType permissionType;

    public Performers(int id, int userId, long taskId, String fullName, PermissionType permissionType) {
        this.id = id;
        this.userId = userId;
        this.taskId = taskId;
        this.fullName = fullName;
        this.permissionType = permissionType;
    }

    public static Performers parsePermission(String line) {
        String[] array = line.split(",");
        int id = Integer.parseInt(array[0]);
        int userId = Integer.parseInt(array[1]);
        long taskId = Long.parseLong(array[2]);
        String fullName = array[3];
        PermissionType permissionType = PermissionType.parsePermissionType(Integer.parseInt(array[4]));
        return new Performers(id, userId, taskId, fullName, permissionType);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }

    @Override
    public String toString() {
        return String.format("%d,%d,%d,%s,%d", id, userId, taskId, fullName, permissionType.ordinal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Performers that = (Performers) o;
        return id == that.id && userId == that.userId && taskId == that.taskId && Objects.equals(fullName, that.fullName) && permissionType == that.permissionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, taskId, fullName, permissionType);
    }
}
