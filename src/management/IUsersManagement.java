package management;

import model.User;

import java.util.List;

public interface IUsersManagement {
    List<User> getUsers();

    User login(String userName, String password);

    void add(User newUser);

    void update(User newUser);

    boolean existById(int id);

    boolean checkDuplicateEmail(String email);

    boolean checkDuplicatePhone(String phone);

    boolean checkDuplicateUserName(String userName);

    User getUserById(int id);
}
