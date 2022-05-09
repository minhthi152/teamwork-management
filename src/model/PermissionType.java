package model;

public enum PermissionType {
    READ_ONLY, UPDATE , UPDATE_DELETE;

    public static PermissionType parsePermissionType(int value) {
        for (PermissionType permissionType : values()) {
            if (permissionType.ordinal() == value)
                return permissionType;
        }
        throw new IllegalArgumentException(value + "permission type  invalid");
    }

}
