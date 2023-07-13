package GUI;

import DTO.BrandList;
import DTO.CarList;
import DTO.Menu;
import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> options = new ArrayList<>();
        options.add("List all brands");
        options.add("Add a new brand");
        options.add("Search a brand based on its ID");
        options.add("Update a brand");
        options.add("Save brands to the file, named brands.txt");
        options.add("List all cars in ascending order of brand names");
        options.add("List cars based on a part of an input brand name");
        options.add("Add a car");
        options.add("Remove a car based on its ID");
        options.add("Update a car based on its ID");
        options.add("Save cars to file, named cars.txt");

        BrandList brandList = new BrandList();
        if (brandList.loadFromFile("brands.txt")) {
            System.out.println("Loaded brands.txt");
        }

        CarList carList = new CarList(brandList);
        if (carList.loadFromFile("cars.txt")) {
            System.out.println("Loaded cars.txt");
        }

        Menu menu = new Menu();

        int choice;

        do {
            choice = menu.int_getChoice(options);
            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    brandList.addBrach();
                    break;
                case 3:
                    System.out.print("Enter brand ID: ");
                    String brandID = scanner.nextLine().trim();
                    int position = brandList.searchID(brandID);
                    if (position < 0) {
                        System.out.println("Not Found!");
                    } else {
                        System.out.println("Brand result is shown");
                        System.out.println(brandList.get(position));
                    }
                    break;
                case 4:
                    brandList.updateBrand();
                    break;
                case 5:
                    if (brandList.size() > 0) {
                        System.out.print("Save changes Y/N: ");
                        String respond = scanner.nextLine().trim().toUpperCase();
                        if (respond.startsWith("Y")) {
                            brandList.saveToFile("brands.txt");
                            System.out.println("Saved!");
                        }
                    }
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    carList.printBaseBrandName();
                    break;
                case 8:
                    carList.addCar();
                    break;
                case 9:
                    carList.removeCar();
                    break;
                case 10:
                    carList.updateCar();
                    break;
                case 11:
                    if (carList.size() > 0) {
                        System.out.print("Save changes Y/N: ");
                        String respond = scanner.nextLine().trim().toUpperCase();
                        if (respond.startsWith("Y")) {
                            carList.saveToFile("cars.txt");
                            System.out.println("Saved!");
                        }
                    }
            }
        } while (choice > 0 && choice <= 11);

    }
}
