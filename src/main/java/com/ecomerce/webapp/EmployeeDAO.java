package com.ecomerce.webapp;

import org.springframework.stereotype.Repository;
 
import com.ecomerce.webapp.Employee;
import com.ecomerce.webapp.Employees;
 
@Repository
public class EmployeeDAO 
{
    private static Employees list = new Employees();
     
    static
    {
        list.getEmployeeList().add(new Employee(1, "Siar", "Ahmad", "siar@gmail.com"));
        list.getEmployeeList().add(new Employee(2, "Imran", "Jan", "imranjan@gmail.com"));
        list.getEmployeeList().add(new Employee(3, "Sam", "KK", "kk@gmail.com"));
        list.getEmployeeList().add(new Employee(4, "Sammy", "Jon", "sjon@gmail.com"));
        list.getEmployeeList().add(new Employee(5, "Sean", "Smith", "smith@gmail.com"));
    }
     
    public Employees getAllEmployees() 
    {
        return list;
    }
     
    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }
}
