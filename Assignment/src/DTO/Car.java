package DTO;

public class Car implements Comparable<Car> {

    private String carID;
    private Brand brand;
    private String color;
    private String frameID;
    private String engieID;

    public Car() {
    }

    public Car(String carID, Brand brand, String color, String frameID, String engieID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engieID = engieID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngieID() {
        return engieID;
    }

    public void setEngieID(String engieID) {
        this.engieID = engieID;
    }

    @Override
    public String toString() {
        return this.carID + ", " + this.brand.getBrandID() + ", " + this.color + ", " + this.frameID + ", " + this.engieID;
    }

    @Override
    public int compareTo(Car c) {
        int d = this.brand.getBrandName().compareTo(c.brand.getBrandName());
        if (d != 0) {
            return d;
        }
        return this.carID.compareTo(c.carID);
    }

    public String screenString() {
        return this.brand + "\n" + this.carID + ", " + this.color + ", " + this.frameID + ", " + this.engieID;
    }

}
