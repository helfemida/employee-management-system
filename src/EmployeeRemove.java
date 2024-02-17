import java.io.File;
import java.util.Scanner;

public class EmployeeRemove implements Remove{
    Scanner input = new Scanner(System.in);
    @Override
    public void removeFile() {
        boolean execution = true;
        int ID =0;
        do{
           try {
               System.out.print("Enter Employee's ID: ");
               ID = input.nextInt();
               execution = false;
           }
           catch (Exception ex){
               System.out.print("InputMismatchException. Try again: ");
               input.nextLine();
           }
        }
        while (execution);
        String fileName = "file" + ID + ".txt";
        File file = new File(fileName);
        if(file.exists()) {
            file.delete();
            System.out.println("\n Employee have been removed successfully");
        }
        else{
            System.out.println("\n Employee file does not exists");
        }
    }
}
