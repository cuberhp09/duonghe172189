package DTO;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public int int_getChoice(ArrayList options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "," + options.get(i));
        }
        System.out.println("Please choose an option 1 to " + options.size() + ":");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public Brand ref_getchoice(ArrayList options) {
        int response;
        int n = options.size();
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > n);
        return (Brand) options.get(response - 1);
    }

}
