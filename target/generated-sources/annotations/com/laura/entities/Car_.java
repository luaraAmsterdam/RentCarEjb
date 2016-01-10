package com.laura.entities;

import com.laura.entities.CarRent;
import com.laura.entities.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-11T02:19:50")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile SingularAttribute<Car, Double> volume;
    public static volatile SingularAttribute<Car, Double> cost;
    public static volatile SingularAttribute<Car, String> color;
    public static volatile SingularAttribute<Car, String> vin;
    public static volatile SingularAttribute<Car, String> model;
    public static volatile SingularAttribute<Car, Integer> id;
    public static volatile SingularAttribute<Car, Person> idOwner;
    public static volatile ListAttribute<Car, CarRent> carRentList;
    public static volatile SingularAttribute<Car, Double> powerc;
    public static volatile SingularAttribute<Car, String> mark;

}