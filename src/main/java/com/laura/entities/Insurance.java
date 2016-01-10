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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "INSURANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insurance.findAllForInsurer", query = "SELECT i FROM Insurance i WHERE i.idInsurer = :idInsurer"),
    @NamedQuery(name = "Insurance.findAll", query = "SELECT i FROM Insurance i"),
    @NamedQuery(name = "Insurance.findById", query = "SELECT i FROM Insurance i WHERE i.id = :id"),
    @NamedQuery(name = "Insurance.findByCost", query = "SELECT i FROM Insurance i WHERE i.cost = :cost"),
    @NamedQuery(name = "Insurance.findByType", query = "SELECT i FROM Insurance i WHERE i.type = :type")})
public class Insurance implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COST")
    private Double cost;
    @Size(max = 20)
    @Column(name = "TYPE")
    private String type;
    @OneToMany(mappedBy = "idInsurance")
    private List<CarRent> carRentList;
    @JoinColumn(name = "ID_INSURER", referencedColumnName = "ID")
    @ManyToOne
    private Person idInsurer;

    public Insurance() {
    }

    public Insurance(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public List<CarRent> getCarRentList() {
        return carRentList;
    }

    public void setCarRentList(List<CarRent> carRentList) {
        this.carRentList = carRentList;
    }

    public Person getIdInsurer() {
        return idInsurer;
    }

    public void setIdInsurer(Person idInsurer) {
        this.idInsurer = idInsurer;
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
        if (!(object instanceof Insurance)) {
            return false;
        }
        Insurance other = (Insurance) object;
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
