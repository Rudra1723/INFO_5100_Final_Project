/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Employee;

/**
 *
 * @author rudrapatel
 */
public class Employee {
     private String fullName;
    private int personnelId;
    private static int globalEmployeeCounter = 1;

    public Employee() {
        personnelId = globalEmployeeCounter;
        globalEmployeeCounter++;
    }

    public int getId() {
        return personnelId;
    }

    public void setName(String name) {
        this.fullName = name;
    }

    public String getName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
