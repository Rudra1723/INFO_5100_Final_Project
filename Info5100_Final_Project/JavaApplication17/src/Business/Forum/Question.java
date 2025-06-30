/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Forum;

import Business.Farmer.Farmer;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rudrapatel
 */
public class Question {
    private List<Answer> answerCollection;
    private String questionText;
    private UserAccount questionAuthorAccount;

    public Question() {
        this.answerCollection = new ArrayList<Answer>();
        
    }

    public List<Answer> getAnswersList() {
        return answerCollection;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answerCollection = answersList;
    }

    public String getQuestion() {
        return questionText;
    }

    public void setQuestion(String question) {
        this.questionText = question;
    }        

    public UserAccount getFarmerAccount() {
        return questionAuthorAccount;
    }

    public void setFarmerAccount(UserAccount farmerAccount) {
        this.questionAuthorAccount = farmerAccount;
    }

    public UserAccount AddFarmer(){
        UserAccount newUserAccount = new UserAccount();
        return newUserAccount;
    }
    
    @Override
    public String toString() {
        return questionAuthorAccount.getEmployee().getName();
    }
}
