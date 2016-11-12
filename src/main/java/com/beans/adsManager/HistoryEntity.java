package com.beans.adsManager;

import javax.persistence.*;

/**
 * Created by FlipBook TP300LD on 12.11.2016.
 */
@Entity
@Table(name = "history", schema = "adsmanager", catalog = "")
public class HistoryEntity {
    private int id;
    private String product;
    private String market;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PRODUCT")
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Basic
    @Column(name = "MARKET")
    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryEntity that = (HistoryEntity) o;

        if (id != that.id) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        if (market != null ? !market.equals(that.market) : that.market != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (market != null ? market.hashCode() : 0);
        return result;
    }
}
