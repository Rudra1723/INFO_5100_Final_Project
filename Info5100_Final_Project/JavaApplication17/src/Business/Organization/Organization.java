/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author rudrapatel
 */
public abstract class Organization {

    private String organizationalName;
    private WorkQueue taskQueue;
    private EmployeeDirectory staffDirectory;
    private UserAccountDirectory accountRegistry;
    private int organizationalId;
    private static int organizationalCounter = 0;
    
    public enum Type{
        Admin("Admin Organization"),
        Farmer("Farmer Organization"),
        Expert("Expert Organization"),
        Officer("Officer Organization"),
        Distributor("Distributor Organization"),
        Customer("Customer Organization"),
        Doctor("Doctor Organization");
        
        private String typeDescription;
        private Type(String description) {
            this.typeDescription = description;
        }
        public String getValue() {
            return typeDescription;
        }
    }

    public Organization(String name) {
        this.organizationalName = name;
        taskQueue = new WorkQueue();
        staffDirectory = new EmployeeDirectory();
        accountRegistry = new UserAccountDirectory();
        organizationalId = organizationalCounter;
        ++organizationalCounter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return accountRegistry;
    }

    public int getOrganizationID() {
        return organizationalId;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return staffDirectory;
    }
    
    public String getName() {
        return organizationalName;
    }

    public WorkQueue getWorkQueue() {
        return taskQueue;
    }

    public void setName(String name) {
        this.organizationalName = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.taskQueue = workQueue;
    }

    @Override
    public String toString() {
        return organizationalName;
    }
    
    
}
