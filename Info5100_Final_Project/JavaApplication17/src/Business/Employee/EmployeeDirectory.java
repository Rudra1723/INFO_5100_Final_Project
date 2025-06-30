/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author rudrapatel
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeCollection;

    public EmployeeDirectory() {
        employeeCollection = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeCollection;
    }
    
    public Employee createEmployee(String name){
        Employee newEmployee = new Employee();
        newEmployee.setName(name);
        employeeCollection.add(newEmployee);
        return newEmployee;
    }
    
}
