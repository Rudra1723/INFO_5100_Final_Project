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
    private List<Answer> answersList;
    private String question;
    private UserAccount farmerAccount;

    public Question() {
        this.answersList = new ArrayList<Answer>();
        
    }

    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }        

    public UserAccount getFarmerAccount() {
        return farmerAccount;
    }

    public void setFarmerAccount(UserAccount farmerAccount) {
        this.farmerAccount = farmerAccount;
    }

    public UserAccount AddFarmer(){
        UserAccount u = new UserAccount();
        return u;
    }
    
    @Override
    public String toString() {
        return farmerAccount.getEmployee().getName();
    }
}
