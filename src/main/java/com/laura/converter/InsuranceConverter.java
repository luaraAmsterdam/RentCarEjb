package com.laura.converter;

import com.laura.entities.Car;
import com.laura.entities.Insurance;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean(name = "insuranceConverterBean")
@FacesConverter(value = "insuranceConverter")
/**
 *
 * @author Laura
 */
public class InsuranceConverter implements Converter{

    @PersistenceContext
    private transient EntityManager em;  
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        return em.find(Insurance.class, Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        return ((Insurance)value).getId().toString();
    }

}
