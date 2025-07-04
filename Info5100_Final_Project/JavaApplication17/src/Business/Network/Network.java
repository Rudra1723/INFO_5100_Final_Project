/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author rudrapatel
 */
public class Network {
    private String networkIdentifier;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network(){
        enterpriseDirectory = new EnterpriseDirectory();
    }
    
    public String getName() {
        return networkIdentifier;
    }

    public void setName(String name) {
        this.networkIdentifier = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    @Override
    public String toString(){
        return networkIdentifier;
    }
    
}
