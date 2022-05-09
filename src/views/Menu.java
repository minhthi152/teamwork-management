package views;

import notification.Exit;
import notification.WrongChoice;
import sort.SortTaskList;

import java.util.Scanner;

import static notification.ReturnToMenu.returnMainMenu;
import static notification.ReturnToMenu.returnShowTaskMenu;


public class Menu {
    static   Scanner input = new Scanner(System.in);

public static void homeMenu(){
    System.out.println("-----------*****------------");
    System.out.println("|        1. Sign in        |");
    System.out.println("|        2. Sign up        |");
    System.out.println("|        0. Exit           |");
    System.out.println("|__________________________|");
    System.out.println("Tell me your choice: ");
    int choice = -1;
    while(choice!=0){
       try {
           choice = Integer.parseInt(input.nextLine());
           switch (choice){
               case 1: SignIn.signIn();
                   break;
               case 2: SignUp.signUp();
                   break;
               case 0:
                   Exit.exitProgram();
           }
       }catch (Exception e){
//           e.printStackTrace();
           WrongChoice.chooseWrong();
           homeMenu();

       }
    }
}
    public static void showMainMenu(){
        System.out.println("------------Menu------------");
        System.out.println("| 1. Add a new task        |");
        System.out.println("| 2. Show tasks            |");
        System.out.println("| 3. Delete task           |");
        System.out.println("| 4. Update a task         |");
        System.out.println("| 5. Sort tasks            |");
        System.out.println("| 6. Search tasks          |");
        System.out.println("| 7. Members management    |");
        System.out.println("| 0. Exit                  |");
        System.out.println("|__________________________|");
        System.out.println("Enter your choice: ");
        int choice = -1;

        while (choice != 0){
            try{
                choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        TaskList.addTask();
                        break;
                    case 2:
                        showTasks();
                        break;
                    case 3:
                        showDeleteMenu();
                        break;
                    case 4:
                        TaskList.updateTask();
                        break;
                    case 5:
                        showMenuSort();
                        break;
                    case 6:
                        showMenuSearch();
                        break;
                    case 7:
                        menuMemberManagement();
                        break;
                    case 0:
                        Exit.exitProgram();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        showMainMenu();
                }

            }
            catch (Exception e){
                WrongChoice.chooseWrong();
                showMainMenu();
            }

        }

    }

    private static void showMenuSort() {
        System.out.println("-----------------------------");
        System.out.println("| 1. Sort by deadline ASC    |");
        System.out.println("| 2. Sort by create day ASC  |");
        System.out.println("| 3. Sort by task name       |");
        System.out.println("| 4. Return                  |");
        System.out.println("-----------------------------");
        int choice = -1;

        while (choice != 0){

            try{
                choice = Integer.parseInt(input.nextLine());;
                switch (choice){
                    case 1:
                        SortTaskList.sortByDeadlineAsc();

                        break;
                    case 2:
                        SortTaskList.sortByCreateDateAsc();
                        break;
                    case 3:
                        SortTaskList.sortByTaskNameAsc();
                        break;
                    case 4:
                        showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        showMenuSort();
                }

            }
            catch (Exception e){
                e.printStackTrace();
                WrongChoice.chooseWrong();
                showMenuSort();
            }

        }


    }


    public static void showTasks(){
        System.out.println("----------Show tasks---------");
        System.out.println("| 1. Show all tasks         |");
        System.out.println("| 2. Show pending tasks     |");
        System.out.println("| 3. Show doing tasks       |");
        System.out.println("| 4. Show completed tasks   |");
        System.out.println("| 10. Back to home page     |");
        System.out.println("-----------------------------");
        int choice = -1;

        while (choice != 0){

            try{
                choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Show all tasks");
                        TaskList.showAllTasks();
                        returnShowTaskMenu();
                        break;
                    case 2:
                        System.out.println("Show pending tasks: Oops! Update later.");
                        returnShowTaskMenu();
                        break;
                    case 3:
                        System.out.println("Show doing tasks: Oops! Update later.");
                        returnShowTaskMenu();
                        break;
                    case 4:
                        System.out.println("Show completed tasks: Oops! Update later.");
                        returnShowTaskMenu();
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        showTasks();
                }

            }
            catch (Exception e){
                e.printStackTrace();
                WrongChoice.chooseWrong();
                showTasks();
            }

        }

    }
    public static void showDeleteMenu(){
        System.out.println("------------Delete----------");
        System.out.println("| 1. Delete a task          |");
        System.out.println("| 2. Delete all tasks       |");
        System.out.println("| 10. Back to home page     |");
        System.out.println("-----------------------------");
        int choice = -1;

        while (choice != 0){
            Scanner input = new Scanner(System.in);
            try{
                choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        TaskList.deleteTask();
                        break;
                    case 2:
                        System.out.println("Delete all tasks");
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();;
                        showDeleteMenu();
                }

            }
            catch (Exception e){
                WrongChoice.chooseWrong();;
                showDeleteMenu();
            }

        }

    }


    public static void menuMemberManagement() {
        System.out.println("-----------------------------------");
        System.out.println("|                                  |");
        System.out.println("| 1. Show members list             |");
        System.out.println("| 2. Change information            |");
        System.out.println("| 10. Back to home page            |");
        System.out.println("|                                  |");
        System.out.println("------------------------------------");
        System.out.println("Enter your choice: ");
        int choice = -1;
        while (choice != 0){
            try {
                choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        UserView.showMembers();
                        returnMainMenu();
                        break;
                    case 2:
                        UserView.changeInfo();
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        menuMemberManagement();
                }
            }catch (Exception e){
                WrongChoice.chooseWrong();
                menuMemberManagement();
            }
        }
    }
    public static void showMenuSearch(){
        System.out.println("-----------------------------------");
        System.out.println("|                                  |");
        System.out.println("| 1. Search by name                |");
        System.out.println("| 2. Search by deadline            |");
        System.out.println("| 10. Back to home page            |");
        System.out.println("|                                  |");
        System.out.println("------------------------------------");
        System.out.println("Enter your choice: ");
        int choice = -1;
        while (choice != 0){
            try {
                choice = Integer.parseInt(input.nextLine());
                switch (choice){
                    case 1:
                        TaskList.searchTaskByName();
                        returnMainMenu();
                        break;
                    case 2:
                        TaskList.searchByDeadline();
                        returnMainMenu();
                        break;
                    case 10:
                        showMainMenu();
                        break;
                    default:
                        WrongChoice.chooseWrong();
                        showMenuSearch();
                }
            }catch (Exception e){
                WrongChoice.chooseWrong();
                showMenuSearch();
            }
        }
    }

}
