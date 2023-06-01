/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws2.pkg2;
import java.util.Scanner;
public class Ws22 {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        String regex = "^SE\\d{3}$"; // Regular expression to match SE followed by 3 digits

        String str;
        boolean isValid;
        do {
            System.out.print("Input the string: ");
            str = input.nextLine();

            try {
                isValid = str.matches(regex);
            } catch (Exception e) {
                System.out.println("Error occurred: " + e.getMessage());
                isValid = false;
            }

            if (!isValid) {
                System.out.println("The string is invalid");
            }
        } while (!isValid);

        System.out.println("The string is " + str);
        input.close();
    }
    
}
