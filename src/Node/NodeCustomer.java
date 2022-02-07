package Node;


import Model.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class NodeCustomer {
    public Customer data;
    public NodeCustomer next;


    public NodeCustomer() {
    }

    public NodeCustomer(Customer data, NodeCustomer next) {
        this.data = data;
        this.next = next;
    }

    public NodeCustomer(Customer data) {
        this.data = data;
        next = null;
    }
}
