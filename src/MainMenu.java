import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainMenu{
    Scanner in = new Scanner(System.in);
    public void mainMenu(){
        System.out.print("\n----------Main Menu----------" +
                "\n 1. Add an employee details" +
                "\n 2. See an Employee Details" +
                "\n 3. Remove an Employee" +
                "\n 4. Update Employee Details" +
                "\n 5. Exit the EMS Portal" +
                "\n \n Choose a number: ");
    }
    public void exitTheProgram(){
        System.out.println("Thank u for sharing your information :з");
        System.exit(0);
    }

}
