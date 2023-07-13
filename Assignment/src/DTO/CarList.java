package DTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CarList extends ArrayList<Car> {

    Scanner scanner = new Scanner(System.in);

    BrandList brandList;

    public CarList() {
    }

    public CarList(BrandList brandList) {
        this.brandList = brandList;
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
                stk = new StringTokenizer(details, ",");
                String loadCarID = stk.nextToken().trim();
                String loadBrandID = stk.nextToken().trim();
                int position = brandList.searchID(loadBrandID);
                Brand loadBrand = brandList.get(position);
                String loadColor = stk.nextToken().trim();
                String loadFrameID = stk.nextToken().trim();
                String loadEngineID = stk.nextToken().trim();

                Car c = new Car(loadCarID, loadBrand, loadColor, loadFrameID, loadEngineID);
                this.add(c);
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
            for (Car x : this) {
                pw.println(x.getCarID() + ", " + x.getBrand().getBrandID() + ", " + x.getColor()
                        + ", " + x.getFrameID() + ", " + x.getEngieID());
            }
            pw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public int searchID(String carID) {
        if (this.isEmpty()) {
            System.out.println("Empty list.");
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCarID().equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String frameID) {
        if (this.isEmpty()) {
            System.out.println("Empty list.");
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equals(frameID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String engineID) {
        if (this.isEmpty()) {
            System.out.println("Empty list.");
            return -1;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getFrameID().equals(engineID)) {
                return i;
            }
        }
        return -1;
    }

    private boolean validCarID(String carID) {
        carID = carID.trim();
        for (int i = 0; i < this.size(); i++) {
            if (carID.equals(this.get(i).getCarID())) {
                return false;
            }
        }
        return true;
    }

    private boolean validFrameID(String frameID) {
        frameID = frameID.trim();
        for (int i = 0; i < this.size(); i++) {
            if (frameID.equals(this.get(i).getFrameID())) {
                return false;
            }
        }
        return true;
    }

    private boolean validEngineID(String carID) {
        carID = carID.trim();
        for (int i = 0; i < this.size(); i++) {
            if (carID.equals(this.get(i).getCarID())) {
                return false;
            }
        }
        return true;
    }

    public void addCar() {

        String newCarID;
        boolean carIDDuplicated = false;
        do {
            System.out.print("Car ID: ");
            newCarID = scanner.nextLine().trim().toUpperCase();
            carIDDuplicated = !validCarID(newCarID);
            if (carIDDuplicated) {
                System.out.println("The ID is duplicated");
            }
        } while (carIDDuplicated);

        Menu menu = new Menu();
        Brand brand = menu.ref_getchoice(brandList);

        String newColor;
        do {
            System.out.print("Color: ");
            newColor = scanner.nextLine().trim();
            if (newColor.length() == 0) {
                System.out.println("Color can not be blank");
            }
        } while (newColor.length() == 0);

        String newFrameID;
        boolean frameDuplicated = false;
        boolean frameMatched = true;
        do {
            System.out.print("Frame ID (format F00000): ");
            newFrameID = scanner.nextLine().trim().toUpperCase();
            frameDuplicated = !validFrameID(newFrameID);
            frameMatched = newFrameID.matches("F\\d{5}$");
            if (frameDuplicated) {
                System.out.println("The Frame ID is duplicated");
            }
            if (!frameMatched) {
                System.out.println("The Frame ID: F and 5 digits");
            }
        } while (frameDuplicated || !frameMatched);

        String newEngineID;
        boolean engineDuplicated = false;
        boolean engineMatched = true;
        do {
            System.out.print("Engine ID (format E00000): ");
            newEngineID = scanner.nextLine().trim().toUpperCase();
            engineDuplicated = !validEngineID(newEngineID);
            engineMatched = newEngineID.matches("E\\d{5}$");
            if (engineDuplicated) {
                System.out.println("The Engine ID is duplicated");
            }
            if (!engineMatched) {
                System.out.println("The Engine ID: E and 5 digits");
            }
        } while (engineDuplicated || !engineMatched);

        this.add(new Car(newCarID, brand, newColor, newFrameID, newEngineID));
        System.out.println("The car " + newCarID + " has been added.");
    }

    public void printBaseBrandName() {
        System.out.print("Enter a part of brand name: ");
        String aPartOfBrandName = scanner.nextLine().trim();
        int n = this.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Car car = this.get(i);
            if (car.getBrand().getBrandName().contains(aPartOfBrandName)) {
                System.out.println(car.screenString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No car is detected");
        }
    }

    public boolean removeCar() {
        if (this.isEmpty()) {
            System.out.println("Car list is empty. Can not remove.");
            return false;
        }
        System.out.print("Enter the Car ID to remove: ");
        String carIDToRemove = scanner.nextLine().trim().toUpperCase();
        int position = searchID(carIDToRemove);
        if (position < 0) {
            System.out.println("Not Found.");
            return false;
        } else {
            this.remove(this.get(position));
            System.out.println(carIDToRemove + " has been removed.");
        }
        return true;
    }

    public boolean updateCar() {
        if (this.isEmpty()) {
            System.out.println("Car list is empty. Can not update.");
            return false;
        }
        System.out.print("Enter the Car ID to update: ");
        String carIDToUpdate = scanner.nextLine().trim().toUpperCase();
        int position = searchID(carIDToUpdate);
        if (position < 0) {
            System.out.println("Not Found.");
            return false;
        } else {
            Menu menu = new Menu();
            Brand brand = menu.ref_getchoice(brandList);

            String newColor;
            do {
                System.out.print("Color: ");
                newColor = scanner.nextLine().trim();
                if (newColor.length() == 0) {
                    System.out.println("Color can not be blank");
                }
            } while (newColor.length() == 0);

            String newFrameID;
            boolean frameDuplicated = false;
            boolean frameMatched = true;
            do {
                System.out.print("Frame ID (format F00000): ");
                newFrameID = scanner.nextLine().trim().toUpperCase();
                frameDuplicated = !validFrameID(newFrameID);
                frameMatched = newFrameID.matches("F\\d{5}$");
                if (frameDuplicated) {
                    System.out.println("The Frame ID is duplicated");
                }
                if (!frameMatched) {
                    System.out.println("The Frame ID: F and 5 digits");
                }
            } while (frameDuplicated || !frameMatched);

            String newEngineID;
            boolean engineDuplicated = false;
            boolean engineMatched = true;
            do {
                System.out.print("Engine ID (format E00000): ");
                newEngineID = scanner.nextLine().trim().toUpperCase();
                engineDuplicated = !validEngineID(newEngineID);
                engineMatched = newEngineID.matches("E\\d{5}$");
                if (engineDuplicated) {
                    System.out.println("The Engine ID is duplicated");
                }
                if (!engineMatched) {
                    System.out.println("The Engine ID: E and 5 digits");
                }
            } while (engineDuplicated || !engineMatched);

            this.get(position).setBrand(brand);
            this.get(position).setColor(newColor);
            this.get(position).setFrameID(newFrameID);
            this.get(position).setEngieID(newEngineID);
            System.out.println(carIDToUpdate + " has been updated.");
        }
        return true;
    }

    public void listCars() {
        if (this.isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        Collections.sort(this);
        System.out.println("\nCar List");
        System.out.println("----------------");
        for (Car x : this) {
            System.out.println(x.screenString());
        }
    }

}
