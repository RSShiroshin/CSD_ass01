/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ordering;
import Node.NodeOrdering;
import Node.NodeProduct;

/**
 *
 * @author ACER
 */
public class ListOrder {
    NodeOrdering head, tail;

    public ListOrder() {
        head = null;
        tail = null;
    }

    public void addOrder(Ordering order) {
        NodeOrdering node = new NodeOrdering(order);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    // Input data
    /**
    Allow a user to input saleing item.
    When running, the screen looks like:
    Enter product code:
    Enter customer code:
    Enter quantity:
    After the user enter pcode and ccode, the program check and acts as follows:
    - If pcode not found in the products list or ccode not found in the customers list  then data is not accepted.
    - If  both pcode and ccode are found in the order list  then  data is not accepted.
    - If pcode and ccode found in products and customers lists but saled = quantity then inform the user that the product is exhausted.
    - If pcode or ccode found and in the products list saled < quantity and k is the entered quantity then if  k <= quantity - saled then data is accepted and  added to the end of the Order list.
     */

    public NodeOrdering searchByProductCodeAndCustomerCode(String pCode, String cCode){
        // search by product code and customer code
        NodeOrdering current = head;
        while (current != null) {
            if (current.data.getProductCode().equals(pCode) && current.data.getCustomerCode().equals(cCode)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void addOrder(ListProduct listProduct, ListCustomer ListCustomer) {
        // enter product code
        String productCode = Utility.getPattern("Enter product code(EX: P00): ", "Wrong format!!", "^[Pp][\\d]{2}$");

        // check product code must be in the list
        NodeProduct node =  listProduct.searchByProductCode(productCode);
        if (node == null) {
            System.out.println("Product code not found");
            return;
        }

        // saled = quantity then inform the user that the product is exhausted
        if (node.data.getSaled() >= node.data.getQuantity()) {
            System.out.println("Product is exhausted");
            return;
        }

        // enter customer code
        String customerCode = Utility.getPattern("Enter customer code(EX C00): ", "Wrong format!!", "^[Cc][\\d]{2}$");

        // check customer code must be in the list
        if (ListCustomer.searchByCustomerCode(customerCode) == null) {
            System.out.println("Customer code not found");
            return;
        }

        // check product code and customer code must not be in the list
        if (searchByProductCodeAndCustomerCode(productCode, customerCode) != null) {
            System.out.println("Product code and customer code already in the list");
            return;
        }

        // enter quantity must be less than or equal to the quantity of the product
        int quantity = Utility.getInt("Enter quantity: ");

        if (quantity > node.data.getQuantity()- node.data.getSaled() || quantity <= 0) {
            System.out.println("Quantity is not available");
            return;
        }

        addOrder(new Ordering(productCode, customerCode, quantity));
    }

    // display ordering data
    public void display() {
        NodeOrdering node = head;
        while (node != null) {
            System.out.println(node.data.getProductCode()+ " " + node.data.getCustomerCode()+ " " + node.data.getQuantity());
            node = node.next;
        }
    }

    // sort by pcode, if pcode is the same, sort by ccode
    public void sortByProductCodeAndCustomerCode() {
        NodeOrdering current = head;
//        NodeOrdering previous = null;
        NodeOrdering next = null;
        while (current != null) {
            next = current.next;
            while (next != null) {
                if (current.data.getProductCode().compareTo(next.data.getProductCode()) > 0) {
                    if (current.data.getProductCode().equals(next.data.getProductCode())) {
                        if (current.data.getCustomerCode().compareTo(next.data.getCustomerCode()) > 0) {
                            // do swap
                            Ordering temp = next.data;
                            next.data = current.data;
                            current.data = temp;
                        }
                    } else {
                        // do swap
                        Ordering temp = next.data;
                        next.data = current.data;
                        current.data = temp;
                    }
                }
                next = next.next;
            }
            current = current.next;
        }
    }
}
