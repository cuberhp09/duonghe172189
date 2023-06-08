package DTO;

import java.util.Scanner;

public class Vase extends Item {
    private int height;
    private String material;
    
    public Vase(){
       super();
    }
    public Vase(int value , String creator , int height, String materia){
        super(value , creator);
        this.height = height;
        this.material = materia;
    }
    public int getHeight(){
        return height;
    }
    public String getMateria(){
        return material;
    }
    public void setHeight(int height){
        this.height = height;    
    }
    public void setMateria(String material){
        this.material = material;
    }

    public void outputVase(){
        super.output();
        
        System.out.println("Height: " + this.height);
        System.out.println("Material: " + this.material);
    }
     public void inputVase(){
         super.input();
         
         Scanner sc = new Scanner(System.in);
         
         System.out.println("Enter Height: ");
         this.height = -1;
         while (this.height < 0){
           this.height = sc.nextInt();
           sc.nextLine();
         }
         System.out.println("Enter Material: ");
         this.material = sc.nextLine();
     }
}