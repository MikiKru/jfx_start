package util;

import model.Employee;
import java.util.*;
public class EmployeeDB {
    public static List<Employee> users = new ArrayList<>(
            Arrays.asList(
                    new Employee("Adam","Kowalski", "DEV_OPS",5500),
                    new Employee("Jan","Nowak", "DEVELOPER",8500),
                    new Employee("Anna","Kot", "DEVELOPER",7500),
                    new Employee("Ala","Kos", "ANALYST",6500)
            )
    );
}
