import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EmployeeManagementSystem {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        EmployeeAdd employeeAdd = new EmployeeAdd();
        System.out.println("**************************************************");
        System.out.println("          Employee Organizational System          ");
        System.out.print("**************************************************");
        MainMenu menu = new MainMenu();
        while (true) {
            menu.mainMenu();
            int choice = choice();
            switch (choice) {
                case 1: {
                    employeeAdd.createFile();
                    break;
                }
                case 2: {
                    EmployeeShow show = new EmployeeShow();
                    show.showFile();
                    break;
                }
                case 3: {
                    EmployeeRemove remove = new EmployeeRemove();
                    remove.removeFile();
                    break;
                }
                case 4: {
                    EmployeeUpdate update = new EmployeeUpdate();
                    update.updateDetail();
                    break;
                }
                case 5: {
                    menu.exitTheProgram();
                    break;
                }
                default: {
                    System.out.println("Enter the correct number from the ones listed below: ");
                    break;
                }
            }
        }
    }
    public static int choice(){
        boolean execution = true;
        do {
            try {
                int n = in.nextInt();
                execution = false;
                return n;
            }
            catch (InputMismatchException ex){
                System.out.print("Enter a number for the choice: ");
                in.nextLine();
            }
            catch (NoSuchElementException ex2){
                System.out.println(ex2);
                in.nextLine();
            }
        }
        while (execution);
        return 0;
    }
}
