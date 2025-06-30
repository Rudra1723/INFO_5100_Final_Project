/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Forum;

import Business.UserAccount.UserAccount;

/**
 *
 * @author rudrapatel
 */
public class Answer {
    private String answerText;
    private boolean isAnswerRelevant;
    private UserAccount answerAuthorAccount;

    public Answer() {
        this.answerAuthorAccount = new UserAccount();
    }
   
    public String getText() {
        return answerText;
    }

    public void setText(String text) {
        this.answerText = text;
    }

    public boolean isIsRelevant() {
        return isAnswerRelevant;
    }

    public void setIsRelevant(boolean isRelevant) {
        this.isAnswerRelevant = isRelevant;
    }

    public UserAccount getFarmerAccount() {
        return answerAuthorAccount;
    }

    public void setFarmerAccount(UserAccount farmerAccount) {
        this.answerAuthorAccount = farmerAccount;
    }
    
    @Override
    public String toString() {
        return answerAuthorAccount.getEmployee().getName();
    }
    
    
}
