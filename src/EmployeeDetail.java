public abstract class EmployeeDetail {
    String name;
    private long contact;
    String position;
    float salary;
    private int id;
    String email;
    int age;
    public void employee_details(){
        System.out.println("\n Employee's name : " + this.name +
                "\n Employee's age : " + this.age +
                "\n Employee's email: " + this.email +
                "\n Employee's position: " + this.position +
                "\n Employee's ID: " + this.id +
                "\n Employee's salary: " + this.salary +
                "\n Employee's contact: " + this.contact);
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContact() {
        return this.contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
