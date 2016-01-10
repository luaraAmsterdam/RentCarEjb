/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "CAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findById", query = "SELECT c FROM Car c WHERE c.id = :id"),
    @NamedQuery(name = "Car.findByVin", query = "SELECT c FROM Car c WHERE c.vin = :vin"),
    @NamedQuery(name = "Car.findByMark", query = "SELECT c FROM Car c WHERE c.mark = :mark"),
    @NamedQuery(name = "Car.findByModel", query = "SELECT c FROM Car c WHERE c.model = :model"),
    @NamedQuery(name = "Car.findByVolume", query = "SELECT c FROM Car c WHERE c.volume = :volume"),
    @NamedQuery(name = "Car.findByPowerc", query = "SELECT c FROM Car c WHERE c.powerc = :powerc"),
    @NamedQuery(name = "Car.findByColor", query = "SELECT c FROM Car c WHERE c.color = :color"),
    @NamedQuery(name = "Car.findByCost", query = "SELECT c FROM Car c WHERE c.cost = :cost"),
    @NamedQuery(name = "Car.findByOwner", query = "SELECT c FROM Car c WHERE c.idOwner = :idOwner")
})
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "VIN")
    private String vin;
    @Size(max = 20)
    @Column(name = "MARK")
    private String mark;
    @Size(max = 20)
    @Column(name = "MODEL")
    private String model;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VOLUME")
    private Double volume;
    @Column(name = "POWERC")
    private Double powerc;
    @Size(max = 20)
    @Column(name = "COLOR")
    private String color;
    @Column(name = "COST")
    private Double cost;
    @JoinColumn(name = "ID_OWNER", referencedColumnName = "ID")
    @ManyToOne
    private Person idOwner;
    @OneToMany(mappedBy = "idCar")
    private List<CarRent> carRentList;

    public Car() {
    }

    public Car(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getPowerc() {
        return powerc;
    }

    public void setPowerc(Double powerc) {
        this.powerc = powerc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Person getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(Person idOwner) {
        this.idOwner = idOwner;
    }

    @XmlTransient
    public List<CarRent> getCarRentList() {
        return carRentList;
    }

    public void setCarRentList(List<CarRent> carRentList) {
        this.carRentList = carRentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }
    
}
