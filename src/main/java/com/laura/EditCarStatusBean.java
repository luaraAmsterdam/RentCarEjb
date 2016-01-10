package com.laura;

import com.laura.entities.CarRent;
import com.laura.entities.facades.CarRentFacade;
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
public class EditCarStatusBean implements Serializable{
    @EJB
    private CarRentFacade carRentFacade;
    
    CarRent order = null;

    public CarRent getOrder() {
        return order;
    }
    
    public void setOrder(CarRent order) {
        this.order = order;
    }
    
    @Transactional
    public String takeCar() {
        boolean check  = checkOrderStatus();
        if(check) {
            order.setCarStatus("taken");
            carRentFacade.edit(order);
            return "/client/clientOrders.xhtml?faces-redirect=true";
        } else
            return "/client/errorStatus.xhtml?faces-redirect=true";
    }
    
    @Transactional
    public String returnCar() {
        if(order.getCarStatus().equals("taken")) {
            order.setCarStatus("returned");
            carRentFacade.edit(order);
            return "/client/clientOrders.xhtml?faces-redirect=true";
        } else
            return "/client/errorStatus.xhtml?faces-redirect=true";
    }
    
    @Transactional
    public String approveOwner() {
        if(order.getOwnerApprove().equals("unreviewed")) {
            order.setOwnerApprove("approved");
            if(order.getInsurerApprove().equals("approved"))
                order.setCarStatus("approved");
            carRentFacade.edit(order);
            return "/owner/unreviewedOrdersOwner.xhtml?faces-redirect=true";
        } else
            return "/owner/errorStatus.xhtml?faces-redirect=true";
    }
    
    @Transactional
    public String rejectOwner() {
        if(order.getOwnerApprove().equals("unreviewed")) {
            order.setOwnerApprove("not approved");
            order.setCarStatus("not approved");
            carRentFacade.edit(order);
            return "/owner/unreviewedOrdersOwner.xhtml?faces-redirect=true";
        } else
            return "/owner/errorStatus.xhtml?faces-redirect=true";
    }
     
    
     @Transactional
    public String approveInsurer() {
        if(order.getInsurerApprove().equals("unreviewed")) {
            order.setInsurerApprove("approved");
            if(order.getOwnerApprove().equals("approved"))
                order.setCarStatus("approved");
            carRentFacade.edit(order);
            return "/insurer/unreviewedOrdersInsurer.xhtml?faces-redirect=true";
        } else
            return "/client/errorStatus.xhtml?faces-redirect=true";
    }
    
    @Transactional
    public String rejectInsurer() {
        if(order.getInsurerApprove().equals("unreviewed")) {
            order.setInsurerApprove("not approved");
            order.setCarStatus("not approved");
            carRentFacade.edit(order);
            return "/insurer/unreviewedOrdersInsurer.xhtml?faces-redirect=true";
        } else
            return "/client/errorStatus.xhtml?faces-redirect=true";
    }
    
    private boolean checkOrderStatus() {
        String insurerApprove = order.getInsurerApprove();
        String ownerAprrove = order.getOwnerApprove();
        String carStatus = order.getCarStatus();
        return insurerApprove.equals("approved") && ownerAprrove.equals("approved") &&
                carStatus.equals("approved");
    }
    
}
