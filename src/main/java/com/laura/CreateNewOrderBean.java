/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura;

import com.laura.entities.CarRent;
import com.laura.entities.Person;
import com.laura.entities.facades.CarRentFacade;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transactional;

/**
 *
 * @author Laura
 */
@ManagedBean
@ViewScoped
public class CreateNewOrderBean implements Serializable{
    @EJB
    private CarRentFacade carRentFacade;
    
    CarRent order = new CarRent();

    public CarRent getRequest()
    {
        return order;
    }

    @Transactional
    public String create(Person person) {
        if(checkDate()) {
            order.setIdRenter(person);
            Double resultCost = calculateResultCost();
            order.setResultCost(resultCost);
            carRentFacade.create(order);
            return "/client/clientOrders.xhtml?faces-redirect=true";
        } else
            return "/client/errorDate.xhtml?faces-redirect=true";
    }
    
    private Double calculateResultCost() {
        Date dateF = order.getDateFrom();
        Date dateT = order.getDateTo();
        long diff = (dateT.getTime() - dateF.getTime());
        Double costCar = order.getIdCar().getCost();
        Double costInsurance = order.getIdInsurance().getCost();
        int day = (int) (diff/86400000 +1);
        return (costCar + costInsurance) * day;
    }
    
    private boolean checkDate() {
        long countAll = carRentFacade.countAllOrderForCar(order.getIdCar());
        long countSorted = carRentFacade.countAllOrderForCarByDate(order.getDateTo(), order.getDateFrom(),  order.getIdCar());
        System.out.println("Allcount = " + countAll + " sorted = " + countSorted);
        return countAll == countSorted; 
    }
}
