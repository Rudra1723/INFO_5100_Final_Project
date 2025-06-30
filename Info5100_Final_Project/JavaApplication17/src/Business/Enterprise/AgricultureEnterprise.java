/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

/**
 *
 * @author rudrapatel
 */
import Business.Role.Role;
import java.util.ArrayList;

public class AgricultureEnterprise extends Enterprise {

    public AgricultureEnterprise(String name){
        super(name, Enterprise.EnterpriseType.Agriculture);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
