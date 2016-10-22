package com.appseven;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by J.Evertse on 18/10/16.
 */
public class Employee {
    public String name;
    public Date birthDate;
    public BigDecimal payment;
    public BigDecimal bonus;
    public List<Kid> kids = new ArrayList<Kid>();

    public Employee(String name){
        this.name = name;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");

        try {
            birthDate = sdf.parse("10-12-1976");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        payment = new BigDecimal("10000");
        bonus = new BigDecimal("10000");
    }

   public void addChild(Kid human){
       this.kids.add(human);
   }

}