package DTO;

import java.util.Scanner;


public class Painting extends Item {
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;
    
    public Painting(){
        super();
    }
    public Painting (int value, String creator, int height, int width, boolean isWatercolour, boolean isFramed){
       super(value,creator);
       
       this.height = height;
       this.width = width;
       this.isWatercolour = isWatercolour;
       this.isFramed= isFramed;
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
    public boolean getisWatercolour(){
        return isWatercolour;
    }
    public boolean getisFramed (){
        return isFramed;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setisWatercolour(boolean isWatercolour){
        this.isWatercolour = isWatercolour;
    }
    public void setisFramed (boolean isFramed){
        this.isFramed = isFramed;
    }
    public void outputPainting(){
        super.output();
        
        System.out.println("Height: " + this.height);
        System.out.println("Width: " + this.width);
        System.out.println("isWatercolour: " + this.isWatercolour);
        System.out.println("isFramed: "+ this.isFramed);
    }
    public void inputPainting(){
        super.input();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height: ");
        this.height = -1;
         while (this.height < 0){
           this.height = sc.nextInt();
           sc.nextLine();
         }
        System.out.println("Enter width: "); 
        this.width = -1;
         while (this.width < 0){
           this.width = sc.nextInt();
           sc.nextLine();
         }
        System.out.println("is water colour(true/false): ");
         this.isWatercolour = false;
        while (true) {
            String input = sc.nextLine();
            if (input.equals("true")) {
                this.isWatercolour = true;
                break;
            } else if (input.equals("false")) {
                this.isWatercolour = false;
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }        
           
        System.out.println("is framed (true/false): ");
         this.isFramed = false;
        while (true) {
            String input = sc.nextLine();
            if (input.equals("true")) {
                this.isFramed = true;
                break;
            } else if (input.equals("false")) {
                this.isFramed = false;
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }
}

