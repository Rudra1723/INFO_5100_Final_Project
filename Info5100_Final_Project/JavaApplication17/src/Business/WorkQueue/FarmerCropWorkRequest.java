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
    private Crop crop;

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
    
    @Override
    public String toString() {
        return this.crop.getCropName();
    }
    
}
