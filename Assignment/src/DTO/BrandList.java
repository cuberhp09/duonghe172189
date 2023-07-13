/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BrandList extends ArrayList<Brand> {

    Scanner scanner = new Scanner(System.in);

    public BrandList() {
        super();
    }

    public boolean loadFromFile(String fName) {
        if (this.size() > 0) {
            this.clear();
        }
        File f = new File(fName);
        if (!f.exists()) {
            return false;
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            StringTokenizer stk = null;
            while ((details = bf.readLine()) != null) {
                stk = new StringTokenizer(details, ", ");
                String loadBrandID = stk.nextToken().trim();
                String loadBrandNam = stk.nextToken().trim();
                String loadSoundBrandAndPrice = stk.nextToken().trim();
                String[] soundAndPrice = loadSoundBrandAndPrice.split(": ");
                String loadSoundBrand = soundAndPrice[0].trim();
                double price = Double.parseDouble(soundAndPrice[1].trim());

                Brand b = new Brand(loadBrandID, loadBrandNam, loadSoundBrand, price);
                this.add(b);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean saveToFile(String fName) {
        if (this.size() == 0) {
            System.out.println("Empty List");
            return false;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(f);
            for (Brand x : this) {
                pw.print(x.getBrandID() + ", " + x.getBrandName() + ", " + x.getSoundBrand() + ": " + x.getPrice());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public int searchID(String brandID) {
        if (this.isEmpty()) {
            System.out.println("Empty List");
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getBrandID().compareTo(brandID) == 0);
            return i;
        }
        return -1;
    }

    public Brand getUserChoice() {
        Menu menu = new Menu();
        return menu.ref_getchoice(this);
    }

    private boolean valid(String bID) {
        bID = bID.trim();
        for (int i = 0; i < this.size(); i++) {
            if (bID.equals(this.get(i).getBrandID())) {
                return false;
            }
        }
        return true;
    }

    public void addBrach() {
        String newBrandID, newBrandName, newSoundBrand;
        double price;
        boolean duplicated = false;
        do {
            System.out.println("Brand ID: ");
            newBrandID = scanner.nextLine().trim();
            duplicated = !valid(newBrandID);
            if (duplicated) {
                System.out.println("The ID is duplicated");
            }
        } while (duplicated);
        do {
            System.out.println("Brand Name: ");
            newBrandName = scanner.nextLine().trim();
            if (newBrandName.length() == 0) {
                System.out.println("Brand Name can not be blank");
            }
        } while (newBrandName.length() == 0);
        do {
            System.out.println("Soundbrand: ");
            newSoundBrand = scanner.nextLine().trim();
            if (newSoundBrand.length() == 0) {
                System.out.println("SoundBrand can not be blank");
            }
        } while (newSoundBrand.length() == 0);
        do {
            System.out.println("Price: ");
            price = Double.parseDouble(scanner.nextLine().trim());
            if (price < 0) {
                System.out.println("The price must be a positive real number");
            }
        } while (price < 0);
        this.add(new Brand(newBrandID, newBrandName, newSoundBrand, price));
        System.out.println("The Brand" + newBrandID + "has been added");
    }

    public void updateBrand() {
        if (this.isEmpty()) {
            System.out.println("Empty list. update can not be performed");

        }
        System.out.println("Please enter brand ID to update :");
        String bID = scanner.nextLine().trim();
        int pos = this.searchID(bID);
        if (pos < 0) {
            System.out.println("The brand ID does not exist!");
        } else {
            String newBrandName, newSoundBrand;
            double price;
            do {
                System.out.println("Brand Name");
                newBrandName = scanner.nextLine().trim();
                if (newBrandName.length() == 0) {
                    System.out.println("Brand Name can not be blank");
                }
            } while (newBrandName.length() == 0);
            do {
                System.out.println("Soundbrand: ");
                newSoundBrand = scanner.nextLine().trim();
                if (newSoundBrand.length() == 0) {
                    System.out.println("Soundbrand can not be blank");
                }
            } while (newSoundBrand.length() == 0);
            do {
                System.out.println("price; ");
                price = Double.parseDouble(scanner.nextLine());
            } while (price < 0);
            this.get(pos).setBrandName(newBrandName);
            this.get(pos).setPrice(price);
            this.get(pos).setSoundBrand(newSoundBrand);
            System.out.println(bID + "has been updtae.");
        }
    }

    public void listBrands() {
        if (this.size() == 0) {
            System.out.println("Empty List!");
            return;
        } else {
            System.out.println("Brand list:");
            for (Brand b : this) {
                System.out.println(b);
            }
            System.out.println("Total :" + this.size() + "brand(s)");
        }
    }

}

