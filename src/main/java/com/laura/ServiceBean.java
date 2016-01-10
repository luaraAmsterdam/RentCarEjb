/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura;

import com.laura.entities.Car;
import com.laura.entities.CarRent;
import com.laura.entities.Insurance;
import com.laura.entities.Person;
import com.laura.entities.facades.CarFacade;
import com.laura.entities.facades.CarRentFacade;
import com.laura.entities.facades.InsuranceFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Laura
 */
@ManagedBean
@SessionScoped
public class ServiceBean {

    @EJB
    private CarRentFacade carRentFacade;
    @EJB
    private CarFacade carFacade;
    @EJB
    private InsuranceFacade insuranceFacade;
    
    /*
     * Client 
    */
    public DataModel<CarRent> getOrdersForClient(Person pesron) {
        return new ListDataModel(carRentFacade.getAllOrdersForPerson(pesron));
    }
    
    public DataModel<Car> getAllCar() {
        return new ListDataModel(carFacade.findAll());
    }
    
    public DataModel<Insurance> getAllInsurance() {
        return new ListDataModel(insuranceFacade.findAll());
    }
    
    /*
     * Owner 
    */
    public DataModel<Car> getAllCarsForOwner(Person person) {
        return new ListDataModel(carFacade.getAllCarsForOwner(person));
    }
    
    public DataModel<CarRent> getUnreviewedOrdersForOwner(Person person) {
        return new ListDataModel(carRentFacade.getUnreviewedOrdersForOwner(person));
    }
    
    /*
     * Insurer 
    */
     public DataModel<Insurance> getAllInsurancesForInsurer(Person person) {
        return new ListDataModel(insuranceFacade.getAllCarsForOwner(person));
    }
    
    public DataModel<CarRent> getUnreviewedOrdersForInsurer(Person person) {
        return new ListDataModel(carRentFacade.getUnreviewedOrdersForInsurer(person));
    }
    
}
