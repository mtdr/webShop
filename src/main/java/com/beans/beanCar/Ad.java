package com.beans.beanCar;

import java.io.Serializable;

/**
 * Created by FlipBook TP300LD on 25.10.2016.
 */
public class Ad  implements Serializable {
    private int id;

    private static int counter = 0;

    private String title;

    private int price;

    private String owner;

    private String year;

    private String mileage;

    private String carType;

    private String colour;

    private String transmission;

    private String engineV;

    private String enginePower;

    private String engineFuel;

    private String wheel;

    private String numOfOwners;

    private String PTS;

    private String foto1;

    private String foto2;

    private String foto3;


    private String foto4;

    public Ad() {
        this.title = null;
        this.price = 0;
        this.owner = null;
        this.year = null;
        this.mileage = null;
        this.carType = null;
        this.colour = null;
        this.transmission = null;
        this.engineFuel = null;
        this.enginePower = null;
        this.engineV = null;
        this.wheel = null;
        this.numOfOwners = null;
        this.PTS = null;
        this.foto1 = null;
        this.foto2 = null;
        this.foto3 = null;
        this.foto4 = null;

        this.id = counter;
        counter++;
    }

    public Ad(String carType, String title, int price, String owner, String year, String mileage,
              String colour, String transmission, String engineFuel, String enginePower, String engineV,
              String wheel ,String numOfOwners, String PTS, String foto1, String foto2, String foto3,
              String foto4) {
        this.title = title;
        this.price = price;
        this.owner = owner;
        this.year = year;
        this.mileage = mileage;
        this.carType = carType;
        this.colour = colour;
        this.transmission = transmission;
        this.engineFuel = engineFuel;
        this.enginePower = enginePower;
        this.engineV = engineV;
        this.wheel = wheel;
        this.numOfOwners = numOfOwners;
        this.PTS = PTS;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;

        this.id = counter;
        counter++;
    }

    public static void setCounter(int counter) {
        Ad.counter = counter;
    }

    public static int getCounter() {
        return counter;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getEngineV() {
        return engineV;
    }

    public void setEngineV(String engineV) {
        this.engineV = engineV;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public String getEngineFuel() {
        return engineFuel;
    }

    public void setEngineFuel(String engineFuel) {
        this.engineFuel = engineFuel;
    }

    public String getNumOfOwners() {
        return numOfOwners;
    }

    public void setNumOfOwners(String numOfOwners) {
        this.numOfOwners = numOfOwners;
    }

    public String getPTS() {
        return PTS;
    }

    public void setPTS(String PTS) {
        this.PTS = PTS;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public String getFoto4() {
        return foto4;
    }

    public void setFoto4(String foto4) {
        this.foto4 = foto4;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", owner='" + owner + '\'' +
                ", price=" + price +
                '}';
    }
}
