/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.CustomerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rudrapatel
 */
public class CustomerOrganization extends Organization{

    public CustomerOrganization() {
        super(Type.Customer.getValue());
    }
    
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> supportedRoles = new ArrayList();
        supportedRoles.add(new CustomerRole());
        return supportedRoles;
    }
}
