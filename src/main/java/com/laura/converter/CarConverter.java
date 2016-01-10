/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura.converter;

import com.laura.entities.Car;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean(name = "carConverterBean")
@FacesConverter(value = "carConverter")
/**
 *
 * @author Laura
 */
public class CarConverter implements Converter{

    @PersistenceContext
    private transient EntityManager em;  
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        return em.find(Car.class, Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        return ((Car)value).getId().toString();
    }

}
