/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FarmerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.Farmer.FarmerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author rudrapatel
 */
public class FarmerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        return new FarmerWorkAreaJPanel(userProcessContainer, userAccount, (FarmerOrganization)organization, enterprise, ecoSystem);
    }
    
    
}
