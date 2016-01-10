/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "CAR_RENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CarRent.findAll", query = "SELECT c FROM CarRent c"),
    @NamedQuery(name = "CarRent.findById", query = "SELECT c FROM CarRent c WHERE c.id = :id"),
    @NamedQuery(name = "CarRent.findByDateFrom", query = "SELECT c FROM CarRent c WHERE c.dateFrom = :dateFrom"),
    @NamedQuery(name = "CarRent.findByDateTo", query = "SELECT c FROM CarRent c WHERE c.dateTo = :dateTo"),
    @NamedQuery(name = "CarRent.findByResultCost", query = "SELECT c FROM CarRent c WHERE c.resultCost = :resultCost"),
    @NamedQuery(name = "CarRent.findByInsurerApprove", query = "SELECT c FROM CarRent c WHERE c.insurerApprove = :insurerApprove"),
    @NamedQuery(name = "CarRent.findByOwnerApprove", query = "SELECT c FROM CarRent c WHERE c.ownerApprove = :ownerApprove"),
    @NamedQuery(name = "CarRent.findByCarStatus", query = "SELECT c FROM CarRent c WHERE c.carStatus = :carStatus"),
    @NamedQuery(name = "CarRent.findAllOrdersForPerson", query = "SELECT c FROM CarRent c WHERE c.idRenter = :idRenter"),
    @NamedQuery(name = "CarRent.findUnreviewedOrdersForOwner", query = "SELECT c FROM CarRent c WHERE c.idCar.idOwner = :idOwner and c.ownerApprove = 'unreviewed'"),
    @NamedQuery(name = "CarRent.findUnreviewedOrdersForInsurer", query = "SELECT c FROM CarRent c WHERE c.idInsurance.idInsurer = :idInsurer and c.insurerApprove = 'unreviewed'"),
    @NamedQuery(name = "CarRent.countOrderByDate", query = "SELECT COUNT(c.id) FROM CarRent c WHERE c.idCar = :idCar AND "
            + "     (c.dateTo < :dateFrom OR c.dateFrom > :dateTo)"),
    @NamedQuery(name = "CarRent.countAllOrderForCar", query = "SELECT COUNT(c.id) FROM CarRent c WHERE c.idCar = :idCar"),
    @NamedQuery(name = "CarRent.checkOrderStatus", query = "SELECT c.insurerApprove, c.ownerApprove FROM CarRent c where c.id = :id")})
//            String query = "SELECT COUNT(ID) FROM CAR_RENT WHERE ID_CAR = " + id +
//                "AND (DATE_TO < '" + from + "' OR DATE_FROM > '" + to + "')";
//             "SELECT COUNT(ID) FROM CAR_RENT WHERE ID_CAR = "
public class CarRent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATE_FROM")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Column(name = "DATE_TO")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RESULT_COST")
    private Double resultCost;
    @Size(max = 20)
    @Column(name = "INSURER_APPROVE")
    private String insurerApprove;
    @Size(max = 20)
    @Column(name = "OWNER_APPROVE")
    private String ownerApprove;
    @Size(max = 20)
    @Column(name = "CAR_STATUS")
    private String carStatus;
    @JoinColumn(name = "ID_CAR", referencedColumnName = "ID")
    @ManyToOne
    private Car idCar;
    @JoinColumn(name = "ID_INSURANCE", referencedColumnName = "ID")
    @ManyToOne
    private Insurance idInsurance;
    @JoinColumn(name = "ID_RENTER", referencedColumnName = "ID")
    @ManyToOne
    private Person idRenter;

    public CarRent() {
        insurerApprove = "unreviewed";
        ownerApprove = "unreviewed";
        carStatus = "wait approve";
    }

    public CarRent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Double getResultCost() {
        return resultCost;
    }

    public void setResultCost(Double resultCost) {
        this.resultCost = resultCost;
    }

    public String getInsurerApprove() {
        return insurerApprove;
    }

    public void setInsurerApprove(String insurerApprove) {
        this.insurerApprove = insurerApprove;
    }

    public String getOwnerApprove() {
        return ownerApprove;
    }

    public void setOwnerApprove(String ownerApprove) {
        this.ownerApprove = ownerApprove;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public Car getIdCar() {
        return idCar;
    }

    public void setIdCar(Car idCar) {
        this.idCar = idCar;
    }

    public Insurance getIdInsurance() {
        return idInsurance;
    }

    public void setIdInsurance(Insurance idInsurance) {
        this.idInsurance = idInsurance;
    }

    public Person getIdRenter() {
        return idRenter;
    }

    public void setIdRenter(Person idRenter) {
        this.idRenter = idRenter;
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
        if (!(object instanceof CarRent)) {
            return false;
        }
        CarRent other = (CarRent) object;
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
