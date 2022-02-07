/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Utility {
    
    static Scanner sc = new Scanner(System.in);
    public static int getInt(String msg, int min, int max){
        if (min>max){
            int t=min;
            min = max;
            max = t;
        }
        int data = 0;
        do{
            try{
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
                if(data<min || data >max)
                    System.err.println("Please enter number between "+min +" -> "+max);
            }catch(Exception e){
                System.err.println("Please enter a number");
            }
        } while (data<min || data >max);
        
        return data;
    }
    
    public static String getPattern(String msg,String msg2, String pattern){
        String data;
        do{
            System.out.print(msg);
            data = sc.nextLine().trim().toUpperCase();
            if(!data.matches(pattern))
                System.err.println(msg2);
        }
        while(!data.matches(pattern));
        return data;
    }
    
    //nhap 1 so nguyen
    public static int getInt(String msg){
        int data = 0;
        boolean check = false;
            System.out.print(msg);
            while(check == false){
                    try{
                        data = Integer.parseInt(sc.nextLine());
                        check = true;
                    }catch(Exception e){
                        System.err.println("Please enter a number");
                }
            }                             
        return data;
    }
    public static String getNonBlankStr(String msg){
        String data;
        do{
            System.out.print(msg);
            data = sc.nextLine().trim();
        }
        while (data.length()==0);
        return data;
    }
    
    public static double getDouble(String msg){
        double data = 0;
        boolean check = false;
            System.out.print(msg);
            while(check == false){
                    try{
                    data = Double.parseDouble(sc.nextLine());
                    check = true;
                    }catch(Exception e){
                    System.err.println("Please enter a number");
                }
            }                             
        return data;
    }
}
