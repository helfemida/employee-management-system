import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeUpdate {
    Scanner input = new Scanner(System.in);
    public void updateDetail(){
        System.out.print("Enter Employee's ID: ");
        int ID = 0;
        boolean execution = true;
        do {
            try {
                ID = input.nextInt();
                execution = false;
            }
            catch (InputMismatchException ex){
                System.out.print("InputMismatchException. Enter a valid ID: ");
                input.nextLine();
            }
        }
        while (execution);

        System.out.println("    File Info: ");
        EmployeeShow show = new EmployeeShow();
        try{
            show.showFile(ID);
        }
        catch (IOException ex){
            System.out.println(ex);
        }

        System.out.println("\n To change the detail:" +
                "\n 1. Enter the old version of the detail that you'd like to change" +
                "\n 2. Enter a new version for this detail.");
        System.out.print("Enter an old version of the detail: ");
        input.nextLine();
        String oldVer = input.nextLine();
        System.out.print("Enter a new version for this detail to be changed: ");
        String newVer = input.nextLine();

        updateFile("file" + ID + ".txt",oldVer,newVer);

    }
    private void updateFile(String fileName, String oldDetail, String newDetail){
        File file = new File(fileName);
        ArrayList<String> linesList = new ArrayList<>();
        try{
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine()){
                String line = scanFile.nextLine();
                if(line.contains(oldDetail)){
                    String tmp = line.substring(0,line.indexOf(oldDetail)) + newDetail;
                    linesList.add(tmp);
                }
                else{
                    linesList.add(line);
                }
            }
            scanFile.close();
        }
        catch (FileNotFoundException ex){
            System.out.println("FileNotFoundException");
        }
        file.delete();

        File newFile = new File(fileName);
        try {
            FileWriter writer = new FileWriter(newFile);
            for (String s : linesList) {
                writer.write(s + "\n");
            }
            writer.close();
        }
        catch (FileNotFoundException | RuntimeException ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}