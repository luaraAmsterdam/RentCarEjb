package com.laura.entities;

import com.laura.entities.Car;
import com.laura.entities.CarRent;
import com.laura.entities.Insurance;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-11T02:19:50")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> password;
    public static volatile SingularAttribute<Person, String> role;
    public static volatile ListAttribute<Person, Insurance> insuranceList;
    public static volatile SingularAttribute<Person, String> mail;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, Integer> id;
    public static volatile ListAttribute<Person, Car> carList;
    public static volatile ListAttribute<Person, CarRent> carRentList;

}