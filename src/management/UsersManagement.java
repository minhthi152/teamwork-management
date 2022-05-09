package management;

import model.User;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class UsersManagement implements IUsersManagement {
    public static UsersManagement instance;
    public final static String PATH = "data/users.csv";

    public UsersManagement() {
    }

    public static UsersManagement getInstance() {
        if (instance == null)
            instance = new UsersManagement();
        return instance;
    }

    @Override
    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        List<String> lines = CSVUtils.read(PATH);
        for (String line : lines) {
            userList.add(new User(line));
        }
        return userList;
    }

    @Override
    public User login(String userName, String password) {
        List<User> usersList = getUsers();
        for (User user : usersList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }

        }
        return null;
    }

    @Override
    public void add(User newUser) {
        List<User> usersList = getUsers();
        usersList.add(newUser);
        CSVUtils.write(PATH, usersList);
    }

    @Override
    public void update(User newUser) {
        List<User> usersList = getUsers();
        for (User user : usersList) {
            if (user.getId() == newUser.getId()) {
                if (newUser.getFullName() != null && !newUser.getFullName().isEmpty())
                    user.setFullName(newUser.getFullName());
                if (newUser.getEmail() != null && !newUser.getEmail().isEmpty())
                    user.setEmail(newUser.getEmail());
                if (newUser.getPhoneNumber() != null && !newUser.getPhoneNumber().isEmpty())
                    user.setPhoneNumber(newUser.getPhoneNumber());

                if (newUser.getUserName() != null && !newUser.getUserName().isEmpty())
                    user.setUserName(newUser.getUserName());
                if (newUser.getPassword() != null && !newUser.getPassword().isEmpty())
                    user.setPassword(newUser.getPassword());
                CSVUtils.write(PATH, usersList);
                break;
            }
        }

    }

    @Override
    public boolean existById(int id) {
        return getUserById(id) != null;
    }

    @Override
    public boolean checkDuplicateEmail(String email) {
        List<User> usersList = getUsers();
        for (User user : usersList) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkDuplicatePhone(String phoneNumber) {
        List<User> usersList = getUsers();
        for (User user : usersList) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkDuplicateUserName(String userName) {
        List<User> usersList = getUsers();
        for (User user : usersList) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User getUserById(int id) {
        List<User> usersList = getUsers();
        for (User user : usersList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
