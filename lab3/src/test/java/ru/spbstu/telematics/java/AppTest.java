package ru.spbstu.telematics.java;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }


    public void testApp()
    {

        // Проверяем на единичном массиве
        ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();
        ArrayList<ArrayList<Double>> test = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> temp1 = new ArrayList<Double>(); // added ()
        temp1.add(3d);
        temp1.add(5d);
        temp1.add(5d);
        temp1.add(5d);
        temp1.add(3d);
        test.add(temp1);
        temp1 = new ArrayList<Double>(); // added ()

        temp1.add(5d);
        temp1.add(8d);
        temp1.add(8d);
        temp1.add(8d);
        temp1.add(5d);
        test.add(temp1);
        temp1 = new ArrayList<Double>(); // added ()

        temp1.add(5d);
        temp1.add(8d);
        temp1.add(8d);
        temp1.add(8d);
        temp1.add(5d);
        test.add(temp1);
        temp1 = new ArrayList<Double>(); // added ()

        temp1.add(5d);
        temp1.add(8d);
        temp1.add(8d);
        temp1.add(8d);
        temp1.add(5d);
        test.add(temp1);
        temp1 = new ArrayList<Double>(); // added ()

        temp1.add(3d);
        temp1.add(5d);
        temp1.add(5d);
        temp1.add(5d);
        temp1.add(3d);
        test.add(temp1);


        ArrayList<Double> temp2 = new ArrayList<Double>(); // added ()

        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                temp2.add(1d);
            }
            matrix.add(temp2);

        }

        Foo a = new Foo(matrix);
        a.start();
        ArrayList<ArrayList<Double>> result = a.getResult();
        for(int i=0;i<result.size();i++){
            for(int j=0;j<result.size();j++){
                System.out.print(result.get(i).get(j));
                System.out.print(" ");
                assertEquals(result.get(i).get(j),test.get(i).get(j));
            }
            System.out.println();
        }

    }
}
