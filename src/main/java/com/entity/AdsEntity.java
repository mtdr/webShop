package com.entity;

import com.beans.beanShopBasket.SBList;

import javax.naming.directory.SearchResult;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by FlipBook TP300LD on 12.11.2016.
 */

@Entity
@Table(name = "ads", schema = "adsmanager")
public class AdsEntity implements Serializable{
    private int id;
    private String title;
    private String owner;
    private int price;
    private String year;
    private String mileage;
    private String carType;
    private String colour;
    private String transmission;
    private String engineFuel;
    private String enginePower;
    private String engineV;
    private String wheel;
    private String numOfOwners;
    private String pts;
    private String foto1;
    private String foto2;
    private String foto3;
    private String foto4;

    private static int counter = 0;

    public AdsEntity(){}

    public AdsEntity(String carType, String title, int price, String owner, String year, String mileage,
                     String colour, String transmission, String engineFuel, String enginePower, String engineV,
                     String wheel ,String numOfOwners, String pts, String foto1, String foto2, String foto3,
                     String foto4) {
        this.id = counter;
        counter++;
        this.title = title;
        this.owner = owner;
        this.price = price;
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
        this.pts = pts;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ad")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdsEntity adsEntity = (AdsEntity) o;

        if (id != adsEntity.id) return false;
        if (price != adsEntity.price) return false;
        if (title != null ? !title.equals(adsEntity.title) : adsEntity.title != null) return false;
        if (owner != null ? !owner.equals(adsEntity.owner) : adsEntity.owner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Basic
    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "mileage")
    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    @Basic
    @Column(name = "car_type")
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Basic
    @Column(name = "colour")
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Basic
    @Column(name = "transmission")
    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Basic
    @Column(name = "engineFuel")
    public String getEngineFuel() {
        return engineFuel;
    }

    public void setEngineFuel(String engineFuel) {
        this.engineFuel = engineFuel;
    }

    @Basic
    @Column(name = "enginePower")
    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    @Basic
    @Column(name = "engineV")
    public String getEngineV() {
        return engineV;
    }

    public void setEngineV(String engineV) {
        this.engineV = engineV;
    }

    @Basic
    @Column(name = "wheel")
    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    @Basic
    @Column(name = "numOfOwners")
    public String getNumOfOwners() {
        return numOfOwners;
    }

    public void setNumOfOwners(String numOfOwners) {
        this.numOfOwners = numOfOwners;
    }

    @Basic
    @Column(name = "pts")
    public String getPts() {
        return pts;
    }

    public void setPts(String pts) {
        this.pts = pts;
    }

    @Basic
    @Column(name = "foto1")
    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    @Basic
    @Column(name = "foto2")
    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    @Basic
    @Column(name = "foto3")
    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    @Basic
    @Column(name = "foto4")
    public String getFoto4() {
        return foto4;
    }

    public void setFoto4(String foto4) {
        this.foto4 = foto4;
    }
}
