/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.Disease.Disease;

/**
 *
 * @author rudrapatel
 */
public class FarmerTreatmentWorkRequest extends WorkRequest{
    private Disease disease;
    private boolean isTreated;
    private String treatmentComments;
    

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public boolean getIsTreated() {
        return isTreated;
    }

    public void setIsTreated(boolean isTreated) {
        this.isTreated = isTreated;
    }

    public String getTreatmentComments() {
        return treatmentComments;
    }

    public void setTreatmentComments(String treatmentComments) {
        this.treatmentComments = treatmentComments;
    }
    
}
