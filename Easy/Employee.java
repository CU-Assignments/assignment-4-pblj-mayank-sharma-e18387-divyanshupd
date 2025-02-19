package assigment;

class Employee {
    private int id;
    private String name;
    private double salary;
 
    public Employee(int var1, String var2, double var3) {
       this.id = var1;
       this.name = var2;
       this.salary = var3;
    }
 
    public int getId() {
       return this.id;
    }
 
    public String getName() {
       return this.name;
    }
 
    public void setName(String var1) {
       this.name = var1;
    }
 
    public double getSalary() {
       return this.salary;
    }
 
    public void setSalary(double var1) {
       this.salary = var1;
    }
 
    public String toString() {
       return "ID: " + this.id + ", Name: " + this.name + ", Salary: " + this.salary;
    }
 }
 