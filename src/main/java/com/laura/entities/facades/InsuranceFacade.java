/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura.entities.facades;

import com.laura.entities.Car;
import com.laura.entities.Insurance;
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
public class InsuranceFacade extends AbstractFacade<Insurance> {
    @PersistenceContext(unitName = "com.laura_CarRentWAR_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InsuranceFacade() {
        super(Insurance.class);
    }
    
    public List<Insurance> getAllCarsForOwner(Person person) {
        List<Insurance> res = em.createNamedQuery("Insurance.findAllForInsurer")
                .setParameter("idInsurer", person).getResultList();
        if(res.size() > 0) 
            return res;
        else
            return null;        
    }
}
