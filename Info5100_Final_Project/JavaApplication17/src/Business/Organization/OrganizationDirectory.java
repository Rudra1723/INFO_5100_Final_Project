/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author rudrapatel
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationCollection;

    public OrganizationDirectory() {
        organizationCollection = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationCollection;
    }
    
    public Organization createOrganization(Type type){
        Organization newOrganization = null;
        if (type.getValue().equals(Type.Farmer.getValue())){
            newOrganization = new FarmerOrganization();
            organizationCollection.add(newOrganization);
        }
        else if (type.getValue().equals(Type.Expert.getValue())){
            newOrganization = new ExpertOrganization();
            organizationCollection.add(newOrganization);
        } 
        else if (type.getValue().equals(Type.Distributor.getValue())){
            newOrganization = new DistributorOrganization();
            organizationCollection.add(newOrganization);
        }
        else if (type.getValue().equals(Type.Officer.getValue())){
            newOrganization = new OfficerOrganization();
            organizationCollection.add(newOrganization);
        }
        else if (type.getValue().equals(Type.Customer.getValue())){
            newOrganization = new CustomerOrganization();
            organizationCollection.add(newOrganization);
        }
        else if (type.getValue().equals(Type.Doctor.getValue())){
            newOrganization = new DoctorOrganization();
            organizationCollection.add(newOrganization);
        }
        return newOrganization;
    }
}
