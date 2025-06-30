/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Crop;
import java.util.Date;

/**
 *
 * @author rudrapatel
 */
public class Crop {
    private String cropName;
    private Date cropExpiryDate;
    private int cropQuantity;
    private double cropPrice;
    

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Date getExpiryDate() {
        return cropExpiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.cropExpiryDate = expiryDate;
    }

    public int getQuantity() {
        return cropQuantity;
    }

    public void setQuantity(int quantity) {
        this.cropQuantity = quantity;
    }

    public double getPrice() {
        return cropPrice;
    }

    public void setPrice(double price) {
        this.cropPrice = price;
    }
}


