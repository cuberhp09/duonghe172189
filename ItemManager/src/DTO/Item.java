package DTO;

import java.util.Scanner;

public class Item {
    protected int value;
    protected String creator;
    
    public Item(){
        
    }
    public Item(int value , String creator){
        this.value = value;
        this.creator = creator;
    }
    public int getValue(){
        return value;
    }
     public String getCreator(){
        return creator;
    }
     public void setValue(int value){
        this.value = value;
     }
     public void setCreator(String creator){   
        this.creator = creator;
     }
     @Override
     public String toString(){
         return "Item{" + "value=" + value + ", creator=" + creator + '}'; 
     }
     public void output() {
        System.out.println("Value: " + this.value);
        System.out.println("Creator: " + this.creator);
    }
     public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value: ");
        this.value = -1;
         while (this.value < 0){
           this.value = sc.nextInt();
           sc.nextLine();
         }
        System.out.println("Enter creator: ");
        this.creator = sc.nextLine();
     }
             
}