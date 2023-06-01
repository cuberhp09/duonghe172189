package workshop01.pkg2;

import java.util.Scanner;

public class Workshop012 {
    public static void main(String[] args) {
        float num1,num2;
        String op;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the number 1: ");
        num1=sc.nextFloat();
        System.out.print("Input the number 2: ");
        num2=sc.nextFloat();
        System.out.print("Input the operator (+, -, *, /): ");
        String operator = sc.next();
        float result;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Khong co ket qua");
                    return;
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("Khong co ket qua");
                return;
        }
        System.out.println("Kết quả: " + result);
    }
}
