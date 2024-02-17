import java.io.*;
import java.util.*;
public class EmployeeAdd extends EmployeeDetail {
    Scanner input = new Scanner(System.in);
    public EmployeeAdd(){}
    public void createFile() {

        System.out.print("Enter Employee's name: ");
        super.setName(input.nextLine());

        System.out.print("Enter Employee's age: ");
        age();

        System.out.print("Enter Employee's email ID: ");
        mail();

        System.out.print("Enter Employee's position: ");
        input.nextLine();
        super.setPosition(input.nextLine());

        System.out.print("Enter Employee's ID: ");
        id();

        System.out.print("Enter Employee's contact info: ");
        contactInfo();

        System.out.print("Enter Employee's salary: ");
        salary();

        String fileName = "file" + super.getId() + ".txt";
        File file = new File(fileName);
        try {
            writeInfo(file);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
    public void age(){
        boolean execution = true;
        do{
            try {
                super.setAge(input.nextInt());
                execution = false;
            }
            catch (InputMismatchException ex){
                System.out.print("InputMismatchException. Try again: ");
                input.nextLine();
            }
        }
        while(execution);
    }
    public void mail(){
        boolean execution = true;
        do {
            try {
                String mail = input.next();
                if (!mail.contains('@'+"")){
                    throw new InvalidMailFormatException();
                }
                super.setEmail(mail);
                execution = false;
            }
            catch (InvalidMailFormatException ex){
                System.out.println("InvalidMailFormatException. Try again. ");
                input.nextLine();
            }
        }
        while(execution);
    }
    private void contactInfo(){
        boolean execution = true;
        do {
            try {
                super.setContact(input.nextLong());
                execution = false;
            }
            catch (InputMismatchException ex){
                System.out.print("InputMismatchException. Try again: ");
                input.nextLine();
            }
        }
        while(execution);
    }
    private void salary(){
        boolean execution = true;
        do {
            try {
                String salary = input.next();
                if(!(salary.contains(".") || salary.contains(","))){
                    super.setSalary(Long.parseLong(salary.substring(0,salary.indexOf('$'))));
                }
                else {
                    int index = salary.contains(','+"")?salary.indexOf(','):salary.indexOf('.');
                    super.setSalary(Float.parseFloat(salary.substring(0, index)));
                }
                execution = false;
            }
            catch (InputMismatchException ex){
                System.out.print("InputMismatchException. Try again: ");
                input.nextLine();
            }
            catch (Exception ex){
                System.out.print("Enter salary in dollars (with $): ");
                input.nextLine();
            }
        }
        while(execution);
    }
    private void id(){
        boolean execution = true;
        do {
            try {
                int id = input.nextInt();
                super.setId(id);
                execution = false;
            }
            catch (InputMismatchException ex){
                System.out.print("InputMismatchException. Try again: ");
                input.nextLine();
            }
        }
        while(execution);
    }
    private void writeInfo(File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write("Employee's name: " + super.name+
                "\n Employee's age: " + super.age+
                "\n Employee's ID: " + super.getId() +
                "\n Employee's Email: " + super.email +
                "\n Employee's Position: " + super.position+
                "\n Employee's contact info: " + super.getContact()+
                "\n Employee's salary: " + super.salary + '$');
        System.out.println("Employee added successfully.");
        writer.close();
    }
}
