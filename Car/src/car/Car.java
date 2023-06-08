/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car;
import java.util.Scanner;

public class Car {
    private String maker;
    private int price;

    public Car() {
        // Default constructor
    }

    public Car(String maker, int price) {
        // Constructor with arguments
        this.maker = maker;
        this.price = price;
    }

    public String getMaker() {
        // Getter method for maker
        return this.maker;
    }

    public int getPrice() {
        // Getter method for price
        return this.price;
    }

    public void setMaker(String maker) {
        // Setter method for maker
        this.maker = maker;
    }

    @Override
    public String toString() {
        // Returns string in format: maker, price
        return this.maker + ", " + this.price;
    }
}

class SpecCar extends Car {
    private int type;

    public SpecCar() {
        // Default constructor
    }

    public SpecCar(String maker, int price, int type) {
        // Constructor with arguments
        super(maker, price);
        this.type = type;
    }

    @Override
    public String toString() {
        // Returns string in format: maker, price, type
        return super.getMaker() + ", " + super.getPrice() + ", " + this.type;
    }

    public void setData() {
        // Adds "XZ" to the head of maker and increases price by 20
        super.setMaker("XZ" + super.getMaker());
        super.getPrice() += 20;
    }

    public int getValue() {
        // Returns price+inc, where if type<7 then inc=10, otherwise inc=15.
        int inc = (this.type < 7) ? 10 : 15;
        return super.getPrice() + inc;
    }
}

/**
 *
 * @author Admin
 */
public class Car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter maker: ");
        String maker = scanner.nextLine();
        
        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        
        System.out.print("Enter type: ");
        int type = scanner.nextInt();
        
        System.out.println("1. Test toString()");
        System.out.println("2. Test setData()");
        System.out.println("3. Test getValue()");
        System.out.print("Enter TC (1,2,3): ");
        int tc = scanner.nextInt();
        
        SpecCar specCar = new SpecCar(maker, price, type);
        
        if (tc == 1) {
            System.out.println(specCar.toString());
        } else if (tc == 2) {
            specCar.setData();
            System.out.println(specCar.toString());
        } else if (tc == 3) {
            System.out.println(specCar.getValue());
        }
        
        scanner.close();
    }
}
