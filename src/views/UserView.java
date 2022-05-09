package views;

import management.UsersManagement;
import model.User;
import utils.ValidateUtils;

import java.util.List;
import java.util.Scanner;

import static notification.ReturnToMenu.returnMainMenu;
import static notification.WrongChoice.chooseWrong;


public class UserView {
    public static UsersManagement usersManagement = UsersManagement.getInstance();
    static Scanner input = new Scanner(System.in);

    public static void showMembers() {
        System.out.println("----MEMBERS LIST---------------------------------------------------------------------------------------------------- ");
        System.out.printf("%-10s %-25s %-35s %-25s %-25s\n", "Id", "Full name", "Email", "Phone Number", "Username");
        System.out.println("---------------------------------------------------------------------------------------------------------------------  ");

        List<User> users = usersManagement.getUsers();
        for (User user : users) {
                System.out.printf("%-10s %-25s %-35s %-25s %-25s\n", user.getId(), user.getFullName(), user.getEmail(), user.getPhoneNumber(), user.getUserName());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------  ");
        System.out.println(" ");

    }


    public static void changeInfo() {
        try {
            showYourInfo();
                System.out.println("---------------------------");
                System.out.println("|  1. Change email        |");
                System.out.println("|  2. Change phone number |");
                System.out.println("|  3. Change password     |");
                System.out.println("|  4. Return              |");
                System.out.println("---------------------------");
                System.out.println("Enter your choice: ");
                int choice = Integer.parseInt(input.nextLine());
            User curUser = UserView.findUserByUsername(SignIn.currentUsername);
                switch (choice) {
                    case 1:
                        String email;

                        do {
                            System.out.println("Enter new email (ex: thi152@gmail.com): ");
                            email = input.nextLine().trim();

                            if (!ValidateUtils.isEmailValid(email)) {
                                System.out.println("Email " + email + " does not match the format. Please check and try again!");
                                continue;
                            }
                            if (usersManagement.checkDuplicateEmail(email)) {
                                System.out.println("Email " + email + " has already existed. Please try another new one!");
                                continue;
                            }
                            break;
                        } while (true);

                        curUser.setEmail(email);
                        usersManagement.update(curUser);
                        System.out.println("Successfully updated email.");
                        returnMainMenu();
                        break;
                    case 2:
                        System.out.println("Enter new phone number: ");
                        String phoneNumber = input.nextLine().trim();
                        while (!ValidateUtils.isPhoneValid(phoneNumber)){
                            System.out.println("This phone number does not match the format. Please check and try again!");
                            System.out.println("Enter new phone number (ex: 0987654123): ");
                            phoneNumber = input.nextLine();
                        }
                        while(usersManagement.checkDuplicatePhone(phoneNumber)){
                            System.out.println("This phone number has already existed. Please try another new one!");
                            System.out.println("Enter new phone number (ex: 0987654123): ");
                            phoneNumber = input.nextLine();
                        }
                        curUser.setPhoneNumber(phoneNumber);
                        usersManagement.update(curUser);
                        System.out.println("Successfully updated phone number.");
                        returnMainMenu();

                        break;
                    case 3:
                        System.out.println("Enter your current password: ");
                        String curPassword = input.nextLine();

                        while(!curPassword.equals(curUser.getPassword())){
                            System.out.println("Wrong password, please try again!");
                            curPassword = input.nextLine();
                        }
                            System.out.println("Enter new password: ");
                            String newPassword = input.nextLine();
                        curUser.setPassword(newPassword);
                        usersManagement.update(curUser);
                        System.out.println("Password updated successfully!");
                        returnMainMenu();
                        break;
                    case 4:
                        Menu.showMainMenu();
                        break;
                    default:
                        chooseWrong();
                        changeInfo();
                }
        } catch (Exception e) {
            chooseWrong();
            changeInfo();
        }
    }



    public static void showYourInfo(){
        List<User> usersList = usersManagement.getUsers();
        for(User user: usersList){
            if(user.getUserName().equals(SignIn.currentUsername)){
                System.out.println("ID: " + user.getId());
                System.out.println("Full name: " + user.getFullName());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Phone number: " + user.getPhoneNumber());
                System.out.println("User name: " + user.getUserName());
                System.out.println("Role: " + user.getRole());

            }
        }

    }
    public static User findUserByUsername(String username) {
        List<User> usersList = usersManagement.getUsers();
        for (User user: usersList) {
            if(user.getUserName().equals(username)){
                return user;
            }
        }
        return null;
    }
}
