/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.OrganicCertification;


import Business.UserAccount.UserAccount;

/**
 *
 * @author rudrapatel
 */
public class OrganicCertification {
    
    private SoilType soilType;
    private SoilStructure soilStructure;
    private boolean usedFertilizersInLastThreeYears;

    private UserAccount userAccount;
    
    public OrganicCertification(){

    }

    
     public enum SoilStructure {
        Columns("Columns"),
        Blocky("Blocky"),
        Granular("Granular"),
        Plate("Plate-Like"),
        Crumb("Crumb");
        private String value;

        private SoilStructure(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public SoilStructure getSoilStructure() {
        return soilStructure;
    } 
    
    
    public enum SoilType {
        Fertile("Fertile Soil"),
        Sandy("Sandy Soil"),
        Nutricious("Nutricious Soil"),
        Slit("Slit Soil");

        private String value;

        private SoilType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public SoilType getSoilType() {
        return soilType;
    }   

    public void setSoilType(SoilType soilType) {
        this.soilType = soilType;
    }

    public void setSoilStructure(SoilStructure soilStructure) {
        this.soilStructure = soilStructure;
    }

    public boolean isUsedFertilizersInLastThreeYears() {
        return usedFertilizersInLastThreeYears;
    }
    
    public void setUsedFertilizersInLastThreeYears(boolean usedFertilizersInLastThreeYears) {
        this.usedFertilizersInLastThreeYears = usedFertilizersInLastThreeYears;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
        
}
