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

    private Forum forum;
    public FarmerOrganization() {
        super(Type.Farmer.getValue());
        this.forum=new Forum();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FarmerRole());
        return roles;
    }

    public Forum getForum() {
        return this.forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }
     
    
    
}

