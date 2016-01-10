package com.laura.entities;

import com.laura.entities.Car;
import com.laura.entities.Insurance;
import com.laura.entities.Person;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-01-11T02:19:50")
@StaticMetamodel(CarRent.class)
public class CarRent_ { 

    public static volatile SingularAttribute<CarRent, String> insurerApprove;
    public static volatile SingularAttribute<CarRent, String> carStatus;
    public static volatile SingularAttribute<CarRent, Insurance> idInsurance;
    public static volatile SingularAttribute<CarRent, String> ownerApprove;
    public static volatile SingularAttribute<CarRent, Date> dateTo;
    public static volatile SingularAttribute<CarRent, Double> resultCost;
    public static volatile SingularAttribute<CarRent, Integer> id;
    public static volatile SingularAttribute<CarRent, Person> idRenter;
    public static volatile SingularAttribute<CarRent, Date> dateFrom;
    public static volatile SingularAttribute<CarRent, Car> idCar;

}