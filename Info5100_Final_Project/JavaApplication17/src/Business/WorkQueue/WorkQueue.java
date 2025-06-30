/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author rudrapatel
 */
public class WorkQueue {
    private ArrayList<WorkRequest> workRequestCollection;

    public WorkQueue() {
        workRequestCollection = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestCollection;
    }
    
}
