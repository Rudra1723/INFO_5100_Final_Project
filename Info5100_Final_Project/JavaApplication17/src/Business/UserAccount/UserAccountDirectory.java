/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;

import java.util.ArrayList;

/**
 *
 * @author rudrapatel
 */
public class UserAccountDirectory {
    
     private ArrayList<UserAccount> userAccountCollection;

    public UserAccountDirectory() {
        userAccountCollection = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountCollection;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount currentUserAccount : userAccountCollection)
            if (currentUserAccount.getUsername().equals(username) && currentUserAccount.getPassword().equals(password)){
                return currentUserAccount;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
        UserAccount newUserAccount = new UserAccount();
        newUserAccount.setUsername(username);
        newUserAccount.setPassword(password);
        newUserAccount.setEmployee(employee);
        newUserAccount.setRole(role);
        userAccountCollection.add(newUserAccount);
        return newUserAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount currentUserAccount : userAccountCollection){
            if (currentUserAccount.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
}
