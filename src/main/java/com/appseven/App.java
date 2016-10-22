package com.appseven;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple demo with nested objects
 * Created by J.Evertse on 18/10/16.
 */
public class App 
{
    static InputStream is;
    static OutputStream os;


    public static void main( String[] args )
    {
        //Create a list of employees
        List<Employee> employees =  new ArrayList<Employee>();

        //Create an employee with kids
        Employee joost = new Employee("joost");

        //Add some children
        joost.addChild(new Kid("Doris",8));
        joost.addChild(new Kid("Tessel",5));

        //Add the employee to the list
        employees.add(joost);

        //Add another employee, without kids
        employees.add(new Employee("kees"));

        try {

            //Read the template and define the output excel file

            is  = App.class.getResourceAsStream("/nested_object_collection_template.xls");

            os = new FileOutputStream("nested_object_collection_output.xls");

            //Define a context and go transform the data to the excel report
            Context context = new Context();
            context.putVar("employees", employees);
            JxlsHelper.getInstance().processTemplate(is, os, context);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
