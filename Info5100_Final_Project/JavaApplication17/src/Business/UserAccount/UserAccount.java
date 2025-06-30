/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author rudrapatel
 */
public class UserAccount {
    
    private String accountIdentifier;
    private String securePassword;
    private Employee linkedEmployee;
    private Role assignedRole;
    private WorkQueue personalWorkQueue;

    public UserAccount() {
        personalWorkQueue = new WorkQueue();
    }
    
    public String getUsername() {
        return accountIdentifier;
    }

    public void setUsername(String username) {
        this.accountIdentifier = username;
    }

    public String getPassword() {
        return securePassword;
    }

    public void setPassword(String password) {
        this.securePassword = password;
    }

    public Role getRole() {
        return assignedRole;
    }

    public void setEmployee(Employee employee) {
        this.linkedEmployee = employee;
    }

    public void setRole(Role role) {
        this.assignedRole = role;
    }

    public Employee getEmployee() {
        return linkedEmployee;
    }

    public WorkQueue getWorkQueue() {
        return personalWorkQueue;
    }
    
    public boolean validateCredentials(String username, String password) {
        return this.accountIdentifier.equals(username) && this.securePassword.equals(password);
    }
    
    @Override
    public String toString() {
        return accountIdentifier;
    }
}
