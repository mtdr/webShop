package com.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by FlipBook TP300LD on 13.11.2016.
 */
@Entity
@Table(name = "shop", schema = "adsmanager")
public class ShopEntity  implements Serializable {
    private int idShop;
    private String address;
    private String titleShop;
    private Double ox;
    private Double oy;

    @Id
    @Column(name = "id_shop")
    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "title_shop")
    public String getTitleShop() {
        return titleShop;
    }

    public void setTitleShop(String titleShop) {
        this.titleShop = titleShop;
    }

    @Basic
    @Column(name = "o_x")
    public Double getOx() {
        return ox;
    }

    public void setOx(Double oX) {
        this.ox = oX;
    }

    @Basic
    @Column(name = "o_y")
    public Double getOy() {
        return oy;
    }

    public void setOy(Double oY) {
        this.oy = oY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopEntity that = (ShopEntity) o;

        if (idShop != that.idShop) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (titleShop != null ? !titleShop.equals(that.titleShop) : that.titleShop != null) return false;
        if (ox != null ? !ox.equals(that.ox) : that.ox != null) return false;
        if (oy != null ? !oy.equals(that.oy) : that.oy != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idShop;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (titleShop != null ? titleShop.hashCode() : 0);
        result = 31 * result + (ox != null ? ox.hashCode() : 0);
        result = 31 * result + (oy != null ? oy.hashCode() : 0);
        return result;
    }
}
