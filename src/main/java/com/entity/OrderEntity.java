package com.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by FlipBook TP300LD on 13.11.2016.
 */
@Entity
@Table(name = "user_order", schema = "adsmanager")
public class OrderEntity implements Serializable {
    private int idOrder;
    private String user;
    private String car;
    private Integer count;
    private java.util.Date date;
    private String delivery;

    @Id
    @Column(name = "id_order", nullable = false)
    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Basic
    @Column(name = "user")
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Basic
    @Column(name = "car")
    public String getCar() {
        return car;
    }

    public void setCar(String idCar) {
        this.car = idCar;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = true, insertable = true, updatable = true)
    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "delivery")
    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (idOrder != that.idOrder) return false;
        if (car != null ? !car.equals(that.car) : that.car != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (delivery != null ? !delivery.equals(that.delivery) : that.delivery != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrder;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (delivery != null ? delivery.hashCode() : 0);
        return result;
    }
}
