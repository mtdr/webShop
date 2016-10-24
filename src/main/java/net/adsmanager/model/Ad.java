package net.adsmanager.model;

import javax.persistence.*;


@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "YEAR")
    private int year;

    @Column(name = "MILEAGE")
    private int mileage;

    @Column(name = "CARTYPE")
    private String carType;

    @Column(name = "COLOUR")
    private String colour;

    @Column(name = "TRANSMISSION")
    private String transmission;

    @Column(name = "ENGINEV")
    private String engineV;

    @Column(name = "ENGINEPOWER")
    private String enginePower;

    @Column(name = "ENGINEFUEL")
    private String engineFuel;

    @Column(name = "NUMOFOWNERS")
    private int numOfOwners;

    @Column(name = "PTS")
    private String PTS;

    @Column(name = "FOTO1")
    private String foto1;

    @Column(name = "FOTO2")
    private String foto2;

    @Column(name = "FOTO3")
    private String foto3;

    @Column(name = "FOTO4")
    private String foto4;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
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

    public int getNumOfOwners() {
        return numOfOwners;
    }

    public void setNumOfOwners(int numOfOwners) {
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
