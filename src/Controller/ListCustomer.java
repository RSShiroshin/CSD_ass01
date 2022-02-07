/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Node.NodeCustomer;
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
public class ListCustomer {
    NodeCustomer head, tail;
    
    public ListCustomer(){
        this.head = null;
        this.tail = null;
    }
    public ListCustomer(NodeCustomer head, NodeCustomer tail) {
        this.head = head;
        this.tail = tail;
    }
    
    public boolean checkDuplicated(String cCode){
        NodeCustomer Q = head;

        while(Q != null){
            if(Q.data.getCustomerCode().toLowerCase().equals(cCode.toLowerCase())){
                return true;
            }
            Q = Q.next;
        }
        return false;
    }
//    Customer list (1 mark):
//2.1.      Load data from file
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
        String cCode;
        String cName;
        String phone;

        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            a = s.split("[|]");
            cCode = a[0].trim();
            cName = a[1].trim();
            phone = a[2].trim();

            addLast(new Customer(cCode, cName, phone)); 
        }
        System.out.println("Load Success");
        disPlay();
        fr.close();
        br.close();
    }
//2.2.      Input & add to the end
    public void addLast(Customer cus){
        NodeCustomer Q = new NodeCustomer(cus);
        if(head==null){
            head=null;
            head = tail = Q;
        }else{
        tail.next = Q;
        tail = Q;
        }
    }
//2.3.      Display data
    public void disPlay(){
        if(head == null){
            System.out.println("List is empty!");
        }
        NodeCustomer q = head;
        while (q != null) {
            System.out.println(q.data );
            q = q.next;
        }
    }
//2.4.      Save customer list to file
    public void saveFile(String fname) throws IOException { // Using FileReader class       
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        NodeCustomer p = head;
        while (p != null) {
            pw.printf("%-6s|%-6s|%-6s", p.data.getCustomerCode(), p.data.getCustomerName(), p.data.getPhone()); 
            p = p.next;
        }
        pw.close();
        fw.close();
    }
//2.5.      Search by ccode
    public NodeCustomer searchByCustomerCode(String cCode){
        NodeCustomer Q = head; //node dang xet
        NodeCustomer P = null; ///node luu cai tk tim dc
        while(Q != null){
            if(Q.data.getCustomerCode().toLowerCase().equals(cCode.toLowerCase())){
                P = Q;
            }
            Q = Q.next;
        }
        return P;
    }
//2.6.      Delete by ccode
    public void delFirst() {
        if (head != null) {
            head = head.next;
        }
    }
    
    public int countL() {
        NodeCustomer p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    
    public void deleteByCustomerCode(String cCode){
        NodeCustomer q = head;
        int count = countL();
        if (count > 1) {
            while (q != null && q.data.getCustomerCode().equalsIgnoreCase(cCode)) {
                delFirst();
                q = q.next;
            }
            while (q != null && q.next != null) {
                if (q.next.data.getCustomerCode().equalsIgnoreCase(cCode)) {
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
}
