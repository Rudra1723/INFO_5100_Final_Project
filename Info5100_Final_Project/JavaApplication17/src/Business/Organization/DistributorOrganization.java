/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.DistributorRole;
import Business.Role.ExpertRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rudrapatel
 */
public class DistributorOrganization extends Organization{

    public DistributorOrganization() {
        super(Type.Distributor.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DistributorRole());
        return roles;
    }
     
   
    
    
}
