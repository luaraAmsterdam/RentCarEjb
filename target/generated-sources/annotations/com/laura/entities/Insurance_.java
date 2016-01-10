package com.laura.entities;

import com.laura.entities.CarRent;
import com.laura.entities.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-11T02:19:50")
@StaticMetamodel(Insurance.class)
public class Insurance_ { 

    public static volatile SingularAttribute<Insurance, Double> cost;
    public static volatile SingularAttribute<Insurance, Person> idInsurer;
    public static volatile SingularAttribute<Insurance, Integer> id;
    public static volatile ListAttribute<Insurance, CarRent> carRentList;
    public static volatile SingularAttribute<Insurance, String> type;

}