/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.OrganicCertification.*;

/**
 *
 * @author rudrapatel
 */
public class OrganicCertificationWorkRequest extends WorkRequest{
    
    private OrganicCertification organicCertification;
    private boolean isCertified;

    public OrganicCertification getOrganicCertification() {
        return organicCertification;
    }

    public void setOrganicCertification(OrganicCertification organicCertification) {
        this.organicCertification = organicCertification;
    }

    public boolean getIsCertified() {
        return isCertified;
    }

    public void setIsCertified(boolean isCertified) {
        this.isCertified = isCertified;
    }
}
