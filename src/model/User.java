package model;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String userName;
    private String password;
    private Role role;

    public User() {
    }

    public User(int id, String fullName, String email, String phoneNumber, String userName, String password, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User(String line){
        String[] userInfo = line.split(",");
        this.id = Integer.parseInt(userInfo[0]);
        this.fullName = userInfo[1];
        this.email = userInfo[2];
        this.phoneNumber = userInfo[3];
        this.userName = userInfo[4];
        this.password = userInfo[5];
        this.role = Role.fromValue(userInfo[6]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return id +
                "," + fullName +
                "," + email +
                "," + phoneNumber +
                "," + userName +
                "," + password +
                "," + role;
    }
}
