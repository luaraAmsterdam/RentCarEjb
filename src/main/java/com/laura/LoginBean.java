/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laura;

import com.laura.entities.Person;
import com.laura.entities.facades.PersonFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Laura
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    @EJB
    private PersonFacade personFacade;

    String mail;
    String password;
    boolean isLogined = false;
    Person currentUser = null;

    public Person getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Person currentUser) {
        this.currentUser = currentUser;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    
    
    public boolean isIsLogined() {
        return isLogined;
    }

    public String login() {
        Person p = personFacade.findByMailAndPassword(mail, password);
        if (p != null) {
            isLogined = true;
            currentUser = p;
            String role = currentUser.getRole();
            System.out.println("!!!!!!!!!!!!!!!!role " + role);
            if(role.equals("renter"))
                return "/client/clientOrders.xhtml?faces-redirect=true";
            else if(role.equals("owner"))
                return "/owner/ownerCars.xhtml?faces-redirect=true";
            else if(role.equals("insurer"))
                return "/insurer/insurerInsurance.xhtml?faces-redirect=true";
        }
        return "/login.xhtml?faces-redirect=true";
    }
}
