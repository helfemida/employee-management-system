import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Scanner;

public class EmployeeShow {
    Scanner input = new Scanner(System.in);
    public void showFile() throws IOException {
        System.out.print("Enter an ID for the user: ");
        int id = input.nextInt();
        File file = new File("file" + id + ".txt");
        if(file.exists()) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String tmp = reader.readLine();
            while (tmp != null) {
                System.out.println(tmp);
                tmp = reader.readLine();
            }
            reader.close();
        }
        else{
            System.out.println("FileNotFoundException");
        }
    }
    public void showFile(int ID) throws IOException{
        File file = new File("file" + ID + ".txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String tmp = reader.readLine();
        while (tmp != null) {
            System.out.println(tmp);
            tmp = reader.readLine();
        }
        reader.close();
    }
}
