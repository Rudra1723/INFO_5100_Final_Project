/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.Expert.ExpertWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author rudrapatel
 */
public class ExpertRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        return new ExpertWorkAreaJPanel(userProcessContainer, userAccount, organization, ecoSystem);
    }
    
}