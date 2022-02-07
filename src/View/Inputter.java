/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ListCustomer;
import Controller.ListOrder;
import Controller.ListProduct;
import Controller.Utility;
import Model.Customer;
import Model.Ordering;
import Model.Product;
import Node.NodeCustomer;
import Node.NodeProduct;
import java.io.IOException;
import javax.rmi.CORBA.Util;

/**
 *
 * @author ACER
 */
public class Inputter {
    ListProduct LP = new ListProduct();
    ListCustomer LC = new ListCustomer();
    ListOrder LO = new ListOrder();
    
//    public void nhapProduct(){
//        LP.addLast(new Product("P03", "milk", 10, 5, 20));
//        LP.addLast(new Product("P01", "sugar", 20, 7, 10));
//        LP.addLast(new Product("P02", "beer", 15, 12, 30));
//    }
    
//    public void nhapCustomer(){
//        LC.addLast(new Customer("C03", "Hoa", "1234"));
//        LC.addLast(new Customer("C01", "La", "5678"));
//        LC.addLast(new Customer("C02", "Canh", "1426"));
//    }
    public void nhapOrder(){
        LO.addOrder(new Ordering("P01", "C01", 2));
        LO.addOrder(new Ordering("P01", "C03", 2));
        LO.addOrder(new Ordering("P03", "C05", 1));
        LO.addOrder(new Ordering("P02", "C01", 1));
    }
    
//Product list (8 marks):
//1.1.      Load data from file
    public void loadLPfromFile() throws Exception{
        String fname = Utility.getNonBlankStr("Enter File Name to load: ");
        LP.loadFile(fname);
//        System.out.println("Load Success");
//        LP.disPlay();
    }
//1.2.      Input & add to the end
    public void addProduct(){
        String newPCode;
        String newPName;
        int newQuantity;
        int newSaled;
        double newPrice;
        boolean codeDupplicated = false;
        
        do{
            newPCode = Utility.getPattern("Enter Product Code (ex: P00): ","Wrong PCode format! Please re-Enter: ", "[Pp][\\d]{2}");;
            codeDupplicated = LP.checkDuplicated(newPCode); 
            if (codeDupplicated)
                System.err.println("Product code is duplicated\n");
        }
        while (codeDupplicated==true);
        newPName = Utility.getNonBlankStr("Enter Product Name: ");
        newQuantity = Utility.getInt("Enter Quantity: ", 0 , Integer.MAX_VALUE);
        newSaled = Utility.getInt("Enter Saled: ", 0, newQuantity);
        newPrice = Utility.getDouble("Enter Price ");
        
        Product newP = new Product(newPCode, newPName, newQuantity, newSaled, newPrice);
        System.out.printf("%-6s|%-6s|%-4s|%-4s|%-6s\n", "Code","Name", "Quan", "Sale", "Price");
        LP.addLast(newP);
    }
//1.3.      Display data
    public void DisplayProductList(){
        System.out.printf("%-6s|%-6s|%-4s|%-4s|%-6s\n", "Code","Name", "Quan", "Sale", "Price");
        LP.disPlay();
    }
    
//1.4.      Save product list to file
    public void savePLtoFile() throws IOException{
        String fname = Utility.getNonBlankStr("Enter File Name to load: ");
        LP.saveFile(fname);
        System.out.println("Save Success");
    }
    
//1.5.      Search by pcode
    public void searchByPCode(){
        String pCode;
        pCode = Utility.getPattern("Please enter code to search(EX: P00): ","Wrong PCode format! Please re-Enter: ", "[Pp][\\d]{2}" );
        NodeProduct found = new NodeProduct();
        found = LP.searchByProductCode(pCode);
        if(found == null)
            System.err.println("Can't find Code "+pCode);
        else{
            System.out.println("Product found!!!");
            System.out.printf("%-6s|%-6s|%-4d|%-4d|%-6.2f",found.data.getProductCode(), found.data.getProductName(), found.data.getQuantity(), found.data.getSaled(), found.data.getPrice());
        }
            
    }
    
//1.6.      Delete by pcode
    public void deleteByPCode(){
        String pCode;
        pCode = Utility.getPattern("Please enter code to search(EX: P00): ","Wrong PCode format! Please re-Enter: ", "[Pp][\\d]{2}" );
        NodeProduct found = new NodeProduct();
        found = LP.searchByProductCode(pCode);
        if(found == null)
            System.err.println("Can't find Code "+pCode);
        else{
            System.out.println("Product found!!!");
            LP.deleteByProductCode(pCode);
            System.out.println("Delete Success!!!");           
        }
        LP.disPlay();
    }
//1.7.      Sort by pcode
    public void sortByPCode(){
        LP.sortByProductCode();
        System.out.println("Sort cuccess");
        LP.disPlay();
    }
    
//1.8.      Add after position  k
    public void addAfterPosition(){
        int pos = Utility.getInt("Please enter position: ", 0, Integer.MAX_VALUE);
        String newPCode;
        String newPName;
        int newQuantity;
        int newSaled;
        double newPrice;
        boolean codeDupplicated = false;
        
        do{
            newPCode = Utility.getPattern("Enter Product Code (ex: P00): ","Wrong PCode format! Please re-Enter: ", "[Pp][\\d]{2}");;
            codeDupplicated = LP.checkDuplicated(newPCode); 
            if (codeDupplicated)
                System.err.println("Product code is duplicated\n");
        }
        while (codeDupplicated==true);
        newPName = Utility.getNonBlankStr("Enter Product Name: ");
        newQuantity = Utility.getInt("Enter Quantity: ", 0 , Integer.MAX_VALUE);
        newSaled = Utility.getInt("Enter Saled: ", 0, newQuantity);
        newPrice = Utility.getDouble("Enter Price ");
        
        Product newP = new Product(newPCode, newPName, newQuantity, newSaled, newPrice);
        LP.addAfterPosition(pos, newP);
        System.out.println("Add Success!!");
        LP.disPlay();
    }
    
//1.9.      Delete the node after the node having code = xCode
    public void deleteAfterPCode(){
        String pCode;
        pCode = Utility.getPattern("Please enter code to delete after(EX: P00): ","Wrong PCode format! Please re-Enter: ", "[Pp][\\d]{2}" );
            System.out.println("Product found!!!");
            LP.deleteAfterProductCode(pCode);
            System.out.println("Delete Success!!!");           
        
        LP.disPlay();
    }

//Customer list (1 mark):
//2.1.      Load data from file
    public void loadLCfromFile() throws Exception{
        String fname = Utility.getNonBlankStr("Enter File Name to load: ");
        LC.loadFile(fname);

    }
    
//2.2.      Input & add to the end
    public void addCustomer(){
        String newCCode;
        String newCName;
        String newPhone;
        boolean codeDupplicated = false;
        
        do{
            newCCode = Utility.getPattern("Enter Product Code (ex: C00): ","Wrong PCode format! Please re-Enter: ", "[Cc][\\d]{2}");;
            codeDupplicated = LC.checkDuplicated(newCCode); 
            if (codeDupplicated)
                System.err.println("Product code is duplicated\n");
        }
        while (codeDupplicated==true);
        newCName = Utility.getNonBlankStr("Enter Product Name: ");
        newPhone = Utility.getPattern("Enter phone(EX: 0000): ", "Wrong format!! Please Re-Enter: ", "[\\d]{4}");
        
        Customer newC = new Customer(newCCode, newCName, newPhone);
        LC.addLast(newC);
    }
//2.3.      Display data
    public void DisplayCustomerList(){
        System.out.printf("%-6s|%-6s|%-6s\n", "cCode","cName", "Phone");
        LC.disPlay();
    }
    
//2.4.      Save customer list to file
    public void saveCLtoFile() throws IOException{
        String fname = Utility.getNonBlankStr("Enter File Name to load: ");
        LC.saveFile(fname);
        System.out.println("Save Success");
    }
    
//2.5.      Search by ccode
    public void searchByCCode(){
        String cCode;
        cCode = Utility.getPattern("Please enter code to search(EX: C00): ","Wrong PCode format! Please re-Enter: ", "[Cc][\\d]{2}" );
        NodeCustomer found = new NodeCustomer();
        found = LC.searchByCustomerCode(cCode);
        if(found == null)
            System.err.println("Can't find Code "+cCode);
        else{
            System.out.println("Customer found!!!");
            System.out.printf("%-6s|%-6s|%-6s",found.data.getCustomerCode(), found.data.getCustomerName(), found.data.getPhone());
        }
            
    }
//2.6.      Delete by ccode
    public void deleteByCCode(){
        String cCode;
        cCode = Utility.getPattern("Please enter code to search(EX: C00): ","Wrong PCode format! Please re-Enter: ", "[Cc][\\d]{2}" );
        NodeCustomer found = new NodeCustomer();
        found = LC.searchByCustomerCode(cCode);
        if(found == null)
            System.err.println("Can't find Code "+cCode);
        else{
            System.out.println("Customer found!!!");
            LC.deleteByCustomerCode(cCode);
            System.out.println("Delete Success!!!");           
        }
        LC.disPlay();
    }
//Order list (1 mark):
//3.1.      Input data
    public void addOrder(){
        LO.addOrder(LP, LC);
    }
//3.2.      Display data with total value
    public void displayOrderList(){
        System.out.printf("%-6s|%-6s|%-6s\n", "pCode","cCode", "Quan");
        LO.display();
    }
//3.3.      Sort  by pcode + ccode
    public void sort(){
        LO.sortByProductCodeAndCustomerCode();
        System.out.println("Sort cuccess");
        LO.display();
    }
}
