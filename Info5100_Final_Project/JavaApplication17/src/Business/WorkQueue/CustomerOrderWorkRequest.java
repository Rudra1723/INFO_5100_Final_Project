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
    private int orderQuantity;
    private UserAccount customerAccount;
    private UserAccount farmerAccount;
    private String deliveryAddress;
    private String customerPhoneNumber;
    private double orderTotalPrice;
    private static int orderCounter = 1;

    public CustomerOrderWorkRequest() {
        orderId = orderCounter;
        orderCounter++;
    }

    public String getPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.customerPhoneNumber = phoneNumber;
    }

    public double getTotalPrice() {
        return orderTotalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.orderTotalPrice = totalPrice;
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
        return orderQuantity;
    }

    public void setQuantiy(int quantity) {
        this.orderQuantity = quantity;
    }

    public UserAccount getCustomer() {
        return customerAccount;
    }

    public void setCustomer(UserAccount customerName) {
        this.customerAccount = customerName;
    }

    public UserAccount getFarmer() {
        return farmerAccount;
    }

    public void setFarmer(UserAccount farmerAccount) {
        this.farmerAccount = farmerAccount;
    }

    public static int getCount() {
        return orderCounter;
    }

    public static void setCount(int count) {
        CustomerOrderWorkRequest.orderCounter = count;
    }

    public String getAddress() {
        return deliveryAddress;
    }

    public void setAddress(String address) {
        this.deliveryAddress = address;
    }

    @Override
    public String toString() {
        return String.valueOf(this.cropName);
    }
}

