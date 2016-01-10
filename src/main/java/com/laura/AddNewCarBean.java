package com.laura;

import com.laura.entities.Car;
import com.laura.entities.Person;
import com.laura.entities.facades.CarFacade;
import java.io.Serializable;
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
public class AddNewCarBean implements Serializable{
    @EJB
    private CarFacade carFacade;
    
    Car car = new Car();

    public Car getCar()
    {
        return car;
    }

    @Transactional
    public String create(Person person) {
        car.setIdOwner(person);
        carFacade.create(car);
        return "/client/ownerCars.xhtml?faces-redirect=true";
    }
    
}