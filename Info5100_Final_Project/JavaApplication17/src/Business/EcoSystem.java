/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author rudrapatel
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem singletonInstance;
    private ArrayList<Network> networkRegistry;
    private Map<String, Object> systemConfiguration;
    
    public static EcoSystem obtainInstance(){
        if(singletonInstance == null){
            singletonInstance = new EcoSystem();
        }
        return singletonInstance;
    }
    
    public Network establishNewNetwork(){
        Network freshNetwork = new Network();
        networkRegistry.add(freshNetwork);
        return freshNetwork;
    }
    
    public boolean validateNetworkExistence(Network targetNetwork) {
        return networkRegistry.contains(targetNetwork);
    }
    
    public int getTotalNetworkCount() {
        return networkRegistry.size();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> availableRoles = new ArrayList<Role>();
        availableRoles.add(new SystemAdminRole());
        return availableRoles;
    }
    
    private EcoSystem(){
        super(null);
        networkRegistry = new ArrayList<Network>();
        systemConfiguration = new HashMap<>();
        initializeSystemDefaults();
    }
    
    private void initializeSystemDefaults() {
        systemConfiguration.put("maxNetworks", 10);
        systemConfiguration.put("systemVersion", "2.0");
        systemConfiguration.put("isActive", true);
    }

    public ArrayList<Network> getNetworkList() {
        return networkRegistry;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkRegistry = networkList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network currentNetwork : networkRegistry){
            // Enhanced validation logic
            if (currentNetwork != null) {
                // Additional network-specific validation can be implemented here
            }
        }
        return true;
    }
    
    public Map<String, Object> getSystemConfiguration() {
        return new HashMap<>(systemConfiguration);
    }
    
    public void updateSystemConfiguration(String key, Object value) {
        systemConfiguration.put(key, value);
    }
}
