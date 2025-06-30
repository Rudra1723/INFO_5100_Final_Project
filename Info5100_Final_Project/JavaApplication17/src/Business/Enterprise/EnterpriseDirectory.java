/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author rudrapatel
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseCollection;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseCollection;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseCollection = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseCollection = new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise newEnterprise = null;
        if(type == Enterprise.EnterpriseType.Agriculture){
            newEnterprise = new AgricultureEnterprise(name);
            enterpriseCollection.add(newEnterprise);
        }
        
        if(type == Enterprise.EnterpriseType.Government){
            newEnterprise = new GovernmentEnterprise(name);
            enterpriseCollection.add(newEnterprise);
        }
        if(type == Enterprise.EnterpriseType.Hospital){
            newEnterprise = new HospitalEnterprise(name);
            enterpriseCollection.add(newEnterprise);
        }
        return newEnterprise;
    }
}

