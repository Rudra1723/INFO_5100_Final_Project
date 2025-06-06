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
    private ArrayList<Enterprise> enterpriseList;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.Agriculture){
            enterprise=new AgricultureEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        if(type==Enterprise.EnterpriseType.Government){
            enterprise=new GovernmentEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.Hospital){
            enterprise=new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}

