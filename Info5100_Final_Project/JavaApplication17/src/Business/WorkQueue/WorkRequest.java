/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author rudrapatel
 */
public abstract class WorkRequest {

    private String requestDescription;
    private UserAccount requestInitiator;
    private UserAccount requestHandler;
    private String requestStatus;
    private Date requestSubmissionDate;
    private Date requestCompletionDate;

    public WorkRequest(){
        requestSubmissionDate = new Date();
    }

    public String getMessage() {
        return requestDescription;
    }

    public void setMessage(String message) {
        this.requestDescription = message;
    }

    public UserAccount getSender() {
        return requestInitiator;
    }

    public void setSender(UserAccount sender) {
        this.requestInitiator = sender;
    }

    public UserAccount getReceiver() {
        return requestHandler;
    }

    public void setReceiver(UserAccount receiver) {
        this.requestHandler = receiver;
    }

    public String getStatus() {
        return requestStatus;
    }

    public void setStatus(String status) {
        this.requestStatus = status;
    }

    public Date getRequestDate() {
        return requestSubmissionDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestSubmissionDate = requestDate;
    }

    public Date getResolveDate() {
        return requestCompletionDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.requestCompletionDate = resolveDate;
    }

    @Override
    public String toString() {
        return String.valueOf(this.requestSubmissionDate);
    }
    
    
}

