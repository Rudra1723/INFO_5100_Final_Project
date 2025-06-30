 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Disease;
import Business.UserAccount.UserAccount;


/**
 *
 * @author rudrapatel
 */
public class Disease {
    private DiseaseType diseaseType;
    private DiseaseCondition diseaseCondition;
    private UserAccount diseaseUserAccount;    
    public Disease(){
    }
    
    public enum DiseaseType {
        Fever("Fever"),
        Diabetes("Diabetes"),
        BloodPressure("BloodPressure");

        private String typeValue;

        private DiseaseType(String value) {
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
      
    public DiseaseType getDiseaseType() {
        return diseaseType;
    }
    
    public enum DiseaseCondition {
        Severe("Severe"),
        Moderate("Moderate"),
        Mild("Mild");

        private String conditionValue;

        private DiseaseCondition(String value) {
            this.conditionValue = value;
        }

        public String getValue() {
            return conditionValue;
        }

        @Override
        public String toString() {
            return conditionValue;
        }
    }

    public DiseaseCondition getDiseaseCondition() {
        return diseaseCondition;
    }   

    public void setDiseaseCondition(DiseaseCondition diseaseCondition) {
        this.diseaseCondition = diseaseCondition;
    }

    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }
    
    public UserAccount getUserAccount() {
        return diseaseUserAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.diseaseUserAccount = userAccount;
    }
}
