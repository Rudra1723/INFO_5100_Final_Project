/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rudrapatel
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        return initializeSystemWithDefaultConfiguration();
    }
    
    private static EcoSystem initializeSystemWithDefaultConfiguration(){
        EcoSystem systemInstance = EcoSystem.obtainInstance();
        
        // Create system administrator employee
        Employee systemAdministrator = systemInstance.getEmployeeDirectory().createEmployee("System Administrator");
        
        // Create system administrator user account
        UserAccount adminUserAccount = systemInstance.getUserAccountDirectory().createUserAccount(
            "sysadmin", 
            "sysadmin", 
            systemAdministrator, 
            new SystemAdminRole()
        );
        
        return systemInstance;
    }
    
    public static EcoSystem configureWithCustomSettings(String adminUsername, String adminPassword) {
        EcoSystem systemInstance = EcoSystem.obtainInstance();
        
        Employee customAdmin = systemInstance.getEmployeeDirectory().createEmployee("Custom Administrator");
        
        UserAccount customAdminAccount = systemInstance.getUserAccountDirectory().createUserAccount(
            adminUsername, 
            adminPassword, 
            customAdmin, 
            new SystemAdminRole()
        );
        
        return systemInstance;
    }
}
