/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author rudrapatel
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        Farmer("Famer"),
        Distributor("Distributor"),
        Expert("Expert"),
        Officer("Officer"),
        Customer("Customer");
        
        private String roleTypeValue;
        private RoleType(String value){
            this.roleTypeValue = value;
        }

        public String getValue() {
            return roleTypeValue;
        }

        @Override
        public String toString() {
            return roleTypeValue;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}