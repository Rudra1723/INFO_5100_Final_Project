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
    
    private SoilType certificationSoilType;
    private SoilStructure certificationSoilStructure;
    private boolean hasUsedFertilizersInLastThreeYears;

    private UserAccount certificationUserAccount;
    
    public OrganicCertification(){

    }

    
     public enum SoilStructure {
        Columns("Columns"),
        Blocky("Blocky"),
        Granular("Granular"),
        Plate("Plate-Like"),
        Crumb("Crumb");
        private String structureValue;

        private SoilStructure(String value) {
            this.structureValue = value;
        }

        public String getValue() {
            return structureValue;
        }

        @Override
        public String toString() {
            return structureValue;
        }
    }

    public SoilStructure getSoilStructure() {
        return certificationSoilStructure;
    } 
    
    
    public enum SoilType {
        Fertile("Fertile Soil"),
        Sandy("Sandy Soil"),
        Nutricious("Nutricious Soil"),
        Slit("Slit Soil");

        private String typeValue;

        private SoilType(String value) {
            this.typeValue = value;
        }

        public String getValue() {
            return typeValue;
        }

        @Override
        public String toString() {
            return typeValue;
        }
    }

    public SoilType getSoilType() {
        return certificationSoilType;
    }   

    public void setSoilType(SoilType soilType) {
        this.certificationSoilType = soilType;
    }

    public void setSoilStructure(SoilStructure soilStructure) {
        this.certificationSoilStructure = soilStructure;
    }

    public boolean isUsedFertilizersInLastThreeYears() {
        return hasUsedFertilizersInLastThreeYears;
    }
    
    public void setUsedFertilizersInLastThreeYears(boolean usedFertilizersInLastThreeYears) {
        this.hasUsedFertilizersInLastThreeYears = usedFertilizersInLastThreeYears;
    }

    public UserAccount getUserAccount() {
        return certificationUserAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.certificationUserAccount = userAccount;
    }
        
}
