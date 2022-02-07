/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Product;
import Node.NodeProduct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ACER
 */
public class ListProduct {
    NodeProduct head, tail;
    
    public ListProduct(){
        this.head = null;
        this.tail = null;
    }
    public ListProduct(NodeProduct head, NodeProduct tail) {
        this.head = head;
        this.tail = tail;
    }
    
    public boolean checkDuplicated(String pCode){
        NodeProduct Q = head;

        while(Q != null){
            if(Q.data.getProductCode().toLowerCase().equals(pCode.toLowerCase())){
                return true;
            }
            Q = Q.next;
        }
        return false;
    }
    
//1.1.      Load data from file
    public void loadFile(String fname) throws Exception { // Using FileReader class
        
        FileReader fr = null;
        try{
            fr = new FileReader(fname);
        }catch(Exception e){
            System.err.print("Ko tim thay file!!\n");
            return;
        }
        
       
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        String pCode;
        String pName;
        int quantity;
        int sale;
        double price;

        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            a = s.split("[|]");
            pCode = a[0].trim();
            pName = a[1].trim();
            quantity = Integer.parseInt(a[2].trim());
            sale = Integer.parseInt(a[3].trim());
            price = Double.parseDouble(a[4].trim());

            addLast(new Product(pCode, pName, quantity, sale, price)); 
        }
        System.out.println("Load Success");
        disPlay();
        fr.close();
        br.close();
    }
//1.2.      Input & add to the end
    public void addLast(Product pro){
        NodeProduct Q = new NodeProduct(pro);
        if(head==null){
            head=null;
            head = tail = Q;
        }else{
        tail.next = Q;
        tail = Q;
        }
    }
    
//1.3.      Display data
    public void disPlay(){
        if(head == null){
            System.out.println("List is empty!");
        }
        NodeProduct q = head;
        while (q != null) {
            System.out.println(q.data );
            q = q.next;
        }
    }
//1.4.      Save product list to file
    public void saveFile(String fname) throws IOException { // Using FileReader class       
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeProduct p = head;
        while (p != null) {
            pw.printf("%-6s|%-6s|%-4d|%-4d|%-6.2f\r\n", p.data.getProductCode(), p.data.getProductName(), p.data.getQuantity(), p.data.getSaled(), p.data.getPrice()); //fix
            p = p.next;
        }
        pw.close();
        fw.close();
    }
//1.5.      Search by pcode
    public NodeProduct searchByProductCode(String pCode){
        NodeProduct Q = head; //node dang xet
        NodeProduct P = null; ///node luu cai tk tim dc
        while(Q != null){
            if(Q.data.getProductCode().toLowerCase().equals(pCode.toLowerCase())){
                P = Q;
            }
            Q = Q.next;
        }
        return P;
    }
    
    public int countL() {
        NodeProduct p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    
    public void delFirst() {
        if (head != null) {
            head = head.next;
        }
    }
//1.6.      Delete by pcode
    public void deleteByProductCode(String pCode){
        NodeProduct q = head;
        int count = countL();
        if (count > 1) {
            while (q != null && q.data.getProductCode().equalsIgnoreCase(pCode)) {
                delFirst();
                q = q.next;
            }
            while (q != null && q.next != null) {
                if (q.next.data.getProductCode().equalsIgnoreCase(pCode)) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
        }
        if (count == 1) {
            head = tail = null;
        }

    }
//1.7.      Sort by pcode
    public void sortByProductCode(){
        NodeProduct Q = head,
                P = null;
        while (Q != null) {            
            P = Q.next;
            while (P != null) {                
                if(((String) Q.data.getProductCode()).compareTo((String)(P.data.getProductCode()))>0){
                    Product temp = P.data;
                    P.data = Q.data;
                    Q.data = temp;
                }
                P = P.next;
            }
            Q = Q.next;
        }
    }
//1.8.      Add after position  k
    public void addAfterPosition(int k, Product pro){
        //add first
        //add last
        NodeProduct Q = head;
        int count = 1;
        NodeProduct P = new NodeProduct(pro);
        while(Q != null && count <= k){
            count++;
            Q = Q.next;
        }
        P.next = Q.next;
        Q.next = P;
    }
//1.9.      Delete the node after the node having code = xCode
    public void deleteAfterProductCode(String pCode){
        NodeProduct q = head;
        while (q != null && q.next != null) {
                if (q.data.getProductCode().equalsIgnoreCase(pCode)) {
                    q.next = q.next.next;
                    q=q.next;
                } else {
                    q = q.next;
                }
            }
    }
    
}
