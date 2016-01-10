package com.laura;

import com.laura.entities.Car;
import com.laura.entities.Insurance;
import com.laura.entities.Person;
import com.laura.entities.facades.CarFacade;
import com.laura.entities.facades.InsuranceFacade;
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
public class AddNewInsuranceBean implements Serializable{
    @EJB
    private InsuranceFacade insuranceFacade;
    
    Insurance insurance = new Insurance();

    public Insurance getInsurance()
    {
        return insurance;
    }

    @Transactional
    public String create(Person person) {
        
        insurance.setIdInsurer(person);
        insuranceFacade.create(insurance);
        return "/insurer/insurerInsurance.xhtml?faces-redirect=true";
    }
    
}