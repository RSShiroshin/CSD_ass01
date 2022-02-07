/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ACER
 */
public class Customer {
    private String customerCode;
    private String customerName;
    private String phone;

    public Customer() {
    }

    public Customer(String customerCode, String customerName, String phone) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.phone = phone;
    }

    public String getCustomerCode() {
        return this.customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return String.format("%-6s|%-6s|%-6s", customerCode,customerName, phone);
    }
}
