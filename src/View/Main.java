/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Utility;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Inputter I = new Inputter();
        Scanner sc  = new Scanner(System.in);
        int option,option2, check=1;
//        I.nhapProduct();
//        I.nhapCustomer();
        I.nhapOrder();
        while(true){
            System.out.println("\nMenu--------- ");
            System.out.println("1. Product List");
            System.out.println("2. Customer List");
            System.out.println("3. Order List");
            System.out.println("0. Exit");
            System.out.print("Your option: ");
            
            option = Utility.getInt("");
            switch(option){
                case 1: {
                    while(true){
                        System.out.println("\nProduct List--------- ");
                        System.out.println("1. Load data from file");
                        System.out.println("2. Input & add to the end");
                        System.out.println("3. Display data");
                        System.out.println("4. Save bus list to file");
                        System.out.println("5. Search by product code");
                        System.out.println("6. Delete by product code");
                        System.out.println("7. Sort by product code");
                        System.out.println("8. Add before position  k");
                        System.out.println("9. Delete the node after the node having code = xCode");
                        System.out.println("0. Back to menu");
                        System.out.print("Your option: ");
                        
                        option2 = Utility.getInt("");
                        switch(option2){
                            case 1: I.loadLPfromFile(); break;
                            case 2: I.addProduct(); break;
                            case 3: I.DisplayProductList();break;
                            case 4: I.savePLtoFile(); break;
                            case 5: I.searchByPCode(); break;
                            case 6: I.deleteByPCode(); break;
                            case 7: I.sortByPCode();break;
                            case 8: I.addAfterPosition();break;
                            case 9: I.deleteAfterPCode();break;
                            case 0: break;
                            default: System.err.println("Ko bit doc so ak"); break;
                        }
                        if(option2==0)
                            break;
                    } 
                    break;
                }             
                case 2: {
                    while(true){
                        System.out.println("\nCustomer List--------- ");
                        System.out.println("1. Load data from file");
                        System.out.println("2. Input & add to the end");
                        System.out.println("3. Display data");
                        System.out.println("4. Save customer list to file");
                        System.out.println("5. Search by customer code");
                        System.out.println("6. Delete by customer code");
                        System.out.println("0. Back to menu");
                        System.out.print("Your option: ");
                        
                        option2 = Utility.getInt("");
                        switch(option2){
                            case 1: I.loadLCfromFile(); break;
                            case 2: I.addCustomer(); break;
                            case 3: I.DisplayCustomerList(); break;
                            case 4: I.saveCLtoFile(); break;
                            case 5: I.searchByCCode(); break;
                            case 6: I.deleteByCCode(); break;
                            case 0: break;
                            default: System.err.println("Ko bit doc so ak"); break;
                        }
                        if(option2==0)
                            break;
                    }
                    break;
                }
                case 3: {
                    while(true){
                        System.out.println("\nOrder List--------- ");
                        System.out.println("1. Input data");
                        System.out.println("2. Display data with total value");
                        System.out.println("3. Sort  by pcode + ccode");
                        System.out.println("0. Back to menu");
                        System.out.print("Your option: ");
                        
                        option2 = Utility.getInt("");
                        switch(option2){
                            case 1: I.addOrder(); break;
                            case 2: I.displayOrderList();break;
                            case 3: I.sort();break;
                            case 0: break;
                            default: System.err.println("Ko bit doc so ak"); break;
                        }
                        if(option2==0)
                            break;
                    }
                    break;
                }                               
                case 0: return;
                default: System.err.println("Ko bit doc so ak"); break;
                
            }
        }
        
    
    }
}
