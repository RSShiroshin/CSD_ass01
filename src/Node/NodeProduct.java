package Node;

import Model.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class NodeProduct {
    public Product data;
    public NodeProduct next;


    public NodeProduct() {
    }

    public NodeProduct(Product data, NodeProduct next) {
        this.data = data;
        this.next = next;
    }

    public NodeProduct(Product data) {
        this.data = data;
        next = null;
    }
}
