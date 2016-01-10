/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.laura.converter;

import com.laura.entities.CarRent;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean(name = "carRentConverterBean")
@FacesConverter(value = "carRentConverter")
/**
 *
 * @author Laura
 */
public class CarRentConverter implements Converter{

    @PersistenceContext
    private transient EntityManager em;  
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        return em.find(CarRent.class, Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        return ((CarRent)value).getId().toString();
    }

}
