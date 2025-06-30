/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Forum.Forum;
import Business.Role.FarmerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rudrapatel
 */
public class FarmerOrganization extends Organization{

    private Forum farmerForum;
    public FarmerOrganization() {
        super(Type.Farmer.getValue());
        this.farmerForum = new Forum();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> supportedRoles = new ArrayList();
        supportedRoles.add(new FarmerRole());
        return supportedRoles;
    }

    public Forum getForum() {
        return this.farmerForum;
    }

    public void setForum(Forum forum) {
        this.farmerForum = forum;
    }
     
    
    
}

