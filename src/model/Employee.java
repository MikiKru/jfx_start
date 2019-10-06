package model;

public class Employee {
    private static int globalId = 1;
    private int userId;
    private String name;
    private String lastname;
    private String possition;
    private double salary;

    public Employee(String name, String lastname, String possition, double salary) {
        this.name = name;
        this.lastname = lastname;
        this.possition = possition;
        this.salary = salary;
        // przypisanie globalId do id usera
        this.userId = globalId;
        // auto inkrementacja id
        globalId++;
    }

    public static int getGlobalId() {
        return globalId;
    }

    public static void setGlobalId(int globalId) {
        Employee.globalId = globalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPossition() {
        return possition;
    }

    public void setPossition(String possition) {
        this.possition = possition;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
