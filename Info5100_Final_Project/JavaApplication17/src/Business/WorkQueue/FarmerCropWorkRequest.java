/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.Crop.Crop;
import Business.Farmer.Farmer;

/**
 *
 * @author rudrapatel
 */
public class FarmerCropWorkRequest extends WorkRequest {
    private Crop requestedCrop;

    public Crop getCrop() {
        return requestedCrop;
    }

    public void setCrop(Crop crop) {
        this.requestedCrop = crop;
    }
    
    @Override
    public String toString() {
        return this.requestedCrop.getCropName();
    }
    
}
