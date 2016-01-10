/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura.entities.facades;

import com.laura.entities.Car;
import com.laura.entities.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Laura
 */
@Stateless
public class CarFacade extends AbstractFacade<Car> {
    @PersistenceContext(unitName = "com.laura_CarRentWAR_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarFacade() {
        super(Car.class);
    }
    
    
    
    public List<Car> getAllCarsForOwner(Person person) {
        List<Car> res = em.createNamedQuery("Car.findByOwner")
                .setParameter("idOwner", person).getResultList();
        if(res.size() > 0) 
            return res;
        else
            return null;        
    }
}
