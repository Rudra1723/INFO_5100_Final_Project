/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author rudrapatel
 */
public class FarmerSubsidyWorkRequest extends WorkRequest{
    private double requestedSubsidyValue;
    private double givenSubsidyValue;
    private boolean isSubsidyApproved;
    private String officerComment;
   

    public double getRequestedSubsidyValue() {
        return requestedSubsidyValue;
    }

    public void setRequestedSubsidyValue(double requestedSubsidyValue) {
        this.requestedSubsidyValue = requestedSubsidyValue;
    }

    public double getGivenSubsidyValue() {
        return givenSubsidyValue;
    }

    public void setGivenSubsidyValue(double givenSubsidyValue) {
        this.givenSubsidyValue = givenSubsidyValue;
    }

    public boolean isIsSubsidyApproved() {
        return isSubsidyApproved;
    }

    public void isIsSubsidyApproved(boolean isSubsidyApproved) {
        this.isSubsidyApproved = isSubsidyApproved;
    }

    public String getOfficerComment() {
        return officerComment;
    }

    public void setOfficerComment(String officerComment) {
        this.officerComment = officerComment;
    }
    
    @Override
    public String toString() {
        return String.valueOf(requestedSubsidyValue);
    }
}
    