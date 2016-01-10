/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura.entities.facades;

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
public class PersonFacade extends AbstractFacade<Person> {

    @PersistenceContext(unitName = "com.laura_CarRentWAR_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }

    public Person findByMailAndPassword(String mail, String password) {
        List<Person> res = em.createNamedQuery("Person.findByMailAndPassword")
                .setParameter("mail", mail)
                .setParameter("password", password)
                .getResultList();

        if (res.size() == 1) {
            return res.get(0);
        }
        return null;
    }

}
