/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Forum;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rudrapatel
 */
public class Forum {
    
    private List<Question> questionList;

    public Forum() {
        questionList= new ArrayList<Question>();
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
    

    
}
