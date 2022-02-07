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
public class Product {
    private String productCode;
    private String productName;
    private int quantity;
    private int saled;
    private double price;

    public Product() {
    }

    public Product(String productCode, String productName, int quantity, int saled, double price) {
        this.productCode = productCode;
        this.productName = productName;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSaled() {
        return saled;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return String.format("%-6s|%-6s|%-4d|%-4d|%-6.2f", productCode,productName, quantity, saled, price);
    }
    
}
