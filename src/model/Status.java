package model;

public enum Status {
    PENDING("PENDING"),
    PROCESSING("PROCESSING"),
    COMPLETED("COMPLETED");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Status fromValue(String value) {
        Status[] values = values();
        for (Status status : values) {
            if (status.value.equals(value))
                return status;
        }
        throw new IllegalArgumentException("invalid");
    }
}
