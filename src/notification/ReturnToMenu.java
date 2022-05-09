package notification;

import java.util.Scanner;

import static views.Menu.showMainMenu;
import static views.Menu.showTasks;
import static views.TaskList.updateTask;

public class ReturnToMenu {
    static Scanner input = new Scanner(System.in);
    public static void returnMainMenu(){
        System.out.println("Enter r to return: ");
        String r = input.nextLine();
        while(!r.equals("r")){
            try {
                System.out.println("Enter r to return: ");
                r = input.nextLine();
            }catch (Exception e){
                System.out.println("Enter r to return: ");
                r = input.nextLine();
            }
        }
        showMainMenu();
        }

    public static void returnShowTaskMenu(){
        System.out.println("Enter r to return: ");
        String r = input.nextLine();
        while(!r.equals("r")){
            try {
                System.out.println("Enter r to return: ");
                r = input.nextLine();
            }catch (Exception e){
                System.out.println("Enter r to return: ");
                r = input.nextLine();
            }
        }
        showTasks();
    }

    public static void returnOrContinueUpdateTask(){
        System.out.println("Enter y to continue updating or n to return: ");
        String choice = input.nextLine();

            switch (choice){
                case "y":
                    updateTask();
                    break;
                case "n":
                    showMainMenu();
                    break;
                default:
                    System.out.println("Please enter provided option!");
                    returnOrContinueUpdateTask();
            }

    }


}
