/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author rudrapatel
 */
public class CustomerOrderWorkRequest extends WorkRequest{
    private int orderId;
    private String cropName;
    private int quantiy;
    private UserAccount customer;
    private String address;
    private String email;
    private double totalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    private static int count = 1;

    public CustomerOrderWorkRequest() {
        orderId = count;
        count++;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public int getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(int quantiy) {
        this.quantiy = quantiy;
    }

    public UserAccount getCustomer() {
        return customer;
    }

    public void setCustomer(UserAccount customerName) {
        this.customer = customerName;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        CustomerOrderWorkRequest.count = count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    @Override
    public String toString() {
        return String.valueOf(this.cropName);
    }
}

