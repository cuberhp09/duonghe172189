/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws2.pkg1;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Ws21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
    int num = 0;
    boolean validInput = false;
        do {            
            try {
                System.out.println("Enter the number: ");
                String input = scanner.nextLine();
                num = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("The nummber is invalid");
            }
        } while (!validInput);
        if (num < 1) {
            System.out.println("The number is invalid");
        } else {
            System.out.println("The number is" + num);
        }
    }
    }

