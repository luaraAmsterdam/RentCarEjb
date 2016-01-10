/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura.entities.facades;

import com.laura.entities.Car;
import com.laura.entities.CarRent;
import com.laura.entities.Person;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Laura
 */
@Stateless
public class CarRentFacade extends AbstractFacade<CarRent> {
    @PersistenceContext(unitName = "com.laura_CarRentWAR_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarRentFacade() {
        super(CarRent.class);
    }
    
    public List<CarRent> getAllOrdersForPerson(Person person) {
        List<CarRent> res = em.createNamedQuery("CarRent.findAllOrdersForPerson")
                .setParameter("idRenter", person).getResultList();
        if(res.size() > 0) 
            return res;
        else
            return null;
    }
        
    public List<CarRent> getUnreviewedOrdersForOwner(Person person) {
        List<CarRent> res = em.createNamedQuery("CarRent.findUnreviewedOrdersForOwner")
                .setParameter("idOwner", person).getResultList();
        if(res.size() > 0) 
            return res;
        else
            return null;
    }
    
    public List<CarRent> getUnreviewedOrdersForInsurer(Person person) {
        List<CarRent> res = em.createNamedQuery("CarRent.findUnreviewedOrdersForInsurer")
                .setParameter("idInsurer", person).getResultList();
        if(res.size() > 0) 
            return res;
        else
            return null;
    }
    
    public long countAllOrderForCar(Car car) {
        List<Long> res = em.createNamedQuery("CarRent.countAllOrderForCar").setParameter("idCar", car).getResultList();
        if(!res.isEmpty())
            return res.get(0);
        else
            return -1;
    }    
    
    public long countAllOrderForCarByDate(Date dateTo, Date dateFrom, Car car) {
        List<Long> res = em.createNamedQuery("CarRent.countOrderByDate").setParameter("dateTo", dateTo).
                setParameter("dateFrom", dateFrom).setParameter("idCar", car).getResultList();
        if(!res.isEmpty())
            return res.get(0);
        else
            return -1;
    }
        
    public String getOrderStatus(Car car) {
        List<String> res = em.createNamedQuery("CarRent.checkOrderStatus")
                .setParameter("idCar", car).getResultList();
        if(!res.isEmpty()) 
            return res.get(0);
        else 
            return null;
    }
}
